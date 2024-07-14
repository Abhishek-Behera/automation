package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentReportListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("testoutput/extent-report.html");
            extent.attachReporter(spark);
        }
        ExtentTest scenarioExtentTest = extent.createTest(scenario.getName());
        scenarioTest.set(scenarioExtentTest);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTest.get().fail("Scenario failed");
        } else {
            scenarioTest.get().pass("Scenario passed");
        }
        extent.flush();
    }
}
