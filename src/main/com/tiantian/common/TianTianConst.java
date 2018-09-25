package com.tiantian.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * 常量仓库
 * <p>
 * 一点小小的重构建议哈：
 * <p>
 * 1. 将逻辑上可以归为一类的合并到一个内部静态类，项数过多，分组管理更爽  by CC11001100@qq.com 2017-8-25 01:29:27
 * <p>
 * <p>
 * <p>
 * Created by zyx on 2017/6/23.
 */
@Lazy(false)
@Component
public class TianTianConst {

    private static String APPLICATION_PROFILE;

//    @Value("${spring.profiles.active}")
//    public void setApplicationProfile(String applicationProfile) {
//        APPLICATION_PROFILE = applicationProfile;
//    }

//    private static final String PROFILE_DEV = "dev";
//
//    private static final String PROFILE_PROD = "prod";
//
//    private static final String PROFILE_PROD_TEST = "prod-test";
//
//    private static final String PROFILE_SLAVE = "slave";
//
//    public static boolean isDev() {
//        return APPLICATION_PROFILE.equals(PROFILE_DEV);
//    }
//
//    public static boolean isProd() {
//        return APPLICATION_PROFILE.equals(PROFILE_PROD);
//    }
//
//    public static boolean isProdTest() {
//        return APPLICATION_PROFILE.equals(PROFILE_PROD_TEST);
//    }
//
//    public static boolean isSlave() {
//        return APPLICATION_PROFILE.equals(PROFILE_SLAVE);
//    }

    public static final String PROJECT_URL = "/iptv4";

    public static final String ROOT_ROLE_NAME = "root";

    public static final String ROOT_SYSUSER_NAME = "xinghongan";

    public static final Pattern PHONE_VALIDATE_REGEX = Pattern.compile("^(13\\d{9}$)|(14\\d{9}$)|(17\\d{9}$)|(15\\d{9}$)|" +
            "(18\\d{9}$)");

    public static final String SESSION_SYSUSER = "SESSION_SYSUSER";

    public static final String SESSION_ROLE_INFO = "SESSION_ROLE_INFO";

    public static final String LOGIN_URL = "/systemUserController/login";//登陆接口

    public static final String LOGOUT_URL = "/systemUserController/logout";//退出接口

    public static final int MENU_STATUS_OPEN = 1;//可以访问的菜单

    public static final int MENU_STATUS_CLOSE = 0;

    public static final int SUCCESS_CODE = 0;//成功

    public static final int CUSTOMS_ERROR_CODE = 1;//自定义异常

    public static final int NO_PERMISSION_ERROR_CODE = 100;//接口权限异常

    public static final int NO_LOGIN_ERROR_CODE = 101;//未登陆异常

    public static final int UNCHECKED_ERROR_CODE = 999;//未捕获异常

    public static final String ROOT_AREA_CODE = "ALL";
    public static final Long ROOT_MENU_ID = 0L;

    public static final String AREA_ROOT_PARENTCODE = "-1";

    /**
     * 联通栏目根父节点
     */
    public static final String STARV_COLUMN_SEL_ROOT_PARENTCODE = "-1";

    /**
     * 移动栏目父节点
     *
    */
    public static final String STARV_COLUMN_SEL_ROOT_PARENTCODE_YD = "1";

    public static final String PLATFORM_TYPE_HW = "HW";
    public static final String PLATFORM_TYPE_ALL = "ALL";
    public static final String PlATFORM_TYPE_ZTE = "ZTE";

    public static final String OPERATOR_LT = "LT";
    public static final String OPERATOR_YD = "YD";
    public static final String OPERATOR_DX = "DX";
    public static final long ALL_CHANNEL_GROUP_CODE = -1L;

    public static final String WEEK_TMP_TABLE = "tmp_week";

    public static final String MONTH_TMP_TABLE = "tmp_month";

    public static final String HOUR_TMP_TABLE = "tmp_hour";

    public static final String THIRTY_MINUTE_TMP_TABLE = "tmp_thirty_minute";

    public static final String TEN_MINUTE_TMP_TABLE = "tmp_ten_minute";

    public static final String FIVE_MINUTE_TMP_TABLE = "tmp_five_minute";

    public static final String MINUTE_TMP_TABLE = "tmp_minute";
    public static final String TMP_SECOND = "tmp_second";



    //定时

    public static final String HAIKAN_CHANNEL = "海看频道";
    public static final String SHANDONG_CHANNEL = "山东卫视高清频道";
    public static final String CHU_ZIBAN_DISHI_CHANNEL = "除自办频道和地市频道";
    public static final String CHU_ZIBAN_DISHI_CHANNEL_GOLD = "除自办频道和地市频道黄金时段";
    public static final String JINAN_CHANNEL = "济南频道";
    public static final String JINAN_CHANNEL_GOLD = "济南频道黄金时段";
    public static final String JUJIAGOUWU_CHANNEL = "居家购物频道";







}
