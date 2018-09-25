package com.tiantian.api.login.loginService.loginServiceImpl;

import com.tiantian.api.dictionaries.dictionariesDao.IDictionariesHeroDao;
import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.api.login.loginService.IloginService;
import com.tiantian.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
