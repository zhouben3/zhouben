package com.zb.user9999.service;

import com.zb.base.bean.ResultData;
import com.zb.base.entity.UserEntity;

import javax.mail.MessagingException;

/**
 * @author zb
 * @date 2019/7/5 20:11
 **/
public interface UserService {
    //注册
    public ResultData<UserEntity> register(String mail, String password,String n);

    public ResultData<String> getN(String mail) throws MessagingException;


    public UserEntity findByMail(String mail);
}
