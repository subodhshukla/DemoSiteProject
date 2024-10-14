package DemoTestNGPackage;

import DemoClassPackage.ExcelUtilClass;
import DemoClassPackage.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class TestingRunClass {
    static HomePage hp=null;
    ExtentSparkReporter htmlreport;
    ExtentReports extent;
    Properties prop=new Properties();
    public TestingRunClass() throws IOException {
        hp=new HomePage();
        InputStream inputStr = new FileInputStream("D:\\subodh\\subodh_Spar\\Automation\\DemoSiteProject\\src\\test\\resources\\Config.properties");
        prop.load(inputStr);
    }
    @BeforeSuite
    public void reportGen(){
        htmlreport=new ExtentSparkReporter("ExtentReport.html");
        extent=new ExtentReports();
        extent.attachReporter(htmlreport);
        System.out.println("Jenkins integrated");

    }
    @BeforeTest
    public void BeforeTestMethod(){
        System.out.println("This is executed before Test");
    }
    @Parameters("Browsername")
    @BeforeClass
    public void browserConfiguration (String Browsername) throws IOException {
        // Test code goes here
        hp.BrowserConfig(Browsername);
        hp.runBrowser();
        System.out.println("This is executed before Class");
    }
    @Test(priority = 1, dataProvider = "CustName")
    public void enterDetails (String custname, String age) throws IOException, InterruptedException {
        ExtentTest firttest=extent.createTest("MyFirstTest", "Its a simple tst");
        hp.enterCustName(custname);
        Thread.sleep(1000);
        hp.clickOnSubmitButton();
        firttest.info("this is steps show how to enter the user details.");
    }
    @DataProvider(name="CustName")
    public Object[][] getData() throws IOException {
        ExcelUtilClass excelData=new ExcelUtilClass(prop.getProperty("DataSheetPath"));
        Object testData[][]= (Object[][]) excelData.getCellStringValue();
        return testData;
    }
    @Test(priority = 2)
    public void selectYourGenderAndTestingType() throws IOException {
        ExtentTest secondtest=extent.createTest("MySecondTest", "Its a simple tst");
        hp.selectGender();
        hp.selectTestingType();
        secondtest.info("This is test for Radio button and checkbox");
    }
    @Test(priority = 3)
    public void manageAlertPupupWindow() throws IOException, InterruptedException {
        ExtentTest thirdtest =extent.createTest("MyThirdTest", "Its a simple tst");
        // hp.gotoLink();
        hp.generateAlertWindow();
        thirdtest.info("This is test for popup window alert");
    }
    /*@Test(priority = 4)
    public void navigateToHomePageMenu() throws IOException, InterruptedException {
        hp.navigateToManualMenu();
        Thread.sleep(5000);
    }*/
    @AfterTest
    public void closeBrowser () {
        hp.closeWebDriver();
    }



}