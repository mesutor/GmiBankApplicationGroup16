package com.gmibank.pages;

import com.gmibank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmpNewAccountPage extends BasePage {


    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createNewAccountItem;

    @FindBy(xpath="//input[@name='description']")
    public WebElement descriptionBox;

    @FindBy(name = "balance")
    public WebElement balanceBox;

    @FindBy(id="tp-account-accountType")
    public WebElement accountTypeDropDownItem;


    @FindBy(id = "tp-account-accountStatusType")
    public WebElement accountStatusTypeDropDown;


    @FindBy(id="tp-account-employee")
    public WebElement employeeDropDownitem;

    @FindBy(id="save-entity")
    public WebElement saveButton;


   @FindBy(xpath = "//div[@class='invalid-feedback']")
    public  WebElement invalidFeedbackMessage;



    }