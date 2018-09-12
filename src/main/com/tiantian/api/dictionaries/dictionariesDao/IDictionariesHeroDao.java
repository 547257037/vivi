package com.tiantian.api.dictionaries.dictionariesDao;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;

import java.util.List;

public interface IDictionariesHeroDao {
    List<Hero> getAllDictionariesHeroList();

    void sveDictionariesHero(Hero hero);

    Hero findHeroByUsername(String heroName);
}
