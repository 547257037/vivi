package com.tiantian.api.dictionaries.dictionariesController;

import com.tiantian.api.dictionaries.dictionariesService.IDictionariesService;

import com.tiantian.api.dictionaries.dictionariesVO.Hero;
import com.tiantian.common.ResponseResult;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.io.InputStream;


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
               dictionariesService.sveDictionariesHero(hero);
           }catch ( return ResponseResult.putSuccessMessage("添加成功"))
        return ResponseResult.putSuccessMessage("添加成功");
        }

    }
