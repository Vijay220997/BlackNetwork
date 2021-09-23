package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

public static void getDriver(String browsername) {
if (browsername.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

} else if (browsername.equalsIgnoreCase("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();

} else if (browsername.equalsIgnoreCase("InternetExplorer")) {
	WebDriverManager.iedriver().setup();
	driver = new InternetExplorerDriver();
} else {
	System.out.println("invalid browser");
}
driver.manage().window().maximize();

}

// 1
public static void launchUrl(String url) {
	driver.get(url);
}// 2

public  static String currentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
}// 3

public static String title() {
	String title = driver.getTitle();
	return title;
}// 4

public  static  void close() {
	driver.close();

}// 5

public static void quit() {
	driver.quit();

}// 6

public  static String windowHandle() {
	String parentId = driver.getWindowHandle();
	return parentId;
}// 7

public  static void windowHandles(int index) {
	Set<String> allwindowId = driver.getWindowHandles();
	// to convert set to list
	List<String> li = new ArrayList<String>();
	li.addAll(allwindowId);
	driver.switchTo().window(li.get(index));

}// 8

public  static void multiwindowHandle(int no) {
	Set<String> allwindowId = driver.getWindowHandles();
	int count = 0;
	for (String string : allwindowId) {
		if (count == no) {
			driver.switchTo().window(string);

		}
		count++;
	}

}

public  static void navigation(String url) {
	driver.navigate().to(url);

}// 9

public  static void navigateForward() {
	driver.navigate().forward();

}// 10

public  static void navigateback() {
	driver.navigate().back();

}// 11

public  static void navigateRefresh() {
	driver.navigate().refresh();

}// 12

public  static void switchWindowid(String id) {
	driver.switchTo().window(id);

}// 13

public  static void switchwindowtitle(String title) {
	driver.switchTo().window(title);

}// 14

public  static void switchwindowurl(String url) {
	driver.switchTo().window(url);

}// 15

public  static void clear(WebElement element) {
	element.clear();

}// 16

public  static void click(WebElement element) {
	element.click();

}// 17

public static String attribute(WebElement element) {
	String attribute = element.getAttribute("value");
	return attribute;
}// 18

public  static String text(WebElement element) {
	String text = element.getText();
	return text;
}// 19sendkeys

public static void passtxt(WebElement element, String text) {
	element.sendKeys(text);

}// 20

public  static void moveelement(WebElement element) {

	Actions actions = new Actions(driver);
	actions.moveToElement(element).perform();

}// 21

public  static void actionclick(WebElement element) {
	Actions actions = new Actions(driver);
	actions.click(element).perform();
}// 22

public  static void rightclick(WebElement element) {
	Actions actions = new Actions(driver);
	actions.contextClick(element).perform();
}// 23

public  static void doubleClick(WebElement element) {
	Actions actions = new Actions(driver);
	actions.doubleClick(element).perform();
}// 24

public  static void dragdrop(WebElement source, WebElement target) {
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, target).perform();
}// 25

public  static void dragdrop2(WebElement source, WebElement target) {
	Actions actions = new Actions(driver);
	actions.clickAndHold(source).moveToElement(target).release().perform();
}// 26

public  static void actionstxtsend(WebElement element, String txt) {
	Actions actions = new Actions(driver);
	actions.sendKeys(element, txt).perform();
}// 27

public  static void keyUp(WebElement element) {
	Actions actions = new Actions(driver);
	actions.keyUp(element, Keys.SHIFT).perform();
}// 28

public  static void keyDown(WebElement element) {
	Actions actions = new Actions(driver);
	actions.keyDown(element, Keys.SHIFT).perform();
}// 29

public  static void accept() {
	Alert alert = driver.switchTo().alert();
	alert.accept();

}// 30

public  static void dismiss() {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	

}// 31
public static void maximize() {
	// TODO Auto-generated method stub

}
public static void implicitWait() {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}

public  static String alertgetText() {
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	return text;

}// 31

public  static void alertsendkeys(String passtxt) {
	Alert alert = driver.switchTo().alert();
	alert.sendKeys(passtxt);

}// 32

public  static void scrollDown(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);

}// 33

public  static void scrollUp(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(false)", element);

}// 34

public  static void jsSendkeys(WebElement element, String data) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
}// 35

public  static void jsClick(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", element);

}// 36

public static  void jsgetAttribute(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// return type is object but type casting for String
	String executeScript = (String) js.executeScript("return arguments[0].getAttribute('value')", element);
	System.out.println(executeScript);

}// 37

public  static  void getScreenShot(String path) throws IOException {
	TakesScreenshot tk = (TakesScreenshot) driver;
	File source = tk.getScreenshotAs(OutputType.FILE);
	System.out.println(source);
	File des = new File(path);
	FileUtils.copyFile(source, des);

}// 38

public static void switchFrameid(String locator, String idname) {
	if (locator.equalsIgnoreCase("id")) {
		driver.switchTo().frame(idname);
	} else if (locator.equalsIgnoreCase("name")) {
		driver.switchTo().frame(idname);
	}

}// 39

public  static  void switchFrameindex(int index) {
	driver.switchTo().frame(index);

}// 40

public  static void switchFrameelement(WebElement element) {
	driver.switchTo().frame(element);

}// 41

public  static void defaultContent() {
	driver.switchTo().defaultContent();

}// 42

public  static  void parentFrame() {
	driver.switchTo().parentFrame();
}// 43

public static void SelectBy(WebElement element, String type, String value) {
	Select select = new Select(element);
	if (type.equalsIgnoreCase("index")) {
		select.selectByIndex(Integer.parseInt(value));
	} else if (type.equalsIgnoreCase("value")) {
		select.selectByValue(value);
	} else if (type.equalsIgnoreCase("text")) {
		select.selectByVisibleText(value);
	}
}
// 44

public  static void deSelectBy(WebElement element, String type, String value) {
	Select select = new Select(element);
	if (type.equalsIgnoreCase("index")) {
		select.deselectByIndex(Integer.parseInt(value));
	} else if (type.equalsIgnoreCase("value")) {
		select.deselectByValue(value);
	} else if (type.equalsIgnoreCase("text")) {
		select.deselectByVisibleText(value);
	}
}

// 45
public  static void deselectAll(WebElement element) {
	Select select = new Select(element);
	select.deselectAll();
}// 46

public   static WebElement getFirstSelect(WebElement element) {
	Select select = new Select(element);
	WebElement selectedOption = select.getFirstSelectedOption();

	return selectedOption;
}

// 47
public  static String getAllSelected(WebElement element) {
	String text = "";
	Select select = new Select(element);
	List<WebElement> allSelectedOptions = select.getAllSelectedOptions();

	for (int i = 0; i < allSelectedOptions.size(); i++) {
		WebElement element2 = allSelectedOptions.get(i);
		text = element2.getText();

	}
	return text;

}

// 48
public static List<WebElement> getoptions(WebElement element) {

	Select select = new Select(element);
	List<WebElement> options = select.getOptions();

	return options;
}

// 49
public static boolean isMultiple(WebElement element) {
	Select select = new Select(element);
	boolean multiple = select.isMultiple();
	return multiple;
}

// 50
// to locate the element
public static WebElement locaters(String locater, String value) {
	WebElement element = null;
	if (locater.equalsIgnoreCase("id")) {
		element = driver.findElement(By.id(value));
	} else if (locater.equalsIgnoreCase("name")) {
		element = driver.findElement(By.name(value));
	} else if (locater.equalsIgnoreCase("xpath")) {
		element = driver.findElement(By.xpath(value));
	}

	else if (locater.equalsIgnoreCase("tagname")) {
		element = driver.findElement(By.tagName(value));
	}
	return element;
}

public static List<WebElement> findElements(WebElement element, String locater, String value) {
	List<WebElement> elements = null;
	if (locater.equalsIgnoreCase("id")) {
		elements = element.findElements(By.id(value));
	} else if (locater.equalsIgnoreCase("name")) {
		elements = element.findElements(By.name(value));
	} else if (locater.equalsIgnoreCase("xpath")) {
		elements = element.findElements(By.xpath(value));
	}

	else if (locater.equalsIgnoreCase("tagname")) {
		elements = element.findElements(By.tagName(value));
	}

	return elements;
}

		public static String getExcel(String pathname, String Sheetname, int rowno, int cellno) throws IOException {
			String value = "";
			File file = new File(pathname);
			FileInputStream stream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(Sheetname);
			Row row = sheet.getRow(rowno);
			Cell cell = row.getCell(cellno);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
				value = dateFormat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);

			}
			return value;

		}

		public static void implicityWait() {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		public static void excelWrite(String pathname, String Sheetno, int rowno, int cellno, String data)
				throws IOException {
			File file = new File(pathname);
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet createSheet = workbook.createSheet(Sheetno);
			Row createRow = createSheet.createRow(rowno);
			Cell createCell = createRow.createCell(cellno);
			createCell.setCellValue(data);

			FileOutputStream stream2 = new FileOutputStream(file);
			workbook.write(stream2);

		}
		public static void keyBoardAction(int name) throws AWTException, InterruptedException {
			
			Robot robot = new Robot();
			robot.keyPress(name);
			robot.keyRelease(name);
			Thread.sleep(2000);
			for (int i = 1; i < 3; i++) {

				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);

			}
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
			
		}

	
}