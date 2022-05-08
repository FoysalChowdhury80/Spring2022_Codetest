package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriver.Web;

public class Homework2 {

    /**
     * Testcase-1:
     *
     *
     * Verify "Keep me signed in" is NOT selected for messenger login page
     *
     * Click "Log in" button
     *
     * Verify "Incorrect email or phone number" is displayed
     *
     * Verify "Continue" button is enabled
     *
     *
     */

    /**
     * Steps:
     * 1. Launch https://www.facebook.com/
     * 2. Click messenger link
     * 3. Verify 'keep me signed in' checkbox is not selected
     */
    @Test
    public static void isSignedInSelected() {
        Web.launchUrlOnNewWindow("https://www.facebook.com/");
        By messangerLocator = By.xpath("//a[@ href='https://messenger.com/']");
        WebElement messengerElement = Web.getDriver().findElement(messangerLocator);
        messengerElement.click();
        By checkBox = By.xpath("//span[@class='_2qcu']");
        WebElement checkBoxElement = Web.getDriver().findElement(checkBox);
        Assert.assertFalse(checkBoxElement.isSelected(), "Checkbox is selected");
        Web.quitWindows();

    }

    /**
     * Testcase-2:
     * On Create new account page:
     * <p>
     * Verify the "Sign Up" button is enabled when user lands on the form
     * <p>
     * Enter the below details in Sign Up form EXCEPT DOB
     * First name
     * Last name
     * email
     * re-enter email
     * new password
     * click Sign Up
     * <p>
     * <p>
     * <p>
     * Verify "Please choose a gender. You can change who can see this later." is displayed
     */
    @Test
    public static void verifyisSignUpButtonEnabled() {
        Web.launchUrlOnNewWindow("https://www.facebook.com/");
        By createNewAccountLocator = By.xpath("//a[@data-testid='open-registration-form-button']");
        WebElement createNewAccountElement = Web.getDriver().findElement(createNewAccountLocator);
        createNewAccountElement.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By signUpButtonLocator = By.xpath("//button[@name='websubmit']");
        WebElement signUpButtonElement = Web.getDriver().findElement(signUpButtonLocator);
        boolean isSignUpButtonEnabled = signUpButtonElement.isEnabled();
        Assert.assertTrue(isSignUpButtonEnabled,"SignUp button is not enabled");
        Web.quitWindows();


}

    @Test
    public static void verifyErrorMessage() {
        Web.launchUrlOnNewWindow("https://www.facebook.com/");
        By createNewAccountLocator = By.xpath("//a[@data-testid='open-registration-form-button']");
        WebElement createNewAccountElement = Web.getDriver().findElement(createNewAccountLocator);
        createNewAccountElement.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By enterFirstNameLocator = By.xpath("//input[@name='firstname']");
        WebElement enterFirstNameElement = Web.getDriver().findElement(enterFirstNameLocator);
        enterFirstNameElement.sendKeys("ff");

        By enterLastNameLocator = By.xpath("//input[@name='lastname']");
        WebElement enterLastNameElement = Web.getDriver().findElement(enterLastNameLocator);
        enterLastNameElement.sendKeys("cc");

        By enterPhoneLocator = By.xpath("//input[@name='reg_email__']");
        WebElement enterPhoneNumElement = Web.getDriver().findElement(enterPhoneLocator);
        enterPhoneNumElement.sendKeys("1234567890");

        By enterPasswordLocator = By.id("password_step_input");
        WebElement enterPasswordElement = Web.getDriver().findElement(enterPasswordLocator);
        enterPasswordElement.sendKeys("646646646");

        By signUpButtonLocator = By.xpath("//button[@name='websubmit']");
        WebElement signUpButtonElement = Web.getDriver().findElement(signUpButtonLocator);
        signUpButtonElement.click();

        By errorMessageLocator = By.xpath("//div[text()='Please choose a gender. You can change who can see this later.']");
        WebElement errorMessageElement = Web.getDriver().findElement(errorMessageLocator);
       boolean isErrorMessageDisplayed = errorMessageElement.isDisplayed();

       Assert.assertTrue(isErrorMessageDisplayed,"Error message is not displayed");
       Web.quitWindows();


    }


}
