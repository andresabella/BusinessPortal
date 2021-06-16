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

public class FundsInCashPagoExpress extends BaseTestChrome {

    @Test
    public void fundsInCashPagoExpress() throws IOException, InterruptedException {

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
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\Login.png"));
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
            FileUtils.copyFile(screenshotFile1, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\Environment.png"));
            System.out.println("Ingresó correctamente a la opción de ambiente SandBox");

        } else {
            System.out.println("No está la opción de ambiente SandBox");
        }

        WebElement walletOption = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[3]/li/a/div/span"));
        if (walletOption.isEnabled()) {
            walletOption.click();
            File screenshotFile2 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\walletOption.png"));
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

        String pagoExpressAcountName = chromeDriver.findElement(By.xpath("//h5[contains(text(),'Account BOB')]")).getText();
        System.out.println("Nombre de la cuenta: " + pagoExpressAcountName );
        String pagoExpressAcountSaldo = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[6]/div/div[1]/div/div/div[2]/h3")).getText();
        System.out.println("Saldo de la cuenta: " + pagoExpressAcountSaldo );
        String paymentMethodReference = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[6]/div/div[1]/div/div/div[4]/p[2]")).getText();
        System.out.println("El payment Method de la cuenta es: " + paymentMethodReference );

        Actions action0 = new Actions(chromeDriver);
        WebElement fundsInButton = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[6]/div/div[1]/div/div/div[4]/div/div[1]/div/button/i"));
        action0.moveToElement(fundsInButton);
        if (fundsInButton.isDisplayed()) {
            fundsInButton.click();
            File screenshotFile2 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\fundsInButton.png"));
            System.out.println("Se ingresa correctamente a la opción de Funds In");

        } else {
            System.out.println("No se encontró la opción de Funds In");

        }

        WebElement paymentMethodCash = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div[4]/button"));
        if (paymentMethodCash.isDisplayed()) {
            paymentMethodCash.click();
            File screenshotFile3 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile3, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\paymentMethodOptionCash.png"));
            System.out.println("Se ingresa correctamente a la opción de Cash como método de pago");

        } else {
            System.out.println("No se encontró la opción de cash como método de pago");

        }

        String PaymentMethodType = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[3]")).getText();
        System.out.println("Nombre del payment method para la transacción es: " + PaymentMethodType );

        WebElement selectPaymentMethodType = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/button"));
        if (selectPaymentMethodType.isDisplayed()) {
            selectPaymentMethodType.click();
            System.out.println("Payment Method seleccionado correctamente");

        } else {
            System.out.println("No se encontró el Payment Method");

        }

        WebElement fundsInDescription = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[1]/input"));
        if (fundsInDescription.isDisplayed()) {
            fundsInDescription.clear();
            fundsInDescription.sendKeys("Funds In Test");
            System.out.println("Se ingresó la descripción correctamente");

        } else {
            System.out.println("No se encontró el campo para la descripción");

        }

        WebElement fundsInAmount = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[2]/input"));
        if (fundsInAmount.isDisplayed()) {
            fundsInAmount.clear();
            fundsInAmount.sendKeys("130");
            File screenshotFile4 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile4, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\fundsInInfo.png"));
            System.out.println("Se ingresó la cantidad correctamente");

        } else {
            System.out.println("No se encontró el campo para la cantidad");

        }

        WebElement createFundsIn = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[3]/div/button[2]"));
        if (createFundsIn.isDisplayed()) {
            createFundsIn.click();
            System.out.println("Se creó la transacción");

        } else {
            System.out.println("No se creó la transacción");

        }

    }
}