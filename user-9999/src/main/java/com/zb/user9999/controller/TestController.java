package com.zb.user9999.controller;

import com.zb.base.bean.ResultData;
import com.zb.base.entity.UserEntity;
import com.zb.user9999.service.UserService;
import com.zb.user9999.util.EncryptionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zb
 * @date 2019/7/5 18:28
 **/
@Controller
//@RestController
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("test")
    public String test() {
        return "redirect:/login.html";
    }

    @ResponseBody
    @RequestMapping(value = "sendmail", method = RequestMethod.POST)
    //注册
    public ResultData<String> getN(String mail, HttpServletResponse response) throws MessagingException {
        //  System.out.println(mail);
        ResultData<String> resultData = new ResultData<>();
        resultData = userService.getN(mail);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return resultData;
    }

    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    //注册
    public ResultData<UserEntity> register(HttpServletResponse response, String mail, String password, String n) {
        ResultData<UserEntity> resultData = userService.register(mail, password, n);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return resultData;
    }

    @ResponseBody
    @RequestMapping("login")
    public ResultData login(String mail, String password, Integer rememberme, HttpSession session) {
        /**
         * 使用shiro编写认证操作
         */
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();

        String newpassword = EncryptionUtil.md5Encode(password, mail);
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(mail, newpassword);

        if (rememberme != null) {
            token.setRememberMe(true);
        }
        //3.执行登录方法
        ResultData resultData = new ResultData();
        try {
            subject.login(token);
            resultData.setResultCode(200);
            resultData.setResultMsg("登录成功");
            //往seesion里放值，还可放一些其他的
            session.setAttribute("mail", mail);
        } catch (UnknownAccountException e) {
            resultData.setResultCode(100);
            resultData.setResultMsg("用户邮箱不存在");
        } catch (IncorrectCredentialsException e) {
            resultData.setResultCode(101);
            resultData.setResultMsg("密码错误");
        } finally {
            return resultData;
        }
    }
}
