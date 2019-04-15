package com.lbs.test.helper;

import com.lbs.bddworkshop.domain.UserDto;
import com.lbs.bddworkshop.services.ILoginService;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.xpath.operations.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginHelper {

    @Autowired
    private ILoginService loginService;

    public void signUp(UserDto userDto) {
        loginService.signUp(userDto);
    }

    public String signIn(String username, String password) {
        return loginService.signIn(username, password);
    }

    public UserDto getUser(String userId) {
        return loginService.getUser(userId);
    }

    public boolean checkUsersAreEqual(UserDto userDto, UserDto signInUserDto) {
        return new EqualsBuilder()
                .append(userDto.getUsername(), signInUserDto.getUsername())
                .append(userDto.getPassword(), signInUserDto.getPassword())
                .append(userDto.getEmail(), signInUserDto.getEmail())
                .isEquals();
    }
}
