package base;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver ;  //1
	public static Properties prop;    //2
	
	public void init(){               //3
		
		//System.setProperty("webdriver.edge.driver", "C:\\edgedriver_win64 (1)\\msedgedriver.exe");
	
		prop=new Properties();
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\bhush\\eclipse-workspace1\\NewSileniumTech\\src\\main\\java\\config\\config.properties");
		prop.load(file);
		} catch (Exception e) {
		e.printStackTrace();
			System.out.println("Configuration file is missing");
		}
		
	String browser = prop.getProperty("browser");
	 //String browser="edge"
	    if(browser.contains("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
		else if(browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
	}
			else if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get(prop.getProperty("url"));

	
	}
}
