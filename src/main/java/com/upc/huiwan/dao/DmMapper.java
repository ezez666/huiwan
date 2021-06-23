package com.upc.huiwan.dao;

import com.upc.huiwan.entity.DungeonMaster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DmMapper {



    int insertDm(DungeonMaster dungeonMaster);

    DungeonMaster selectDmByCard(String idCard);
}
