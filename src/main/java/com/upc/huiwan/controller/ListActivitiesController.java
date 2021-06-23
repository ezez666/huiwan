package com.upc.huiwan.controller;


import com.alibaba.fastjson.JSONObject;
import com.upc.huiwan.entity.ListActivities;
import com.upc.huiwan.entity.Script;
import com.upc.huiwan.entity.User;
import com.upc.huiwan.returnJson.ActivityInfo;
import com.upc.huiwan.returnJson.ReturnObject;
import com.upc.huiwan.service.ListActivitiesService;
import com.upc.huiwan.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class ListActivitiesController {


    @Autowired
    private ListActivitiesService listActivitiesService;
    @Autowired
    private ScriptService scriptService;

    /**
     *
     * 用户创建组局
     * @param scriptId
     * @param businessId
     * @param playTime
     * @param session
     * @return
     */

    @RequestMapping("/activity/createActivity")
    public String addListActivities(@RequestParam("scriptId")int scriptId,
                                    @RequestParam("businessId")int businessId,
                                    @RequestParam("playTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date playTime,
                                    HttpSession session){
        User user = (User) session.getAttribute("user");
        Script script = scriptService.findScriptById(scriptId);

        //这里存在一个判空

        ListActivities activity = new ListActivities();
//        activity.setUserId(user.getId());
        activity.setUserId(1);
        activity.setScriptId(scriptId);
        activity.setBusinessId(businessId);
        activity.setPeopleAll(script.getNumbers());
//        activity.setPeopleAll(5);
        activity.setPeopleExistence(1);
        activity.setPeopleLack(script.getNumbers()-1);
//        activity.setPeopleLack(4);
        activity.setStatus(0);
        activity.setEffectiveTime(new Date(1000*60*60*24*5));
        activity.setCreateTime(new Date());
        activity.setPlayTime(playTime);
        Integer result = listActivitiesService.insertListActivities(activity);
        if(result == 0){
            return JSONObject.toJSONString(new ReturnObject("0","活动创建失败"));
        }else{
            return JSONObject.toJSONString(new ReturnObject("1","活动创建成功"));
        }
    }

    @RequestMapping("/activity/selectActivities")
    public String selectActivities(@RequestParam("businessId")int businessId,
                                   @RequestParam("offset")int offset,
                                   @RequestParam("limit")int limit){
        List<ListActivities> list = listActivitiesService.selectActivities(businessId, offset, limit);

        return JSONObject.toJSONString(new ReturnObject(list));
    }

    @RequestMapping("/activity/Activities/{activityId}")
    public String selectActivityById(@RequestParam @PathVariable int activityId){
        System.out.println(activityId);
//        ListActivities activity = listActivitiesService.selectActivityById(2);
        ListActivities activity = listActivitiesService.selectActivityById(activityId);
        return JSONObject.toJSONString(new ReturnObject(activity));
    }

    @RequestMapping("/activity/Activities/{activityId}/detail")
    public String selectActivityDetail(@RequestParam @PathVariable int activityId){
        System.out.println(activityId);
        ListActivities activity = listActivitiesService.selectActivityById(activityId);
        int userId = activity.getUserId();
        ActivityInfo activityInfo = listActivitiesService.selectActivity(activityId, userId);

        return JSONObject.toJSONString(new ReturnObject(activityInfo));
    }

    @RequestMapping("/activity/joinActivity")
    public String joinActivity(@RequestParam("activityId")int activityId,
                               @RequestParam("userId")int userId){

        ListActivities activity = listActivitiesService.selectActivityById(activityId);
        listActivitiesService.joinActivity(activity.getUserId(),userId,activityId);

        return JSONObject.toJSONString(new ReturnObject("1","参加活动成功"));

    }

}
