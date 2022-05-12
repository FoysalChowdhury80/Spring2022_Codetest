package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import webDriver.Web;

public class Homework_3 {

    /**
     * TC-1:  darksky.net
     * Verify correct temperature value is displayed after changing temperature units
     */

    @Test
    public static void isCorrectTempDisplayed (){
        Web.launchUrlOnNewWindow("https://www.darksky.net");

        By currentTempInFh = By.xpath("//span[@class='desc swap']//span[@class='summary swap']");
        WebElement currentTempFhElement = Web.getDriver().findElement(currentTempInFh);
        String currentTempFhString = currentTempFhElement.getText();
        int convertedCurrentFhTemp = Integer.parseInt(currentTempFhString.substring(0,2));
        By temperatureButtonLocator = By.xpath("//div[@class='selectric-wrapper selectric-units selectric-below']");
        WebElement temperatureButtonElement = Web.getDriver().findElement(temperatureButtonLocator);
        temperatureButtonElement.click();




    }

    /**
     * TC-2: facebook.com
     * Verify current date is selected in the dropdown when user lands on the Create new account form
     */

    /**
     * TC-3: https://classroomessentialsonline.com/
     * Verify user lands on Economy Church Chairs page after clicking the option from Church Chairs
     */


}
