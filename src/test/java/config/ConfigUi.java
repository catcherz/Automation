package config;

import com.codeborne.selenide.Configuration;
import constants.Drivers;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ConfigUi {
    @BeforeGroups(alwaysRun = true, groups = "Ui")
    public static void setBrowser() {
        System.out.print("Config before \"Ui\" test group");

        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", Drivers.CHROME);
        }

        Configuration.screenshots = true;
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1680,1050");
        Configuration.browserCapabilities.merge(options);

        setWebDriver(new ChromeDriver(options));
    }

    @AfterSuite(alwaysRun = true, groups = "Ui")
    public void closeDriver() {
        getWebDriver().manage().logs().get("browser");
        getWebDriver().quit();
        System.out.print("Test has been completed");
    }
}
