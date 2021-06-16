package InswitchHub;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ViewUserNames extends BaseTestChrome {

    @Test
    public void ViewUserNames() throws IOException, InterruptedException {

        chromeDriver.get("https://dashboard-ish.apps.ins.inswhub.com/login");
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement userName = chromeDriver.findElement(By.name("email"));
        if (userName.isDisplayed()) {
            userName.clear();
            userName.sendKeys("andres.abella");
        } else {
            System.out.println("No se pudo ingresar el username");

        }

        WebElement password = chromeDriver.findElement(By.name("password"));
        if (password.isDisplayed()) {
            password.clear();
            password.sendKeys("inswitch");
            //Tomar Screenshot
            //File screenshotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Login.png"));
        } else {
            System.out.println("No se pudo ingresar el Password");

        }

        WebElement signIn = chromeDriver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        if (signIn.isDisplayed()) {
            signIn.click();
        } else {
            System.out.println("No se pudo hacer Login correctamente");
        }

        Thread.sleep(300);

        WebElement sandBoxEnvironment = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[1]"));
        //Ambiente Producción
        //WebElement sandBoxEnvironment = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[2]"));
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (sandBoxEnvironment.isEnabled()) {
            //chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul")).click();
            sandBoxEnvironment.click();
            //File screenshotFile0 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(screenshotFile0, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Environment.png"));
            System.out.println("Ingresó correctamente a la opción de ambiente SandBox");

        } else {
            System.out.println("No está la opción de ambiente SandBox");
        }


        WebElement customersOptionfinaly = chromeDriver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
        //WebElement customersOption = chromeDriver.findElement(By.xpath("//*[@id="root"]/div[2]/div/div/aside/div[4]/div/ul/div[4]/li/a/div/span"));
        if (customersOptionfinaly.isDisplayed()) {
            customersOptionfinaly.click();
            System.out.println("Ingresó correctamente a la opción de Customers");

        } else {
            System.out.println("No se pudo ingresar a la opción de Customers");

        }

        Actions action8 = new Actions(chromeDriver);
        WebElement viewCustomerInformation = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr/td[7]/div/a[1]/button/i"));
        action8.moveToElement(viewCustomerInformation);
        if (viewCustomerInformation.isDisplayed()) {
            viewCustomerInformation.click();
            File screenshotFile23 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile23, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\viewCustomerInformation.png"));


        } else {
            System.out.println("No se logró encontrar la información del cliente");

        }


        WebElement viewUsernamesInformation1 = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[3]/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/span"));
        if (viewUsernamesInformation1.isDisplayed()) {
            File screenshotFile24 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile24, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\viewUsernamesInformation1.png"));

        } else {
            System.out.println("No hay datos asociados");

        }

        String asaasAcountName = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[3]/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/span")).getText();
        System.out.println("Primer Usuario: " + asaasAcountName);

        String viewUsernamesInformation2 = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[3]/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/span")).getText();
        System.out.println("Segundo Usuario: " + viewUsernamesInformation2);

        String viewUsernamesInformation3 = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[3]/div/div[1]/div/div[1]/div[2]/div[3]/div/div[1]/span")).getText();
        System.out.println("Tercer Usuario: " + viewUsernamesInformation3);

        String viewUsernamesInformation4 = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[3]/div/div[1]/div/div[1]/div[2]/div[4]/div/div[1]/span")).getText();
        System.out.println("Cuarto Usuario: " + viewUsernamesInformation4);




    }
}
