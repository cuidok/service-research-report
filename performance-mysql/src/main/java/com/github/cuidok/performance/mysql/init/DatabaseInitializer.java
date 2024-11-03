package com.github.cuidok.performance.mysql.init;

import com.github.cuidok.performance.mysql.order.Order;
import com.github.cuidok.performance.mysql.order.OrderMapper;
import com.github.cuidok.performance.mysql.order.OrderStatus;
import com.github.cuidok.performance.mysql.user.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseInitializer {

    private final SecureRandom random = new SecureRandom();

    private final OrderMapper orderMapper;

    private final Map<Integer, User> userMap;

    public DatabaseInitializer(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
        userMap = UserMapInitializer.initUserMap();
    }

    private Order build() {
        Order order = new Order();
        order.setName("TEST-NAME-" + System.currentTimeMillis());
        order.setDes("TEST-DES-" + System.currentTimeMillis());

        // compute the random number from 10.00 to 99999.99
        BigDecimal price = BigDecimal.valueOf(10 + random.nextInt(99990) + random.nextDouble()).setScale(2, RoundingMode.HALF_UP);
        order.setPrice(price);

        // compute the status, Query from the OrderStatus enum randomly
        OrderStatus[] statuses = OrderStatus.values();
        order.setStatus(statuses[random.nextInt(statuses.length)]);

        // compute the userId, Query from the userIds array randomly
        User user = userMap.get(1000 + random.nextInt(userMap.size()));
        order.setUserId(user.getId());
        order.setUserName(user.getName());

        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());

        return order;
    }

    public void initDatabase() {
        int recodeCount = 40000000;
        int insertBatch = 10000;
        int batchCount = recodeCount / insertBatch;
        for (int i = 0; i < batchCount; i++) {
            List<Order> orders = new ArrayList<>(insertBatch);
            for (int j = 0; j < insertBatch; j++) {
                Order order = build();
                orders.add(order);
            }
            orderMapper.insertOrder(orders);
            System.out.println("Inserted " + insertBatch * i + " records");
        }
    }
}
