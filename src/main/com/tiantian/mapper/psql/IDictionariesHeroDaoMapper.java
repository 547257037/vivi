package com.tiantian.mapper.psql;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;

import java.util.List;

public interface IDictionariesHeroDaoMapper {
    List<Hero> getAllDictionariesHeroList(Hero hero);
}
