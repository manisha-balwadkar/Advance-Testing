package com.company;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {

    @FindBy(partialLinkText = "Hom")
    public static WebElement homeByPartialLink;

    @FindBy(className = "btn btn-success navbar-toggle")
    public static WebElement btnByCSS;

    @FindBy(linkText = "Register")
    public static WebElement registerLink;

    @FindBy(id = "btn2")
    public static WebElement registerButtonById;

    @FindBy(className = "form-control ng-pristine ng-invalid ng-invalid-required ng-touched")
    public static WebElement lastNameByClassSelector;

    @FindBy(css = "input#checkbox1")
    public static WebElement checkBoxByCSS;

    @FindBy(tagName = "img")
    public static WebElement imageTagName;

    @FindBy(name = "signup")
    public static WebElement signBtnByName;

    @FindBy(id = "firstpassword")
    public static WebElement firstPassword;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public static WebElement loginViaEmail;
}
