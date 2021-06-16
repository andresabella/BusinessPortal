package InswitchHub;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FundsInCashPagoExpress extends BaseTest {


    @Test
    public void fundsInCashPagoExpress() throws IOException, InterruptedException {

        driver.get("https://dashboard-ish.apps.ins.inswhub.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement userName = driver.findElement(By.name("email"));
        if (userName.isDisplayed()) {
            userName.clear();
            userName.sendKeys("andres.abella");
        } else {
            System.out.println("No se pudo ingresar el username");

        }

        WebElement password = driver.findElement(By.name("password"));
        if (password.isDisplayed()) {
            password.clear();
            password.sendKeys("inswitch");
            //Tomar Screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\Login.png"));
        } else {
            System.out.println("No se pudo ingresar el Password");

        }

        WebElement signIn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        if (signIn.isDisplayed()) {
            signIn.click();
        } else {
            System.out.println("No se pudo hacer Login correctamente");
        }

        Thread.sleep(300);

        WebElement sandBoxEnvironment = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[1]"));
        //Ambiente Producción
        //WebElement sandBoxEnvironment = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[2]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (sandBoxEnvironment.isEnabled()) {
            //driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul")).click();
            sandBoxEnvironment.click();
            File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile1, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\Environment.png"));
            System.out.println("Ingresó correctamente a la opción de ambiente SandBox");

        } else {
            System.out.println("No está la opción de ambiente SandBox");
        }

        WebElement walletOption = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[3]/li/a/div/span"));
        if (walletOption.isEnabled()) {
            walletOption.click();
            File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\walletOption.png"));
            System.out.println("Se desplegó la opción de Wallet correctamente");

        } else {
            System.out.println("No se desplegó la opción de Wallet correctamente");
        }

        WebElement balanceOption = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[3]/li/div/a[2]/span"));
        if (balanceOption.isEnabled()) {
            balanceOption.click();
            System.out.println("Se muestra la opción de Balance correctamente");

        } else {
            System.out.println("No se muestra la opción de Balance");
        }

        String pagoExpressAcountName = driver.findElement(By.xpath("//h5[contains(text(),'Account BOB')]")).getText();
        System.out.println("Nombre de la cuenta: " + pagoExpressAcountName );
        String pagoExpressAcountSaldo = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[9]/div/div[1]/div/div/div[2]/h3")).getText();
        System.out.println("Saldo de la cuenta: " + pagoExpressAcountSaldo );
        String paymentMethodReference = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[9]/div/div[1]/div/div/div[4]/p[2]")).getText();
        System.out.println("El payment Method de la cuenta es: " + paymentMethodReference );

        Actions action0 = new Actions(driver);
        WebElement fundsInButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[9]/div/div[1]/div/div/div[4]/div/div[1]/div/button/i"));
        action0.moveToElement(fundsInButton);
        if (fundsInButton.isDisplayed()) {
            fundsInButton.click();
            File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\fundsInButton.png"));
            System.out.println("Se ingresa correctamente a la opción de Funds In");

        } else {
            System.out.println("No se encontró la opción de Funds In");

        }

        WebElement paymentMethodCash = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div[4]/button"));
        if (paymentMethodCash.isDisplayed()) {
            paymentMethodCash.click();
            File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile3, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\paymentMethodOptionCash.png"));
            System.out.println("Se ingresa correctamente a la opción de Cash como método de pago");

        } else {
            System.out.println("No se encontró la opción de cash como método de pago");

        }

        Thread.sleep(3000);

        String paymentMethodSelected = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[3]")).getText();
        System.out.println("El método de pago seleccionado es: " + paymentMethodSelected );

        WebElement selectPaymentMethodType = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/button"));
        if (selectPaymentMethodType.isDisplayed()) {
            selectPaymentMethodType.click();
            System.out.println("Payment Method seleccionado correctamente");

        } else {
            System.out.println("No se encontró el Payment Method");

        }

        WebElement fundsInDescription = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[1]/input"));
        if (fundsInDescription.isDisplayed()) {
            fundsInDescription.clear();
            fundsInDescription.sendKeys("Funds In Test");
            System.out.println("Se ingresó la descripción correctamente");

        } else {
            System.out.println("No se encontró el campo para la descripción");

        }

        WebElement fundsInAmount = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[2]/input"));
        if (fundsInAmount.isDisplayed()) {
            fundsInAmount.clear();
            fundsInAmount.sendKeys("130");
            File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile4, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\fundsInInfo.png"));
            System.out.println("Se ingresó la cantidad correctamente");

        } else {
            System.out.println("No se encontró el campo para la cantidad");

        }

        WebElement createFundsIn = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[3]/div/button[2]"));
        if (createFundsIn.isDisplayed()) {
            createFundsIn.click();
            System.out.println("Se creó la transacción");

        } else {
            System.out.println("No se creó la transacción");

        }

        Thread.sleep(4000);
        File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile5, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\createTransaction.png"));

        WebElement goToTransactions = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[5]/li/a/div/span"));
        if (goToTransactions.isDisplayed()) {
            goToTransactions.click();
            System.out.println("Ingresó a la opción Transactions");

        } else {
            System.out.println("No ingresó a la opción Transactions");

        }

        WebElement viewTransactions = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[1]/div/div/div[4]/button"));
        if (viewTransactions.isDisplayed()) {
            viewTransactions.click();
            File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile6, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPagoExpress\\viewTransactions.png"));
            System.out.println("Ingresó a la opción Transactions");

        } else {
            System.out.println("No ingresó a la opción Transactions");

        }

        String lastTransaction = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div/div[2]/table/tbody/tr[1]")).getText();
        System.out.println("Confirmación datos última transacción enviada: " + lastTransaction );


    }
}
