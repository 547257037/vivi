package com.tiantian.api.dictionaries.dictionariesDao.impl;

import com.tiantian.api.dictionaries.dictionariesDao.IDictionariesHeroDao;
import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.common.Jdbc;
import com.tiantian.mapper.psql.IDictionariesHeroDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DictionariesHeroDaoImpl implements IDictionariesHeroDao {

    @Autowired
    private Jdbc psql;
      @Autowired
    private IDictionariesHeroDaoMapper iDictionariesHeroDaoMapper;
    @Override
    public List<Hero> getAllDictionariesHeroList(Hero hero) {
        return iDictionariesHeroDaoMapper.getAllDictionariesHeroList(hero);
    }

    @Override
    public void sveDictionariesHero(Hero hero) {
        String insertSql="insert into hero3(hero_name,hero_password,hero_type,hero_price,img_path,video_path,hero_describe) values(?,?,?,?,?,?,?)";
        psql.update(insertSql,hero.getHeroName(),hero.getHeroPassword(),hero.getHeroType(),hero.getHeroPrice(),hero.getImgPath(),hero.getVideoPath(),hero.getDescribe());
    }

    @Override
    public Hero findHeroByUsername(String heroName) {
        String sql = "select * from hero where hero_name = ? ";
        return psql.queryOneObject(sql,new BeanPropertyRowMapper<>(Hero.class),heroName);
    }

    @Override
    public Hero findUserByUsernameAndPassword(String heroName, String password) {
        return null;
    }

}
