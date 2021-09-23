package org.baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends BaseClass {
	public Loginpage() {

		PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//input[@formcontrolname=\"userEmail\"]")
		private WebElement txtUserName;


		@FindBy(xpath="//input[@formcontrolname=\"userPassword\"]")
		private WebElement txtPassword;

		@FindBy(xpath="//button[@type=\"submit\"]")
		private WebElement btnLogin;

		public WebElement getTxtUserName() {
			return txtUserName;
		}

		public WebElement getTxtPassword() {
			return txtPassword;
		}

		public WebElement getBtnLogin() {
			return btnLogin;
		}




}
