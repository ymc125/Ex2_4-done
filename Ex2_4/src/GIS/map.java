  package GIS;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import Geom.Point3D;
//Allows you to upload an image file
//Represented by image dimensions in length and width;
//@ wight
//@ height
public class map { 
	private BufferedImage picture;
	private int wight;
	private int height;
	public BufferedImage getPicture() {
		return picture;
	}
	/////*****geters and seters//////
	public int getWight() {
		return wight;
	}
	public void setWight(int wight) {
		this.wight = wight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	//If there is a corrupted file upload then it informs πεθ
	//IOException
	public map() throws IOException {
		picture=ImageIO.read(new File("C:\\Users\\ym126\\Desktop\\Ex3\\Ariel1"));
		this.height =picture.getHeight();
		this.wight= picture.getWidth();
	}
	//I have calculated the image itself without linking functions
	//I calculated the dimensions of the image by overlapping the image in Google Earth
	//I missed between the GPS points represented in the decimal view
	//I divided the width of the image by the subtraction result between them and the numbers that went along the length and width
	//153809.29563967     ,     117668.47300174    
	public ArrayList<game> pixeltorad(ArrayList<game> a){
		for (int i=0; i<=a.size(); i++)
		{
		String[] s=a.get(i).getPoint().split(",");
		double y = 32.105978 - (Double.parseDouble(s[1])/153809.29563967);
		double x = 35.212525 + (Double.parseDouble(s[0])/117668.47300174);
		a.get(i).setPoint(x+","+y+","+0);
					}
		return a;
	}
	public ArrayList<game> radtopixel(ArrayList<game> a){
		for (int i=0; i<=a.size(); i++)
		{
		String[] s=a.get(i).getPoint().split(",");
		int y = (int)(32.105978 - (Double.parseDouble(s[1])*153809.29563967));
		int x = (int)(( (Double.parseDouble(s[0])-35.212525 )*117668.47300174));
		a.get(i).setPoint(x+","+y+","+0);
					}
		return a;
	}
}
  		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	