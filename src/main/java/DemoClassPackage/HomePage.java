package DemoClassPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {
    String configPropertyPath;
    String elementPropertyPath;
    ElementActionClass act=new ElementActionClass();
    ExcelUtilClass utilClass=null;
    public  HomePage() throws IOException {
        String datapath=prop.getProperty("DataSheetPath");
        utilClass=new ExcelUtilClass(datapath);
        configPropertyPath=prop.getProperty("ConfigPropertyFilePath");
        elementPropertyPath=prop.getProperty("elementPropertyFilePath");
    }

    public void BrowserConfig(String Browser){
        if(driver == null) {
            if (Browser.contains("Chrome")){
                //***Below statement used instead of "System.setProperty()"
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                //action = new Actions(driver);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                //driver.manage().timeouts().getPageLoadTimeout();
            }
            if (Browser.contains("firefox")) {
                //***Below statement used instead of "System.setProperty()"
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
    }
    public void runBrowser() throws IOException {
        act.openBrowser(driver,prop,configPropertyPath,"WebPage");
        act.WorkingPage(driver);
    }
    public void enterCustName(String custName) throws IOException {
        //String custName=utilClass.getCellStringValue();
        act.textBoxEntry(custName, driver, prop, elementPropertyPath, "Fname");
    }
    public void clickOnSubmitButton() throws IOException {
        act.buttonClick(driver, prop, elementPropertyPath, "SubmitButton");
    }
    public void selectGender() throws IOException {
        act.radioButtonSelect(driver, prop, elementPropertyPath, "RadioBtnMale");
    }
    public void selectTestingType() throws IOException {
        act.checkBoxSelect(driver, prop, elementPropertyPath, "CheckBoxAutoTesting");
    }
    public void gotoLink() throws IOException, InterruptedException {
        act.clickOnLink(driver, prop, elementPropertyPath, "Link");
    }
    public void generateAlertWindow() throws IOException {
        act.alertPopUpWindow(driver, prop, elementPropertyPath, "AlertBoxButton");
    }
    /*public void navigateToManualMenu() throws IOException, InterruptedException {
        act.HandoverOnTab(driver, prop, elementPropertyPath, "Tab_Manual", "Subtab_WhatIsManualTesting");
        act.WorkingPage(driver);
    }*/
    public void closeWebDriver() {
        driver.close();
        driver.quit();
    }

}
