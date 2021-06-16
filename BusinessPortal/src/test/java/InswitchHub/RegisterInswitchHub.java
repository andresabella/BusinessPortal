package InswitchHub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class RegisterInswitchHub {

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


    @Test
    public void register(){
        chromeDriver.get("https://dashboard-ish.apps.ins.inswhub.com/login");
        //Acertamos si la opción de registrar está habilitada
        WebElement opcionRegistro = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div/p/a/u"));
        //Assert.assertTrue(opcionRegistro.isDisplayed());

        if (opcionRegistro.isDisplayed()) {
            System.out.println("La opción de registro --> Existe.");
            opcionRegistro.click();
        }

        WebElement ingresoNombre = chromeDriver.findElement(By.name("firstName"));

        if (ingresoNombre.isDisplayed()) {
            ingresoNombre.click();
            ingresoNombre.clear();
            ingresoNombre.sendKeys("Andresss");
            System.out.println("Campo de ingresar Nombre --> Existe.");

        }

        WebElement ingresoApellido = chromeDriver.findElement(By.name("lastName"));
        if (ingresoApellido.isDisplayed()) {
            ingresoApellido.click();
            ingresoApellido.clear();
            ingresoApellido.sendKeys("Abellaaa");
            System.out.println("Campo de ingresar Apellido --> Existe.");

        }

        WebElement ingresoEmail = chromeDriver.findElement(By.name("email"));
        if (ingresoEmail.isDisplayed()) {
            ingresoEmail.click();
            ingresoEmail.clear();
            ingresoEmail.sendKeys("test@inswitch.com");
            System.out.println("Campo de ingresar Email --> Existe.");

        }

        WebElement ingresoNombreUsuario = chromeDriver.findElement(By.name("username"));
        if (ingresoNombreUsuario.isDisplayed()) {
            ingresoNombreUsuario.click();
            ingresoNombreUsuario.clear();
            ingresoNombreUsuario.sendKeys("newuser6");
            System.out.println("Campo de ingresar Nombre de Usuario --> Existe.");

        }

        WebElement ingresoPassword = chromeDriver.findElement(By.name("password"));
        if (ingresoPassword.isDisplayed()) {
            ingresoPassword.click();
            ingresoPassword.clear();
            ingresoPassword.sendKeys("P1234");
            System.out.println("Campo de Password --> Existe.");

        }

        WebElement ingresoConfirmacionPassword = chromeDriver.findElement(By.name("rePassword"));
        if (ingresoConfirmacionPassword.isDisplayed()) {
            ingresoConfirmacionPassword.click();
            ingresoConfirmacionPassword.clear();
            ingresoConfirmacionPassword.sendKeys("P1234");
            System.out.println("Campo de Confirmación Password --> Existe.");

        }

        WebElement ingresoNombreCompañia = chromeDriver.findElement(By.name("companyName"));
        if (ingresoNombreCompañia.isDisplayed()) {
            ingresoNombreCompañia.click();
            ingresoNombreCompañia.clear();
            ingresoNombreCompañia.sendKeys("name 1 test");
            System.out.println("Campo de Nombre de Compañia --> Existe.");

        }

        WebElement ingresoWebSite = chromeDriver.findElement(By.name("website"));
        if (ingresoWebSite.isDisplayed()) {
            ingresoWebSite.click();
            ingresoWebSite.clear();
            ingresoWebSite.sendKeys("any1@io.com");
            System.out.println("Campo de Website --> Existe.");

        }

        WebElement terminosyCondiciones = chromeDriver.findElement(By.name("acceptTerms"));
        if (terminosyCondiciones.isDisplayed()) {
            terminosyCondiciones.click();
            System.out.println("Campo de Terminos y condiciones --> Existe.");


        }

        WebElement crearCuenta = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div/form/div[8]/button"));
        if (crearCuenta.isSelected()) {
            crearCuenta.click();
            System.out.println("Campo de Terminos y condiciones --> Existe.");
            chromeDriver.findElement(By.name("Close")).click();
            System.out.println("Registro Exitoso.");

        }

    }

    @After
    public void closeDriver(){

        chromeDriver.quit();
    }



}
