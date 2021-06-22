package InswitchHub;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FundsInCashPuntoExpressEC extends BaseTest {


    @Test
    public void fundsInCashPuntoExpressEC() throws IOException, InterruptedException {

        driver.get("https://dashboard-ish.apps.ins.inswhub.com/login");

        WebElement userName = driver.findElement(By.name("email"));
        if (userName.isDisplayed()==true) {
            userName.clear();
            userName.sendKeys("andres.abella");
        } else {
            System.out.println("No se pudo ingresar el username");

        }

        WebElement password = driver.findElement(By.name("password"));
        if (password.isDisplayed()==true) {
            password.clear();
            password.sendKeys("inswitch");
            //Tomar Screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\Login.png"));
        } else {
            System.out.println("No se pudo ingresar el Password");

        }

        WebElement signIn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        if (signIn.isDisplayed()==true) {
            signIn.click();
        } else {
            System.out.println("No se pudo hacer Login correctamente");
        }

        Thread.sleep(300);

        WebElement sandBoxEnvironment = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[1]"));
        //Ambiente Producción
        //WebElement sandBoxEnvironment = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[2]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (sandBoxEnvironment.isEnabled()==true) {
            //driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul")).click();
            sandBoxEnvironment.click();
            File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile1, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\Environment.png"));
            System.out.println("Ingresó correctamente a la opción de ambiente SandBox");

        } else {
            System.out.println("No está la opción de ambiente SandBox");
        }

        WebElement walletOption = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[3]/li/a/div/span"));
        if (walletOption.isEnabled()==true) {
            walletOption.click();
            File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\walletOption.png"));
            System.out.println("Se desplegó la opción de Wallet correctamente");

        } else {
            System.out.println("No se desplegó la opción de Wallet correctamente");
        }

        WebElement balanceOption = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[3]/li/div/a[2]/span"));
        if (balanceOption.isEnabled()==true) {
            balanceOption.click();
            System.out.println("Se muestra la opción de Balance correctamente");

        } else {
            System.out.println("No se muestra la opción de Balance");
        }

        String puntoExpressAcountName = driver.findElement(By.xpath("//h5[contains(text(),'Account EC')]")).getText();
        System.out.println("Nombre de la cuenta: " + puntoExpressAcountName );
        String puntoExpressAcountSaldo = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[8]/div/div[1]/div/div/div[2]/h3")).getText();
        System.out.println("Saldo de la cuenta: " + puntoExpressAcountSaldo );
        String paymentMethodReference = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[8]/div/div[1]/div/div/div[4]/p[2]")).getText();
        System.out.println("El payment Method de la cuenta es: " + paymentMethodReference );

        Actions action0 = new Actions(driver);
        WebElement fundsInButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[8]/div/div[1]/div/div/div[4]/div/div[1]/div/button/i"));
        action0.moveToElement(fundsInButton);
        if (fundsInButton.isDisplayed()==true) {
            fundsInButton.click();
            File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile3, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\fundsInButton.png"));
            System.out.println("Se ingresa correctamente a la opción de Funds In");

        } else {
            System.out.println("No se encontró la opción de Funds In");

        }

        WebElement selectCashOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div[4]/button/span"));
        if (selectCashOption.isDisplayed()==true) {
            selectCashOption.click();
            File screenshotFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile4, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\selectCashOption.png"));
            System.out.println("Selección de metodo de pago Cash");

        } else {
            System.out.println("No se encontró el método de pago cash");

        }

        WebElement selectPaymentMethod = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/button"));
        if (selectPaymentMethod.isDisplayed()==true) {
            selectPaymentMethod.click();
            File screenshotFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile5, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\selectPaymentMethod.png"));
            System.out.println("Selección de payment method correcto");

        } else {
            System.out.println("No se encontró el payment method");

        }

        WebElement enterDescription = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[1]/input"));
        if (enterDescription.isDisplayed()==true) {
            enterDescription.clear();
            enterDescription.sendKeys("FundsIn Test Cash");
            File screenshotFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile6, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\enterDescription.png"));
            System.out.println("Se ingreso la descripción del pago");

        } else {
            System.out.println("No se ingresó la descripción");

        }

        WebElement enterAmount = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[2]/input"));
        if (enterAmount.isDisplayed()==true) {
            enterAmount.clear();
            enterAmount.sendKeys("112");
            System.out.println("Se ingreso la cantidad del pago");

        } else {
            System.out.println("No se ingresó la cantidad");

        }

        WebElement createTransaction = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[3]/div/button[2]"));
        if (createTransaction.isDisplayed()==true) {
            createTransaction.click();
            System.out.println("Transacción creada");

        } else {
            System.out.println("Transacción no creada");

        }
        Thread.sleep(4000);
        File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile7, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\createTransaction.png"));

        WebElement goToTransactions = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[5]/li/a/div/span"));
        if (goToTransactions.isDisplayed()==true) {
            goToTransactions.click();
            System.out.println("Ingresó a la opción Transactions");

        } else {
            System.out.println("No ingresó a la opción Transactions");

        }

        WebElement viewTransactions = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[1]/div/div/div[4]/button"));
        if (viewTransactions.isDisplayed()==true) {
            viewTransactions.click();
            File screenshotFile8 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile8, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInCashPuntoExpressEC\\viewTransactions.png"));
            System.out.println("Ingresó a la opción Transactions");

        } else {
            System.out.println("No ingresó a la opción Transactions");

        }

        String lastTransaction = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div/div[2]/table/tbody/tr[1]")).getText();
        System.out.println("Confirmación datos última transacción enviada: " + lastTransaction );


    }
}
