import base.basePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.landPage;
import java.awt.*;
import java.io.IOException;

public class run {
    basePage bp = new basePage();
    @BeforeClass
    public void setUp(){
        bp.setUp();
    }

    @Test
    public void runRobot() throws InterruptedException, AWTException, IOException {
        landPage lp = new landPage();
        lp.navUrl();
        lp.uploadImage();
      //  lp.downloadImage();
      //  lp.checkDownloaded();
    }

    @AfterClass
    public void closeDriver(){
        bp.tearDown();
    }
}
