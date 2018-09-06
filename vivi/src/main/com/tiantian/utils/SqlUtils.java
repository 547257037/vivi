package com.tiantian.utils;

import com.google.common.collect.Lists;
import com.tiantian.config.exception.StarvException;

import java.util.Collection;
import java.util.List;

/**
 * Created by zyx on 2017/6/30.
 */
public class SqlUtils {

    /**
     * 转成一个sql字符串
     * <p>
     * EXPLAIN：
     * <p>
     * 相当于mybatis中的foreach
     * <p>
     * 样例：
     * <p>
     * [1, 2, 3, 4, 5] --> (1, 2, 3, 4, 5)
     * ["1", "2", "3"] --> ('1', '2', '3')
     *
     * @param contentList 内容集合
     * @param isNumber    是否为数字，不是数字需要加引号
     */
    public static String ToInSql(List<String> contentList, boolean isNumber) {

        if (contentList.size() == 0) {
            throw new StarvException("集合不能为空");
        }

        StringBuilder sb = new StringBuilder(" (");
        if (isNumber) {
            for (String c : contentList) {
                sb.append(c).append(",");
            }
        } else {
            for (String c : contentList) {
                sb.append("'").append(c).append("'").append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") ");

        return sb.toString();
    }

    public static String ToInSql(List<String> contentList) {
        return ToInSql(contentList, false);
    }


    public static String ToInSql(boolean isNumber, String... content) {
        return ToInSql(Lists.newArrayList(content), isNumber);
    }

    public static String ToInSql(String... content) {
        return ToInSql(Lists.newArrayList(content), false);
    }

    public static String collectionToInSql(Collection contentList, boolean isNumber) {

        if (contentList.size() == 0) {
            throw new StarvException("集合不能为空");
        }

        StringBuilder sb = new StringBuilder(" (");
        if (isNumber) {
            for (Object c : contentList) {
                sb.append(c).append(",");
            }
        } else {
            for (Object c : contentList) {
                sb.append("'").append(c).append("'").append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") ");

        return sb.toString();
    }

    public static String collectionToInSql(Collection collection) {
        return collectionToInSql(collection, false);
    }
}
