package view;

import java.io.IOException;

import controller.controller;
import controller.icontroller;

public class main {

	public static void main(String[] args) {
		icontroller controller = new controller();
		String path = "C:\\TEMP\\Aula";
		try {
			controller.readFile(path, "generic_food.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}