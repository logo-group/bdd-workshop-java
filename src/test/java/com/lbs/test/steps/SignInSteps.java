package com.lbs.test.steps;

import com.lbs.bddworkshop.domain.UserDto;
import com.lbs.test.configuration.AppConfiguration;
import com.lbs.test.helper.LoginHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = AppConfiguration.class)
public class SignInSteps {

    @Autowired
    private LoginHelper loginHelper;

    private String signInUsername;
    private String signInPassword;
    private String signInUserId;

    @Before
    public void reset(){
        signInUserId = null;
        signInUsername = null;
        signInPassword = null;
    }

    @Given("^There are users$")
    public void thereAreUsers(DataTable table) {
        List<UserDto> userDtoList = table.asList(UserDto.class);

        Assert.assertNotNull(userDtoList);
        Assert.assertTrue(userDtoList.size() > 0);

        userDtoList.forEach(userDto -> loginHelper.signUp(userDto));
    }

    @When("^I try to sign-in with \"([^\"]*)\", \"([^\"]*)\"$")
    public void iTryToSignInWith(String username, String password) throws Throwable {
        this.signInUsername = username;
        this.signInPassword = password;
    }

    @Then("^Sign-in completed successfully$")
    public void signInCompletedSuccessfully() {
        signInUserId = loginHelper.signIn(signInUsername, signInPassword);
    }

    @Then("^Sign-in completed unsuccessfully with message \"([^\"]*)\"$")
    public void signInCompletedUnsuccessfullyWithMessage(String message) throws Throwable {
        try{
            loginHelper.signIn(signInUsername, signInPassword);
            Assert.fail();
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(), message);
        }
    }

    @And("^Following user obtained$")
    public void followingUserObtained(DataTable table) {
        List<UserDto> userDtoList = table.asList(UserDto.class);
        Assert.assertNotNull(userDtoList);
        Assert.assertTrue(userDtoList.size() == 1);

        UserDto signInUserDto = loginHelper.getUser(signInUserId);

        boolean areEquals = loginHelper.checkUsersAreEqual(userDtoList.get(0), signInUserDto);
    }
}
