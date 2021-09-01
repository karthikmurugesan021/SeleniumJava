package test.java.com.ofs.testcases;

import com.fasterxml.jackson.databind.ser.Serializers;
import main.java.generics.BaseTest;
import main.java.generics.CommonMethods;
import main.java.generics.ObjectRepSheet;
import main.java.generics.Utility;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ElementsCases extends BaseTest {


    @Test(groups = {"Sanity"})
    public void textBoxes() throws InterruptedException{
        CommonMethods method = new CommonMethods();
        ObjectRepSheet elementMenu = Utility.getCellData_OBR("QAHomePage", "ElementsMenu");
        method.highLightElement(elementMenu, "ElementsMenu");
        Thread.sleep(30);
        method.clickElementByScrollPage(elementMenu, "ElementsMenu");
        Thread.sleep(50);
        ObjectRepSheet textBoxMenu = Utility.getCellData_OBR("TextBox", "textBox");
        method.highLightElement(textBoxMenu,"textBox");
        Thread.sleep(50);
        method.click(textBoxMenu, "textBox");
        Thread.sleep(1000);


        Reporter.log("clicked textbox menu", true);

//        String fullName1 = Utility.getCellData_TestData("TextBox", "FullName");
        ObjectRepSheet txtFullName = Utility.getCellData_OBR("TextBox", "fullName");
        ObjectRepSheet txtEmail = Utility.getCellData_OBR("TextBox", "eMail");
        ObjectRepSheet txtCurrentAddress = Utility.getCellData_OBR("TextBox", "currentAddress");
        ObjectRepSheet txtPermanentAddress = Utility.getCellData_OBR("TextBox", "permanentAddress");
        ObjectRepSheet buttonSubmit = Utility.getCellData_OBR("TextBox", "buttonSubmit");

        method.sendKeys(txtFullName,"Karthik","Full Name");
        method.sendKeys(txtEmail, "karthikm21@gmail.com", "eMail");
        method.sendKeys(txtCurrentAddress, "Annanagar East", "currentAddress");
        method.sendKeys(txtPermanentAddress, "Annanagar East", "permanentAddress");
        method.clickElementByScrollPage(buttonSubmit,"buttonSubmit");

        Thread.sleep(100);
        //Initialize the locators for the verification
        ObjectRepSheet lblName = Utility.getCellData_OBR("TextBox", "lblName");
        ObjectRepSheet lblEmail = Utility.getCellData_OBR("TextBox", "lblEmail");
        ObjectRepSheet lblCurrentAddress = Utility.getCellData_OBR("TextBox", "lblCurrentAddress");
        ObjectRepSheet lblPermanentAddress = Utility.getCellData_OBR("TextBox", "lblPermanentAddress");

        // Getting text from the labels
        String verifyName = method.getText(lblName, "verifylbl");
        System.out.println(verifyName);
        String txt1[]=verifyName.split(":");
        System.out.println(txt1[1]);
        String txt2[]=verifyName.split("a");
        System.out.println("output is :" + txt2[1]);

        System.out.println(txt2[2]);
        String verifyEmail = method.getText(lblEmail, "verifyEmail");
        String verifyCurrentAddress = method.getText(lblCurrentAddress, "verifyCurrentAddress");
        String verifyPermanentAddress = method.getText(lblPermanentAddress, "verifyPermanent");

        //Verify the string using AssertEquals
        method.compareText(txt1[1], "Karthik");
        method.compareText(verifyEmail, "Email:karthikm21@gmail.com");
        method.compareText(verifyCurrentAddress, "Current Address :Annanagar East");
        method.compareText(verifyPermanentAddress, "Permananet Address :Annanagar East");
        Reporter.log("Verified Fullname", true);


    }
}
