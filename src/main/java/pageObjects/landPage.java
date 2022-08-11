package pageObjects;

import base.basePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;


public class landPage {
    WebDriver driver = basePage.driver;

    public void navUrl() {
        driver.get("https://cartoonize-lkqov62dia-de.a.run.app/");
    }

    public void uploadImage() throws InterruptedException, AWTException, IOException {
        driver.manage().window().maximize();
        //
        File folder = new File("C:\\Users\\E-LINE\\Desktop\\Fiverrr\\Rahaman_PhotoAuto\\src\\main\\resources\\uploadPhotos");
        File file[] = folder.listFiles();

        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                System.out.println("File name is " + file[i].getName());
                Thread.sleep(2500);
                driver.findElement(By.xpath("//div[@id='uploadimage']")).click();
                Thread.sleep(5000);

                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection strSel = new StringSelection("C:\\Users\\E-LINE\\Desktop\\Fiverrr\\Rahaman_PhotoAuto\\src\\main\\resources\\uploadPhotos\\" + file[i].getName());
                clipboard.setContents(strSel, null);
                Thread.sleep(5000);

                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_CONTROL);
                r.keyPress(KeyEvent.VK_V);
                r.keyRelease(KeyEvent.VK_V);
                r.keyRelease(KeyEvent.VK_CONTROL);

                Thread.sleep(5000);

                r.keyPress(KeyEvent.VK_ENTER);
                r.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(2500);

                String url = driver.findElement(By.xpath("//button[@class='ui primary button']/..")).getAttribute("href");
                System.out.println("URL is "+url);



                FileUtils.copyURLToFile(
                        new URL(url),
                        new File("C:\\Users\\E-LINE\\Desktop\\Fiverrr\\Rahaman_PhotoAuto\\src\\main\\resources\\downloadPhotos\\" + file[i].getName()));
                    }
            Thread.sleep(3300);
            this.navUrl();

                }

            }

            public void downloadImage () throws InterruptedException {
                Thread.sleep(5000);
                driver.findElement(By.xpath("//button[@class='ui primary button']")).click();

            }

            public void checkDownloaded () {
                String text = driver.findElement(By.xpath("")).getText();
                System.out.println(text);
            }
        }
