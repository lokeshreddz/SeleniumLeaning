import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

public class BrokenLinks {

    public static WebDriver driver = null;

    public static void main(String[] args) {

        String homepage = "https://www.guru99.com/find-broken-links-selenium-webdriver.html";
        String url = "";
        HttpURLConnection huc = null;
        int resposecode = 200;
        System.setProperty("webdriver.gecko.driver", "C:\\Automate3.0\\SeleniumLearning\\geckodriver.exe");

        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homepage);

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

            //while (it.hasNext())


    }
}
