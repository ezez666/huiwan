package com.upc.huiwan.service;

import com.upc.huiwan.dao.BusinessMapper;
import com.upc.huiwan.entity.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {


    @Autowired
    private BusinessMapper businessMapper;

    public Business findBusinessByName(String username,String passwprd){
        return businessMapper.selectByName(username,passwprd);
    }




}
