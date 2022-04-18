package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.ACCEPT_INSECURE_CERTS;

public class CaseStudySelenium {

    private static WebDriver driver;

    public static void main(String[] arg) throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\manishabajirao.balwa\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver(caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");
        // userSection pushRight
        //List<WebElement> items = driver.findElements(By.cssSelector(".userSection pushRight"));
        //items.get(2).click();
        WebElement logOptionElement = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
        logOptionElement.click();

        Thread.sleep(100);
        //WebElement advElement = driver.findElement(By.cssSelector(".langCardClose"));
        //advElement.click();

        logOptionElement.click();

        WebElement mobileOrEmailNumber = driver.findElement(By.id("username"));
        mobileOrEmailNumber.sendKeys("asaahdakd");

        WebElement continueButton = driver.findElement(By.cssSelector("button.capText.font16"));
        if(!continueButton.isEnabled()){
            System.out.println("Invalid login details");
        }
        Thread.sleep(100);
        driver.navigate().to("https://www.makemytrip.com/");
        logOptionElement = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
        if(logOptionElement.isDisplayed())
        {
           logOptionElement.click();
        }
        mobileOrEmailNumber = driver.findElement(By.id("username"));
        mobileOrEmailNumber.sendKeys("8888082782");
        continueButton = driver.findElement(By.cssSelector("button.capText.font16"));
        if(continueButton.isEnabled()){
            System.out.println("Valid login details");
            continueButton.click();
        }



        // login using gmail
        Thread.sleep(50);
        driver.findElement(By.cssSelector("button.capText.font16")).click();

       // driver.close();
    }

}
