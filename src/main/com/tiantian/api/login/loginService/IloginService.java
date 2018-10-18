package com.tiantian.api.login.loginService;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;

import javax.servlet.http.HttpServletRequest;

public interface IloginService {
    Hero login(Hero user);
    Hero getUserByToken(HttpServletRequest request);
}
