import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStepDef {
    WebDriver driver;
    By locationBox = By.xpath("//input[@type='text']");
    By searchButton= By.xpath("//a[@class='searchButton']");

    @Given("User will be on home page")
    public void given1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://darksky.net/");
    }
    @When("User delete the location box")
    public void when1(){
        driver.findElement(locationBox).clear();
    }
    @And("User enter the location")
    public void and1(){
        driver.findElement(locationBox).sendKeys("Cologne");
    }

    @And("Click the search button")
    public void and2(){
        driver.findElement(searchButton).click();
    }

    @Then("Verify the lowest and highest temp is displayed correctly")
    public void then1(){
        WebElement lowestTemp = driver.findElement(By.xpath("//span[@class='low-temp-text']"));
        WebElement highestTemp = driver.findElement(By.xpath("//span[@class='low-temp-text']"));
        lowestTemp.isDisplayed();
        highestTemp.isDisplayed();
    }
}
