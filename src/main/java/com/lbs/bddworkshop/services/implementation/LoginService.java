package com.lbs.bddworkshop.services.implementation;

import com.lbs.bddworkshop.dao.IUserDao;
import com.lbs.bddworkshop.dao.entity.User;
import com.lbs.bddworkshop.domain.UserDto;
import com.lbs.bddworkshop.services.ILoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private IUserDao userDao;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void signUp(UserDto userDto) {
        Assert.notNull(userDto, "invalid request");
        Assert.hasText(userDto.getUsername(), "invalid username");

        User existingUser = userDao.findOne(Example.of(new User(userDto.getUsername())));
        Assert.isNull(existingUser, "user exists");

        Assert.hasText(userDto.getPassword(), "invalid password");
        Assert.isTrue(userDto.getPassword().length() >= 3, "invalid password");

        Assert.hasText(userDto.getEmail(), "invalid email");
        Assert.isTrue(userDto.getEmail().contains("@"), "invalid email");

        User user = modelMapper.map(userDto, User.class);
        userDao.save(user);
    }

    @Override
    public String signIn(String username, String password) {
        Assert.hasText(username, "invalid username");
        Assert.hasText(password, "invalid password");

        User user = userDao.findOne(Example.of(new User(username, password)));
        Assert.notNull(user, "user not found");
        return user.getId().toString();
    }

    @Override
    public UserDto getUser(String userId) {
        Assert.hasText(userId, "user not found");

        User user = userDao.findOne(UUID.fromString(userId));
        Assert.notNull(user, "user not found");

        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
