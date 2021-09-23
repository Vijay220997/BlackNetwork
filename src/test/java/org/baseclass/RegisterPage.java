package org.baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerbtnclk;

	public WebElement getRegisterbtnclk() {
		return registerbtnclk;
	}
	@FindBy(xpath="//input[@formcontrolname=\"firstName\"]")
	private WebElement regFirstName;
	
	
	@FindBy(xpath="//input[@formcontrolname=\"lastName\"]")
	private WebElement regLastName;
	
	@FindBy(xpath="//input[@formcontrolname=\"userName\"]")
	private WebElement regUserName;
	
	@FindBy(xpath="//input[@formcontrolname=\"email\"]")
	private WebElement regEmail ;
	
	@FindBy(xpath="//input[@formcontrolname=\"password\"]")
	private WebElement regPassword;
	
	
	@FindBy(xpath="//input[@formcontrolname=\"confirmPassword\"]")
	private WebElement regConfirmPassword;
	
	@FindBy(xpath="//input[@id=\"customSwitch1\"]")
	private WebElement toggleBtn;
	
	
	
	public WebElement getRegFirstName() {
		return regFirstName;
	}



	public WebElement getRegLastName() {
		return regLastName;
	}



	public WebElement getRegUserName() {
		return regUserName;
	}



	public WebElement getRegEmail() {
		return regEmail;
	}



	public WebElement getRegPassword() {
		return regPassword;
	}



	public WebElement getRegConfirmPassword() {
		return regConfirmPassword;
	}



	public WebElement getToggleBtn() {
		return toggleBtn;
	}



	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement submitBtn;

	
	


}
