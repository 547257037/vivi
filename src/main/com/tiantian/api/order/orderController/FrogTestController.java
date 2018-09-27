package com.tiantian.api.order.orderController;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CacheConfig(cacheNames = "frogtest")
@RestController
@RequestMapping(value = "/frogtest")
public class FrogTestController {

    @Cacheable()
    @ApiOperation(value = "获取Frog的列表")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Hero> show(){
        List<Hero> list = new ArrayList<>();
        list.add(new Hero(1,"one",2,new Date(),"controllertest"));
        list.add(new Hero(2,"two",3,new Date(),"controllertest"));
        return list;
    }

    @Cacheable()
    @ApiOperation(value = "获取Frog详细信息",notes = "根据id查询对应Frog信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Map<String,Object> showById(@PathVariable int id){
        Map<String,Object> map = new HashMap<>();
        if(id == 1){
            map.put("FROG",new Hero(1,"one",3,new Date(),"showById"));
            map.put("RESULT","SUCCESS");
        }else{
            map.put("FROG",null);
            map.put("RESULT","ERROR");
        }
        return map;
    }

    @CacheEvict(allEntries = true)
    @ApiOperation(value = "添加Frog详细信息",notes = "添加一条Frog的详细信息")
    @ApiImplicitParam(name = "frog", value = "Frog实体", required = true, dataType = "Frog")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody Hero frog){
        Map<String,Object> map = new HashMap<>();
        map.put("FROG",frog);
        map.put("RESULT","SUCCESS");
        return map;
    }

    @CacheEvict(allEntries = true)
    @ApiOperation(value = "删除Frog详细信息",notes = "根据id删除对应Frog的详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteById(@PathVariable int id){
        Map<String,Object> map = new HashMap<>();
        if(id != 0){
            map.put("FROG",new Hero(id,"testfrog",id,new Date(),"deleteById"));
            map.put("RESULT","SUCCESS");
        }else{
            map.put("FROG",null);
            map.put("RESULT","ERROR");
        }
        return map;
    }

    @CacheEvict(allEntries = true)
    @ApiOperation(value = "更新Frog详细信息",notes = "根据id更新Frog的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "frog", value = "Frog实体", required = true, dataType = "Frog")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Map<String,Object> updateById(@PathVariable int id,@RequestBody Hero frog){
        Map<String,Object> map = new HashMap<>();
        map.put("FROG",frog);
        map.put("RESULT","SUCCESS");
        map.put("ID",id);
        return map;
    }


}
