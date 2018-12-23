package GIS;

import java.io.IOException;

import File_format.RecursiveFileDisplay;

public class check {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String path="C:\\Users\\ym126\\Desktop\\Ex2\\data";
		RecursiveFileDisplay mc=new RecursiveFileDisplay();
		GIS_project gisp=mc.projectCreator(path);
		System.out.println("done");
	}

}
