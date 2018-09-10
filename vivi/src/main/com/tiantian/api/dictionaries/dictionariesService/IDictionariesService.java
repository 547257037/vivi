package com.tiantian.api.dictionaries.dictionariesService;

import com.tiantian.api.dictionaries.dictionariesEntity.DictionariesHero;
import com.tiantian.api.dictionaries.dictionariesVO.ImgResultDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDictionariesService {
    List<DictionariesHero> getAllDictionariesHeroList();

    ImgResultDto sveDictionariesHero(List<MultipartFile> list, String imgUploadAbsolutePath, String imgUploadRelativePath, int i);
}
