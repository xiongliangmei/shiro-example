package com.gitub.xl137010393.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/***
 * 授权控制器
 */
public class AuthorizeController {

    public Object authorize(Model model, HttpServletRequest request) throws OAuthProblemException {

        try {
            //构建OAuth 请求
            OAuthAuthzRequest oAuthAuthzRequest = new OAuthAuthzRequest(request);

        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
