package DemoClassPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ManualTabPage extends BaseClass {
    String configPropertyPath;
    String elementPropertyPath;
    ElementActionClass act=new ElementActionClass();
    public  ManualTabPage() throws IOException {
        configPropertyPath=prop.getProperty("ManualTabPagePropertyPath");
        elementPropertyPath=prop.getProperty("elementPropertyFilePath");
    }
    public void navigateToManualMenu() throws IOException, InterruptedException {
        act.HandoverOnTab(driver, prop, elementPropertyPath, "Tab_Manual");
        act.WorkingPage(driver);
    }
    public void navigateToSubMenu_WhatIsManualTesting() throws IOException, InterruptedException {
        act.clickOnSubMenu(driver, prop, elementPropertyPath,"Subtab_WhatIsManualTesting");
    }
    public void navigateToSubMenu_TestScenarioExample() throws IOException, InterruptedException {
        act.clickOnSubMenu(driver, prop, elementPropertyPath,"Subtab_TestScenarioExample");
    }

    public void verifyLinkManualTesting() throws IOException, InterruptedException {

        act.clickOnLink(driver,prop,configPropertyPath, "ContentLink");
        Thread.sleep(5000);
        act.clickOnLink(driver,prop,configPropertyPath, "RecommendedTutorial");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);

    }

    public void verifyLinkScenarioExample() throws IOException, InterruptedException {

        act.clickOnLink(driver,prop,configPropertyPath, "TestScenariosofATMMachine");
        Thread.sleep(5000);
        act.clickOnLink(driver,prop,configPropertyPath, "TestScenariosofDoor");

        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
    }
}

