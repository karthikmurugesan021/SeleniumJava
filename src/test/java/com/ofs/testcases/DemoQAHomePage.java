package test.java.com.ofs.testcases;

import main.java.generics.BaseTest;
import main.java.generics.ObjectRepSheet;
import main.java.generics.Utility;
import org.testng.Reporter;
import org.testng.annotations.Test;
import main.java.generics.CommonMethods;
import org.openqa.selenium.*;

public class DemoQAHomePage extends BaseTest {
    @Test(groups = {"Sanity"})
    public void homePage () throws InterruptedException {
        CommonMethods method = new CommonMethods();
        ObjectRepSheet verifyPageTitle = Utility.getCellData_OBR("QAHomePAge", "VerifyTitleToolsQA");

        method.visibilityOfElement(verifyPageTitle, "VerifyTitleToolsQA");
        method.highLightElement(verifyPageTitle, "VerifyTitleToolsQA");

        ObjectRepSheet elementMenu = Utility.getCellData_OBR("QAHomePage", "ElementsMenu");
        method.highLightElement(elementMenu, "ElementsMenu");

        Reporter.log("statement 1", true);

        method.click(verifyPageTitle, "VerifyTitleToolsQA");
        method.clickElementByScrollPage(elementMenu, "ElementsMenu");

        /*method.click(elementMenu, "ElementsMenu");*/
        method.getScreenShot();
        Thread.sleep(30);


        Reporter.log("statement 2", true);


    }
}
