package com.tiantian.api.dictionaries.dictionariesService;

import com.tiantian.api.dictionaries.dictionariesEntity.DictionariesHero;

import com.tiantian.api.dictionaries.dictionariesVO.Hero;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDictionariesService {
    List<DictionariesHero> getAllDictionariesHeroList();

    void sveDictionariesHero(List<MultipartFile> list, String imgUploadAbsolutePath, String imgUploadRelativePath, int i);

    void sveDictionariesHero(Hero hero);
}
