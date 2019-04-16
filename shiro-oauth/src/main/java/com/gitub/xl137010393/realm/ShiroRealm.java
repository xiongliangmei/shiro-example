package com.gitub.xl137010393.realm;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    /***
     * 授权
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object principal = principals.getPrimaryPrincipal();

        Set<String> roles = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if ("admin".equals(principal.toString())) {
            roles.add("admin");
            info.setRoles(roles);
            info.addStringPermissions(Arrays.asList("admin:*"));
        } else if ("user".equals(principal.toString())) {
            roles.add("user");
            info.setRoles(roles);
            info.addStringPermissions(Arrays.asList("user:*"));
        }
        return info;
    }

    /****
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String principal = username;
        String credentials = "";

        if ("admin".equalsIgnoreCase(username)){
            credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
        }else if ("user".equalsIgnoreCase(username)){
            credentials ="";
        }
        String realmName = getName();
        ByteSource salt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(principal,credentials,salt,realmName);
        return info;
    }
}
