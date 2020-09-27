# VoteAuto
自动投票
//https://npm.taobao.org/mirrors/chromedriver/  这个网址可以查看谷歌浏览器对应的chromedriver
/* System.setProperty("webdriver.chrome.driver", "D:\\tools\\Vote\\chromedriver.exe");
WebDriver driver = new ChromeDriver();*/

//火狐浏览器更改了默认安装地址必须配置,否则会报错Cannot find firefox binary in PATH. Make sure firefox is installed
System.setProperty("webdriver.firefox.bin", "D:\\installSoftware\\firefox\\firefox.exe");
//https://github.com/mozilla/geckodriver/tags  github上下载火狐浏览器的插件
System.setProperty("webdriver.gecko.driver", "D:\\tools\\Vote\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
