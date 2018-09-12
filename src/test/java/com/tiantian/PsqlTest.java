package com.tiantian;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PsqlTest {
    @Qualifier("pSql")
    @Autowired
    private JdbcTemplate psql;

    @Test
    public void gggg() throws Exception {
        List list  =psql.query("select * from hero ", new BeanPropertyRowMapper( Hero.class));
            System.out.println(list);

    }
}
