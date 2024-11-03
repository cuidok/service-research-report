package com.github.cuidok.performance.mysql.order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    void insertOrder(List<Order> order);

}
