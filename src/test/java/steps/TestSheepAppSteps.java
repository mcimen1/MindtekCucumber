package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.TestSheepHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class TestSheepAppSteps {

WebDriver driver= Driver.getDriver();

TestSheepHomePage testSheepHomePage=new TestSheepHomePage();

    @Given("user navigates to TestSheep application")
    public void user_navigates_to_TestSheep_application() {
        driver.get(ConfigReader.getProperty("TestSheepURL"));


    }


    @When("user enters {String} as first number")
    public void user_enters_as_first_number(String int1) {
        testSheepHomePage.number1.sendKeys(int1.toString());


    }
    @When("user enters {string} as second number")
    public void user_enters_as_second_number(String int1) {
        testSheepHomePage.number2.sendKeys(int1.toString());



    }
    @When("user selects {string} operator")
    public void user_selects_operator(String string) {

        BrowserUtils.selectByText(testSheepHomePage.operatorDropdown,string);

    }
    @When("user clicks on calculate button")
    public void user_clicks_on_calculate_button() {
        testSheepHomePage.calculateButton.sendKeys(Keys.ENTER);

    }
    @Then("user validates that output is {int}")
    public void user_validates_that_output_is(Integer int1) {
       String actualAnswer= testSheepHomePage.answerField.getAttribute("value");
       Assert.assertEquals(int1.toString(),actualAnswer);

    }


    @Then("user validates {string} error message")
    public void userValidatesErrorMessage(String string) {
        String actualErrorMessage=testSheepHomePage.errorMessage.getText();
        Assert.assertEquals(string,actualErrorMessage);

    }


    @When("user enters {string} as first number")
    public void userEntersAsFirstNumber(String string) {
        testSheepHomePage.number1.sendKeys(string,toString());
    }
}





