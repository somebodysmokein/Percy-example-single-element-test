package com.browserstack.test;// Generated by Selenium IDE
import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;

public class TestImageUploadTest {
  public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
  public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
  public WebDriver driver=null;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  public Percy percy;



  @BeforeTest
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    percy = new Percy(driver);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterTest
  public void tearDown()
  {
    driver.quit();
  }

  @Test
  public void testImageUpload() throws InterruptedException {
    driver.get("https://4over.com/business-cards");
    driver.manage().timeouts().implicitlyWait(Duration.of(30, ChronoUnit.SECONDS));
    //driver.manage().window().setSize(new Dimension(1920, 1080));
    //driver.findElement(By.cssSelector("#ui-id-3")).click();
    /*driver.findElement(By.cssSelector("#ui-id-18 > span")).click();
    js.executeScript("window.scrollTo(0,65)");
    driver.findElement(By.cssSelector("#ui-id-2 > span")).click();*/
    driver.findElement(By.linkText("Standard Business Cards")).click();
    driver.findElement(By.id("pdp-login-customer-email")).click();
    driver.findElement(By.id("pdp-login-customer-email")).sendKeys("browserstack@4over.com");
    driver.findElement(By.id("pdp-login-pass")).click();
    driver.findElement(By.id("pdp-login-pass")).sendKeys("4r&&Haq7f-Ep");
    driver.findElement(By.cssSelector("#send4 > span")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#send4 > span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".magnify-wheel-loaded > .fotorama__img"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    //driver.findElement(By.id("attribute211")).click();
    WebElement sizeElt=fluientWaitforElement(driver.findElement(By.id("attribute211")), 60, 5);
    Select sizeSelector = new Select(sizeElt);
    sizeSelector.selectByValue("113");

    //driver.findElement(By.id("attribute196")).click();
    WebElement shapeElt=fluientWaitforElement(driver.findElement(By.id("attribute196")), 60, 5);
    Select shapeSelector = new Select(shapeElt);
    shapeSelector.selectByVisibleText("Rectangle");

    //driver.findElement(By.id("attribute197")).click();
    WebElement stockElt=fluientWaitforElement(driver.findElement(By.id("attribute197")), 60, 5);
    Select stockSelector = new Select(stockElt);
    stockSelector.selectByVisibleText("14PT C2S");

    //driver.findElement(By.id("attribute204")).click();
    WebElement colorSpecElt=fluientWaitforElement(driver.findElement(By.id("attribute204")), 60, 5);
    Select colcorSpecSelector = new Select(colorSpecElt);
    colcorSpecSelector.selectByVisibleText("4/4 (4 color both sides)");

    //driver.findElement(By.id("attribute201")).click();
    WebElement coatingElt=fluientWaitforElement(driver.findElement(By.id("attribute199")), 60, 5);
    Select coatingSelector = new Select(coatingElt);
    coatingSelector.selectByVisibleText("Matte");

    WebElement spotUVElt=fluientWaitforElement(driver.findElement(By.id("attribute201")), 60, 5);
    Select spotUVSidesSelector= new Select(spotUVElt);
    spotUVSidesSelector.selectByVisibleText("No Spot UV");
    js.executeScript("window.scrollTo(0,485)");
    //driver.findElement(By.name("turnaround_time")).click();


    //driver.findElement(By.id("attribute199")).click();
    driver.findElement(By.cssSelector(".proceed-to-shipping")).click();

    WebElement projNameElt=fluientWaitforElement(driver.findElement(By.id("project_name")),60,5);
    projNameElt.sendKeys("test");

    Thread.sleep(3000);
    js.executeScript("window.scrollTo(0,485)");

    Thread.sleep(3000);

      WebElement shippingMethodElt = fluientWaitforElement(driver.findElement(
              By.cssSelector("div.project_shipping-method > div:nth-child(2) > select")), 60, 5);
    try {
      Select shippingSelector = new Select(shippingMethodElt);
      shippingSelector.selectByVisibleText("Ground Shipping $8.00");
    }catch(StaleElementReferenceException e)
    {
      System.out.println("Inside StaleElementReferenceException");
      System.out.println(e.getMessage());
      e.printStackTrace();
    }


    JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
    String prevFrameName = (String) jsExecutor.executeScript("return self.name");
    System.out.println("***************** Previous frame using self.name " + prevFrameName);

    WebElement uploadBtn=fluientWaitforElement(driver.findElement(By.cssSelector("div.project-summary_actions > div > button")),60,5);
    uploadBtn.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#project-artwork > iframe")));


    List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
    System.out.println("The total number of iframes are " + iframeElements.size());



    String currentFrameName = (String) jsExecutor.executeScript("return self.name");
    System.out.println("***************** Current frame using self.name " + currentFrameName);

    WebElement firstUpload=fluientWaitforElement(driver.findElement(
            By.xpath("(//*[@class=\"filepond--drop-label\"])[1]")),300,5);
    Thread.sleep(3000);
    firstUpload.click();
    uploadFile("/Users/venkatesh/Projects/Console-Annotations/src/conf/3.5x2-PaintedEdge-FR.pdf");

    WebElement secondUpload=fluientWaitforElement(driver.findElement(By.xpath("(//*[@class=\"filepond--drop-label\"])[2]")),60,5);
    secondUpload.click();
    uploadFile("/Users/venkatesh/Projects/Console-Annotations/src/conf/1_2X3.5-bk.pdf");
    Thread.sleep(3000);

    driver.switchTo().defaultContent();
    Thread.sleep(3000);

    String currentFrameAfterSwitching = (String) jsExecutor.executeScript("return self.name");
    System.out.println("***************** Current frame After switching to default content" + currentFrameAfterSwitching);


    WebDriverWait waitforiFrameReload = new WebDriverWait(driver, Duration.ofSeconds(120));
    waitforiFrameReload.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#project-artwork > iframe")));

    String chgFrameAfterSwitching = (String) jsExecutor.executeScript("return self.name");
    System.out.println("***************** Current frame After reloading iFrame " + chgFrameAfterSwitching);





    WebElement mainCanvas=fluientWaitforElement(
            driver.findElement(By.xpath("//div[@id=\"workspace\"]//img[@id=\"imgMain\"]")),300,5);




    if(mainCanvas.isEnabled()) {


      //percy.snapshot("Docs Page Test", Arrays.asList(new Integer[]{375, 480, 720, 1280, 1440, 1920}));
      Map<String, Object> froptions = new HashMap<String, Object>();
      froptions.put("widths", Arrays.asList(new Integer[]{375, 480, 720, 1280, 1440, 1920}));
      froptions.put("scope", "div.jss45 > div.jss30 > div.jss31 > div > div");
      percy.snapshot("Front Panel", froptions);


      Map<String, Object> bkoptions = new HashMap<String, Object>();
      bkoptions.put("widths", Arrays.asList(new Integer[]{375, 480, 720, 1280, 1440, 1920}));
      bkoptions.put("scope", "div.jss45 > div.jss30 > div.jss32 > div > div");
      percy.snapshot("Back Panel", bkoptions);


      Map<String,Object> mainCanvasMap= new HashMap<>();
      //mainCanvasMap.put("scope", "div#workspace > div.boxesHolderContainer > div#BoxesHolder > div#PrintableArea > div#C4mCanvasArtHolder > img#imgMain");
      mainCanvasMap.put("scope","div#workspace > div.boxesHolderContainer > div#BoxesHolder > div#PrintableArea > div#C4mCanvasArtHolder > img#imgMain");
      mainCanvasMap.put("widths",Arrays.asList(new Integer[]{375, 480, 720, 1280, 1440, 1920}));
      mainCanvasMap.put("enableJavaScript",true);
      percy.snapshot("Main Canvas Back Panel", mainCanvasMap);


      WebElement frontPanelElt=fluientWaitforElement(driver.findElement(By.cssSelector("div.jss45 > div.jss30 > div.jss31")), 60, 5);
      frontPanelElt.click();
      Map<String,Object> mainCanvasMapFrontPanel= new HashMap<>();
      mainCanvasMapFrontPanel.put("scope","div#workspace > div.boxesHolderContainer > div#BoxesHolder > div#PrintableArea > div#C4mCanvasArtHolder > img#imgMain");
      mainCanvasMapFrontPanel.put("widths",Arrays.asList(new Integer[]{375, 480, 720, 1280, 1440, 1920}));
      mainCanvasMapFrontPanel.put("enableJavaScript",true);
      percy.snapshot("Main Canvas Front Panel", mainCanvasMapFrontPanel);

      WebElement rotateRight= fluientWaitforElement(driver.findElement(By.cssSelector("div#rotate-right")), 60, 5);
      rotateRight.click();
      Map<String,Object> mainCanvasMapFrontPanelRightRotate= new HashMap<>();
      mainCanvasMapFrontPanelRightRotate.put("scope","div#workspace > div.boxesHolderContainer > div#BoxesHolder > div#PrintableArea > div#C4mCanvasArtHolder > img#imgMain");
      mainCanvasMapFrontPanelRightRotate.put("widths",Arrays.asList(new Integer[]{375, 480, 720, 1280, 1440, 1920}));
      mainCanvasMapFrontPanelRightRotate.put("enableJavaScript",true);
      mainCanvasMapFrontPanelRightRotate.put("percyCSS", "div#workspace img#imgMain {transform: rotate(90deg)}");
      percy.snapshot("Main Canvas Front Panel Right Rotated", mainCanvasMapFrontPanelRightRotate);

      froptions.put("scope", "div.jss45 > div.jss30 > div.jss32 > div > div");
      percy.snapshot("Front Panel Right Rotated", froptions);


    }


  }

  public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {

    //System.out.println(driver.getTitle());
    FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(timoutSec))
            .pollingEvery(Duration.ofSeconds(pollingSec))
            .ignoring(NoSuchElementException.class, TimeoutException.class)
            .ignoring(StaleElementReferenceException.class);
    int retry=0;

//    for (int i = 0; i < 2; i++) {
    while(retry<5)
    {
      try {

        fWait.until(ExpectedConditions.visibilityOf(element));
        fWait.until(ExpectedConditions.elementToBeClickable(element));
        break;
      } catch (Exception e) {
        System.out.println("Element Not found trying again - " + element.toString().substring(70));
        e.printStackTrace();
        retry++;
        System.out.println("Retry count "+ retry);

      }
    }

    return element;

  }

  public static void setClipboardData(String string) {
//StringSelection is a class that can be used for copy and paste operations.
    StringSelection stringSelection = new StringSelection(string);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
  }


  public static void uploadFile(String fileLocation) {
    try {
//Setting clipboard with file location
      setClipboardData(fileLocation);
//native key strokes for CTRL, V and ENTER keys
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }


}



