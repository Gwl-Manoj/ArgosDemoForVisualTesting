package commonFunctions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.WebDriverBase;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CommonFunctions 
{
	boolean flag;
	WebDriverBase webDB = new WebDriverBase();
	public void capturescreenshot() {
//        // Set up the ChromeDriver path
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        
        // Initialize WebDriver
//        WebDriver driver = new ChromeDriver();

        try {
            // Open the target webpage
//            driver.get("https://gwl:gwl@automatepro.galaxyweblinks.com/");

            // Capture full-page screenshot
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(webDB.getDriver());

            // Save the screenshot to a file
            ImageIO.write(screenshot.getImage(), "PNG", new File("fullpage-screenshot.png"));

            System.out.println("Full-page screenshot captured successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
//            driver.quit();
        }
    }
	
	public boolean setBrowserResolution(int width, int height)
	{
		Dimension size = new Dimension(width, height);
		webDB.getDriver().manage().window().setSize(size);
		
		return flag;
	}

}
