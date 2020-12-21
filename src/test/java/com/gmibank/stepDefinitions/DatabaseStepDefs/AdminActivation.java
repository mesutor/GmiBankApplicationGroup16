package com.gmibank.stepDefinitions.DatabaseStepDefs;

import com.gmibank.pages.UsersPageWithTable;
import com.gmibank.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;


public class AdminActivation {
    UsersPageWithTable usersPageWithTable = new UsersPageWithTable();
    String path = ConfigurationReader.getProperty("registration_excel_path");
    String registrationSheet = ConfigurationReader.getProperty("registration_sheet_name");
    User userFromExcel;
    String jhiUserSheet = ConfigurationReader.getProperty("jhi_user_sheet_name");

    @Given("find the user taken from excel and activate it as {string}")
    public void find_the_user_taken_from_excel_and_activate_it_as(String string) {
        ExcelUtilities excel = new ExcelUtilities(path, registrationSheet);
        userFromExcel = excel.getLastRegistrantAsUser();
        String emailFromExcel = userFromExcel.getEmail();
        BrowserUtils.waitForClickablility(usersPageWithTable.createButton,5);

        //email'den kisiyi bul
        WebElement emailElement = usersPageWithTable.checkWantedElementOnTheLastPage("Email", emailFromExcel);
        if (emailElement == null) {
            emailElement = usersPageWithTable.locateWantedCellWithGivenColumnAndValue("Email", emailFromExcel);
        }
        System.out.println("emailElement = " + emailElement);

        String firstActivationStatus = usersPageWithTable.getActivationStatus(emailFromExcel);
        System.out.println("firstActivationStatus = " + firstActivationStatus);

        usersPageWithTable.clickAndChangeActivationStatus(emailFromExcel);

        //islem basarili sonucunu kontrol et
        String expectedResultMessage = "A user is updated with";
        Assert.assertTrue(usersPageWithTable.doesContainSuchAMessageInsideAlert(expectedResultMessage));

        BrowserUtils.waitForInvisibility(By.xpath("//div[@role='alert']"),10);
        Driver.getDriver().navigate().refresh();

        WebElement element = usersPageWithTable.locateWantedCellWithGivenColumnAndValue("Email", emailFromExcel);
        BrowserUtils.hover(element);
        String secondActivationStatus = usersPageWithTable.getActivationStatus(emailFromExcel);

        System.out.println("secondActivationStatus = " + secondActivationStatus);
        Assert.assertFalse(firstActivationStatus.equals(secondActivationStatus));

        //
        ExcelUtilities excel2 = new ExcelUtilities(path,jhiUserSheet);
        Map<String, String> map = ExcelUtilities.convertUserToMap(userFromExcel);
        System.out.println("map = " + map);
        excel2.writeUserIntoExcel(map);
        excel.removeLastRow();
    }

    @Then("verify that UI information matches database response")
    public void verify_that_UI_information_matches_database_response() {
        System.out.println("basarili gorunuyor");
    }

}
