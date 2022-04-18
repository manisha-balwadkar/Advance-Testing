package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StudyMakeMyTrip {

    private static ChromeDriver driver;
    WebElement element;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\manishabajirao.balwa\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSeleniumLocatorsWithScrolling() {
        driver.get("https://www.makemytrip.com/");
        //Assert.assertEquals("5 Balloons | Jack of many web trades", driver.getTitle());
        System.out.println(driver.getTitle());

        // get by xpath
        WebElement element = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
        element.click();
        if(Elements.loginViaEmail.isSelected())
            Elements.loginViaEmail.click();

        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;

        // now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);",Elements.firstPassword);
        Elements.firstPassword.sendKeys("pswd");
        System.out.println(element.getText());

    }


    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}