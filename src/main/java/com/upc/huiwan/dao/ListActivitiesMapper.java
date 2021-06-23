package com.upc.huiwan.dao;


import com.upc.huiwan.entity.ListActivities;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ListActivitiesMapper {

    public int insertListActivity(ListActivities listActivities);



    public ListActivities selectActivityById(int activityId);

    public List<ListActivities> selectActivities(int businessId, int offset, int limit);
}
