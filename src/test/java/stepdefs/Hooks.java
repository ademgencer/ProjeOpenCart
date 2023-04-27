package stepdefs;

import driver.Driver;
import io.cucumber.java.After;

public class Hooks {

    // Cucumber notasyonları, varsa TestNG notasyonlarından sonra çalışırlar.
    // Hooks dosyası stepdefs package ında değilse cucumber çalıştırılmaz çünkü TestNG runner Classından
    // @CucumberOptions notasyonu sebebiyle cucumber ı çalıştırır fakat Cucumber notasyonlu metotlar Hooks
    // içinde olduğundan glue da değilse ya da Hooks farklı package da  ise package ı glue da ayrıca
    // yazılmamışsa çalıştıramayacaktır.

    @After(order = 0)// Senaryonun run edilmesi bitince çalışır.
    public void quit() {// Her senaryodan sonra çalışır.
        Driver.quitDriver();
    }


}
