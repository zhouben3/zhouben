package com.zb.user9999.util;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author zb
 * @date 2019/7/8 19:47
 **/
public class MailUtil {
    public static void sendRegesiterMail(String mail, String n) throws MessagingException {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        System.out.println(javaMailSender);
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);


        //邮件设置
        helper.setSubject("验证码");
        helper.setText("你的验证码是" + n, true);

        helper.setTo(mail);
        helper.setFrom("hhu_zb@foxmail.com");

        // helper.addAttachment("1.txt", new File("C:\\Users\\zhouben\\Desktop\\R\\新建文本文档 (2).txt"));
        javaMailSender.send(mimeMessage);
    }

}
