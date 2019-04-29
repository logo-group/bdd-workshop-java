package com.lbs.bddworkshop.rest;

import com.lbs.bddworkshop.domain.UserDto;
import com.lbs.bddworkshop.services.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class LoginRestController implements ILoginService {

    @Autowired
    private ILoginService loginService;

    @Override
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public void signUp(@RequestBody UserDto userDto) {
        loginService.signUp(userDto);
    }

    @Override
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@RequestParam String username, @RequestParam String password) {
        return loginService.signIn(username, password);
    }

    @Override
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDto getUser(String userId) {
        return loginService.getUser(userId);
    }
}
