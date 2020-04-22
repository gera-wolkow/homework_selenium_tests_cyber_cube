import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;


/**
 * Created by iuriiryndin on 20.04.2020
 */

@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"stepdefs"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
        )

public class Main {
    public TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public static void start (){
        Configuration.remote = "http://localhost:4444/wd/hub";
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        open();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        testNGCucumberRunner.finish();
    }

}
