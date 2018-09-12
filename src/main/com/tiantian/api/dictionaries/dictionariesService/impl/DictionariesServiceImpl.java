package com.tiantian.api.dictionaries.dictionariesService.impl;

import com.tiantian.api.dictionaries.dictionariesDao.IDictionariesHeroDao;
import com.tiantian.api.dictionaries.dictionariesDao.impl.DictionariesHeroDaoImpl;
import com.tiantian.api.dictionaries.dictionariesService.IDictionariesService;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.utils.MD5Utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service

public class DictionariesServiceImpl implements IDictionariesService {
    @Autowired
    private IDictionariesHeroDao dictionariesHeroDao;
    @Override
    public List<Hero>  getAllDictionariesHeroList() {
        return dictionariesHeroDao.getAllDictionariesHeroList();
    }


    @Transactional
    @Override
    public void sveDictionariesHero(Hero hero) throws IOException {
        StringBuffer videoPath = new StringBuffer();
        StringBuffer imagePath = new StringBuffer();
        MultipartFile[] videofiles = hero.getVideoFiles();
        MultipartFile[] imagefiles = hero.getImageFiles();
        for (MultipartFile imagefile : imagefiles) {
            String originalFilename = imagefile.getOriginalFilename();
            File f = new File(DictionariesHeroDaoImpl.class.getResource("/static/images").getPath()+"/"+originalFilename);
                 f.delete();
                FileOutputStream fileOutputStream = FileUtils.openOutputStream(f);
                imagePath.append("|"+f.toString());
                IOUtils.copy(imagefile.getInputStream(),fileOutputStream);

        }
        for (MultipartFile videofile : videofiles) {
            String originalFilename = videofile.getOriginalFilename();
            File f = new File(DictionariesHeroDaoImpl.class.getResource("/static/video").getPath()+"/"+originalFilename);
                f.delete();
                videoPath.append(","+f.toString());
                FileOutputStream fileOutputStream = FileUtils.openOutputStream(f);
                IOUtils.copy(videofile.getInputStream(),fileOutputStream);

        }


        System.out.println(imagePath.toString());
        System.out.println(videoPath.toString());
        hero.setImgPath(imagePath.toString().substring(1));
        hero.setVideoPath(videoPath.toString().substring(1));
        hero.setHeroPassword(MD5Utils.md5(hero.getHeroPassword()));
        dictionariesHeroDao.sveDictionariesHero(hero);
    }

    @Override
    public boolean findHeroByUsername(Hero hero) {
        return dictionariesHeroDao.findHeroByUsername(hero.getHeroName()) != null;
    }
    public static void main(String[] s){
        File f = new File(DictionariesHeroDaoImpl.class.getResource("/static/video").getPath()+"/");
        System.out.println(f);
    }
}
