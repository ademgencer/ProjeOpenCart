package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        // features dosyası java dosyası olmadığından java package ı dışında da çalışacağından path ini content root tan alırız.
        features = {"src/test/java/features/opencart.feature"},// feature dosyasının source path ini yazıyoruz.
        // source dosyaları renklendirilmiştir projede, java lar gibi resources ler gibi...
        // glue java dosyası olduğundan java package ının altından itibaren tanımlanır ve çalışır, dışında açılmışsa çalışmaz zaten.
        glue = {"stepdefs"},// sadece çalışması istenen stepdefs in olduğu package ın path ini yazıyoruz.
        // Hooks bu package(glue) da degilse calistirilmaz.
        // glue = "{}" boş bırakılırsa tüm java packagelerı altına bakacaktır.
        // Sadece "@iMac" taglı feature dosyasını çalıştırır, ya da ayrı bir runner class oluşturabiliriz.
        dryRun = false,
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json", // cucumber json report
                "html:test-output/cucumber-reports/cucumber.html", // cucumber html report
        } // gerekli ayarlamalar
        // runner dan senaryoyu çalıştırırsak plugin deki reportlar oluşturulur.
)

public class Runner extends AbstractTestNGCucumberTests {

    // TestNg class ıdır, aşağıya yazılan TestNG annotation lu
    // metotlar Cucumber metotlarından önce çalışır.

}
