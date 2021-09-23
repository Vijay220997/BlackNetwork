package org.baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {
	public Homepage() {
		PageFactory.initElements(driver, this);

}
@FindBy(xpath="//button[@class=\"btn btn-yellow btn-block pt9 pb9 px-3 br-10 fs13 fw-500\"]")
private WebElement createPostBtn;
////button[@class='btn btn-yellow btn-block pt9 pb9 px-3 br-10 fs13 fw-500']

@FindBy(xpath="//button[text()=\" Add Photos/ Videos \"]")
private WebElement addPostBtn;

@FindBy(xpath="//button[text()=\" Post \"]")
private WebElement postBtn;

public WebElement getCreatePostBtn() {
	return createPostBtn;
}

public WebElement getAddPostBtn() {
	return addPostBtn;
}

public WebElement getPostBtn() {
	return postBtn;
}




}
