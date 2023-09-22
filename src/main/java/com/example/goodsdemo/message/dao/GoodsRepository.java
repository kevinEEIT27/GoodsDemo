package com.example.goodsdemo.message.dao;

import com.example.goodsdemo.message.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
