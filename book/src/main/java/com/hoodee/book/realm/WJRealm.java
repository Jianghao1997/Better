package com.hoodee.book.realm;

import com.hoodee.book.pojo.User;
import com.hoodee.book.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Package: com.hoodee.book.realm
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 20:38
 * Modified By:
 */
@Slf4j
public class WJRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    /**
     * 简单重写获取授权信息方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 获取认证信息，即根据 token 中的用户名从数据库中获取密码、盐等并返回
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        User user = userService.getByUserName(username);
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        } else {
            String passwordInDB = user.getPassword();
            String salt = user.getSalt();
            log.info("加盐内容 :{}",salt);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,passwordInDB, ByteSource.Util.bytes(salt), getName());
            return authenticationInfo;
        }
    }
}
