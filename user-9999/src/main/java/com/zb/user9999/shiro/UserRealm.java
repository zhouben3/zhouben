package com.zb.user9999.shiro;

import com.zb.base.bean.ResultData;
import com.zb.base.entity.UserEntity;
import com.zb.base.util.DateUtil;
import com.zb.user9999.mapper.UserMapper;
import com.zb.user9999.service.UserService;
import com.zb.user9999.util.EncryptionUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zb
 * @date 2019/6/26 20:42
 **/
//service层
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //授权的认证
        return null;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Autowired
    UserMapper userMapper;

    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //编写shiro判断逻辑，判断用户名密码是否正确
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //UserEntity userEntity = userService.findByMail(token.getUsername());
        UserEntity userEntity = userMapper.selectByMail(token.getUsername());
        if (userEntity == null) {
            //用户名不存在
            return null;//shiro底层会抛出UnkowAccountException
        }
        //比较密码
        return new SimpleAuthenticationInfo("", userEntity.getuPass(), "");
    }

}
