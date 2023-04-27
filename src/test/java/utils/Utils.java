package utils;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    /**
     * takescreenshots
     */
    public static void takeScreenShot() {
        takeScreenShot("screenshot");
    }

    /**
     * @param fileName filename of the screenshot
     */
    public static void takeScreenShot(String fileName) {
        fileName = fileName + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String filePath = "screenShot/" + fileName + ".png";
        TakesScreenshot scrShot = ((TakesScreenshot) Driver.getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    // todo: bu metoda çalış!!!
    /**
     * create directory if not exist
     *
     * @param fileWithPath
     */
    public static void createDirectory(String fileWithPath) {
        String[] pathArray = fileWithPath.split("/");
        String path = "";
        if (pathArray.length > 0) {
            for (int i = 0; i < pathArray.length - 1; i++) {
                path += pathArray[i] + "/";
            }
        }
        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }


    /**
     * java sleep
     *
     * @param millis milliseconds
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    // todo: bu metoda çalış!
    /**
     * file exist mi(mevcut mu?)
     *
     * @param fileWithPath file with path
     * @return boolean
     */
    public static boolean isFileExist(String fileWithPath) {
        File f = new File(fileWithPath);
        return f.exists() && !f.isDirectory();
    }




}
