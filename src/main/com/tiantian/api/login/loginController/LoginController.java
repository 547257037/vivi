package com.tiantian.api.login.loginController;

import com.tiantian.api.dictionaries.dictionariesEntity.Hero;
import com.tiantian.api.login.loginService.IloginService;
import com.tiantian.common.ResponseResult;
import com.tiantian.common.TianTianConst;
import com.tiantian.utils.CookieUtils;
import com.tiantian.utils.JacksonUtil;
import com.tiantian.utils.RedisUtils;
import com.tiantian.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Scope(value = "prototype")
@RequestMapping("LoginController")
public class LoginController {
    @Autowired
    private IloginService iloginService;

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public ResponseResult login(@RequestBody(required = false) Hero user, HttpServletResponse response, HttpServletRequest request) {

        Hero hero = iloginService.login(user);

        if (hero != null) {

            //登录成功
            //生成token
            String token = UUID.randomUUID().toString();
            //把用户信息写入redis
            //key:REDIS_SESSION:{TOKEN}
            //value:user转json
            hero.setHeroPassword(null);
            RedisUtils.set(TianTianConst.REDIS_SESSION_KEY + ":" + token, JacksonUtil.objectToJSon(user));
            //设置session的过期时间
            RedisUtils.expire(TianTianConst.REDIS_SESSION_KEY + ":" + token, TianTianConst.SESSION_EXPIRE);
            //写cookie
            CookieUtils.setCookie(request, response, TianTianConst.HERO_TOKEN, token);

            return ResponseResult.putSuccessData(token);
        } else {
            //登录失败，,设置提示信息，跳转到登录页面
            //输入的验证码错误,设置提示信息，跳转到登录页面
            return ResponseResult.putError("用户名或者密码输入错误！");
        }

    }

    }
