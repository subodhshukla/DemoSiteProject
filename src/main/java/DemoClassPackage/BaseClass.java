package DemoClassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {

    static String Browser;
    static WebDriver driver;
    Properties prop=new Properties();
    Properties xpathProperty=new Properties();
    // static Actions action;

    public BaseClass() throws IOException {
        //***Configuration xpath property file setting
        InputStream inputStr = new FileInputStream("D:/subodh/subodh_Spar/Automation/DemoSiteProject/src/test/resources/Config.properties");
        prop.load(inputStr);

        //***Element xpath property file setting
        InputStream spathPrty = new FileInputStream("D:/subodh/subodh_Spar/Automation/DemoSiteProject/src/test/resources/ElementProperty.properties");
        xpathProperty.load(spathPrty);
    }
}

