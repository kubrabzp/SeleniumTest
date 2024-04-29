package org.etiya;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // WebDriver'ı başlatmak için kullanılır. (Bu örnekte Chrome kullanarak)
        // ChromeDriver --> Selenium WebDriver ile Chrome tarayıcısını kontrol etmek için kullanılmıştır.
        WebDriver webDriver = new ChromeDriver();


        // navigate()to --> Yazılan URL'ye gitmek için kullanılır.
        webDriver.navigate().to("https://www.google.com");

        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        Thread.sleep(1000);

        // navigate().back()--> Tarayıcı geçmişinde bir sayfa geri gitmek için kullanılır.
        // Örneğin, bir önceki sayfaya geri dönmek için:
        webDriver.navigate().back();
        Thread.sleep(2000);

        // navigate().forward()--> Tarayıcı geçmişinde bir sayfa ileri gitmek için kullanılır.
        // Örneğin, bir sonraki sayfaya gitmek için:
        webDriver.navigate().forward();
        Thread.sleep(2000);

        // navigate().refresh()--> Mevcut sayfayı yenilemek için kullanılır.
        webDriver.navigate().refresh();
        Thread.sleep(2000);


        // getTitle() --> URL'de ki title içeriğini almak için kullanılır.
        String title = webDriver.getTitle();
        System.out.println(title);


        // findElement--> Belirli bir web öğesini bulmak için kullanılır.(Örnek olarak--> user-name id'li elemanı bulma)
        WebElement usernameElement = webDriver.findElement(By.id("user-name"));

        // sendKeys--> WebElement'e klavye girişi yapmak için kullanılır. Özellikle metin kutularına veya diğer giriş alanlarına metin göndermek için kullanılır.
        // Örnek olarak => usernameElement kutusuna "standard_user" yazısını gönderme
        usernameElement.sendKeys("standard_user");
        Thread.sleep(1000);


        WebElement passwordElement = webDriver.findElement(By.id("password"));
        passwordElement.sendKeys("secret_sauce");
        Thread.sleep(1000);

        // clear--> Bir WebElement'in içeriğini temizlemek için kullanılır.
        passwordElement.clear();
        Thread.sleep(3000);


        // JavascriptExecutor--> Selenium WebDriver ile web tarayıcısında JavaScript kodlarını çalıştırmak için kullanılır.
        // executeScript--> JavascriptExecutor arabirimine ait bir metod olup, belirtilen JavaScript kodunu tarayıcıda çalıştırmak için kullanılır.
        // window.scrollTo --> Bir tarayıcı penceresinin belirli bir konuma kaydırılması sağlanır.
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);


        // By.className --> Parantez içine yazılacak sınıf ismiyle, bu sınıf ismine sahip olan tüm elementleri bulmak için kullanılır.
        // getText--> Bir WebElement'in içeriğini almak için kullanılır. Yani, belirli bir web öğesinin görüntülenen metin içeriğini almak için kullanılır.
        List<WebElement> elements = webDriver.findElements(By.className("login_password"));
        for (WebElement element1 : elements) {
            System.out.println("Bulunan öğe: " + element1.getText());
        }

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));

        // getSize--> Bir WebElement'in boyutunu almak için kullanılır.
        Dimension lgnBtnSize = (Dimension) loginBtn.getSize();
        System.out.println("Butonun boyutu: " + lgnBtnSize + " Genişlik: " + lgnBtnSize.getWidth()
                + " Yükseklik: " + lgnBtnSize.getHeight());

        Point location = loginBtn.getLocation();
        System.out.println("Butonun konumu: " + location);


        // isDisplayed--> Bir WebElement'in görünürlüğünü kontrol etmek için kullanılır.
        // Bu örnekte eğer resim görünüyorsa, true değeri döner; görünmezse veya sayfa üzerindeki boyutları sıfır ise false değeri döner.
        WebElement image = webDriver.findElement(By.className("bot_column"));
        boolean isVisible = image.isDisplayed();
        System.out.println("Resim görünürlüğü: " + isVisible);


        // submit--> Bir formun gönderilmesini ve form verilerinin belirtilen hedefe iletilmesini sağlar.
        // Bu, genellikle oturum açma, kayıt olma ve form tabanlı işlemler gibi durumlarda kullanılır.
        // loginBtn.submit();


        // click--> Bir WebElement üzerinde tıklama işlemi gerçekleştirmek için kullanılır.
        loginBtn.click();
        Thread.sleep(5000);

        // quit--> Kullanılan tarayıcı oturumunu sonlandırmak için kullanılır
        webDriver.quit();

    }
}