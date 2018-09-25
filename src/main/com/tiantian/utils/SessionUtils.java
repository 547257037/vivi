package com.tiantian.utils;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.common.TianTianConst;
import com.tiantian.config.exception.StarvException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zyx on 2017/11/20.
 * 通过threadLocal方便获取session属性 无需从controller参数传递
 */
public class SessionUtils {

    public static HttpSession getSession() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (ra == null) {
            throw new StarvException("没有请求");
        }
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request.getSession();
    }

    public static Object getSessionAttr(String attr) {
        return getSession().getAttribute(attr);
    }

    public static Hero getSystemUser() {
        Hero user = (Hero) getSessionAttr(TianTianConst.SESSION_SYSUSER);
        if (user == null) {
            throw new StarvException("没有登录", TianTianConst.NO_LOGIN_ERROR_CODE);
        }
        return user;
    }
}
