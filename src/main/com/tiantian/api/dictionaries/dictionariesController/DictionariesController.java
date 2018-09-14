package com.tiantian.api.dictionaries.dictionariesController;

import com.tiantian.api.dictionaries.dictionariesService.IDictionariesService;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.common.ResponseResult;


import com.tiantian.config.exception.StarvException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;


@RestController
@Scope(value = "prototype")
@RequestMapping("DictionariesController")
public class DictionariesController {
    @Autowired
   private IDictionariesService dictionariesService;
    @GetMapping("getDictionariesHeroList")
    public ResponseResult getAllDictionariesHeroList(){
        Map<Integer, List<Hero>> collect = dictionariesService.getAllDictionariesHeroList().stream().collect(groupingBy(x -> x.getHeroType(), mapping(x -> x, toList())));
        collect.values().stream().forEach(x->x.stream().sorted(Comparator.comparing(Hero::getHeroLv).reversed()));
        return ResponseResult.putSuccessData(collect);
    }

    @ResponseBody
    @RequestMapping("sveDictionariesHero")
    public ResponseResult sveDictionariesHero(Hero hero) throws IOException {
           try {
               if (dictionariesService.findHeroByUsername(hero)) {
                   return ResponseResult.putSuccessMessage("     后台报错了，大兄嘚！");
               }

           }catch ( Exception e){
               throw new StarvException(e.getMessage());
           }
        dictionariesService.sveDictionariesHero(hero);
        return ResponseResult.putSuccessMessage("    恭喜你！My Hero！");
        }

    }
