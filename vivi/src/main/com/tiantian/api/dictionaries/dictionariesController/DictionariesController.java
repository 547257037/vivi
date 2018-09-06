package com.tiantian.api.dictionaries.dictionariesController;

import com.tiantian.api.dictionaries.dictionariesService.IDictionariesService;
import com.tiantian.api.dictionaries.dictionariesVO.ImgResultDto;
import com.tiantian.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public ImgResultDto sveDictionariesHero(@RequestParam("img") List<MultipartFile> list) {

            //这里是我在web中定义的两个初始化属性，保存目录的绝对路径和相对路径，你们可以自定义
            String imgUploadAbsolutePath = "images/";
            String imgUploadRelativePath = "images/";

          //服务曾处理数据，返回Dto
            ImgResultDto imgResult
                    = dictionariesService.sveDictionariesHero(list, imgUploadAbsolutePath,
                    imgUploadRelativePath,1);
            return imgResult;
        }

    }
