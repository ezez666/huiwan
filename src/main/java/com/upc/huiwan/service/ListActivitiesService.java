package com.upc.huiwan.service;


import com.upc.huiwan.dao.ListActivitiesMapper;
import com.upc.huiwan.entity.ListActivities;
import com.upc.huiwan.entity.Script;
import com.upc.huiwan.entity.User;
import com.upc.huiwan.returnJson.ActivityInfo;
import com.upc.huiwan.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ListActivitiesService {
    @Autowired
    private ListActivitiesMapper listActivitiesMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private ScriptService scriptService;

    public Integer insertListActivities(ListActivities listActivities){
        return listActivitiesMapper.insertListActivity(listActivities);
    }

    public void joinActivity(int createId,int userId,int activityId){


        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                String activityKey = RedisKeyUtil.getActivityKey(activityId, createId);

                redisOperations.multi();

                redisOperations.opsForZSet().add(activityKey,userId,System.currentTimeMillis());

                return redisOperations.exec();
            }
        });
    }

    public ActivityInfo selectActivity(int activityId,int userId){
        ListActivities activity = listActivitiesMapper.selectActivityById(activityId);
        String activityKey = RedisKeyUtil.getActivityKey(activityId, userId);
        Set<Integer> users = redisTemplate.opsForZSet().reverseRange(activityKey, 0, -1);

        if(users == null){
            return null;
        }
        List<Map<String,Object>> list = new ArrayList<>();


        for(int targetId : users){
            Map<String, Object> map = new HashMap<>();
            User user = userService.findUserById(targetId);
            map.put("user", user);
            Double score = redisTemplate.opsForZSet().score(activityKey, targetId);
            map.put("joinTime", new Date(score.longValue()));
            list.add(map);
        }

        int size = redisTemplate.boundZSetOps(activityKey).size().intValue();


        ActivityInfo activityInfo = new ActivityInfo(activity.getPeopleAll(),size+1,activity.getPeopleAll()-size-1,list);

        return activityInfo;
    }

    public ListActivities selectActivityById(int activityId){
        return listActivitiesMapper.selectActivityById(activityId);
    }

    public List<ListActivities> selectActivities(int businessId,int offset,int limit){
        List<ListActivities> activities = listActivitiesMapper.selectActivities(businessId, offset, limit);
        List<ListActivities> ans = new ArrayList<>();
        for(ListActivities activity : activities){
            String activityKey = RedisKeyUtil.getActivityKey(activity.getId(), activity.getUserId());
            int size = redisTemplate.boundZSetOps(activityKey).size().intValue();
            activity.setPeopleExistence(size+1);
            activity.setPeopleLack(activity.getPeopleAll()-size-1);

            ans.add(activity);

        }
        return activities;
    }




}
