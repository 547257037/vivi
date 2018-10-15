package com.tiantian.api.order.orderController;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;

import com.tiantian.utils.RedisUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CacheConfig(cacheNames = "frogtest")
@RestController
@RequestMapping(value = "/frogtest")
public class FrogTestController {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<Hero> set(@PathVariable String id){
        RedisUtils.set(id,id);
        List<Hero> list = new ArrayList<>();
        list.add(new Hero(1,"one",2,new Date(),"controllertest"));
        list.add(new Hero(2,"two",3,new Date(),"controllertest"));
        return list;
    }



    @CacheEvict(allEntries = true)

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody Hero frog){
        Map<String,Object> map = new HashMap<>();
        map.put("FROG",frog);
        map.put("RESULT","SUCCESS");
        return map;
    }

    @CacheEvict(allEntries = true)

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

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Map<String,Object> updateById(@PathVariable int id,@RequestBody Hero frog){
        Map<String,Object> map = new HashMap<>();
        map.put("FROG",frog);
        map.put("RESULT","SUCCESS");
        map.put("ID",id);
        return map;
    }


}
