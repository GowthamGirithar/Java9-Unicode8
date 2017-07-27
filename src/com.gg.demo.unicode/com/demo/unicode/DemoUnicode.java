package com.demo.unicode;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.PropertyResourceBundle;

/**
 * Class to describe the java 9 features of Internationalization in JDK 9
 * Java 9 Features Demo with modular development.
 * @author Gowtham Girithar Srirangasamy
 * 
 *
 */
public class DemoUnicode {
	/**
	 * For input.properties the content is 
	 *  key =€ / \u20AC
     *  mood = 😎 / \uD83D\uDE0E
     *  chineese = 你好
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/** demo for PropertyResourceBundle and Properties */
		withPropertyResourceBundle(new FileInputStream("input.properties"));
		withProperties(new FileInputStream("input.properties"));
	}
	/**
	 * This method will read the value from the property file and write into the another one.
	 * This method will print the actual characters.
	 * @param propertyFile
	 * @throws IOException
	 */
	private static void withPropertyResourceBundle(InputStream propertyFile) throws IOException {
		/** the text file is created becuasue the console might not have UTF-8 support for many*/
		PrintWriter writer = new PrintWriter("output_1.txt", "UTF-8");
		PropertyResourceBundle properties = new PropertyResourceBundle(propertyFile);
		/** iterate and print the values*/
		properties.getKeys().asIterator().forEachRemaining(key -> {
			String value = properties.getString(key);
			/** Printing the value will help for whom UTF-8 will be supported*/
			System.out.println(key + " = " + value);
			/**printing in file*/
			writer.println(key + " = " + value);

		});
		/**closing the resources*/
		writer.close();
	}
	/**
	 * This method will read the value from the property file and write into the another one.
	 * @param propertyFile
	 * @throws IOException
	 */
	private static void withProperties(InputStream propertyFile) throws IOException {
		/** the text file is created becuasue the console might not have UTF-8 support for many*/
		PrintWriter writer = new PrintWriter("output_2.txt", "UTF-8");
		Properties properties = new Properties();
		/**load the property files*/
		properties.load(propertyFile);
		properties.forEach((key, value) -> {
			/** Printing the value will help for whom UTF-8 will be supported*/
			System.out.println(key + " = " + value);
			/**printing in file*/
			writer.println(key + " = " + value);
		});
		/**closing the resources*/
		writer.close();

	}

}
