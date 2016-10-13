package cm.hwl.seleniums;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrowsers implements IFrameLocators, JDweb {
    private WebDriver driver;
    private ParseProperties locator;
    private ParseProperties ppro;
    private Wait wait;
    private SwitchToSome switchToSome;

    @BeforeClass
    public void before() {
	driver = Browsers.getDriver(BrowsersType.FIREFOX);
	locator = new ParseProperties(System.getProperty("user.dir")
		+ "\\locator.properties");
	ppro = new ParseProperties(System.getProperty("user.dir")
		+ "\\test.properties");
    }

    @Test
    public void test1() {
	driver.get(ppro.getData("url"));
	wait = new Wait(driver);
	wait.waitFor(5);
	driver.switchTo().frame(
		driver.findElement(By.xpath(locator.getData("iframe"))));
	driver.findElement(By.xpath(locator.getData("uernamePath"))).sendKeys(
		ppro.getData("username"));
	driver.findElement(By.xpath(locator.getData("passwordPath"))).sendKeys(
		ppro.getData("password"));
	driver.findElement(By.xpath(locator.getData("loginbtn"))).click();

    }

    @Test(dependsOnMethods = "test1")
    public void seeMails() {
	wait.waitForElementPresent(locator.getData("homeTitle"));
	driver.findElement(By.xpath(locator.getData("mailbox"))).click();
	int totalmails = 0;
	String mails = driver.findElement(By.xpath(locator.getData("mails")))
		.getText();
	totalmails = Integer.parseInt(mails.substring(1, mails.length() - 1));
	// System.out.println(totalmails);
	int totalpage = Integer.parseInt(driver
		.findElement(By.xpath(locator.getData("page"))).getText()
		.split("/")[1]);
	System.out.println("totalpage: " + totalpage);
	int unreadmails = 0;
	while (totalpage >= 1) {
	    List<WebElement> elements = driver.findElements(By.xpath(locator
		    .getData("letters")));
	    for (WebElement e : elements) {
		System.out.println(e.getText());
	    }
	    unreadmails = elements.size() + unreadmails;
	    try {
		driver.findElement(By.xpath(locator.getData("nextPage")))
			.click();
		wait.waitFor(5000);
	    } catch (Exception e) {
		break;
	    }
	    totalpage--;
	}
	System.out.println("unreadmails: " + unreadmails);
    }

    @Test
    public void testIframe() {
	driver.get("http://jqueryui.com/slider/");
	wait = new Wait(driver);
	// 转到iframe窗口
	wait.waitForElementPresent(jqueryHome);
	// driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
	switchToSome = new SwitchToSome(driver);
	switchToSome.swtichToIFrame(iframe);
	Point sliderPoint = driver.findElement(By.xpath(Slider)).getLocation();
	// System.out.println(sliderPoint);//(-1, 4)
	Actions action = new Actions(driver);
	action.dragAndDropBy(driver.findElement(By.xpath(Slider)),
		sliderPoint.getX() + 90, sliderPoint.getY()).build().perform();
	// 返回默认的windows
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//a[text()='Demos']")).click();
    }

    @Test
    public void SelectItemFromDropDownList() {
	driver.get("https://passport.jd.com/uc/login?ltype=logout");
	driver.findElement(By.xpath(loginNo)).sendKeys(username);
	driver.findElement(By.xpath(loginPassword)).sendKeys(password);
	driver.findElement(By.xpath(loginBtn)).click();
	wait = new Wait(driver);
	wait.waitForElementPresent(logo);
	driver.findElement(By.xpath(usernameLocator)).click();
	switchToSome = new SwitchToSome(driver);
	switchToSome.swtichToNewWindows("我的京东");
	// 下拉到个人信息
	((JavascriptExecutor) driver)
		.executeScript("window.scrollBy(0,900)", 0);
	wait.waitFor(5000);
	driver.findElement(By.xpath(self)).click();
	switchToSome.swtichToNewWindows("账户信息");
	wait.waitForElementPresent(brithday);
	Select selectYear = new Select(driver.findElement(By.xpath(brithday)));
	// selectYear.selectByVisibleText("2005");
	List<WebElement> allyear = selectYear.getOptions();
	for (WebElement e : allyear) {
	    System.out.println(e.getText());
	}
    }

}
