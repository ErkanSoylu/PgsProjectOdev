package com.saha;


import com.google.common.collect.ImmutableMap;
import com.saha.helper.StoreHelper;
import com.saha.model.SelectorInfo;
import com.saha.selector.Selector;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.saha.selector.SelectorFactory;
import com.saha.selector.SelectorType;
import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Nullable;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;


import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;


public class StepImpl {

    private static Workbook wb;
    private static Sheet sh;
    private static FileInputStream fis ;
    private static FileOutputStream fos ;
    private static Row row ;
    private static Cell cell ;
    private Logger logger = LoggerFactory.getLogger(getClass());
    protected AppiumDriver<MobileElement> appiumDriver;
    private FluentWait<AppiumDriver> appiumFluentWait;
    private Selector selector;
    private boolean localAndroid = true;
    private DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ALL);
    private String model;


    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
        if (StringUtils.isEmpty(System.getenv("key"))) {

            if (localAndroid) {
                logger.info("Local Browser");
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities
                        .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
                //desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.turkishairlines.mobile");
                desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.turkishairlines.mobile.ui.main.MainActivity");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
                desiredCapabilities.setCapability("unicodeKeyboard", false);
                desiredCapabilities.setCapability("resetKeyboard", false);
                URL url = new URL("http://0.0.0.0:4723/wd/hub");
                appiumDriver = new AndroidDriver(url, desiredCapabilities);
            } else {
               /*
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities
                        .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "61dacc0380193eee2014abca876b137027226b01"); //8
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "saba bt");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");
                desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.pinsoft.PIA-UAT");
                desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new IOSDriver<>(url, desiredCapabilities);

                */
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities
                        .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "61dacc0380193eee2014abca876b137027226b01"); //8
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "saba bt");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");
                desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.pinsoft.PIA-UAT");
                desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new IOSDriver<>(url, desiredCapabilities);
                localAndroid = false;
            }
        } else {
            String hubURL = "http://hub.testinium.io/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            System.out.println("key:" + System.getenv("key"));
            System.out.println("platform" + System.getenv("platform"));
            System.out.println("version" + System.getenv("version"));

            if (System.getenv("platform").equals("ANDROID")) {
                capabilities.setCapability("key", System.getenv("key"));
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.piac.thepiaapp.android.beta");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.pia.ticketing.view.splash.SplashScreenActivity");
                // capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
                capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                capabilities.setCapability("unicodeKeyboard", false);
                capabilities.setCapability("resetKeyboard", false);
                appiumDriver = new AndroidDriver(new URL(hubURL), capabilities);
                localAndroid = true;
            } else {
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                capabilities.setCapability("usePrebuiltWDA", true);
                capabilities.setCapability("waitForAppScript", "$.delay(1000);");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.pinsoft.PIA-UAT");
                //capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.4");
                //appiumDriver.getCapabilities().getCapability("platformVersion");
                capabilities.setCapability("key", System.getenv("key"));
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, System.getenv("version"));
                appiumDriver = new IOSDriver<>(new URL(hubURL), capabilities);
                localAndroid = false;
            }
        }
        selector = SelectorFactory.createElementHelper(localAndroid ? SelectorType.ANDROID : SelectorType.IOS);
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        appiumFluentWait = new FluentWait(appiumDriver);
        appiumFluentWait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(1000, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        System.out.println("sessionID: " + appiumDriver.getSessionId());
    }
    @AfterScenario
    public void afterScenario() {
        appiumDriver.quit();
    }
    public MobileElement findElement(By by) {
        return appiumDriver.findElement(by);
    }
    private boolean isElementPresent(By by) {
        try {
            appiumDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void waitUntilElementIsVisible(String key) {
        By elementBy = selector.getSelectorInfo(key).getBy();
        appiumFluentWait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        System.out.println("'" + key + "' is displayed");
    }
    public List<MobileElement> findElements(By by) {
        return appiumFluentWait.until(new ExpectedCondition<List<MobileElement>>() {
            @Nullable
            @Override
            public List<MobileElement> apply(@Nullable WebDriver driver) {
                List<MobileElement> elements = driver.findElements(by);
                return elements.size() > 0 ? elements : null;
            }
        });
    }

    public Object shellCommand(String commandType, String shellCommands) {
        String[] args = shellCommands.trim().split(" ");
        List<String> removePicsArgs = new ArrayList<>();
        for (int i = 0 ; i < args.length ; i++){
            removePicsArgs.add(args[i]);
        }
        Map<String, Object> removePicsCmd = ImmutableMap.of(
                "command", commandType,
                "args", removePicsArgs
        );
        return appiumDriver.executeScript("mobile: shell",removePicsCmd);
    }

    public Object mobileShell(String commandType, String shellCommands){
        return shellCommand(commandType, shellCommands);
    }

    public void getPhoneModel(){
        //Lokal cihaz modeli.
        model = shellCommand("getprop", "ro.product.model").toString();
    }

    @Step("<key> işlemi rastgele seçilir ")
    public void selectSeat(String key) {
        List<MobileElement> elements = findElemenstByKey(key);
        List koltukListeis = new ArrayList();
        int turSayisi = 0;
        while (turSayisi < 2) {
            turSayisi = turSayisi + 1;
            int i = 0;
            for (i = 0; i < elements.size(); i++) {
                String ucusMusait = elements.get(i).getAttribute("clickable");
                if (ucusMusait.equals("true")) {
                    koltukListeis.add(i);
                } else if (ucusMusait.equals("false")) {
                }
            }
            if (koltukListeis.size() == 0) {
                swipeDownAccordingToPhoneSize();
                i = 0;
            }
        }
        Random random = new Random();
        int toplamSayi = random.nextInt(koltukListeis.size());
        elements.get((Integer) koltukListeis.get(toplamSayi)).click();

    }
    @Step("Mevcut kişi sayısını kontrol et")
    public void controlTheBasketCount() throws InterruptedException {
        Thread.sleep(5000);
        boolean test = isElementPresent(By.id("com.turkishairlines.mobile:id/frPickPassengerlistitem_tvEdit"));
        if (test == true) {
            System.out.println("Sepette ürünler mevcut , ürün adedine göre sırasıyla silme işlemi gerçekleştirilecek.");
            List<MobileElement> allProducts = findElemenstByKey("duzenleButonu");
            for(int i=allProducts.size(); i>0; i--){
                Thread.sleep(5000);
                clickByKey("duzenleButonu");
                System.out.println("Mevcut kişi listesine girildi. ...");
                Thread.sleep(2000);
                clickByKey("kisiSilme");
                System.out.println("Listeden kişi silindi...");
                Thread.sleep(2000);
            }

            Thread.sleep(5000);
            System.out.println("Mevcut kişi listesi olmadığı için devam ediliyor...");
            Thread.sleep(5000);

        }
        else {
            System.out.println("Mevcut kişi listesi olmadığı için devam ediliyor...");
            Thread.sleep(5000);

        }
    }
    @Step({"Click element by <key> if exist"})
    public void existClickByKey(String key) {

        MobileElement element = null;
        try {
            element = findElementByKey(key);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (element != null) {
            element.click();
        }
    }

    @Step({"Click element by <key>"})
    public void clickByKey(String key) throws InterruptedException {
        findElementByKey(key).click();
        System.out.println("'" + key + "' element clicked");
        Thread.sleep(2000);
    }

    @Step("Find element by <key> and send keys <text> to input")
    public void sendKeysToInput(String key, String text) {

        findElement(By.xpath(key)).sendKeys(text);
        System.out.println("Text girildi");
    }

    @Step({"Find element by <key> and send keys <text>"})
    public void searhAirportInputsendKeysByKeyNotClear(String key, String text) {

        MobileElement _me = findElementByKey(key);
        _me.setValue(text);
        System.out.println("'" + text + "' written to '" + key + "' element.");
    }

    @Step("Check flight list")
    public void checkTotalFlightList() {
        List<MobileElement> allProducts= findElemenstByKey("ucusListeleme");
        allProducts.size();
        System.out.println("Uçuş sayısı kontrol ediliyor...:"+allProducts.size());
        if (allProducts.size()>0) {
            System.out.println("Uçuş Sayısı 0'dan fazladır devam ediliyor...");
        }
        else {
            System.out.println("Uçuş listelenemedi sistemden çıkılıyor...");
            appiumDriver.closeApp();
        }

    }
    @Step("Select departure date")
    public void selectDepDate() {
        int dayToBeSelected = LocalDate.now().plusDays(2).getDayOfMonth();
        int today = LocalDate.now().plusDays(0).getDayOfMonth();
        System.out.println("Departure, day of month : " + dayToBeSelected);

        if (appiumDriver instanceof AndroidDriver) {

            if (today >= 31) {

                waitBySecond(3);
                swipeMethod();
                waitBySecond(3);
                swipeMethod();
                waitBySecond(3);
                swipeMethod();
                waitBySecond(3);
                swipeMethod();
                waitBySecond(5);

                findElement(By.xpath("//*[@text='" + dayToBeSelected + "']")).click();
            } else {

                findElement(By.xpath("//*[@text='" + dayToBeSelected + "']")).click();
            }
        }
    }
    @Step({"<key> li elementi bul", "Find element by <key>"})
    public MobileElement findElementByKey(String key) {

        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        return selectorInfo.getIndex() > 0 ? findElements(selectorInfo.getBy())
                .get(selectorInfo.getIndex()) : findElement(selectorInfo.getBy());
    }

    @Step({"<key> li elementleri bul", "Finds element by <key>"})
    public List<MobileElement> findElemenstByKey(String key) {

        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        return findElements(selectorInfo.getBy());
    }
    @Step({"Değeri <text> e eşit olan elementli bul ve tıkla",
            "Find element text equals <text> and click"})
    public void clickByText(String text) {

        findElement(By.xpath(".//*[contains(@text,'" + text + "')]")).click();
    }
    private int getScreenWidth() {
        return appiumDriver.manage().window().getSize().width;
    }

    private int getScreenHeight() {
        return appiumDriver.manage().window().getSize().height;
    }

    private int getScreenWithRateToPercent(int percent) {
        return getScreenWidth() * percent / 100;
    }

    private int getScreenHeightRateToPercent(int percent) {
        return getScreenHeight() * percent / 100;
    }

    public void swipeDownAccordingToPhoneSize(int startXLocation, int startYLocation, int endXLocation, int endYLocation) {

        startXLocation = getScreenWithRateToPercent(startXLocation);
        startYLocation = getScreenHeightRateToPercent(startYLocation);
        endXLocation = getScreenWithRateToPercent(endXLocation);
        endYLocation = getScreenHeightRateToPercent(endYLocation);
        //appiumDriver.swipe(startXLocation, startYLocation, endXLocation, endYLocation, 1500);
    }

    @Step(" <yön> yönüne swipe et")
    public void swipe(String yon) {

        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;

        if (yon.equals("SAĞ")) {

            int swipeStartWidth = (width * 80) / 100;
            int swipeEndWidth = (width * 30) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
        }
        else if (yon.equals("SOL")) {

            int swipeStartWidth = (width * 30) / 100;
            int swipeEndWidth = (width * 80) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);

        }
    }
    @Step({"Wait <second> seconds"})
    public void waitBySecond(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
            System.out.println(seconds +  " saniye bekleniyor. ");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swipeUpAccordingToPhoneSize() {

        if (appiumDriver instanceof AndroidDriver) {

            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 50) / 100;
            int swipeEndHeight = (height * 90) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
        }
        else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 40) / 100;
            int swipeEndHeight = (height * 90) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
        }
    }

    public void swipeDownAccordingToPhoneSize() {

        if (appiumDriver instanceof AndroidDriver) {

            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 90) / 100;
            int swipeEndHeight = (height * 50) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
        }
        else {

            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 90) / 100;
            int swipeEndHeight = (height * 40) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
        }
    }



    @Step("swipe et")
    public void swipeMethod() {

        if (appiumDriver instanceof IOSDriver) {

            Dimension size = appiumDriver.manage().window().getSize();
            int x = size.getWidth() / 2;
            int starty = (int) (size.getHeight() * 0.60);
            int endy = (int) (size.getHeight() * 0.10);

            new TouchAction(appiumDriver).longPress(PointOption.point(x, starty))
                    .moveTo(PointOption.point(x, endy))
                    .release().perform();

            System.out.println("swipe yapıldı");

        }
        else if (appiumDriver instanceof AndroidDriver) {

            if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("ce03171359aa84720c")) {

                System.out.println("Method (swipe et) cihaz S8 PLUS (ce03171359aa84720c) için çalıştırılmadı.");
            }
            else if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("fe64e409")){

                System.out.println("Method (swipe et) cihaz Galaxy A7  (fe64e409) için çalıştırılmadı.");
            }
            else{

                new TouchAction(appiumDriver).longPress(PointOption.point(330, 800))
                        .moveTo(PointOption.point(330, 568))
                        .release().perform();

                System.out.println("swipe yapıldı");
            }
        }
    }


    @Step("device info")
    public void deviceInfo() {

        System.out.println(appiumDriver.getCapabilities().getCapability("deviceModel").toString());
    }

    public String exceldenOku(int vRow, int vColumn, int SheetNumber) throws IOException {
        Workbook workbook=null;
        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\testinium\\Desktop\\PgsProjectOdev\\src\\test\\resources\\excel\\odevTHY.xlsx");
            workbook = new XSSFWorkbook(fis);
        }
        catch (FileNotFoundException e) {
            System.out.println("Dosya Bulunamadı");
        }
        catch (IOException e) {
            System.out.println("Dosya açılırken bir sorun ile karşılaşıldı");
        }
        Sheet sheet=workbook.getSheetAt(SheetNumber);
        DataFormatter formatter = new DataFormatter();
        Cell cell = sheet.getRow(vRow).getCell(vColumn);
        String telefon_nodondur= formatter.formatCellValue(cell);
        return telefon_nodondur;
    }
    @Step(" <key> Alanına : <SheetNumber> numaralı sheet'den <row> satırından , <col> kolonundandan bilgi girilir.")
    public void sendkeytoExcel(String key,int SheetNumber,int row,int col) throws IOException {
        MobileElement element = findElementByKey(key);
      element.sendKeys(exceldenOku(row, col,SheetNumber));
    }

}