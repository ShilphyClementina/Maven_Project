package utility;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
    File  -> file location
    FileInputstream --> to read the file
    Property --> class --> create object
    .load
     */

public class FileReaderManager {

    private static FileInputStream fileInputStream;
    private static Properties property;

    private static void setupProperty(){
        File file = new File("D:\\Shilphy\\Testing\\Automation testing - Greens technologies\\Work Space\\IPT_Java_Project\\src\\main\\resources\\TestData.properties");
        try {
            fileInputStream = new FileInputStream(file);
             property = new Properties();
            property.load(fileInputStream);
        } catch (FileNotFoundException e) {
            Assert.fail("ERROR: OCCURRED DURING FILE LOADING");
        } catch (IOException e) {
            Assert.fail("ERROR: OCCURRED DURING FILE READING");
        }
    }
    public static String getDataProperty (String value){
          setupProperty();
          String data = property.getProperty(value);
          return data;
    }


}
