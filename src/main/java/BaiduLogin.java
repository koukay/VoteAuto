import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BaiduLogin {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
//        System.setProperty("webdriver.gecko.driver", "D:\tools\Vote\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\Vote\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(100, 50));
        driver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://pan.baidu.com/");

        Thread.sleep(1000);

        /*WebElement qqLoginLink = driver
                .findElement(By.xpath("/html/body/div[1]/div[3]/div[6]/div/div[4]/div[2]/div/ul/li[2]/a"));
        qqLoginLink.click();
        Thread.sleep(1000);*/

        // 获取当前页面句柄
        String handle = driver.getWindowHandle();
        // 获取所有页面的句柄，并循环判断不是当前的句柄 然后切换到子窗体
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }

        // 由于登录输入框在frame中，还需要先切换进入frame，否则，也找不到输入框的
//        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ptlogin_iframe']")));

        // 调试过程中，如果提示找不到元素，不知道是否切换成功了，可以把当前handler的source打印出来看看
        // System.out.println(driver.getPageSource());

//        driver.findElement(By.xpath("//*[@id='switcher_plogin']")).click();
        driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_4__userName']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_4__password']")).sendKeys("pwd");
        driver.findElement(By.xpath("//*[@id='TANGRAM__PSP_4__submit']")).submit();
        ////*[@id="TANGRAM__PSP_4__submit"]

        //由于我的账号没绑定手机，点登录后会有个提示，如果直接关闭，可能被判断为还没完成登录，没有会话，所以稍等片刻
        Thread.sleep(2000);

        //关闭弹出的子窗体
        driver.close();

        //driver.navigate() 下有很多方法，比如后退，刷新等
        Thread.sleep(2000);
    }

}
