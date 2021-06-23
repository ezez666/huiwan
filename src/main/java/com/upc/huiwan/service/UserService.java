package com.upc.huiwan.service;


import com.upc.huiwan.dao.UserMapper;
import com.upc.huiwan.entity.User;

import com.upc.huiwan.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }

    public User findUserByName(String name){return userMapper.selectByName(name);}
    public Map<String, String> login(String username, String password) {
        Map<String, String> map = new HashMap<>();


        // 验证账号
        User user = userMapper.selectByName(username);
        if (user == null) {
            map.put("message", "该账号不存在!");
            return map;
        }

        // 验证状态
        if (user.getStatus() == 0) {
            map.put("message", "该账号未激活!");
            return map;
        }

        // 验证密码
        password = CommunityUtil.md5(password + user.getSalt());
        if (!user.getPassword().equals(password)) {
            map.put("message", "密码不正确!");
            return map;
        }

        // 生成登录凭证
//        LoginTicket loginTicket = new LoginTicket();
//        loginTicket.setUserId(user.getId());
//        loginTicket.setTicket(CommunityUtil.generateUUID());
//        loginTicket.setStatus(0);
//        loginTicket.setExpired(new Date(System.currentTimeMillis() + expiredSeconds * 1000));
////        loginTicketMapper.insertLoginTicket(loginTicket);
//
//        String redisKey = RedisKeyUtil.getTicketKey(loginTicket.getTicket());
//        redisTemplate.opsForValue().set(redisKey, loginTicket);

//        map.put("ticket", loginTicket.getTicket());
        return map;
    }




}
