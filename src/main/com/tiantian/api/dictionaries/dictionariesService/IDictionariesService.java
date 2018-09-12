package com.tiantian.api.dictionaries.dictionariesService;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;

import java.io.IOException;
import java.util.List;

public interface IDictionariesService {
    List<Hero> getAllDictionariesHeroList();



    void sveDictionariesHero(Hero hero) throws IOException;

    boolean findHeroByUsername(Hero hero);
}
