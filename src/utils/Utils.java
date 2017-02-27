package utils;

import java.io.*;
import java.util.Properties;

public class Utils {

    /**
     * This is a method for reading property files
     * @param path The path of file destination
     * @return The {@link Properties} object of read file text
     */
    public static Properties readProperties(String path) {
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    /**
     * This is a method for reading any file
     * @param path The path of file destination
     * @return The {@link String} object of read file text
     */
    // TODO change this method using ArrayList<String>
    public static String readTextFromFile(String path) {
        String text = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String lineContents;
            while ((lineContents = reader.readLine()) != null)
                text+=lineContents + " ";
            reader.close();
            return text;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
