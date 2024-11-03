package com.github.cuidok.performance.postgresql.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {

    private Integer id;

    private String name;

    private String des;

    private BigDecimal price;

    private OrderStatus status;

    private Integer userId;

    private String userName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
