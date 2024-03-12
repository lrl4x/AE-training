package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends Tests{
    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */
//   breakout task (15) - write some logs in that 'FileUploadTest'
////    Steps to implement logging:
////    add the pom.xml dependency
////    create the sample properties file
////    create the logger configuration in your base test class
////    use the logger object in your test class


    @Test
    public void uploadFile(){
        String filePath = "C:/Users/Admin/Desktop/images/2022_76.webp";
        String url ="https://the-internet.herokuapp.com/upload";


        logger.info("Starting the file upload test.");


        logger.info(" Navigating to: " + url);
        driver.get(url);

        logger.info("Uploading file from path: " + filePath);
        By fileUploadInput = By.xpath("//input[@type='file'][1]");
        driver.findElement(fileUploadInput).sendKeys(filePath);


        logger.info("Submitting the file upload form.");
        By submitButton = By.id("file-submit");
        driver.findElement(submitButton).click();

        By checkFile = By.tagName("h3");
        String uploadSuccessMessage = driver.findElement(checkFile).getText();
        logger.info("Verifying the file upload success message.");
        Assertions.assertEquals("File Uploaded!", uploadSuccessMessage, "Expected and actual success messages do not match.");


        logger.info("File upload test completed successfully.");
    }
}
