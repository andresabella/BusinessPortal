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

public class FundsInAsaas extends BaseTestChrome {

    @Test
    public void fundsInAsaas() throws IOException, InterruptedException {

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
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\Login.png"));
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

        String asaasAcountName = chromeDriver.findElement(By.linkText("Account BRL Sandbox")).getText();
        System.out.println("Nombre de la cuenta: " + asaasAcountName );
        String assasAcountSaldo = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[13]/div/div[1]/div/div/div[2]/h3")).getText();
        System.out.println("Saldo de la cuenta: " + assasAcountSaldo );


        Actions action0 = new Actions(chromeDriver);
        WebElement clickFundsIn = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div/div[4]/div[13]/div/div[1]/div/div/div[4]/div/div[1]/div/button/i"));
        action0.moveToElement(clickFundsIn);
        if (clickFundsIn.isDisplayed()) {
            clickFundsIn.click();
            System.out.println("Ingreso correcto a Funds In");

        } else {
            System.out.println("No se encontró la cuenta BR");

        }

        WebElement clickFundsInCash = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div[4]/button"));
        if (clickFundsInCash.isDisplayed()) {
            clickFundsInCash.click();
            File screenshotFile3 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile3, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\clickFundsInCash.png"));
            System.out.println("Ingreso correcto a la opción de Cash");

        } else {
            System.out.println("No se encontró la opción de Cash");
        }

        WebElement paymentMethodType = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/button"));
        if (paymentMethodType.isDisplayed()) {
            paymentMethodType.click();
            File screenshotFile4 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile4, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\paymentMethodType.png"));
            System.out.println("Seleccinó el método para pago correctamente");

        } else {
            System.out.println("No se encontró método para pago");
        }

        //Funds In Transaction

        String paymentMethodSelected = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/p/small/strong")).getText();
        System.out.println("El método de pago seleccionado es: " + paymentMethodSelected );

        WebElement fundsInDescription = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[1]/input"));
        if (fundsInDescription.isDisplayed()) {
            fundsInDescription.clear();
            fundsInDescription.click();
            fundsInDescription.sendKeys("Funds In test");
            System.out.println("Se ingresó correctamente la descripción de la transacción");

        } else {
            System.out.println("No se ingresó la descripción de la transacción");
        }

        WebElement fundsInAmount = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[2]/input"));
        if (fundsInAmount.isDisplayed()) {
            fundsInAmount.clear();
            fundsInAmount.click();
            fundsInAmount.sendKeys("121");
            System.out.println("Se ingresó correctamente la cantidad de la transacción");

        } else {
            System.out.println("No se ingresó la cantidad de la transacción");
        }

        WebElement fundsInIdentification = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[3]/input"));
        if (fundsInIdentification.isDisplayed()) {
            fundsInIdentification.clear();
            fundsInIdentification.click();
            fundsInIdentification.sendKeys("54.651.716/0011-50");
            System.out.println("Se ingresó correctamente CPF-CNPJ para la transacción");

        } else {
            System.out.println("No se ingresó CPF-CNPJ para de la transacción");
        }

        WebElement fundsInName = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[3]/input"));
        if (fundsInName.isDisplayed()) {
            fundsInName.clear();
            fundsInName.click();
            fundsInName.sendKeys("Andres Abella");
            File screenshotFile5 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile5, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\fundsInName.png"));
            System.out.println("Se ingresó correctamente el nombre del titular para la transacción");

        } else {
            System.out.println("No se ingresó el nombre del titular para de la transacción");
        }

        WebElement fundsInCreate = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/form/div[5]/div/button[2]"));
        if (fundsInCreate.isDisplayed()) {
            fundsInCreate.click();
            System.out.println("Se crea la transacción");

        } else {
            System.out.println("No se creó la transacción");
        }

        WebElement fundsInConfirm = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]"));
        if (fundsInConfirm.isDisplayed()) {
            System.out.println("Se confirma exitosamente la transacción");
            File screenshotFile6 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile6, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\fundsInConfirm.png"));


        } else {
            System.out.println("No se creó la transacción");
        }

        String fundsInConfirmMessage = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]")).getText();
        System.out.println("El mensaje de confirmación transaccional es: " + fundsInConfirmMessage );

    }
}
