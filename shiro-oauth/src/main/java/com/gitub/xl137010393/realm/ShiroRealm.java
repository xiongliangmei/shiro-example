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
/*        Object principal = principals.getPrimaryPrincipal();

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
        }*/
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> permissionSet = new HashSet<>();
        permissionSet.add("user:add");
        permissionSet.add("user:delete");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionSet);
        info.addRole("admin");
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
 /*       UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if ("admin".equals(token.getUsername())&&"123456".equals(token.getPassword())){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
            return info;
        }*/
        String useranme = (String) authenticationToken.getPrincipal();
        if ("".equals(useranme)){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(useranme,"123456",this.getName());

        return info;
    }
}
