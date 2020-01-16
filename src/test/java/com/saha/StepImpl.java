package com.saha;

import com.google.common.collect.ImmutableMap;
import com.saha.helper.RandomString;
import com.saha.helper.StoreHelper;
import com.saha.model.SelectorInfo;
import com.saha.selector.Selector;
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
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import java.awt.*;


import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class StepImpl {

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

    @Step("If <key> displayed. App opened")
    public void checkApp(String key) throws InterruptedException {

        logger.info("Check your app opened");
        Assert.assertTrue("Element is not found in page", findElementByKey(key).isEnabled());
    }

    @Step({"Click element by <key>"})
    public void clickByKey(String key) {

        findElementByKey(key).click();
        System.out.println("'" + key + "' element clicked");
    }

    @Step({"Click element with coordinate : <x> , <y>"})
    public void clickByKeyWithCoordinate(int x, int y) {

        new TouchAction(appiumDriver)
                .press(point(x,y))
                .waitAction(waitOptions(Duration.ofMillis(1)))
                .release()
                .perform();
        System.out.println("tap with coordinate");
    }

    @Step({"<key> element is displayed"})
    public void existElement(String key) {

        Assert.assertTrue("Element is not found in page", findElementByKey(key).isDisplayed());
        System.out.println("'" + key + "' is displayed");
      /*
        try{
            findElementByKey(key).isDisplayed();
            System.out.println(key+" is displayed");
        }catch(Exception e){
            System.out.println(key+" is not displayed");
        }
      */
    }

    @Step("giris yap butonuna tikla")
    public void clickLoginButton() throws InterruptedException {

        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 30, 1000);
        MobileElement me = (MobileElement) webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(
                        By.id("com.ttech.android.onlineislem:id/buttonPasswordContinue")));
        me.click();
        waitBySecond(5);
        existClickByKey("dinamikKartlarıKapatmaIkonu");
    }

    @Step({"Click element by <key> if exist"})
    public void existClickByKey(String key) {

        WebElement element = null;
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

    @Step({"<key> li elementi bul, temizle ve <text> değerini yaz",
            "Find element by <key> clear and send keys <text>"})
    public void sendKeysByKey(String key, String text) {

        MobileElement webElement = findElementByKey(key);
        webElement.clear();
        webElement.setValue(text);
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
    @Step("Dataları excelden oku") public void parseTheDatasFromExcel(){
        FileInputStream fis = null;
        try {
        fis = new FileInputStream("C:\\Users\\testinium\\Desktop\\PgsProjectOdev\\src\\test\\resources\\excel\\odevTHY.xlsx");
        }catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı.");
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.out.println("Dosya kapatılırken bir hata oluştu.");
            }
        }
    }
    @Step("Check flight list")
    public void checkTotalFlightList() {
        List<MobileElement> allProducts= findElemenstByKey("ucusListeleme");
      //  Random rand = new Random();
        allProducts.size();
       // int RandomProduct = rand.nextInt(allProducts.size());
        System.out.println("Toplam Ürün Sayısı...:"+allProducts.size());
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

        int dayToBeSelected = LocalDate.now().plusDays(3).getDayOfMonth();
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
                swipeMethod(); //   ---> Localde burası 3 adet swipeMethod yeterli ama testinium.io 4 tane olması gerekiyor.
                waitBySecond(5);

                findElement(By.xpath("//*[@text='" + dayToBeSelected + "']")).click();
            } else {

                findElement(By.xpath("//*[@text='" + dayToBeSelected + "']")).click();
            }
        }
    }
    @Step({"Find element by <key> and send keys <text> email"})
    public void searhAirportInputsendKeysByKeyNotClearEmail(String key, String text) {

        MobileElement me = findElementByKey(key);
        me.clear();
        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            me.sendKeys(String.valueOf(c));
            //new TouchAction(appiumDriver).tap(point(me.getLocation().getX(), 230)).perform();
            clickByKey("contactInformationPhoneNumber");
        }
        System.out.println("'" + text + "' written to '" + key + "' element.");
    }

    @Step({"Find element by <key> and send keys <text> phone"})
    public void searhAirportInputsendKeysByKeyNotClearPhone(String key, String text) {

        MobileElement _me = findElementByKey(key);
        _me.clear();
        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            _me.sendKeys(String.valueOf(c));
            new TouchAction(appiumDriver).tap(point(_me.getLocation().getX(), 225)).perform();
        }
        System.out.println("'" + text + "' written to '" + key + "' element.");
    }

    @Step({"<key> li elementi bul ve değerini <saveKey> olarak sakla",
            "Find element by <key> and save text <saveKey>"})
    public void saveTextByKey(String key, String saveKey) {

        StoreHelper.INSTANCE.saveValue(saveKey, findElementByKey(key).getText());
    }

    @Step({"<key> li elementi bul ve değerini <saveKey> saklanan değer ile karşılaştır",
            "Find element by <key> and compare saved key <saveKey>"})
    public void equalsSaveTextByKey(String key, String saveKey) {

        Assert.assertEquals(StoreHelper.INSTANCE.getValue(saveKey), findElementByKey(key).getText());
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

    @Step({"İçeriği <value> e eşit olan elementli bul ve tıkla",
            "Find element value equals <value> and click"})
    public void clickByValue(String value) {

        findElement(MobileBy.xpath(".//*[contains(@value,'" + value + "')]")).click();
    }

    @Step({"<key> li ve değeri <text> e eşit olan elementli bul ve tıkla",
            "Find element by <key> text equals <text> and click"})
    public void clickByIdWithContains(String key, String text) {

        List<MobileElement> elements = findElemenstByKey(key);
        for (MobileElement element : elements) {

            System.out.print("Text !!!" + element.getText());
            if (element.getText().toLowerCase().contains(text.toLowerCase())) {

                element.click();
                break;
            }
        }
    }

    @Step({"<key> li ve değeri <text> e eşit olan elementli bulana kadar swipe et ve tıkla", "Find element by <key> text equals <text> swipe and click"})
    public void clickByKeyWithSwipe(String key, String text) {

        boolean find = false;
        int maxRetryCount = 10;
        while (!find && maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKey(key);

            for (MobileElement element : elements) {
                if (element.getText().contains(text)) {
                    // element.click();
                    find = true;
                    break;
                }
            }
            if (!find) {
                maxRetryCount--;

                if (appiumDriver instanceof AndroidDriver) {
                    swipeUpAccordingToPhoneSize();
                }
                else {
                    swipeDownAccordingToPhoneSize();
                }
            }
        }
    }

    @Step({"<key> li elementi bulana kadar swipe et ve tıkla", "Find element by <key>  swipe and click"})
    public void clickByKeyWithSwipe(String key) {

        int maxRetryCount = 10;
        while (maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKey(key);

            if (elements.size() > 0) {
                if (elements.get(0).isDisplayed() == false) {

                    maxRetryCount--;
                    swipeMethod();
                }
                else {
                    elements.get(0).click();
                    System.out.println(key + " elementine tıklandı");
                    break;
                }
            }
            else {
                maxRetryCount--;
                swipeMethod();
            }

        }
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

    @Step({"<key> id'li elementi bulana kadar <times> swipe yap ", "Find element by <key>  <times> swipe "})
    public void swipeDownUntilSeeTheElement(String element, int limit) {

        for (int i = 0; i < limit; i++) {
            List<MobileElement> meList = appiumDriver.findElements(By.id(element));
            //  List<MobileElement> meList = findElemenstByKey(element);
            if (meList.size() > 0 &&
                    meList.get(0).getLocation().x <= getScreenWidth() &&
                    meList.get(0).getLocation().y <= getScreenHeight()) {
                break;
            }
            else {
                swipeDownAccordingToPhoneSize(50, 80, 50, 30);
                break;
            }
        }
    }

    @Step({"<key> li elementi bulana kadar swipe et", "Find element by <key> swipe "})
    public void findByKeyWithSwipe(String key) {
        int maxRetryCount = 10;
        while (maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKey(key);

            if (elements.size() > 0) {
                if (!elements.get(0).isDisplayed()) {

                    maxRetryCount--;
                    swipeDownAccordingToPhoneSize();
                }
                else {
                    System.out.println(key + " element bulundu");
                    break;
                }
            }
            else {
                maxRetryCount--;
                swipeDownAccordingToPhoneSize();
            }

        }
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

    @Step({"<key> li elementi bul yoksa <message> mesajını hata olarak göster",
            "Find element by <key> if not exist show error message <message>"})
    public void isElementExist(String key, String message) {

        Assert.assertTrue(message, findElementByKey(key) != null);
    }

    @Step({"<key> li elementin değeri <text> e içerdiğini kontrol et", "Find element by <key> and text contains <text>"})
    public void containsTextByKey(String key, String text) {

        By by = selector.getElementInfoToBy(key);
        Assert.assertTrue(appiumFluentWait.until(new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            @Override
            public Boolean apply(WebDriver driver) {

                try {
                    currentValue = driver.findElement(by).getText();
                    return currentValue.contains(text);
                }
                catch (Exception e) {
                    return false;
                }
            }

            @Override
            public String toString() {
                return String.format("text contains be \"%s\". Current text: \"%s\"", text, currentValue);
            }
        }));
    }

    @Step({"<key> li elementin değeri <text> e eşitliğini kontrol et", "Find element by <key> and text equals <text>"})
    public void equalsTextByKey(String key, String text) {

        Assert.assertTrue(appiumFluentWait.until(
                ExpectedConditions.textToBe(selector.getElementInfoToBy(key), text)));
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

    public boolean isElementPresent(By by) {
        try {
            appiumDriver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step({"<times> kere aşağıya kaydır", "Swipe times <times>"})
    public void swipe(int times) throws InterruptedException {

        for (int i = 0; i < times; i++) {

            swipeDownAccordingToPhoneSize();
            waitBySecond(3);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("swipe");
            System.out.println("-----------------------------------------------------------------");

        }
    }

    @Step({"Swipe up times <times>"})
    public void swipeUP(int times) throws InterruptedException {

        for (int i = 0; i < times; i++) {

            swipeUpAccordingToPhoneSize();
            waitBySecond(1);
            System.out.println("swipe up");
        }
    }

    @Step({"Hide keyboard"})
    public void hideAndroidKeyboard() {

        try {
            if (localAndroid == false) {

                appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Toolbar Done Button\"]"))
                        .click();
            }
            else {
                appiumDriver.hideKeyboard();
            }

        }
        catch (Exception ex) {
            logger.error("keyboard can't closed. ", ex.getMessage());
        }
    }

    @Step({"check <key> word in the page."})
    public void getPageSourceFindWord(String key) {

        Assert.assertTrue(key + " can't find in the page.",
                appiumDriver.getPageSource().contains(key));
        System.out.println(key + " can find in the page");
    }

    @Step({"<length> uzunlugunda random bir kelime üret ve <saveKey> olarak sakla"})
    public void createRandomNumber(int length, String saveKey) {

        StoreHelper.INSTANCE.saveValue(saveKey, new RandomString(length).nextString());
    }

    @Step("click back button")
    public void clickBybackButton() {

        if (localAndroid == false) {
            appiumDriver.navigate().back();
        }
        else {
            ((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
        }
    }

    @Step("Debug step")
    public void debugStep() {
        waitBySecond(1);
    }

    @Step("Yeni şifre <text> ve yeni şifre tekrar <textrepeat>  alanlarına tex değerlerini yaz")
    public void writeNewPassword(String text, String textrepeat) {

        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 30, 1000);
        MobileElement me = (MobileElement) webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("com.ttech.android.onlineislem:id/editTextPassword")));
        me.click();
        me.setValue(text);
        appiumDriver.navigate().back();
        WebDriverWait webDriverWait2 = new WebDriverWait(appiumDriver, 30, 1000);
        MobileElement me2 = (MobileElement) webDriverWait2.until(ExpectedConditions
                .presenceOfElementLocated(
                        By.id("com.ttech.android.onlineislem:id/editTextPasswordRepeat")));
        me2.click();
        me2.setValue(textrepeat);
        appiumDriver.navigate().back();
    }

    @Step("<StartX>,<StartY> oranlarından <EndX>,<EndY> oranlarına <times> kere swipe et")
    public void pointToPointSwipe(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();

        int height = d.height;
        int width = d.width;
        startX = (width * startX) / 100;
        startY = (height * startY) / 100;
        endX = (width * endX) / 100;
        endY = (height * endY) / 100;
        for (int i = 0; i < count; i++) {
            waitBySecond(1);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
        }
    }

    @Step("restart app")
    public void restart() throws InterruptedException {

        appiumDriver.closeApp();
        appiumDriver.launchApp();
        System.out.println("App restarted");
        waitBySecond(5);
        existClickByKey("allowed");
    }

    @Step("pop-up allowed")
    public void closePopupAndCookie() throws InterruptedException {

        waitBySecond(2);
        appiumDriver.context("NATIVE_APP");
        new WebDriverWait(appiumDriver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='İZİN VER']")));

        if (isElementPresent(By.xpath("//*[@text='İZİN VER']"))) {

            System.out.print("Notification pop-up kapatıldı !!!!!!");
            waitBySecond(2);
            appiumDriver.context("NATIVE_APP");
            appiumDriver.findElement(By.xpath("//*[@text='İZİN VER']")).click();
        }
        else {
            System.out.print("Pop-up görülmedi");

        }
    }

    @Step("5S için <key> elementini bulana kadar yukarı kaydır")
    public void swipeFor5S(String element) {
        System.out.println(
                " // BROWSERNAME: " + appiumDriver.getCapabilities().getCapability("deviceName").toString()
                        + " //");
        if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("5S")) {

            System.out.println("5S için if koşulları gerçekleştiriliyor...");
            int maxRetryCount = 10;
            while (maxRetryCount > 0) {
                List<MobileElement> elements = findElemenstByKey(element);

                if (elements.size() > 0) {
                    if (!elements.get(0).isDisplayed()) {

                        maxRetryCount--;
                        swipeUpAccordingToPhoneSize();
                    }
                    else {
                        elements.get(0).click();
                        System.out.println(element + " elementine tıklandı");
                        break;
                    }
                }
                else {
                    maxRetryCount--;
                    swipeUpAccordingToPhoneSize();
                }
            }
        }
    }

    @Step("Select seat from row: <row> and column: <column>")
    public void selectSeat(String row, String column) {

        findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"seatMap_availSeat_" + row + "_" + column + "\"]\n")).click();
    }

    @Step("Select <flightType> flight")
    public void selectFlight(String flightType) {

        if (appiumDriver instanceof AndroidDriver) {

            String flightTypeControlID = "";
            if (flightType.equals("oneway")){

                flightTypeControlID = "com.piac.thepiaapp.android.beta:id/tv_price";
            }
            else if(flightType.equals("roundtrip")){

                flightTypeControlID = "com.piac.thepiaapp.android.beta:id/tv_rt_price";
            }

            boolean flightStatus = true;
            while (flightStatus) {
                try {
                    if (findElement(By.id("com.piac.thepiaapp.android.beta:id/tv_empty_flight")).isDisplayed()) {

                        findElement(By.id("com.piac.thepiaapp.android.beta:id/tw_next_info")).click();
                        System.out.println("next day");
                    }
                }
                catch (Exception e) {
                    System.out.println("loop continue");
                }

                try {
                    if (findElement(By.id("com.piac.thepiaapp.android.beta:id/rlt_flight")).isDisplayed()) {

                        String flightTicketControl = findElement(By.id(flightTypeControlID)).getText();
                        System.out.println("'"+flightTicketControl+"'");

                        if (flightTicketControl.equals("SOLD OUT")) {

                            System.out.println("sold out flight");
                            findElement(By.id("com.piac.thepiaapp.android.beta:id/tw_next_info")).click();
                            findElement(By.id(flightTypeControlID)).click();
                            break;
                        }
                        else {
                            findElement(By.id(flightTypeControlID)).click();
                            System.out.println("flight");
                            break;
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println("loop continue 2");
                }
            }


        } else if (appiumDriver instanceof IOSDriver) {

//            boolean flag = true;
//            int i = 0;
//            while (flag) {
//                try {
//                    if (findElement(MobileBy.xpath(".//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[1]//*[contains(@name, 'Last')]")).isDisplayed()) {
//                        break;///buraya düzenleme yapılacak/// else if
//                    } else if (findElement(MobileBy.xpath("(//XCUIElementTypeOther[@name='selectFlight_dateSelection_middle'])[2]")).isDisplayed()) {
//                        if (findElement(MobileBy.xpath("(//XCUIElementTypeOther[@name='selectFlight_dateSelection_right'])[2]")).isDisplayed()) {
//                            findElement(MobileBy.xpath("(//XCUIElementTypeOther[@name='selectFlight_dateSelection_right'])[2]")).click();
//                        }
//                    }
//                } catch (Exception e) {
//                    if (findElement(MobileBy.xpath("(//XCUIElementTypeOther[@name='selectFlight_dateSelection_right'])[2]")).isDisplayed()) {
//                        findElement(MobileBy.xpath("(//XCUIElementTypeOther[@name='selectFlight_dateSelection_right'])[2]")).click();
//                        flag = false;
//                    }
//                }
//                i++;
//                if (i == 5) {
//                    flag = false;
//                }
//            }
            clickByKey("flightItem");
        }
    }

    @Step("Select departure and return date")
    public void selectDepAndReturnDate() throws InterruptedException {

        if (appiumDriver instanceof AndroidDriver) {

            int today = LocalDate.now().plusDays(0).getDayOfMonth();
            int plusTwoDays = LocalDate.now().plusDays(3).getDayOfMonth();
            int plusThreeDays = LocalDate.now().plusDays(4).getDayOfMonth();

            System.out.println("Today : " + today);
            System.out.println("Departure, day of month : " + plusTwoDays);
            System.out.println("Return, day of month : " + plusThreeDays);

            if( today >= 30) {

                waitBySecond(3);
                swipeMethod();
                waitBySecond(3);
                swipeMethod();
                waitBySecond(3);
                swipeMethod();
                waitBySecond(3);
                swipeMethod(); //   ---> Localde burası 3 adet swipeMethod yeterli ama testinium.io 4 tane olması gerekiyor.
                waitBySecond(5);

                findElement(By.xpath("//*[@text='"+ plusTwoDays +"']")).click();
                findElement(By.xpath("//*[@text='"+ plusThreeDays +"']")).click();

            }
            else {

                findElement(By.xpath("//*[@text='" + plusTwoDays + "']")).click();
                findElement(By.xpath("//*[@text='" + plusThreeDays + "']")).click();
            }

        }
        else if (appiumDriver instanceof IOSDriver) {

            int today = LocalDate.now().plusDays(0).getDayOfMonth();
            int plusTwoDays = LocalDate.now().plusDays(2).getDayOfMonth();
            int plusThreeDays = LocalDate.now().plusDays(3).getDayOfMonth();

            System.out.println("Today : " + today);
            System.out.println("Departure, day of month : " + plusTwoDays);
            System.out.println("Return, day of month : " + plusThreeDays);

            if( today >= 29) {

                int upperMonthHeader = 111;
                int lowerMonthHeader = 433;
                System.out.println("upper month header: " + upperMonthHeader);
                System.out.println("lower month header: " + lowerMonthHeader);
                int deviceMiddleX = getScreenWidth() / 2;
                swipeMethod(deviceMiddleX, lowerMonthHeader, deviceMiddleX, upperMonthHeader);
            }

            int firstDateValue = Integer.parseInt(findElement(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeOther[1]/" +
                    "following-sibling::XCUIElementTypeCell/XCUIElementTypeOther/" +
                    "XCUIElementTypeStaticText")).getAttribute("value"));
            System.out.println("_____ first Date Value  " + firstDateValue);

            if (firstDateValue == 1) {

                findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ plusTwoDays +"']")).click();
            }
            else if (firstDateValue > 1) {
                if (plusTwoDays >= firstDateValue) {
                    findElement(By.xpath("(.//XCUIElementTypeCollectionView/XCUIElementTypeOther[1]/" +
                            "following-sibling::*//XCUIElementTypeStaticText[@name='" + plusTwoDays + "'])[2]")).click();
                }
                else

                    findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\""+ plusTwoDays +"\"])[1]")).click();
                System.out.println("else içersinde");
            }

            int secondDateValue = Integer.parseInt(findElement(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeOther[1]/" +
                    "following-sibling::XCUIElementTypeCell/XCUIElementTypeOther" +
                    "/XCUIElementTypeStaticText")).getAttribute("value"));
            System.out.println("_____second Date Value  " + secondDateValue);



            if (secondDateValue == 1) {

                findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ plusThreeDays +"']")).click();
            }
            else if (secondDateValue > 1) {
                if (plusThreeDays >= secondDateValue) {

                    findElement(By.xpath("(.//XCUIElementTypeCollectionView/XCUIElementTypeOther[1]/" +
                            "following-sibling::*//XCUIElementTypeStaticText[@name='" + plusThreeDays + "'])[2]")).click();
                }
                else

                    findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\""+ plusThreeDays +"\"])[1]")).click();
            }
        }
    }

    @Step({"Hide keyboard with Next Button"})
    public void hideKeyboardWithNextButton() {

        findElement(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Next:\"]")).click();
    }

    @Step({"Hide keyboard with Done Button"})
    public void hideKeyboardWithDoneButton() {

        findElement(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    @Step({"Tap element with <key>"})
    public void tapByElement(String key) {

        int startX = findElementByKey(key).getLocation().getX();
        int addition = (int) (findElementByKey(key).getSize().height * 0.5);
        int endX = startX + addition;
        int startY = findElementByKey(key).getLocation().getY();
        new TouchAction(appiumDriver).tap(point(endX, startY)).perform();
    }

    @Step({"Click <key> element left coordinate"})
    public void loginCountryCode(String key) {

        int x = findElementByKey(key).getLocation().getX();
        int y = findElementByKey(key).getLocation().getY();
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(new PointOption().withCoordinates(x + 79, y + 15)).perform();
    }

    @Step("Scroll down")
    public void scrollDown() {

        Dimension size = appiumDriver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.60);
        int endy = (int) (size.getHeight() * 0.10);
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

    @Step("swipe et Two")
    public void swipeMethodTwo() {

        if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("ce03171359aa84720c") ||
                appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("fe64e409")) {

            Dimension size = appiumDriver.manage().window().getSize();
            int x = size.getWidth() / 2;
            int starty = (int) (size.getHeight() * 0.60);
            int endy = (int) (size.getHeight() * 0.10);

            new TouchAction(appiumDriver).longPress(PointOption.point(x, starty))
                    .moveTo(PointOption.point(x, endy))
                    .release().perform();
            System.out.println( "swipe et Two if deviceName için çalıştı");
        }
        else{
            new TouchAction(appiumDriver).longPress(PointOption.point(330, 800))
                    .moveTo(PointOption.point(330, 568))
                    .release().perform();
            System.out.println("swipe yapıldı");
        }
    }

    public void swipeMethod(int startX, int startY, int endX, int endY) {

        new TouchAction(appiumDriver).longPress(PointOption.point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .waitAction(waitOptions(Duration.ofMillis(100)))
                .perform();
        System.out.println("Swiped between " + startX + " - " + startY + " and " + endX + " - " + endY);
    }

    @Step("device info")
    public void deviceInfo() {

        System.out.println(appiumDriver.getCapabilities().getCapability("deviceModel").toString());
    }

    @Step("Select mister title ios")
    public void selectMisterTitleIos() {

        new TouchAction(appiumDriver)
                .tap(PointOption.point(163, 491))
                .waitAction(waitOptions(Duration.ofMillis(500)))
                .tap(PointOption.point(163, 491))
                .waitAction(waitOptions(Duration.ofMillis(500)))
                .tap(PointOption.point(163, 491))
                .perform();

        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();
    }

    @Step("Select birhdate ios")
    public void selectBirthdateIos() {

        clickByKey("dateOfBirth");
        appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).setValue("1");
        //bunu sayı olarak ver
        //appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(1).setValue("August");
        appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(2).setValue("1990");
        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();
    }

    @Step("Select country: <counrty> and national id number: <ssn>")
    public void selectCountryAndSetIdNo(String counrty, String ssn) {

        clickByKey("nationality");
        //Bu ekranda bazen klavye çıkıp yok olup, bazen yok olmayabiliyor
        List<MobileElement> doneButton = appiumDriver.findElements(MobileBy.AccessibilityId("Done"));
        if (doneButton.size() > 0) {
            doneButton.get(0).click();
        }

        appiumDriver.findElement(MobileBy.AccessibilityId(counrty)).click();
        sendKeysByKey("nationalIdNumberTextInput", ssn);
        clickDoneButton();
    }

    @Step("Click Done button to close keyboard")
    public void clickDoneButton() {

        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();
    }

    @Step("Set credit card expiration month")
    public void setCardExpirationMonth() {

        appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).setValue("12");
    }

    @Step("Set credit card expiration year")
    public void setCardExpirationYear() {

        appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(1).setValue("2020");
        clickDoneButton();
    }

    @Step("Select <counrty> as country ios")
    public void selectCountryFromComboboxIos(String counrty) {

        clickByKey("paymentCountry");
        //Bu ekranda bazen klavye çıkıp yok olup, bazen yok olmayabiliyor
        List<MobileElement> doneButton = appiumDriver.findElements(MobileBy.AccessibilityId("Done"));
        if (doneButton.size() > 0) {
            doneButton.get(0).click();
        }
        appiumDriver.findElement(MobileBy.AccessibilityId(counrty)).click();
    }

    @Step("Click buy ticket button")
    public void clickBuyTicket() {

        clickByKey("buyTicket");
    }

    @Step("Click Submit button on 3DSecure page")
    public void clickSubmitButton3DSecure() {

        waitUntilElementIsVisible("3dsecureSubmitButton");
        clickByKey("3dsecureSubmitButton");
    }

    @Step("Check if PNR No exists ios")
    public void checkIfPnrNoExists() {

        waitUntilElementIsVisible("pnrText");
    }

/*    @Step("Update alert kontrol")
    public void updateAlertControl() {
        try {
            Thread.sleep(4000);
            if (findElement(By.id("android:id/alertTitle")).isDisplayed()) {
                findElement(By.id("android:id/button2")).click();
                System.out.println("Later button clicked");
            }
        } catch (Exception e) {
            System.out.println("Alert not found");
        }
    }*/

    @Step("Wait <seconds> seconds if iOS")
    public void waitBySecondIfIos(int seconds) {
        if (appiumDriver instanceof IOSDriver) {

            try {
                Thread.sleep(seconds * 1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Step("Device name")
    public void deviceName(){

        System.out.println(appiumDriver.getCapabilities().getCapability("deviceName").toString());
        System.out.println(appiumDriver.getCapabilities().getCapability("platformVersion").toString());
        System.out.println(appiumDriver.getCapabilities().getCapability("deviceModel").toString());
    }

    @Step("Write ccv number")
    public void writeCCV() {

        sendKeycode('3');
        sendKeycode('5');
        sendKeycode('8');
    }

    @Step("write credit card number")
    public void writeCreditCardNumber() throws InterruptedException {

        sendKeycode('4');
        Thread.sleep(4000);
        sendKeycode('4');
        Thread.sleep(4000);
        sendKeycode('4');
        Thread.sleep(4000);
        sendKeycode('4');
        Thread.sleep(8000);
        sendKeycode('3');
        Thread.sleep(4000);
        sendKeycode('3');
        Thread.sleep(4000);
        sendKeycode('3');
        Thread.sleep(4000);
        sendKeycode('3');
        Thread.sleep(8000);
        sendKeycode('2');
        Thread.sleep(4000);
        sendKeycode('2');
        Thread.sleep(4000);
        sendKeycode('2');
        Thread.sleep(4000);
        sendKeycode('2');
        Thread.sleep(8000);
        sendKeycode('1');
        Thread.sleep(4000);
        sendKeycode('1');
        Thread.sleep(4000);
        sendKeycode('1');
        Thread.sleep(4000);
        sendKeycode('1');
        Thread.sleep(4000);
    }

    public void sendKeycode(char num) {

        switch (num) {

            case '0':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
                break;
            case '1':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
                break;
            case '2':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_2);
                break;
            case '3':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_3);
                break;
            case '4':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_4);
                break;
            case '5':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_5);
                break;
            case '6':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_6);
                break;
            case '7':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_7);
                break;
            case '8':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_8);
                break;
            case '9':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_9);
                break;
            default:
                break;
        }
    }

    public void sendKeycodeTwo(char num) {

        switch (num) {

            case '0':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_0);
                break;
            case '1':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_1);
                break;
            case '2':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_2);
                break;
            case '3':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_3);
                break;
            case '4':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_4);
                break;
            case '5':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_5);
                break;
            case '6':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_6);
                break;
            case '7':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_7);
                break;
            case '8':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_8);
                break;
            case '9':
                ((AndroidDriver<?>) appiumDriver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_9);
                break;
            default:
                break;
        }
    }

    @Step("write credit card number Two")
    public void writeCreditCardNumberTwo() throws InterruptedException {

        sendKeycodeTwo('4');
        Thread.sleep(4000);
        sendKeycodeTwo('4');
        Thread.sleep(4000);
        sendKeycodeTwo('4');
        Thread.sleep(4000);
        sendKeycodeTwo('4');
        Thread.sleep(8000);
        sendKeycodeTwo('3');
        Thread.sleep(4000);
        sendKeycodeTwo('3');
        Thread.sleep(4000);
        sendKeycodeTwo('3');
        Thread.sleep(4000);
        sendKeycodeTwo('3');
        Thread.sleep(8000);
        sendKeycodeTwo('2');
        Thread.sleep(4000);
        sendKeycodeTwo('2');
        Thread.sleep(4000);
        sendKeycodeTwo('2');
        Thread.sleep(4000);
        sendKeycodeTwo('2');
        Thread.sleep(8000);
        sendKeycodeTwo('1');
        Thread.sleep(4000);
        sendKeycodeTwo('1');
        Thread.sleep(4000);
        sendKeycodeTwo('1');
        Thread.sleep(4000);
        sendKeycodeTwo('1');
        Thread.sleep(4000);
    }

    @Step("close keyboard")
    public void closeKeyboard() {

        System.out.println(
                " // BROWSERNAME: " + appiumDriver.getCapabilities().getCapability("deviceName").toString()
                        + " //");
        if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("ce03171359aa84720c") ||
                appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("fe64e409")) {

            System.out.println("Method (close keyboard) cihaz GALAXY_S8_PLUS(ce03171359aa84720c) için çalıştırılmıyor.");
            System.out.println("Method (close keyboard) cihaz Galaxy A7 (fe64e409) için çalıştırılmıyor.");
        }
        else{
            appiumDriver.hideKeyboard();
            System.out.println("keyboard closed");
        }
    }

    @Step("elementinin <x> , <y> koordinatlarına tıkla")
    public void tapPhoneSize(int x, int y){

        MobileElement element = findElement(By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther"));
        Point point = element.getLocation();
        Dimension dimension = element.getSize();
        x = point.x + (dimension.width*x)/100;
        y = point.y + (dimension.height*y)/100;
        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point(x,y)).perform();
    }

    @Step("Date select flight")
    public void dateSelect(){

        //int dayToBeSelected = LocalDate.now().plusDays(1).getDayOfMonth();
        swipeMethod();
        swipeMethod();
        findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"1\"])[2]")).click();

    }

    @Step("Select return flight")
    public void selectReturnFlight() {

        swipeMethod();
        swipeMethod();
        findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"9\"])[1]")).click();

    }

    @Step("Select return flight Dom_Dom")
    public void selectReturnFlightDom() {

        swipeMethod();
        swipeMethod();
        findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"14\"])[1]")).click();

    }

    @Step("Select birhdate ios <key> day: <day> year: <year>")
    public void selectBirthdateIos(String key, String day, String year) {

        clickByKey(key);
        waitBySecond(2);
        clickByKey(key);
        appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).setValue(day);
        //bunu sayı olarak ver
        //appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(1).setValue("August");
        appiumDriver.findElementsByClassName("XCUIElementTypePickerWheel").get(2).setValue(year);
        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();
    }

    @Step("Pnr no copy and Checkin surname: <surname>")
    public void checkinProcess(String surname) throws AWTException, InterruptedException {

        System.out.println(
                " // BROWSERNAME: " + appiumDriver.getCapabilities().getCapability("deviceName").toString()
                        + " //");

        try {
            clickDoneButton();
            System.out.println("clickDoneButton çalıştırıldı ");
        }
        catch (Exception e) {
            System.out.println("clickDoneButton çalışmadı.");
        }




        String getPNRtext =  findElementByKey("pnr").getText();
        String pnrtText = getPNRtext.substring(6, 11);

        findElementByKey("homePageBtn").click();
        findElementByKey("checkinPageBtn").click();

        findElementByKey("checkinSurnameTxt").sendKeys(surname);
        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();
        System.out.println("'" + surname + "' yazıldı");
        findElementByKey("checkinPnrTxt").sendKeys(pnrtText);
        System.out.println("'" + pnrtText + "' yazıldı");
        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();

        findElementByKey("checkinSearchBtn").click();

    }

    @Step("Check for flights <emptyText> <availableKey> <searchKey>")
    public void checkForFlights (String emptyText, String availableKey, String searchKey) {


        boolean flightStatus = true;
        while (flightStatus) {
            try {
                if (findElementByKey(emptyText).isDisplayed()) {

                    clickByKey(searchKey);
                    System.out.println("NO FLIGHT  -> Click Search ");
                }
            }
            catch (Exception e) {
                System.out.println("Loop Continue 1");
            }
            try {

                if (findElementByKey(availableKey).isDisplayed()) {

                    clickByKey(availableKey);
                    System.out.println("YES FLIGHT");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Loop Continue 2");
            }
        }
    }

    @Step("Check for flights android <singleEmptyFlight> <availableKey> <searchKey> <multiCityclickKey>")
    public void checkForFlightsAndroid (String emptyText, String availableKey, String searchKey , String clickKey) {
        boolean flightStatus = true;
        while (flightStatus) {
            try {
                if  ( findElement(By.xpath("//*[@text='"+ emptyText +"']")).isDisplayed()) {
                    clickByKey(searchKey);
                    System.out.println("NO FLIGHT  -> Click Search ");
                }
            }
            catch (Exception e) {
                System.out.println("Loop Continue 1");
            }
            try {

                if (findElementByKey(availableKey).isDisplayed()) {

                    clickByKey(availableKey);
                    System.out.println("YES FLIGHT");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Loop Continue 2");
            }
            try {
                if (findElementByKey(clickKey).isDisplayed()) {

                    clickByKey(clickKey);
                    System.out.println("YES FLIGHT");
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Loop Continue 3");
            }
        }
    }
    @Step("Check for flights android <singleEmptyFlight> <availableKey> <searchKey>")
    public void checkForFlightsAndroid (String emptyText, String availableKey, String searchKey) {
        boolean flightStatus = true;
        while (flightStatus) {
            try {
                if  ( findElement(By.xpath("//*[@text='"+ emptyText +"']")).isDisplayed()) {
                    clickByKey(searchKey);
                    System.out.println("NO FLIGHT  -> Click Search ");
                }
            }
            catch (Exception e) {
                System.out.println("Loop Continue 1");
            }
            try {

                if (findElementByKey(availableKey).isDisplayed()) {

                    clickByKey(availableKey);
                    System.out.println("YES FLIGHT");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Loop Continue 2");
            }
        }
    }

    @Step("<checkinPassengerItem> checkbox <item>. person select")
    public void checkinPassengerSelect(String checkinPassengerItem, int item){

        findElemenstByKey(checkinPassengerItem).get(item-1).click();
        System.out.println(item+". passenger select for checkin");
    }

    @Step("3d payment Submit button clicked")
    public void threeDPaymentSubmitBtn(){
        try {

            findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.widget.ListView/" +
                    "android.view.View[8]/android.widget.Button")).click();
            System.out.println("Text 'Submit' clicked");
        }
        catch (Exception e){
            findElement(By.xpath("//android.widget.Button[@content-desc=\"Submit\"]")).click();
            System.out.println("Content desc 'Submit' clicked");
        }
    }

    @Step("Checkin process and surname: <surname>")
    public void checkinProcessAndroid(String surname) {

        String getPNRtext =  findElementByKey("pnrText").getText();
        String pnrtText = getPNRtext.substring(5, 10);
        System.out.println(pnrtText);
        findElementByKey("homePageBtn").click();
        findElementByKey("checkinPageBtn").click();
        findElementByKey("checkinSurnameTxt").sendKeys(surname);
        System.out.println("'" + surname + "' yazıldı");
        //hideAndroidKeyboard();

        findElementByKey("checkinPnrTxt").sendKeys(getPNRtext);
        System.out.println("'" + pnrtText + "' yazıldı");
        findElementByKey("checkinSearchBtn").click();
    }

    @Step("elementinin <x> , <y> koordinatlarına tıkla <key> <text>")
    public void tapPhoneSize2(int x, int y, String key, String text){

        MobileElement element = findElementByKey(key);
        element.sendKeys(text);
        Point point = element.getLocation();
        Dimension dimension = element.getSize();
        x = point.x + (dimension.width*x)/100;
        y = point.y + (dimension.height*y)/100;
        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point(x,y)).perform();
    }

    @Step("<x>,<y> <key> Click")
    public void x_y_keyClick (int x, int y, String key) {

            MobileElement element = findElementByKey(key);
            Point point = element.getLocation();
            Dimension dimension = element.getSize();
            x = point.x + (dimension.width*x)/100;
            y = point.y + (dimension.height*y)/100;
            TouchAction action = new TouchAction(appiumDriver);
            action.tap(PointOption.point(x,y)).perform();

            logger.info(" x: " + x + " y: " + y + " key: " + key + " click");
            System.out.println(" x: " + x + " y: " + y + " key: " + key + " click");
    }

   @Step("Select birhdate")
   public void selectBirhdate() throws InterruptedException {

       System.out.println(
               " // BROWSERNAME: " + appiumDriver.getCapabilities().getCapability("deviceName").toString()
                       + " //");

       clickByKey("dateOfBirth");

       if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("fe64e409")) {

           System.out.println("Method (Select birhdate) cihaz GALAXY_A7(fe64e409) için çalışıyor.");
           waitBySecond(2);
           clickByKeyWithCoordinate(530,720);
           waitBySecond(2);
           clickByKeyWithCoordinate(290,720);
           waitBySecond(2);
           clickByKey("selectDatePopupOkBtn");

       }
       else if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("ce03171359aa84720c")) {

           System.out.println("Method (Select birhdate) cihaz GALAXY_S8_PLUS(ce03171359aa84720c) için çalışıyor.");
           int dayToBeSelected = LocalDate.now().plusDays(-1).getDayOfMonth();
           findElement(By.xpath("//*[@text='" + dayToBeSelected + "']")).click();
           clickByKey("selectDatePopupOkBtn");

       }
       else {

           System.out.println("Method (Select birhdate) deviceName diğerleri için çalışıyor.");
           clickByKey("selectBirthDateYear");
           clickByKey("selectBirthDateYear2");
           clickByKey("selectDatePopupOkBtn");
           waitBySecond(5);
           swipeMethod();
           swipeMethod();
           waitBySecond(5);
        }
   }

    @Step("Select child or infant birhdate")
    public void selectBirhdateTwo() throws InterruptedException {

        System.out.println(
                " // BROWSERNAME: " + appiumDriver.getCapabilities().getCapability("deviceName").toString()
                        + " //");

        clickByKey("dateOfBirth");

        if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("ce03171359aa84720c")) {

            System.out.println("Method (Select child or infant birhdate) cihaz GALAXY_S8_PLUS(ce03171359aa84720c) için çalışıyor.");
            int dayToBeSelected = LocalDate.now().plusDays(7).getDayOfMonth();
            findElement(By.xpath("//*[@text='" + dayToBeSelected + "']")).click();
            clickByKey("selectDatePopupOkBtn");

        }
        else if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("fe64e409")) {

            System.out.println("Method (Select child or infant birhdate) cihaz GALAXY_A7(fe64e409) için çalışıyor.");
            waitBySecond(2);
            clickByKeyWithCoordinate(530,1080);
            waitBySecond(2);
            clickByKeyWithCoordinate(290,1080);
            waitBySecond(2);
            clickByKey("selectDatePopupOkBtn");
        }
        else {

            clickByKey("birthDateYearSelect");
            clickByKey("birthDateYearSelect2");
            clickByKey("selectDatePopupOkBtn");
            waitBySecond(5);
        }
    }

    @Step("Credit card; select expire date")
    public void creditCardSelectExpireDate() throws InterruptedException {

        System.out.println(
                " // BROWSERNAME: " + appiumDriver.getCapabilities().getCapability("deviceName").toString()
                        + " //");

        clickByKey("expireDate");

        if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("fe64e409")) {

            System.out.println("Method (Credit card; select expire date) cihaz GALAXY_A7(fe64e409) için çalışıyor.");
            pointToPointSwipe2(450,910,450,1100);
            pointToPointSwipe2(680,730,680,500);
            clickByKey("selectDatePopupOkBtn");

        }
        else {

        clickByKey("expireDateMonth");
        clickByKey("expireDateYear");
        clickByKey("selectDatePopupOkBtn");
        }

    }

    @Step("Click if available <key>")
    public void clickIfAvailable(String key) {

        waitBySecond(5);

        try {
            if (findElementByKey(key).isDisplayed()) {

                findElementByKey(key).click();
                System.out.println( key + " key var tıklandı.");
            }
            else{
                System.out.println( key + " key olmadıgı için tıklanmadı.");
            }
        }
        catch (Exception e) {
            System.out.println( key + " key olmadıgı için tıklanmadı.");
        }
    }

    @Step("<StartX>,<StartY> oranlarından <EndX>,<EndY>  swipe et")
    public void pointToPointSwipe2(int startX, int startY, int endX, int endY) throws InterruptedException {

        Dimension d = appiumDriver.manage().window().getSize();

        waitBySecond(2);
        new TouchAction(appiumDriver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();

    }

    @Step("Pnr no copy and Checkin surname: <surname> TEST <PNR>")
    public void checkinProcessTEST(String surname, String pnr) throws AWTException, InterruptedException {


        findElementByKey("checkinPageBtn").click();

        findElementByKey("checkinSurnameTxt").sendKeys(surname);
        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();
        System.out.println("'" + surname + "' yazıldı");
        findElementByKey("checkinPnrTxt").sendKeys(pnr);
        System.out.println("'" + pnr + "' yazıldı");
        appiumDriver.findElement(MobileBy.AccessibilityId("Done")).click();

        findElementByKey("checkinSearchBtn").click();

    }
    @Step("ManageBooking process and surname: <surname>")
    public void manageBooking(String surname) throws InterruptedException {

        String getPNRtext =  findElementByKey("pnrText").getText();
        System.out.println(getPNRtext);
        String pnrtText = getPNRtext.substring(5, 11);
        System.out.println(pnrtText);
        findElementByKey("homePageBtn").click();
        findElementByKey("manageBookingBtn").click();
        findElementByKey("manageBookingPnrText").sendKeys(pnrtText);
        System.out.println("'" + pnrtText + "' yazıldı");
        appiumDriver.hideKeyboard();
        Thread.sleep(2000);
        findElementByKey("checkinSurnameTxt").sendKeys(surname);
        System.out.println("'" + surname + "' yazıldı");
        appiumDriver.hideKeyboard();
        //hideAndroidKeyboard();



        Thread.sleep(2000);
        findElementByKey("checkinSearchBtn").click();
    }
    @Step({"<key> li elementi bul ve değerini <saveKey> olarak sakla1",
            "Find element by <key> and save text <saveKey>"})
    public void savethePriceKey(String key, String saveKey) throws InterruptedException {
        Thread.sleep(1000);
        StoreHelper.INSTANCE.saveValue(saveKey, findElementByKey(key).getText());
        Thread.sleep(2000);
        System.out.println(saveKey);
    }


    @Step("Select infant birhdate")
    public void selectBirhdateinfant() throws InterruptedException {

        System.out.println(
                " // BROWSERNAME: " + appiumDriver.getCapabilities().getCapability("deviceName").toString()
                        + " //");

        clickByKey("dateOfBirth");

        if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("ce03171359aa84720c")) {

            System.out.println("Method (Select child or infant birhdate) cihaz GALAXY_S8_PLUS(ce03171359aa84720c) için çalışıyor.");
            int dayToBeSelected = LocalDate.now().plusDays(7).getDayOfMonth();
            findElement(By.xpath("//*[@text='" + dayToBeSelected + "']")).click();
            clickByKey("selectDatePopupOkBtn");

        }
        else if (appiumDriver.getCapabilities().getCapability("deviceName").toString().contains("fe64e409")) {

            System.out.println("Method (Select child or infant birhdate) cihaz GALAXY_A7(fe64e409) için çalışıyor.");
            waitBySecond(2);
            clickByKeyWithCoordinate(530,1080);
            waitBySecond(2);
            clickByKeyWithCoordinate(290,1080);
            waitBySecond(2);
            clickByKey("selectDatePopupOkBtn");
        }
        else {

            clickByKey("birthDateYearSelect");;
            clickByKey("selectDatePopupOkBtn");
            waitBySecond(5);
        }
    }
    @Step({"<key> li elementi bul ve değerini <saveKey> saklanan değer ile karşılaştır ve değişiklik oldugunu dogrula1",
            "Find element by <key> and compare saved key <saveKey>"})
    public void equalsSaveTextByKeyNotequal(String key, String saveKey) {
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertNotEquals(StoreHelper.INSTANCE.getValue(saveKey), findElementByKey(key).getText());
        System.out.println(saveKey);
    }

}