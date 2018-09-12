package com.tiantian.api.dictionaries.dictionariesController;

import com.tiantian.api.dictionaries.dictionariesService.IDictionariesService;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.common.ResponseResult;


import com.tiantian.config.exception.StarvException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;



@RestController
@Scope(value = "prototype")
@RequestMapping("DictionariesController")
public class DictionariesController {
    @Autowired
   private IDictionariesService dictionariesService;
    @GetMapping("getDictionariesHeroList")
    public ResponseResult getAllDictionariesHeroList(){

        return ResponseResult.putSuccessData(dictionariesService.getAllDictionariesHeroList());
    }

    @ResponseBody
    @RequestMapping("sveDictionariesHero")
    public ResponseResult sveDictionariesHero(Hero hero) throws IOException {
           try {
               if (dictionariesService.findHeroByUsername(hero)) {
                   return ResponseResult.putError("添加失败，用户名重复");
               }

           }catch ( Exception e){
               throw new StarvException(e.getMessage());
           }
        dictionariesService.sveDictionariesHero(hero);
        return ResponseResult.putSuccessMessage("添加成功");
        }

    }
