package com.glen.demo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.openqa.selenium.server.browserlaunchers.Sleeper;

import java.io.File;  
import java.net.URL;  
import java.util.List;

 
public class ContactsTest {
	static int i=1;
	private AppiumDriver driver; 
    @Before
    public void setUp() throws Exception {
    	
        //����apk��·��
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "ContactManager.apk");
        
        //�����Զ�����ز���
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "EQBITGMRAIMFBMPJ");
        //Android Emulator
        
        //���ð�׿ϵͳ�汾
        capabilities.setCapability("platformVersion", "4.4");
        //����apk·��
        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        //����app����������������
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        
        //��ʼ��
        //AndroidDriver
    	driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);    
    }
   
    @Test
    public void addContact(){
        WebElement el = driver.findElement(By.name("Add Contact"));
        el.click();
        
        el=driver.findElementById("com.example.android.contactmanager:id/accountSpinner");
        el.click();
        ((AndroidDeviceActionShortcuts) driver).sendKeyEvent(AndroidKeyCode.BACK);
//        el.sendKeys("KEYCODE_BACK");
        el=driver.findElementById("com.example.android.contactmanager:id/contactPhoneTypeSpinner");
        el.click();
        el=driver.findElementById("android:id/text1");
        el.click();
       
        
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
    	/*   for(int a=0;a<=10;a++){ 
    		   
    		   String d=String.valueOf(i);
    		   textFieldsList.get(0).sendKeys(d);
    		  // textFieldsList.input.sendKeys("ssssssss");
    		   i++;
    		   }*/
    		  
    	   textFieldsList.get(0).sendKeys("sminame");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        /*driver.closeApp();
        driver.launchApp();
        driver.resetApp();*/
        driver.findElementByName("Save").click();
//        List<WebElement>buttonfind=driver.findElementsByAccessibilityId("com.example.android.contactmanager:id/accountSpinner");
//        buttonfind
        
        
    }    
    
    @After
    public void tearDown() throws Exception {
       //driver.quit();
    }
}