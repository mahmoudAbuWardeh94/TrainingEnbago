import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.multipart.FileUpload;

public class EnbagoTestCase {
	public WebDriver driver;
	public int numberOfBlockUsers = 1;
	public int numberOfUnblockUsers = numberOfBlockUsers;
	public int maxIsFixed = 5;

	@BeforeTest()
	public void before_test() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\":r0:\"]")).sendKeys("super@test.com");
		driver.findElement(By.xpath("//*[@id=\":r1:\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();

	}
	@Test()
	public void scroll() throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[2]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/section/a[4]")).click();
		
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		
	}
	

	@Test(priority = 0)
	public void block_users() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (int i = 0; i < numberOfBlockUsers; i++) {
			Thread.sleep(1000);
			driver.findElement(By.className("bg2")).click();
			driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[1]/a")).click();
		}
	}

	@Test(priority = 1)
	public void unblock_users() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (int k = 0; k < numberOfUnblockUsers; k++) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[6]/a")).click();
			driver.findElement(By.className("bg3")).click();
			driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[6]/a")).click();
		}
	}

	@Test(priority = 2)
	public void verity_search_criteria_users_management_page() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input"))
				.sendKeys("Enbago_00017");// userName
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input")).clear();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input"))
				.sendKeys("ibrahiem@nadsoft.net"); // Email

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input")).clear();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input"))
				.sendKeys("GOOGLE");// RegistrationType
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input")).clear();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input"))
				.sendKeys("FACEBOOK");// RegistrationType
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input")).clear();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input"))
				.sendKeys("APPLE");// RegistrationType
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div[1]/div[2]/div/input")).clear();
	}

	@Test(priority = 3)
	public void fixed_up_to_5() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[2]/a")).click();
		Thread.sleep(3000);
		List<WebElement> isFixed = driver.findElements(By.className("form-check-input"));
		int totalIsFixed = isFixed.size();
		for (int j = 0; j < totalIsFixed; j++) {
			Thread.sleep(1000);
			isFixed.get(j).click();
		}
	}

	@Test(priority = 4)
	public void update_approved_post() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/table/tbody/tr[1]/td[11]/a"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":r2:\"]")).sendKeys("عاجل");
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div[1]"))
				.sendKeys("hhh");
		Thread.sleep(1000);

		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/label/input"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div/label/input"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/label/input"))
				.click();

		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[2]/div[5]/div[1]/div/div/label/input"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[2]/div[6]/div[1]/div/div/label/input"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.id(":r8:")).sendKeys("https://www.youtube.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]")).click();

	}

	@Test(priority = 5)
	public void send_a_notification() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/aside/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\":r2:\"]")).sendKeys("عاجل"); // title
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[1]/div[3]/div/textarea"))
				.sendKeys("السلام عليكم"); // content
		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/label/input"))
				.click();
		driver.findElement(By.xpath("//*[@id=\":r7:\"]")).sendKeys("https://www.youtube.com");
		driver.findElement(By.xpath("//*[@id=\":r4:\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_sign_in_submit\"]/span")).click();

	}

}