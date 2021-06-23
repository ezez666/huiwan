package com.upc.huiwan.util;

public class RedisKeyUtil {



    private static final String SPLIT = ":";
    private static final String PREFIX_SCRIPT = "script";
    private static final String PREFIX_ACTIVITY = "activity";


    // 拼单活动
    // script : activity:activityId:userId   -> zset(userId,now)
    // 2021-05-22 20:36:48
    //activity:2:11

    public static String getActivityKey(int activityId,int userId){
        return PREFIX_ACTIVITY + SPLIT + activityId + SPLIT + userId;
    }

}
