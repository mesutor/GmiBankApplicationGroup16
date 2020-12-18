package com.gmibank.stepDefinitions;

import com.gmibank.pages.*;
import com.gmibank.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestClass {

    @BeforeMethod
    public void setup() {
/*    WebDriver driver = Driver.getDriver();
    driver.get(ConfigurationReader.getProperty("url"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);*/
    }


    @AfterMethod
    public void tearDown() {
/*    BrowserUtils.waitFor(1);
    Driver.closeDriver();*/
    }

    @Test
    public void test1() throws Exception {


        BasePage basePage = new BasePage();
        basePage.clickAndSelectDropDownItemUnderAccountMenuIcon("Sign in");
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidInfo("admin");
        BrowserUtils.waitFor(2);
        basePage.clickGivenNavItemAndSelectGivenDropDownItem("Administration", "User management");
        UsersPageWithTable usersPageWithTable = new UsersPageWithTable();
        usersPageWithTable.clickGivenButtonForWantedColumnAndValue("Email", "jenny@gmail.com", "edit");
        System.out.println("basePage.getPageHeader() = " + basePage.getPageHeader());
        Assert.assertTrue(basePage.getPageHeader().contains("User ["));
        BrowserUtils.waitFor(3);

    }

    @Test
    public void test2() throws Exception {
        BasePage basePage = new BasePage();
        basePage.clickAndSelectDropDownItemUnderAccountMenuIcon("Sign in");
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidInfo("employee");
        BrowserUtils.waitFor(2);
        basePage.clickGivenNavItemAndSelectGivenDropDownItem("My Operations", "Manage Customers");
        CustomersPageWithTable customersPageWithTable = new CustomersPageWithTable();
        customersPageWithTable.clickGivenButtonForWantedColumnAndValue("Email", "07-12-20-14-38@US013.com", "view");
        System.out.println("basePage.getPageHeader() = " + basePage.getPageHeader());
        Assert.assertTrue(basePage.getPageHeader().equals("Customer [35132]"));
        BrowserUtils.waitFor(3);
    }


    @Test
    public void test3() throws Exception {
        BasePage basePage = new BasePage();
        basePage.clickAndSelectDropDownItemUnderAccountMenuIcon("Sign in");
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithValidInfo("employee");
        BrowserUtils.waitFor(2);
        basePage.clickGivenNavItemAndSelectGivenDropDownItem("My Operations", "Manage Accounts");
        AccountsPageWithTable accountsPageWithTable = new AccountsPageWithTable();
        accountsPageWithTable.clickGivenButtonForWantedColumnAndValue("Description", "team13 customer account2", "view");
        System.out.println("basePage.getPageHeader() = " + basePage.getPageHeader());
        Assert.assertTrue(basePage.getPageHeader().equals("Account [30239]"));
        BrowserUtils.waitFor(3);
    }


    @Test
    public void test4() {
        System.out.println("DummyDataGenerator.generateAddress() = " + DummyDataGenerator.generateAddress());
        Map<String, String> map = new HashMap<>();
        map = DummyDataGenerator.generateAllNeededInformationExceptPassword();
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
