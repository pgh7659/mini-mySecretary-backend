package com.gil.mySecretary.config.auth.model;

import java.util.Map;

public class NaverOAuth2UserInfo extends OAuth2UserInfo {
    public NaverOAuth2UserInfo(Map<String, Object> attributes) {
        super((Map<String, Object>) attributes.get("response"));
    }

    @Override
    public String getId() {
        return (String) super.attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) super.attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) super.attributes.get("email");
    }
}
