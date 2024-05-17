package miniproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	private WebDriver driver;

    public void createBrowser() throws InterruptedException {
    	driver =new ChromeDriver();
    	
    }
    public void closeBrowser() {
        driver.quit();
    }
    public void navigateToURL(String url) {
        driver.get(url);
    }
 
    public void maximizeWindow()
    {
		driver.manage().window().maximize();
    }
    public void clickSignInLink() {
        WebElement signInLink = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]"));
        signInLink.click();
    }
    public String getAlertText() {
    	Alert alert=driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
    public void clickForgotPasswordLink() {
        WebElement fPasswordLink =driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[3]/div[2]/span/a"));
        fPasswordLink.click();
    }
    public void clickNext() {
        WebElement Nextbut =driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/input[2]"));
        Nextbut.click();
    }
    public void clickPrivacypolicy() {
        WebElement privacyPolicy =driver.findElement(By.xpath("/html/body/div/div[3]/a[2]"));
        privacyPolicy.click();
    }
    public void goPrevious()
    {
		driver.navigate().back();
    }
    public void closePage()
    {
		driver.close();
    }
    public String getNewTabTitle() {
    	String pageTitle="";
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                pageTitle = driver.getTitle(); 
            }
        }
		return pageTitle;
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
		Main obj=new Main();
		obj.createBrowser();
		Thread.sleep(5000);
		obj.navigateToURL("https://mail.rediff.com/cgi-bin/login.cgi");
		obj.maximizeWindow();
		Thread.sleep(5000);
		obj.clickSignInLink();
		String firstAlert=obj.getAlertText();
		obj.clickForgotPasswordLink();
		obj.clickNext();
		String secondAlert=obj.getAlertText();
		obj.goPrevious();
		obj.clickPrivacypolicy();
		String newTabTitle=obj.getNewTabTitle();
		obj.closePage();
		System.out.println(firstAlert);
		System.out.println(secondAlert);
		System.out.println(newTabTitle);
		obj.closeBrowser();
		Excel obj2=new Excel();
		obj2.excelsheet(firstAlert, secondAlert, newTabTitle);
    }
}
