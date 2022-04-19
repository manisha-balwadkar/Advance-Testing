package com.company;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSelenium {

    private static ChromeDriver driver;
    WebElement element;

    @Before
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\manishabajirao.balwa\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSeleniumLocatorsWithScrolling() {
        driver.get("http://demo.automationtesting.in");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"btn2\"]")).click();
        // get By button id
        //Elements.registerButtonById.click();

        // get by link
        //Elements.registerLink.click();
        driver.findElement(By.linkText("Register")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // by patial link
        driver.findElement(By.partialLinkText("Reg")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Elements.registerLink.click(); not working
        driver.findElement(By.linkText("Register")).click();

        // btn by css
        driver.findElement(By.cssSelector("input[ng-model=\"EmailAdress\"]")).click();
        driver.findElement(By.cssSelector("input[ng-model=\"EmailAdress\"]")).sendKeys("123");


        // get by xpath
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")));
        firstName.click();
        firstName.sendKeys("Manisha");

        // get by id
        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;

        // now execute query which actually will scroll until that element is not appeared on page.
        //je.executeScript("arguments[0].scrollIntoView(true);", Elements.lastNameByClassSelector);
        //Elements.lastNameByClassSelector.sendKeys("Balwadkar");
        je.executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")));
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Balwadkar");

        // by css
        //Elements.checkBoxByCSS.click();
        driver.findElement(By.cssSelector("input#checkbox1")).click();

        // by tag name selector
        // System.out.println(Elements.imageTagName.getAttribute("src)")); did not work
        System.out.println(driver.findElement(By.tagName("img")).getAttribute("src)"));

        // by Name
        // Elements.signBtnByName.click(); did not work
        driver.findElement(By.name("signup")).click();

    }


    @Test
    public void testSeleniumFrames() {
        driver.get("http://demo.automationtesting.in/Frames.html");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        for (int i = 0; i <= size; i++) {
            driver.switchTo().frame(i);
            List<WebElement> textWebElement = driver.findElements(By.xpath("/html/body/section/div/div/div/input"));
            int total = textWebElement.size();
            if (total > 0) {
                textWebElement.get(0).click();
                textWebElement.get(0).sendKeys("Manisha");
            }
            System.out.println(total);
            driver.switchTo().defaultContent(); //switching back from the iframe
            i = size;
        }
    }

    @Test
    public void testSeleniumPopups() {

        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        driver.switchTo().frame("iframeResult");

        //Find "Try it" button
        WebElement promptButton = driver.findElement(By.cssSelector("html>body>button"));
        //Actual Message
        WebElement actualPromptMessage = driver.findElement(By.cssSelector("#demo"));
        //Click confirm button ("Try it" button)
        promptButton.click();
        //Send "SW Test Academy" to Alert's text box
        driver.switchTo().alert().sendKeys("SW Test Academy");
        //Accept the alert (Click Ok button)
        driver.switchTo().alert().accept();
        //Assertion
        //Assertion.assertEquals("Hello SW Test Academy! How are you today?",actualPromptMessage.getText());
    }

    @After
    public static void closeBrowser() {
        //driver.quit();
    }
}