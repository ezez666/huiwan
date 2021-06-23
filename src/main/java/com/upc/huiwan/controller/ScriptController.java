package com.upc.huiwan.controller;

import com.alibaba.fastjson.JSONObject;
import com.upc.huiwan.entity.Business;
import com.upc.huiwan.entity.Script;
import com.upc.huiwan.returnJson.ReturnObject;
import com.upc.huiwan.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class ScriptController {

    @Autowired
    private ScriptService scriptService;

    @RequestMapping("/script/selectScripts")
    public String findScripts(@RequestParam("businessId")int businessId,
                                    @RequestParam("offset")int offset,
                                    @RequestParam("limit")int limit){
        List<Script> list = scriptService.findScripts(businessId, offset, limit);

        return JSONObject.toJSONString(new ReturnObject(list));
    }



    @RequestMapping("/script/createScript")
    public String insertScript(@RequestParam("name")String name, @RequestParam("numbers") int numbers,
                               @RequestParam("price")int price, @RequestParam("synopsis")String synopsis,
                            HttpSession session){
        Business business =(Business)session.getAttribute("business");
        Script script = new Script();
        script.setName(name);
        script.setNumbers(numbers);
        script.setStatus(0);
        script.setGrade(5);
        script.setPrice(price);
//        script.setBelongBusinessId(business.getId());
        script.setBelongBusinessId(1);
        script.setSynopsis(synopsis);
        script.setCreateTime(new Date());
        Integer result = scriptService.insertScript(script);
        if(result == 0){
            return JSONObject.toJSONString(new ReturnObject("0","该剧本已存在"));
        }else{
            return JSONObject.toJSONString(new ReturnObject("1","插入剧本成功"));
        }
    }

    @RequestMapping("/script/{scriptId}")
    public String getScript(@RequestParam @PathVariable int scriptId){
        Script script = scriptService.findScriptById(scriptId);
        return JSONObject.toJSONString(new ReturnObject(script));
    }


}
