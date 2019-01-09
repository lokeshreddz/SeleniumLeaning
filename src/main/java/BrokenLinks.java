import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homepage);

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {

            url = it.next().getAttribute("href");

            System.out.println(url);

            if (url == null || url.isEmpty()) {

                System.out.println("URL is miss configured or is empty()");
                continue;
            }

            if (!url.startsWith(homepage)) {
                System.out.println("url belongs to another page - skipping it");
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                resposecode = huc.getResponseCode();

                if (resposecode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        driver.close();

    }
}
