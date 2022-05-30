package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class controller implements icontroller {
	
	public controller() {
		super();
	}

	@Override
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		File dir = new File(path);
		if(!dir.exists() && !dir.isDirectory())
			throw new IOException("Pasta invalida");
		
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("Fruits")) {
					linha = linha.replace(",", "\t");
					linha = linha.replace("Fruits", "");
					linha = linha.replace("NULL", "");
					
					System.out.println(linha);
					linha = buffer.readLine();
				}
				linha = buffer.readLine();		
			}
			buffer.close();
		} else {
			throw new IOException("Arquivo invalido");
		}
	}

}