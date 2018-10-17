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
    public ResponseResult login(@RequestBody Hero user, HttpServletResponse response, HttpServletRequest request) {
        Hero systemUser1 = (Hero) SessionUtils.getSessionAttr(TianTianConst.SESSION_SYSUSER);
        if(systemUser1!=null){
            return ResponseResult.putSuccessData(systemUser1, "已有用户登录,请先退出已登录用户");
        }
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
            CookieUtils.setCookie(request, response, "HERO_TOKEN", token);


//            //登录成功,将user对象放入session，跳转到首页
//            hero.setHeroPassword(null);
//            HttpSession session = SessionUtils.getSession();
//            session.setAttribute(TianTianConst.SESSION_SYSUSER, hero);
//            session.setMaxInactiveInterval(60 * 60 * 10);
//            return ResponseResult.putSuccessData(hero, "登陆成功");
        } else {
            //登录失败，,设置提示信息，跳转到登录页面
            //输入的验证码错误,设置提示信息，跳转到登录页面
            return ResponseResult.putError("用户名或者密码输入错误！");
        }

    }


}
