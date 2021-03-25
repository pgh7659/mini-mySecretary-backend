package com.gil.mySecretary.config.auth.service;

import com.gil.mySecretary.config.auth.exception.OAuth2AuthenticationProcessingException;
import com.gil.mySecretary.config.auth.model.AuthProvider;
import com.gil.mySecretary.config.auth.model.GoogleOAuth2UserInfo;
import com.gil.mySecretary.config.auth.model.NaverOAuth2UserInfo;
import com.gil.mySecretary.config.auth.model.OAuth2UserInfo;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.GOOGLE.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if(registrationId.equalsIgnoreCase(AuthProvider.NAVER.toString())) {
            return new NaverOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("[" + registrationId + "] => is not supported!");
        }
    }
}
