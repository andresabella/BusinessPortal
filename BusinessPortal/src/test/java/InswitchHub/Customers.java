package InswitchHub;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Customers extends BaseTestChrome {


    @Test
    public void viewCustomers() throws IOException, InterruptedException {

        chromeDriver.get("https://dashboard-ish.apps.ins.inswhub.com/login");
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement userName = chromeDriver.findElement(By.name("email"));
        if(userName.isDisplayed()){
            userName.clear();
            userName.sendKeys("andres.abella");
        } else {
            System.out.println("No se pudo ingresar el username");

        }

        WebElement password = chromeDriver.findElement(By.name("password"));
        if(password.isDisplayed()){
            password.clear();
            password.sendKeys("inswitch");
            //Tomar Screenshot
            File screenshotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Login.png"));
        } else {
            System.out.println("No se pudo ingresar el Password");

        }

        WebElement signIn = chromeDriver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        if(signIn.isDisplayed()){
            signIn.click();
        }else {
            System.out.println("No se pudo hacer Login correctamente");
        }

        Thread.sleep(300);

        WebElement sandBoxEnvironment = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[1]"));
        //Ambiente Producción
        //WebElement sandBoxEnvironment = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[2]"));
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(sandBoxEnvironment.isEnabled()){
            //chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul")).click();
            sandBoxEnvironment.click();
            File screenshotFile0 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile0, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Environment.png"));
            System.out.println("Ingresó correctamente a la opción de ambiente SandBox");

        } else {
            System.out.println("No está la opción de ambiente SandBox");
        }

        WebElement customersOption = chromeDriver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
        //WebElement customersOption = chromeDriver.findElement(By.xpath("//*[@id="root"]/div[2]/div/div/aside/div[4]/div/ul/div[4]/li/a/div/span"));
        if(customersOption.isDisplayed()){
            customersOption.click();
            File screenshotFile2 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\CustomerOptions.png"));
        } else {
            System.out.println("No se pudo cargar las opciones de usuario");
        }

        WebElement viewCustomers = new WebDriverWait(chromeDriver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary']")));
        if(viewCustomers.isDisplayed()){
            viewCustomers.click();
            Thread.sleep(900);
            //List<WebElement> listCustomers = chromeDriver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]"));
            String listCustomers = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[2]/table/tbody")).getText();
            System.out.println("/-------------------------------------------------------/");
            System.out.println("Los datos de los usuarios registrados son: " + listCustomers);
            System.out.println("/-------------------------------------------------------/");
            File screenshotFile3 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile3, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\Listado_clientes.png"));
        }else {
            System.out.println("No se pudo cargar el listado de clientes");
        }

        WebElement newCustomer = chromeDriver.findElement(By.xpath("//i[contains(text(),'library_add')]"));
        if(newCustomer.isDisplayed()){
            newCustomer.click();
            File screenshotFile4 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile4, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\newCustomer.png"));
        }else {
            System.out.println("No se pudo cargar la opción de crear nuevo cliente");
        }

        //Datos del nuevo usuario

        WebElement addCustomerType = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[2]/select"));
        if (addCustomerType.isDisplayed()) {
            addCustomerType.click();
            //Opción Natural Person
            chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[2]/select/option[1]")).click();
            System.out.println("Seleccionó la opción Natural Person");
            //Opción Legal Person
            //chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[2]/select/option[2]")).click();
            //System.out.println("Seleccionó la opción Legal Person");
            File screenshotFile5 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile5, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\CustomerType.png"));
        } else {
            System.out.println("No se encontró la opción de Customer Type");
        }

        //Add Document
        Actions action = new Actions(chromeDriver);
        WebElement customerAddDocument = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/div/div/div[1]/button"));
        action.moveToElement(customerAddDocument);
        if (customerAddDocument.isDisplayed()) {
            customerAddDocument.click();
            System.out.println("Opción de adicionar nuevo documento de Usuario seleccionado correctamente");

        } else {
            System.out.println("Opción de adicionar de documento no está");

        }

        WebElement customerIdType = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/select"));
        if (customerIdType.isDisplayed()) {
            customerIdType.click();
            //National ID
            chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/select/option[2]")).click();
            //Passport
            //chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/select/option[1]")).click();
            System.out.println("Tipo de documento del Usuario seleccionado correctamente");

        } else {
            System.out.println("El tipo de documento seleccionado no está");

        }

        WebElement customerIdNumber = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[2]/input"));
        if (customerIdNumber.isDisplayed()) {
            customerIdNumber.clear();
            customerIdNumber.sendKeys("1019049163");
            System.out.println("Número de documento del Usuario ingresado correctamente");

        } else {
            System.out.println("Número de documento no ingresado");

        }

        WebElement customerIssueDate = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[3]/input"));
        if (customerIssueDate.isDisplayed()) {
            customerIssueDate.sendKeys("09082015");
            System.out.println("Fecha de documento del Usuario ingresado correctamente");

        } else {
            System.out.println("Fecha de documento no ingresado");

        }

        WebElement customerExpiryDate = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[4]/input"));
        if (customerExpiryDate.isDisplayed()) {
            customerExpiryDate.sendKeys("10082030");
            System.out.println("Fecha expiración de documento del Usuario ingresado correctamente");

        } else {
            System.out.println("Fecha expiración de documento no ingresado");

        }

        WebElement customerIssuerPlace = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[6]/div/select"));
        if (customerIssuerPlace.isDisplayed()) {
            customerIssuerPlace.click();
            chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div/div/div[6]/div/select/option[48]")).click();
            System.out.println("País del documento del Usuario ingresado correctamente");

        } else {
            System.out.println("País del documento no ingresado");

        }

        WebElement customerConfirmAddDocument = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/button"));
        if (customerConfirmAddDocument.isDisplayed()) {
            customerConfirmAddDocument.click();
            File screenshotFile22 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile22, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerAddNewDocument.png"));
            System.out.println("Se adiciono un nuevo documento de Usuario correctamente");

        } else {
            System.out.println("No se adicionó el nuevo documento ingresado");

        }

        WebElement customerInfoAddDocument = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/div/div/div[2]/div/table/tbody"));
        if (customerInfoAddDocument.isDisplayed()) {
            customerInfoAddDocument.getText();
            File screenshotFile22 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile22, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerAddNewDocument.png"));
            System.out.println("Los datos del documento asociado son: " + customerInfoAddDocument);

        } else {
            System.out.println("No hay datos asociados al nuevo documento ingresado");

        }


        WebElement customerUserName = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[1]/div/div[1]/input"));
        if (customerUserName.isDisplayed()) {
            customerUserName.clear();
            customerUserName.sendKeys("NewUser10");
            System.out.println("UserName ingresado correctamente");
            File screenshotFile6 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile6, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerUserName.png"));

        } else {
            System.out.println("UserName no ingresado");

        }

        //Se retiró esta opción
        /*WebElement customerPassword = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[1]/div/div[2]/input"));
        if (customerPassword.isDisplayed()) {
            customerPassword.clear();
            customerPassword.sendKeys("1234");
            System.out.println("Password ingresado correctamente");
            File screenshotFile7 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile7, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerPassword.png"));

        } else {
            System.out.println("Password no ingresado");

        }*/

        Actions action1 = new Actions(chromeDriver);
        WebElement customerTitle = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[2]/div/div[1]/input"));
        action1.moveToElement(customerTitle);
        if (customerTitle.isDisplayed()) {
            customerTitle.clear();
            customerTitle.sendKeys("Mr");
            System.out.println("Titulo (Mr) ingresado correctamente");
            File screenshotFile8 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile8, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerTitle.png"));

        } else {
            System.out.println("Titulo (Mr) no ingresado");

        }

        WebElement customerFirstName = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[2]/div/div[2]/input"));
        if (customerFirstName.isDisplayed()) {
            customerFirstName.clear();
            customerFirstName.sendKeys("New User");
            System.out.println("Primer Nombre de Usuario ingresado correctamente");
            File screenshotFile9 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile9, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerFirstName.png"));

        } else {
            System.out.println("Primer Nombre de Usuario no ingresado");

        }

        Actions action2 = new Actions(chromeDriver);
        WebElement customerMiddleName = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[2]/div/div[3]/input"));
        action2.moveToElement(customerMiddleName);
        if (customerMiddleName.isDisplayed()) {
            customerMiddleName.clear();
            customerMiddleName.sendKeys("");
            System.out.println("Segundo Nombre de Usuario ingresado correctamente");
            File screenshotFile10 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile10, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerMiddleName.png"));

        } else {
            System.out.println("Segundo Nombre de Usuario no ingresado");

        }

        WebElement customerLastName = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[2]/div/div[4]/input"));
        if (customerLastName.isDisplayed()) {
            customerLastName.clear();
            customerLastName.sendKeys("");
            System.out.println("Apellido de Usuario ingresado correctamente");
            File screenshotFile11 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile11, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerLastName.png"));

        } else {
            System.out.println("Apellido Nombre de Usuario no ingresado");

        }

        Actions action3 = new Actions(chromeDriver);
        WebElement customerPhoneNumber = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[3]/div/div[1]/input"));
        action3.moveToElement(customerPhoneNumber);
        if (customerPhoneNumber.isDisplayed()) {
            customerPhoneNumber.clear();
            customerPhoneNumber.sendKeys("3192507363");
            System.out.println("Número de teléfono ingresado correctamente");
            File screenshotFile12 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile12, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerPhoneNumber.png"));

        } else {
            System.out.println("Número de teléfono no ingresado");

        }

        WebElement customerEmailAddress = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[3]/div/div[2]/input"));
        if (customerEmailAddress.isDisplayed()) {
            customerEmailAddress.clear();
            customerEmailAddress.sendKeys("andres.abella@inswitch.com");
            System.out.println("Email de Usuario ingresado correctamente");
            File screenshotFile13 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile13, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerEmailAddress.png"));

        } else {
            System.out.println("Email de Usuario no ingresado");

        }

        //Se retiró esta opción:
        /*Actions action4 = new Actions(chromeDriver);
        WebElement ownerFirstNamePhone = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[3]/div/div[3]/input"));
        action4.moveToElement(ownerFirstNamePhone);
        if (ownerFirstNamePhone.isDisplayed()) {
            ownerFirstNamePhone.clear();
            ownerFirstNamePhone.sendKeys("New User");
            System.out.println("Nombre del propietario de teléfono ingresado correctamente");
            File screenshotFile14 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile14, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\ownerFirstNamePhone.png"));

        } else {
            System.out.println("Nombre del propietario de teléfono no ingresado");

        }*/

        WebElement ownerLastNamePhone = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[3]/div/div[2]/input"));
        if (ownerLastNamePhone.isDisplayed()) {
            ownerLastNamePhone.clear();
            ownerLastNamePhone.sendKeys("Test");
            System.out.println("Apellido del propietario de teléfono ingresado correctamente");
            File screenshotFile15 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile15, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\ownerLastNamePhone.png"));

        } else {
            System.out.println("Apellido del propietario de teléfono de Usuario no ingresado");

        }

        Actions action5 = new Actions(chromeDriver);
        WebElement customerDateofBirth = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[1]/input"));
        action5.moveToElement(customerDateofBirth);
        if (customerDateofBirth.isDisplayed()) {
            customerDateofBirth.sendKeys("07311990");
            System.out.println("Fecha de nacimiento del usuario ingresada correctamente");
            File screenshotFile16 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile16, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerDateofBirth.png"));

        } else {
            System.out.println("Fecha de nacimiento del usuario no ingresada");

        }

        WebElement customerBirthCountry = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[2]/div/select"));
        if (customerBirthCountry.isDisplayed()) {
            customerBirthCountry.click();
            chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[2]/div/select/option[48]")).click();
            System.out.println("País de nacimiento del Usuario ingresado correctamente");
            File screenshotFile17 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile17, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerBirthCountry.png"));

        } else {
            System.out.println("País de nacimiento del Usuario no ingresado");

        }

        WebElement customerGender = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[3]/div/select"));
        if (customerGender.isDisplayed()) {
            customerGender.click();
            //Opcion Male
            chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[3]/div/select/option[3]")).click();
            //Opción Female
            //chromeDriver.findElement(By.xpath("//*[@id="root"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[3]/div/select/option[2]")).click();
            System.out.println("Género del Usuario ingresado correctamente");
            File screenshotFile18 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile18, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerGender.png"));

        } else {
            System.out.println("Género del Usuario no ingresado");

        }

        WebElement customerNationality = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[4]/div/select"));
        if (customerNationality.isDisplayed()) {
            customerNationality.click();
            //Opcion Male
            chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[4]/div/select/option[48]")).click();
            System.out.println("Nacionalidad del Usuario ingresada correctamente");
            File screenshotFile19 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile19, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerNationality.png"));

        } else {
            System.out.println("Nacionalidad del Usuario no ingresada");

        }

        Actions action6 = new Actions(chromeDriver);
        WebElement customerResidenceCountry = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[5]/div/select"));
        action6.moveToElement(customerResidenceCountry);
        if (customerResidenceCountry.isDisplayed()) {
            customerResidenceCountry.click();
            chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[5]/div/select/option[39]")).click();
            System.out.println("País de Residencia del usuario ingresado correctamente");
            File screenshotFile21 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile21, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\customerResidenceCountry.png"));

        } else {
            System.out.println("País de Residencia del usuario no ingresado");

        }

        Actions action7 = new Actions(chromeDriver);
        WebElement createCustomer = chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div[2]/div[3]/div[2]/div/div[4]/form/div[4]/div/div[5]/div/select"));
        action6.moveToElement(createCustomer);
        if (customerResidenceCountry.isDisplayed()) {
            customerResidenceCountry.click();
            File screenshotFile22 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile22, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\createCustomer.png"));
            System.out.println("Cliente creado");


        } else {
            System.out.println("No se logró crerar el cliente");

        }
        Thread.sleep(500);

        WebElement confirmCreateCustomer = chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]"));
        if (confirmCreateCustomer.isDisplayed()) {
            chromeDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button")).click();
            System.out.println("Confirmación de Usuario creado exitosamente");
            File screenshotFile13 = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile13, new File("C:\\Users\\Andres Abella Mora\\Pictures\\InsiwtchHub\\confirmCreateCustomer.png"));

        } else {
            System.out.println("Usuario no creado");

        }


    }
}
