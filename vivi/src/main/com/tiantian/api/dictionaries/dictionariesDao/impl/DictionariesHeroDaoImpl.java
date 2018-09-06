package com.tiantian.api.dictionaries.dictionariesDao.impl;

import com.tiantian.api.dictionaries.dictionariesDao.IDictionariesHeroDao;
import com.tiantian.api.dictionaries.dictionariesEntity.DictionariesHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DictionariesHeroDaoImpl implements IDictionariesHeroDao {
    @Qualifier("pSql")
    @Autowired
    private JdbcTemplate psql;
    @Override
    public List<DictionariesHero> getAllDictionariesHeroList() {
        return psql.query("select * from hero ", new BeanPropertyRowMapper( DictionariesHero.class));
    }
}
