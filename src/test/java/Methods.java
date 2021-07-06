import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class Methods extends BaseTest {
    public static String text ="";

    public WebElement findElement(String key){
        try{
            WebElement element = new WebDriverWait(driver,5,300).until(ExpectedConditions.elementToBeClickable(By.cssSelector(key)));
            return element;
        } catch (Exception ex) {
            Assertions.fail("" + key + "'li element 10 saniye boyunca arandı fakat bulunamadı....!!!!");
            return null;
        }
    }
    public List<WebElement> findElements(String key){
        try {
            WebDriverWait waitForFormLabel = new WebDriverWait(driver,30);
            List<WebElement> elements = driver.findElements(By.cssSelector(key));
            waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;
        } catch (Exception ex) {
            Assertions.fail("" + key + "'li element 10 saniye boyunca arandı fakat bulunamadı....!!!!");
            return null;
        }
    }
    public void clickToElement(WebElement element){
        scrollToElement(element);
        waitByMilliSeconds(500);
        element.click();
    }

    public void sendKeysToElement(WebElement element, String text) {

        scrollToElement(element);
        waitByMilliSeconds(500);
        element.sendKeys(text);
    }
    public String getTextElement(WebElement element){
        scrollToElement(element);
        waitByMilliSeconds(500);
        String elemaninTexti = "";
        elemaninTexti = element.getText();
        System.out.println("Elemanın text değeri: " + elemaninTexti);
        return elemaninTexti;
    }
    public String getAttributeElement(WebElement element){
        scrollToElement(element);
        waitByMilliSeconds(500);
        String elemaninAttribute = "";
        elemaninAttribute = element.getAttribute("value");
        System.out.println("Elemanın Attribute değeri: " + elemaninAttribute);
        return elemaninAttribute;
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", element);
    }
    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void getTextControl(WebElement element, String key){
        Assertions.assertEquals(".........Eleman girilen texti içermiyor.........",getTextElement(element),key);
        System.out.println("Girilen değer ile Elementin texti uyuşuyor..");
    }
    public void getAttributeControl(WebElement element, String key) {
        Assertions.assertEquals("Eleman girilen texti içermiyor..!!!", getAttributeElement(element), key);
        System.out.println("Girilen değer ile Elementin texti uyuşuyor..");
    }

    public void textControl(WebElement element) {
        Assertions.assertTrue(getTextElement(element).contains(text), "Eleman texti kaydedilen değer ile uyuşmuyor..!!!");
        System.out.println("Girilen değer ile Elementin texti uyuşuyor..");
    }

    public void saveStaticString(WebElement element) {
        scrollToElement(element);
        text = element.getText();
        System.out.println("Elementin text değeri: " + text);

    }
    public int randomInt() {
        Random r = new Random();
        int low = 1;
        int high = 24;
        int result = r.nextInt(high - low) + low;
        System.out.println(result + ". Elemente tıklandı..");
        return result;
    }
    public void handles(String key){
        List<WebElement> elements = findElements(key);
        waitByMilliSeconds(500);
        clickToElement(elements.get(randomInt()));
        String parent=driver.getWindowHandle();
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            String child_window=I1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parent);

    }
    public void SelectMethod(String key, String text) {
        Select element = new Select(findElement(key));
        element.selectByVisibleText(text);
    }
}
