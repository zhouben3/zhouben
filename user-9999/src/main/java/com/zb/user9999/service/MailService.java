package com.zb.user9999.service;

import javax.mail.MessagingException;

/**
 * @author zb
 * @date 2019/7/9 10:13
 **/
public interface MailService {
    //发送注册码
    public void sendRegesiterMail(String mail, String n) throws MessagingException;
}
