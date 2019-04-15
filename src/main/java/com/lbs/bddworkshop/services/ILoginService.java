package com.lbs.bddworkshop.services;

import com.lbs.bddworkshop.domain.UserDto;

public interface ILoginService {
    void signUp(UserDto userDto);

    String signIn(String username, String password);

    UserDto getUser(String userId);
}
