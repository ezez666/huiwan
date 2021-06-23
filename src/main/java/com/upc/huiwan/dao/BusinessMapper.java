package com.upc.huiwan.dao;

import com.upc.huiwan.entity.Business;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BusinessMapper {

    Business selectByName(String username,String password);




}
