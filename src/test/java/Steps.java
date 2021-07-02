import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Steps extends Methods {

    public void clickElement(String key) {
        WebElement element = findElement(key);
        clickToElement(element);
    }

    public void ifElementExistClick(String key) {
        waitSecond(2);
        List<WebElement> elements = driver.findElements(By.cssSelector(key));
        if (elements.size() > 0) {
            clickToElement(elements.get(0));
        }
    }

    public void randomClick(String key) {
        List<WebElement> elements = findElements(key);
        clickToElement(elements.get(randomInt()));
    }

    public void sendKeysToElementTest(String key, String text) {
        WebElement element = findElement(key);
        sendKeysToElement(element, text);
    }

    public void waitSecond(int second) {
        waitByMilliSeconds(second * 1000);
    }

    public void getTextControlTest(String key, String text) {
        WebElement element = findElement(key);
        getTextControl(element, text);
    }

    public void getAttributeControlTest(String key, String text) {
        WebElement element = findElement(key);
        getAttributeControl(element, text);
    }

    public void textControlTest(String key) {
        WebElement element = findElement(key);
        textControl(element);
    }

    public void saveText(String key) {
        WebElement element = findElement(key);
        saveStaticString(element);

    }

    public void SelectElement(String key, String text) {
        SelectMethod(key, text);
    }

    public void changeControl() {
        if (driver.findElements(By.cssSelector("div[class='pb-basket-item-price']")).size() > 0) {
            textControlTest("div[class='pb-basket-item-price']"); // ürün fiyatını kontrol et
            clickElement("button[class='ty-numeric-counter-button']"); //ürün adet arttır
            waitSecond(2); // 2 saniye bekle
            getAttributeControlTest("input[class='counter-content']", "2"); //ürün adeti 2 mi kontrol et
            clickElement("i[class='i-trash']"); //ürünü kaldır butonuna bas


        } else {
            textControlTest("div[class*='priceInfo']"); //ürün fiyatını kontrol et
            SelectElement("select[class*='basketItemQuantity']", "2"); //ürün adetini 2 yap
            waitSecond(2); //2 saniye bekle
            getTextControlTest("select[class*='basketItemQuantity'] option[selected='selected']", "2"); //ürün adeti 2 mi kontrol et
            clickElement("a[class='removeitem']"); //ürünü kaldır butonuna bas

        }

    }
}
