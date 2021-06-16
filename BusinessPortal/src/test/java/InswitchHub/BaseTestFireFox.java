package InswitchHub;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BaseTestFireFox {

    WebDriver firefoxDriver;

    @Before
    public void abrirDriver() {
        //encontrar archivo exe de geckodriver
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");

        //creamos opciones sobre nuestro driver
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);

        //nueva instancia de FirefoxDriver
        firefoxDriver = new FirefoxDriver(options);

        //definimos tiempo de espera hasta que aceptemos un timeout
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void closeDriverFirefox() {
        //Cerrar ventana, apagar driver
        WebElement logoutUser = firefoxDriver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/div[1]/a[1]"));
        logoutUser.click();

        WebElement confirmLogoutUser = firefoxDriver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/div[1]/div[1]/a[3]"));
        WebDriverWait wait1 = new WebDriverWait(firefoxDriver, 20);
        wait1.until(ExpectedConditions.elementToBeClickable(confirmLogoutUser));
        confirmLogoutUser.click();

        WebElement textLogoutUser = firefoxDriver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        if (textLogoutUser.isDisplayed()) {
            System.out.println("Retornó a la Página de Inicio Correctamente");
        }


        firefoxDriver.quit();
    }
}
