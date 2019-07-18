package com.zb.user9999.service.impl;

import com.zb.user9999.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author zb
 * @date 2019/7/9 10:14
 **/
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Override
    public void sendRegesiterMail(String mail, String n) throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();


        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);


        //邮件设置
        helper.setSubject("验证码");
        helper.setText("你的验证码是" + n, true);

        helper.setTo(mail);
        helper.setFrom("hhu_zb@foxmail.com");
        javaMailSender.send(mimeMessage);


    }
}
