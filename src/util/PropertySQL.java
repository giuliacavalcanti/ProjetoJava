package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertySQL {
	Properties property = new Properties();
	FileInputStream fs;
	
	public String sqlSentences(String key) throws FileNotFoundException{
		//apontar para o arquivo de properties
		fs = new FileInputStream(System.getProperty("user.dir") + "\\ SQLSentences.properties");
		try {
			//carregar o arquivo de properties
			property.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//a partir do arquivo carregado, a gente retorna a string
		return property.getProperty("key");
	
	}
}
