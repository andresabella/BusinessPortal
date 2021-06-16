package InswitchHub;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BaseTestChrome {

    WebDriver chromeDriver;
    @Before
    public void openDriver() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette", false);
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
    }

    @After
    public void closeDriver(){

        WebElement logoutUser = chromeDriver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/div[1]/a[1]"));
        logoutUser.click();

        WebElement confirmLogoutUser = chromeDriver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/div[1]/div[1]/a[3]"));
        WebDriverWait wait1 = new WebDriverWait(chromeDriver, 20);
        wait1.until(ExpectedConditions.elementToBeClickable(confirmLogoutUser));
        confirmLogoutUser.click();

        WebElement textLogoutUser = chromeDriver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        if (textLogoutUser.isDisplayed()){
            System.out.println("/-------------------------------------------------------/");
            System.out.println("Cierre de sesión correcto, retorno a la Página de Inicio");
        } else {
            System.out.println("/-------------------------------------------------------/");
            System.out.println("No se finalizó la sesión como se esperaba");

        }


        chromeDriver.quit();
    }



}
