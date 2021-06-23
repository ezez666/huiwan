package com.upc.huiwan.controller;


import com.alibaba.fastjson.JSONObject;
import com.upc.huiwan.entity.User;
import com.upc.huiwan.returnJson.ReturnObject;
import com.upc.huiwan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        Map<String, String> map = userService.login(username, password);
        if(!map.isEmpty()){
            String message = map.get("message");
            return JSONObject.toJSONString(new ReturnObject("0",message));
        }
        User user = userService.findUserByName(username);
        user.setToken(username);
        session.setAttribute("user",user);
        return JSONObject.toJSONString(new ReturnObject(user));
    }

    @RequestMapping("/user/{userId}")
    public String getUser(@RequestParam @PathVariable int userId){
        User user = userService.findUserById(userId);
        return JSONObject.toJSONString(new ReturnObject(user));
    }





}
