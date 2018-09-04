package com.tiantian.common;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author zyx
 * @date 2018/5/4.
 */
public class Jdbc extends JdbcTemplate {

    public Jdbc(DataSource dataSource) {
        super(dataSource);
    }

    public <T> T queryOneObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) {
        List<T> results = query(sql, args, new RowMapperResultSetExtractor<>(rowMapper, 1));
        if (CollectionUtils.isEmpty(results)) {
            return null;
        } else {
            return results.get(0);
        }
    }
}
