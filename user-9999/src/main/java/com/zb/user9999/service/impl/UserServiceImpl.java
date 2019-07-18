package com.zb.user9999.service.impl;

/**
 * @author zb
 * @date 2019/7/5 20:13
 **/

import com.zb.base.bean.ResultData;
import com.zb.base.entity.UserEntity;
import com.zb.base.mapper.UserEntityMapper;
import com.zb.base.util.DateUtil;
import com.zb.user9999.mapper.UserMapper;
import com.zb.user9999.service.MailService;
import com.zb.user9999.service.UserService;
import com.zb.user9999.util.EncryptionUtil;
import com.zb.user9999.util.MaHashMapUtil;
import com.zb.user9999.util.MailUtil;
import com.zb.user9999.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserEntityMapper userEntityMapper;
    @Autowired
    MailService mailService;

    @Override
    public UserEntity findByMail(String mail) {
        UserEntity userEntity = userMapper.selectByMail(mail);
        return userEntity;
    }

    //注册
    @Override
    public ResultData<UserEntity> register(String mail, String password, String n) {
        ResultData<UserEntity> resultData = new ResultData<>();
        UserEntity userEntity = userMapper.selectByMail(mail);
        String N = MaHashMapUtil.hashMap.get(mail);
        if (N == null) {
            resultData.setResultMsg("验证码过时");
            resultData.setResultCode(107);
            resultData.setResultTime(DateUtil.getDate());
            return resultData;
        } else if (!N.equals(n)) {
            resultData.setResultMsg("验证码不正确");
            resultData.setResultCode(104);
            resultData.setResultTime(DateUtil.getDate());
            return resultData;
        } else {
            String md5password = EncryptionUtil.md5Encode(password, mail);
            UserEntity userEntity1 = new UserEntity();
            userEntity1.setuEmail(mail);
            userEntity1.setuPass(md5password);
            userEntity1.setuCtime(DateUtil.getDate());
            userEntityMapper.insert(userEntity1);
            // resultData.setResultData(userEntity);
            resultData.setResultCode(200);
            resultData.setResultMsg("注册成功");
            resultData.setResultTime(DateUtil.getDate());
            return resultData;
        }

    }

    //注册时，发送验证码
    @Override
    public ResultData<String> getN(String mail) throws MessagingException {
        ResultData<String> resultData = new ResultData<>();
        UserEntity userEntity = userMapper.selectByMail(mail);
        if (userEntity != null) {
            resultData.setResultMsg("该邮箱已经注册");
            resultData.setResultCode(103);
            resultData.setResultTime(DateUtil.getDate());
            return resultData;
        } else {
            String n = RandomUtil.getrandom();
            try {
                //MailUtil.sendRegesiterMail(mail, n);
                mailService.sendRegesiterMail(mail, n);
                try {
                    MaHashMapUtil.storageMa(mail, n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resultData.setResultCode(200);
                resultData.setResultMsg("邮件发送成功");
                resultData.setResultTime(DateUtil.getDate());
            } catch (Exception e) {
                resultData.setResultCode(105);
                resultData.setResultMsg("邮箱不正确");
                resultData.setResultTime(DateUtil.getDate());
                e.printStackTrace();
            }
            return resultData;
        }
    }
}

