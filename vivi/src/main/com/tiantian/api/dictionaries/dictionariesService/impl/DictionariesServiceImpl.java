package com.tiantian.api.dictionaries.dictionariesService.impl;

import com.tiantian.api.dictionaries.dictionariesDao.IDictionariesHeroDao;
import com.tiantian.api.dictionaries.dictionariesEntity.DictionariesHero;
import com.tiantian.api.dictionaries.dictionariesService.IDictionariesService;
import com.tiantian.api.dictionaries.dictionariesVO.ImgResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class DictionariesServiceImpl implements IDictionariesService {
    @Autowired
    private IDictionariesHeroDao dictionariesHeroDao;
    @Override
    public List<DictionariesHero>  getAllDictionariesHeroList() {
        return dictionariesHeroDao.getAllDictionariesHeroList();
    }

    @Override
    public ImgResultDto sveDictionariesHero(List<MultipartFile> list, String imgUploadAbsolutePath, String imgUploadRelativePath, int i) {



        ImgResultDto imgResultDto = new ImgResultDto();
        //这里定
        String[] urlData = new String[5];
        int index = 0;
        try {
            for(MultipartFile img : list) {
            //获取原始文件名，比如你上传的是　图片．jpg,则fileName＝图片．jpg
                String fileName = img.getOriginalFilename();
                if(fileName == "") {
                    continue;
                }

                String finalPath = imgUploadRelativePath;  //绝对路径　＋　相对路径
                //为了保证文件名不一致，因此文件名称使用当前的时间戳和4位的随机数，还有原始文件名组成
                //觉得实际的企业开发不应当使用原始文件名，否则上传者使用一些不好的名字，对于下载者就不好了．
                //这里为了调试方便，可以加上．
                String finalFileName =  (new Date().getTime()) + Math.round(Math.random() * 1000)  //文件名动态部分
                        + fileName; //文件名　原始文件名
                File newfile = new File( finalPath + finalFileName);

                //保存文件到本地
                img.transferTo(newfile);



                //这里的路径是项目路径＋文件路径＋文件名称
                //这么写不是规范的做法，项目路径应是放在前端处理，只需要发送相对路径和文件名称即可，项目路径由前端加上．
                urlData[index++] = imgUploadRelativePath + finalFileName;

                //设置异常代号
                imgResultDto.setErrno(0);
            }
            imgResultDto.setData(urlData);
            //返回Ｄto
            return imgResultDto;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return imgResultDto;
        }


    }
}
