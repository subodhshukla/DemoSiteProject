package DemoClassPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class ElementActionClass{

    public ElementActionClass() throws IOException {
    }

    public void openBrowser(WebDriver driver, Properties prop, String propertyFilePath, String elementName) throws IOException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        driver.get("\n"+prop.getProperty(elementName));

    }
    public void textBoxEntry(String testboxvalue, WebDriver driver,Properties prop, String propertyFilePath, String elementname) throws IOException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        driver.findElement(By.xpath(prop.getProperty(elementname))).clear();
        driver.findElement(By.xpath(prop.getProperty(elementname))).sendKeys(testboxvalue);
    }
    public void buttonClick(WebDriver driver,Properties prop, String propertyFilePath, String elementname) throws IOException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        driver.findElement(By.xpath(prop.getProperty(elementname))).click();
    }

    public void radioButtonSelect(WebDriver driver,Properties prop, String propertyFilePath, String elementname) throws IOException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        driver.findElement(By.xpath(prop.getProperty(elementname))).click();
    }
    public void checkBoxSelect(WebDriver driver,Properties prop, String propertyFilePath, String elementname) throws IOException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        driver.findElement(By.xpath(prop.getProperty(elementname))).click();
    }
    public void clickOnLink(WebDriver driver,Properties prop, String propertyFilePath, String elementname) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop.getProperty(elementname)))));
        WebElement linkClickbale = driver.findElement(By.xpath(prop.getProperty(elementname)));
        WebElement link = driver.findElement(By.xpath(prop.getProperty(elementname)));
        Actions actions = new Actions(driver);
        actions.moveToElement(link).click().perform();
    }
    public void alertPopUpWindow(WebDriver driver,Properties prop, String propertyFilePath, String elementname) throws IOException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        driver.findElement(By.xpath(prop.getProperty(elementname))).click();
        driver.switchTo().alert().accept();
    }
    public void HandoverOnTab(WebDriver driver,Properties prop, String propertyFilePath, String menu) throws IOException, InterruptedException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        Actions actions = new Actions(driver);
        WebElement menuOption= driver.findElement(By.xpath(prop.getProperty(menu)));
        actions.moveToElement(menuOption).perform();
        Thread.sleep(2000);


    }
    public void clickOnSubMenu(WebDriver driver,Properties prop, String propertyFilePath, String SubMenu) throws InterruptedException, IOException {
        InputStream inputStr = new FileInputStream(propertyFilePath);
        prop.load(inputStr);
        driver.findElement(By.xpath(prop.getProperty(SubMenu))).click();
        Thread.sleep(3000);
    }
    public void WorkingPage(WebDriver driver){
        System.out.println("Page Title :"+ driver.getTitle());
    }
    public void dropDownSelect(WebDriver driver,Properties prop, String propertyFilePath, String elementname){

    }
}

