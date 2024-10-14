package DemoTestNGPackage;

import DemoClassPackage.HomePage;
import DemoClassPackage.ManualTabPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestingRunClassManualTab {
    ManualTabPage mp=null;
    HomePage hp=null;
    Properties prop=new Properties();
    public TestingRunClassManualTab() throws IOException {
        mp=new ManualTabPage();
        hp=new HomePage();
        InputStream inputStr = new FileInputStream("D:\\subodh\\subodh_Spar\\Automation\\DemoSiteProject\\src\\test\\resources\\Config.properties");
        prop.load(inputStr);
    }
    @Test(priority = 1)
    public void GoToManualTestingMenuItem() throws IOException, InterruptedException {
        mp.navigateToManualMenu();
        mp.navigateToSubMenu_WhatIsManualTesting();
    }
    @Test(priority = 2)
    public void verifyManualTabLink() throws IOException, InterruptedException {
        mp.verifyLinkManualTesting();

    }
    @Test(priority = 3)
    public void GoToTestScenarioExampleMenuItem() throws IOException, InterruptedException {
        mp.navigateToManualMenu();
        mp.navigateToSubMenu_TestScenarioExample();
    }
    @Test(priority = 4)
    public void verifyTestScenarioExampleLink() throws IOException, InterruptedException {
        mp.verifyLinkScenarioExample();

    }

    @AfterClass
    public void closeBrowser () {
        hp.closeWebDriver();
    }
}

