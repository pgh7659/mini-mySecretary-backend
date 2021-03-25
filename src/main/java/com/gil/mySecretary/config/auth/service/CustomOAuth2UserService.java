package com.gil.mySecretary.config.auth.service;

import com.gil.mySecretary.config.auth.exception.OAuth2AuthenticationProcessingException;
import com.gil.mySecretary.config.auth.model.AuthProvider;
import com.gil.mySecretary.config.auth.model.OAuth2UserInfo;
import com.gil.mySecretary.config.auth.model.UserPrincipal;
import com.gil.mySecretary.domain.user.User;
import com.gil.mySecretary.domain.user.UserRepository;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        return processOAuth2User(userRequest, oAuth2User);

    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory
                .getOAuth2UserInfo(
                        userRequest.getClientRegistration().getRegistrationId(),
                        oAuth2User.getAttributes()
                        );

        if(StringUtils.isBlank(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email is not found from Provider[" + userRequest.getClientRegistration().getRegistrationId() + "]");
        }

        Optional<User> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
            if(!user.getProvider().equals(AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase(Locale.ROOT)))) {
                throw new OAuth2AuthenticationProcessingException("Please use your " + user.getProvider() + " account to login.");
            }

            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(userRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User registerNewUser(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) {
        return userRepository.save(
                User
                        .builder()
                        .name(Optional.ofNullable(oAuth2UserInfo.getName()).orElse(oAuth2UserInfo.getEmail()))
                        .email(oAuth2UserInfo.getEmail())
                        .provider(AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase(Locale.ROOT)))
                        .providerId(oAuth2UserInfo.getId())
                        .build());
    }

    private User updateExistingUser(User user, OAuth2UserInfo oAuth2UserInfo) {
        user.changeName(Optional.ofNullable(oAuth2UserInfo.getName()).orElse(oAuth2UserInfo.getEmail()));

        return userRepository.save(user);
    }
}
