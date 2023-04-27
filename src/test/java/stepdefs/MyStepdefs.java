package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utils.Utils;

import java.util.List;

public class MyStepdefs extends BaseSteps{

    String lastMacName;

    @Given("{string} git")
    public void httpOpencartAbstractaUsGit(String url) {
        driver.get(url);
    }

    @When("mac arat")
    public void macArat() {
        By lSearchInput = By.xpath("//input[@placeholder='Search']");
        driver.findElement(lSearchInput).sendKeys("mac" + Keys.ENTER);

    }

    @And("bulunan ürünlerden sonuncusunun ismini System.setProperty icine kaydedin")
    public void bulunanÜrünlerdenSonuncusununIsminiSystemSetPropertyIcineKaydedin() {
        By lMacs = By.cssSelector("h4");
        List<WebElement> elements = driver.findElements(lMacs);
        System.setProperty("last mac", elements.get(3).getText());
        lastMacName = System.getProperty("last mac");

    }

    @And("yeni TAB'da {string} adreaine gidin")
    public void yeniTABDaHttpsOpensourceDemoOrangehrmliveComWebIndexPhpDashboardIndexAdreaineGidin(String url) {
        driver.switchTo().newWindow(WindowType.WINDOW).get(url);
    }

    @And("login olun")
    public void loginOlun() {
        By lUserName= By.xpath("//input[@placeholder='Username']");
        By lPassword= By.xpath("//input[@placeholder='Password']");
        By lSubmitButton= By.xpath("//button[@type='submit']");
        sendKeys(lUserName,"Admin");
        sendKeys(lPassword,"admin123");
        click(lSubmitButton);
    }

    @And("admin'e tikla")
    public void adminETikla() {
        By lAdminLink = By.xpath("//li[@class='oxd-main-menu-item-wrapper'][1]");
        click(lAdminLink);
    }

    @And("username inputuna kaydettiginiz ürün ismini yazin")
    public void usernameInputunaKaydettiginizÜrünIsminiYazin() {
        By lUserNameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
        sendKeys(lUserNameInput, lastMacName);
    }

    @Then("ekran kaydi alin")
    public void ekranKaydiAlin() {
        Utils.takeScreenShot("OpenSourceSS");
    }


}
