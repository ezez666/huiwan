package com.upc.huiwan.service;

import com.upc.huiwan.dao.DmMapper;
import com.upc.huiwan.entity.DungeonMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmService {

    @Autowired
    private DmMapper dmMapper;



    public Integer insertDm(DungeonMaster dungeonMaster){
        DungeonMaster dm = dmMapper.selectDmByCard(dungeonMaster.getIdCard());
        int result=0;
        if(dm!=null){
            return result;
        }else{
            result = dmMapper.insertDm(dungeonMaster);
            return result;
        }
    }
}
