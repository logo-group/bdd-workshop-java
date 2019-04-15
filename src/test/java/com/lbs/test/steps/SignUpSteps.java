package com.lbs.test.steps;

import com.lbs.bddworkshop.domain.UserDto;
import com.lbs.test.configuration.AppConfiguration;
import com.lbs.test.helper.LoginHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = AppConfiguration.class)
public class SignUpSteps {

    @Autowired
    private LoginHelper loginHelper;

    private UserDto signUpUserDto;

    @Before
    public void reset(){
        signUpUserDto = null;
    }

    @When("^I try to sign-up with following$")
    public void iTryToSignUpWithFollowing(DataTable table) {
        List<UserDto> userDtoList = table.asList(UserDto.class);

        Assert.assertNotNull(userDtoList);
        Assert.assertTrue(userDtoList.size() == 1);

        signUpUserDto = userDtoList.get(0);

    }

    @Then("^Sign-up completed successfully$")
    public void signUpCompletedSuccessfully() {
        try{
            loginHelper.signUp(signUpUserDto);
        }catch (Exception e){
            Assert.fail();
        }
    }

    @Then("^Sign-up completed unsuccessfully with message \"([^\"]*)\"$")
    public void signUpCompletedUnsuccessfullyWithMessage(String message) throws Throwable {
        try{
            loginHelper.signUp(signUpUserDto);
            Assert.fail();
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(), message);
        }
    }
}
