// http://www.codeproject.com/Articles/879896/Programming-in-Java-using-the-MVC-architecture
package javaMVCModels;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloWorldModel {
	public String getData() throws FileNotFoundException, IOException {
		
		if (!(new File("C:\\file.txt").isFile())) {
			Files.createFile(Paths.get("C:\\file.txt"));
		}
		String data;
		
		// try-with-resourse block
		try (BufferedReader reader = new BufferedReader(
				new FileReader("C:\\file.txt"))) {
			StringBuilder string = new StringBuilder();
			
			// Read line-by-line
			String line = reader.readLine();
			string.append("<html>");
			while(line != null) {
				string.append(line);
				string.append("<br />");
				line = reader.readLine();
			}
			string.append("</html>");
			data = string.toString();
		} catch (Exception er) {
			data = er.getMessage();
		}
		return data;		
	}
	
	public boolean writeData(String data) throws IOException, FileNotFoundException
	{
		// Save teh data to the FIle
		try (BufferedWriter writer = new BufferedWriter(
									  new FileWriter("C:\\file.txt"))) {
			writer.write(data);;
			return true;
		} catch (Exception er) {
			return false;
		}
	}
}
