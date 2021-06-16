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

public class FundsInCashPuntoExpressEC extends BaseTestChrome{

    @Test
    public void fundsInCashPuntoExpressEC() throws IOException, InterruptedException {

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
            File screenshotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\Login.png"));
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
            File screenshotFile1 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile1, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\Environment.png"));
            System.out.println("Ingresó correctamente a la opción de ambiente SandBox");

        } else {
            System.out.println("No está la opción de ambiente SandBox");
        }

        WebElement walletOption = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[3]/li/a/div/span"));
        if (walletOption.isEnabled()) {
            walletOption.click();
            File screenshotFile2 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\walletOption.png"));
            System.out.println("Se desplegó la opción de Wallet correctamente");

        } else {
            System.out.println("No se desplegó la opción de Wallet correctamente");
        }

        WebElement balanceOption = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[3]/li/div/a[2]/span"));
        if (balanceOption.isEnabled()) {
            balanceOption.click();
            System.out.println("Se muestra la opción de Balance correctamente");

        } else {
            System.out.println("No se muestra la opción de Balance");
        }

        String puntoExpressAcountName = chromeDriver.findElement(By.xpath("//h5[contains(text(),'Account EC')]")).getText();
        System.out.println("Nombre de la cuenta: " + puntoExpressAcountName );
        String puntoExpressAcountSaldo = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[8]/div/div[1]/div/div/div[2]/h3")).getText();
        System.out.println("Saldo de la cuenta: " + puntoExpressAcountSaldo );
        String paymentMethodReference = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[8]/div/div[1]/div/div/div[4]/p[2]")).getText();
        System.out.println("El payment Method de la cuenta es: " + paymentMethodReference );

        Actions action0 = new Actions(chromeDriver);
        WebElement fundsInButton = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[8]/div/div[1]/div/div/div[4]/div/div[1]/div/button/i"));
        action0.moveToElement(fundsInButton);
        if (fundsInButton.isDisplayed()) {
            fundsInButton.click();
            File screenshotFile3 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile3, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\fundsInButton.png"));
            System.out.println("Se ingresa correctamente a la opción de Funds In");

        } else {
            System.out.println("No se encontró la opción de Funds In");

        }

        WebElement selectCashOption = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div[4]/button/span"));
        if (selectCashOption.isDisplayed()) {
            selectCashOption.click();
            File screenshotFile4 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile4, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\selectCashOption.png"));
            System.out.println("Selección de metodo de pago Cash");

        } else {
            System.out.println("No se encontró el método de pago cash");

        }




    }
}
