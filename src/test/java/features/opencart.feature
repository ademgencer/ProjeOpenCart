Feature: Opencart elemnet text kopyalama ve opensource da Admine yapıştırma

  Scenario: opencart to opensource

    Given "https://opencart.abstracta.us/" git
    When mac arat
    And bulunan ürünlerden sonuncusunun ismini System.setProperty icine kaydedin
    And yeni TAB'da "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" adreaine gidin
    And login olun
    And admin'e tikla
    And username inputuna kaydettiginiz ürün ismini yazin
    Then ekran kaydi alin
    And ilk tabdaki opencart sayfasına geri gelin