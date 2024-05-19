package org.testNgAnnotations.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginScript {
    WebDriver driver;

    @BeforeSuite
    public void BeforeSuite()
    {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void AfterSuite()
    {
        System.out.println("After Suite");
    }

    @BeforeClass
    public void BeforeClass()
    {
        System.out.println("Before Class");
    }

    @AfterClass
    public void AfterClass()
    {
        System.out.println("After Class");
    }

    @BeforeTest
    public void LaunchTheURL()
    {
        System.out.println("Before Test");
        //-----------
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("After Method");
    }

    //@Ignore - To ignore the test from executing.
    @Parameters("URL")
    @Test(priority = 0)
    public void EnterTheURL(String url)
    {
        System.out.println("Test 0");
        //-----------
        driver.get(url);
    }

    @Test(priority = 1)
    public void EnterLoginDetails()
    {
        System.out.println("Test 1");
        //-----------
        driver.findElement(By.name("email")).sendKeys("qatestertest@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test@123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

    @Test(priority = 2)
    public void Logout()
    {
        System.out.println("Test 2");
        //------------
        driver.findElement(By.linkText("Logout")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Account Logout']")).isDisplayed());
    }

    @AfterTest
    public void CloseTheBroswer()
    {
        System.out.println("After Test");
        //-----------
        driver.quit();
    }
}
