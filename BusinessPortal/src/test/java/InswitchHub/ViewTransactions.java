package InswitchHub;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ViewTransactions extends BaseTest {


    @Test
    public void ViewTransactions() throws IOException, InterruptedException {

        driver.get("https://dashboard-ish.apps.ins.inswhub.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


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
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Transactions\\Login.png"));
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
            File screenshotFile0 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile0, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Transactions\\Environment.png"));
            System.out.println("Ingresó correctamente a la opción de ambiente SandBox");

        } else {
            System.out.println("No está la opción de ambiente SandBox");
        }

        WebElement transactionOptions = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/aside/div[4]/div/ul/div[5]/li/a/div/span"));
        if (transactionOptions.isDisplayed()==true) {
            transactionOptions.click();
            System.out.println("Ingreso a la opción de Transacciones");

        } else {
            System.out.println("No se pudo acceder a la opción de Transacciones");
        }

        WebElement viewTransactions = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[1]/div/div[2]/div[3]/button"));
        if (viewTransactions.isDisplayed()==true) {
            viewTransactions.click();
            File screenshotFile7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile7, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\FundsInAsaas\\viewTransactions.png"));
            System.out.println("Ingresó a la opción Transactions");

        } else {
            System.out.println("No ingresó a la opción Transactions");

        }

        String lastTransaction = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div/div[2]/table/tbody")).getText();
        System.out.println("Confirmación datos últimas transacciones enviadas: " + lastTransaction );
        File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile1, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Transactions\\getTransactions.png"));






    }
}
