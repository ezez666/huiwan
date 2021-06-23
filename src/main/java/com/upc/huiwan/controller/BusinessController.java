package com.upc.huiwan.controller;

import com.alibaba.fastjson.JSONObject;
import com.upc.huiwan.entity.Business;
import com.upc.huiwan.returnJson.BusinessInfo;
import com.upc.huiwan.returnJson.Permission;
import com.upc.huiwan.returnJson.Permissions;
import com.upc.huiwan.returnJson.ReturnObject;
import com.upc.huiwan.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/auth/2step-code")
    public Boolean test(){
        System.out.println("前端框架自带的一个验证规则，写不写无所谓");
        return true;
    }

    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session){
    //public String login(@RequestBody Map<String ,String> map, HttpSession session){
        System.out.println("login");
        System.out.println(username +"   "+password);

        Business business = businessService.findBusinessByName(username,password);
        business.setToken(business.getUsername());
        //用户数据写入session
        session.setAttribute("business",business);
        ReturnObject returnObject = new ReturnObject(business);
        return JSONObject.toJSONString(returnObject);

    }

    @RequestMapping("/user/info")
    public String getInfo(HttpSession session){
        Business business =(Business)session.getAttribute("business");
        //获取模块信息
        System.out.println(business.getPrivileges());
        String[] split = business.getPrivileges().split("-");
        //创建权限集合对象
        Permissions permissions = new Permissions();
        //向权限集合对象中添加具体的权限
        List<Permission> permissionList = new ArrayList<>();
        for (String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        //设置返回值的result
        BusinessInfo businessInfo = new BusinessInfo(business.getUsername(),permissions);
        return JSONObject.toJSONString(new ReturnObject(businessInfo));

    }

    @RequestMapping("/auth/logout")
    public void logOut(HttpSession session){
        System.out.println("logout");
        session.invalidate();
    }




}
