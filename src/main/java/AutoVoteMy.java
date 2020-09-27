import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class AutoVoteMy {

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i <10 ; i++) {
            Thread.sleep(3000);
            //https://npm.taobao.org/mirrors/chromedriver/  这个网址可以查看谷歌浏览器对应的chromedriver
            System.setProperty("webdriver.chrome.driver", "D:\\tools\\Vote\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "D:\\tools\\Vote\\geckodriver.exe");
//         WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().window().setPosition(new Point(100, 50));
            driver.manage().deleteAllCookies();
            // 与浏览器同步非常重要，必须等待浏览器加载完毕
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://jinshuju.net/f/fy20QA");

            Thread.sleep(1000);
            //选中18号  浏览器右击查看元素,可以复制 xpath
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[3]/div/div[2]/div/div[2]/div/div/span/div/div[3]/div/div/label/span[1]")).click();

            Thread.sleep(5000);
            //投票
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[5]/div[1]/button")).click();
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div/div[3]/a/div")).submit();

            Thread.sleep(2000);
            driver.quit();
//        }
    }

}