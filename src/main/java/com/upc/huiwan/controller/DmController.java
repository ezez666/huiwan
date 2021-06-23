package com.upc.huiwan.controller;

import com.alibaba.fastjson.JSONObject;
import com.upc.huiwan.entity.Business;
import com.upc.huiwan.entity.DungeonMaster;
import com.upc.huiwan.returnJson.ReturnObject;
import com.upc.huiwan.service.DmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class DmController {

    @Autowired
    private DmService dmService;

    @RequestMapping("/script/insertDm")
    public String insertDm(@RequestParam("name")String name, @RequestParam("sex")int sex,
                           @RequestParam("idCard")String idCard, @RequestParam("phone")String phone,
                           @RequestParam("selfDescription")String selfDescription,  HttpSession session){
        Business business =(Business)session.getAttribute("business");
        DungeonMaster dm = new DungeonMaster();
        dm.setName(name);
        dm.setSex(sex);
        dm.setIdCard(idCard);
        dm.setPhone(phone);
        dm.setSelfDescription(selfDescription);
//        dm.setBelongBusinessId(1);
        dm.setBelongBusinessId(business.getId());
        dm.setCreateTime(new Date());
        Integer result = dmService.insertDm(dm);
        if(result == 0){
            return JSONObject.toJSONString(new ReturnObject("0","该dm已注册"));
        }else{
            return JSONObject.toJSONString(new ReturnObject("1","注册dm成功"));
        }
    }



}
