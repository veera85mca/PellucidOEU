package windowoeu;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Getscreenshot extends Tabtest{

public static void takescreenshot(String screenname) throws IOException
{
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File desfolder=new File(System.getProperty("user.dir")+File.separator+"Failedscreenshot"+File.separator+screenname+".png");
	FileUtils.copyFile(srcfile, desfolder);
}
}
