import org.junit.jupiter.api.Test;

public class Senaryo extends BaseTest {
    Steps steps = new Steps();

    @Test
    public void TestSenaryosu() throws Exception {
        steps.ifElementExistClick("#gender-popup-modal > div > div > div.modal-close");// kadın/erkek pop-up ı çıkarsa kapat
        steps.clickElement("#account-navigation-container > div > div.account-nav-item.user-login-container > div.link.account-user"); //Giriş yap ikonuna tıkla
        steps.waitSecond(3); // 3 saniye bekle
        steps.sendKeysToElementTest("input[id='login-email']", "xmyle@outlook.com"); //email inputuna değeri yaz
        steps.sendKeysToElementTest("input[id='login-password-input']", "123deneme123"); // parola inputuna değeri yaz
        steps.clickElement("#login-register > div.lr-container > div.q-layout.login > form > button");
        steps.waitSecond(3);// giriş yap butonuna tıkla
        //steps.getTextControlTest("#account-navigation-container > div > div.account-nav-item.user-login-container > div.link.account-user > p", "Hesabım"); //giriş yapılmış mı kontrol et
        steps.sendKeysToElementTest("#auto-complete-app > div > div > input", "bilgisayar"); // arama çubuğuna "bilgisayar" yaz
        steps.clickElement("i[class='search-icon']"); //arama ikonuna bas
        //steps.clickElement("body");
        steps.handles("div[class='p-card-img-wr']"); // rastgele bir ürün seç
        steps.waitSecond(2);// 2 saniye bekle
        //steps.clickElement("div[class='pr-cn-in'] div[class='add-to-bs-tx']"); //sepete ekle butonuna bas
        steps.clickElement("#account-navigation-container > div > div.account-nav-item.basket-preview"); //sepetim ikonuna bas
        steps.saveText("#partial-basket > div > div.pb-merchant-group > div.pb-basket-item > div.pb-basket-item-actions > div.pb-basket-item-price > span"); //ürünün fiyat bilgisini kaydet
        steps.waitSecond(2); // 2 saniye bekle
        steps.changeControl(); // Sepetim sayfasında ürünlere göre div değişikliği olduğu için method yazıldı
        steps.clickElement("#partial-basket > div > div.pb-merchant-group > div.pb-basket-item > div.pb-basket-item-actions > button > i"); //sil butonuna bas
        steps.clickElement("#ngdialog1 > div.ngdialog-content > form > div > div.footer > div > div.left > button.btn-item.btn-remove");//sil butonuna bas
        steps.getTextControlTest("div[class='col-lg-8 col-md-8 col-xs-8'] span", "Sepetinizde ürün bulunmamaktadır."); // sepet boş mu kontrol et
    }
}
