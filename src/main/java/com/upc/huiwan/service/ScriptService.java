package com.upc.huiwan.service;

import com.upc.huiwan.dao.ScriptMapper;
import com.upc.huiwan.entity.Script;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScriptService {
    @Autowired
    private ScriptMapper scriptMapper;

    /**
     * businessId为0时返回所有剧本，不为0是返回该商家的剧本
     * @param businessId
     * @param offset
     * @param limit
     * @return
     */
    public List<Script> findScripts(int businessId,int offset,int limit){
        return scriptMapper.selectScripts(businessId,offset,limit);
    }

    /**
     * 再插入数据之前，最好对当前信息做判断，判断剧本是否存在，如果存在则不允许插入，如果不存在才允许插入
     * @param script
     * @return
     */
    public Integer insertScript(Script script){
        Script scriptByName = scriptMapper.selectScriptByName(script.getName());
        int result=0;
        if(scriptByName!=null && scriptByName.getBelongBusinessId()==script.getBelongBusinessId()){
            return result;
        }else {
            result = scriptMapper.insertScript(script);
            return result;
        }
    }

    public Script findScriptById(int id){
        return scriptMapper.selectScriptById(id);
    }



}
