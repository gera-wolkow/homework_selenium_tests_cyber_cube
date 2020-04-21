package selenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by iuriiryndin on 20.04.2020
 */
public class Main {

    public static String mainUrl;

    @BeforeSuite
    public static void start () throws IOException{
        Configuration.remote = "http://localhost:4444/wd/hub";
        Properties properties = new Properties();
        File file = new File("config.properties");
        FileInputStream fileIn = new FileInputStream(file);
        properties.load(fileIn);
        mainUrl = properties.getProperty("mainUrl");
        fileIn.close();
    }

    @BeforeMethod
    public static void setUpBrowser () {
        open(mainUrl);
    }

    @AfterMethod
    public static void cleanBrowser () {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }



}
