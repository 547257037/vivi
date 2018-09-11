package com.tiantian.api.dictionaries.dictionariesService.impl;

import com.tiantian.api.dictionaries.dictionariesDao.IDictionariesHeroDao;
import com.tiantian.api.dictionaries.dictionariesEntity.DictionariesHero;
import com.tiantian.api.dictionaries.dictionariesService.IDictionariesService;

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
    public void sveDictionariesHero(List<MultipartFile> list, String imgUploadAbsolutePath, String imgUploadRelativePath, int i) {






    }
}
