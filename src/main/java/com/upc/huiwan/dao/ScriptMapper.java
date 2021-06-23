package com.upc.huiwan.dao;

import com.upc.huiwan.entity.Script;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ScriptMapper {


    List<Script> selectScripts(int belongBusinessId,int offset,int limit);

    int insertScript(Script script);

    Script selectScriptByName(String name);

    Script selectScriptById(int id);



}
