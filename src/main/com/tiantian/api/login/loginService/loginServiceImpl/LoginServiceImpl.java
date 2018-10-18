package com.tiantian.api.login.loginService.loginServiceImpl;

import com.tiantian.api.dictionaries.dictionariesDao.IDictionariesHeroDao;
import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.api.login.loginService.IloginService;
import com.tiantian.common.TianTianConst;
import com.tiantian.utils.CookieUtils;
import com.tiantian.utils.JacksonUtil;
import com.tiantian.utils.MD5Utils;
import com.tiantian.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements IloginService {
    @Autowired
    private IDictionariesHeroDao iDictionariesHeroDao;

    //用户登陆
    @Override
    public Hero login(Hero hero) {
        //使用MD5加密密码
        String password = MD5Utils.md5(hero.getHeroPassword());
        return iDictionariesHeroDao.findUserByUsernameAndPassword(hero.getHeroName(), password);

    }

    @Override
    public Hero getUserByToken(HttpServletRequest request) {
        //从cookie中取token
        String token = CookieUtils.getCookieValue(request, TianTianConst.HERO_TOKEN);
        //判断token是否有值
        if (StringUtils.isBlank(token)) {
            return null;
        }
        //调用sso的服务查询用户信息(查redis)
        Object o = RedisUtils.get(TianTianConst.HERO_TOKEN);
        JacksonUtil.jsonToObject(Redi);
        //把json转换成java对象


    }
}
