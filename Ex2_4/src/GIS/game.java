package GIS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * this class represents a converter from CSV files to KML files.
 * read more:
 * https://en.wikipedia.org/wiki/Comma-separated_values
 * https://en.wikipedia.org/wiki/Keyhole_Markup_Language
 * 	@author yitzhak.
 *
 */
public class game {
	//The department represents a collection of fruits and pakmens
ArrayList< pakmen> pakmen;
ArrayList<furit> furit;
	private static final String furit = null;/////******////
	/**
	 * function is used to read a csv file, split each line by commas and then create a Document object. the Document object will be ready to use
	 * @param path
	 * @return
	 */
	public ArrayList<game> read(String csvFile) {
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			ArrayList<game> colP=new ArrayList<game>();
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] lineData = line.split(cvsSplitBy);
				game place=new game();
				place.setName(lineData[0]);
				place.setId(lineData[1]);
				place.setPoint(lineData[3]+","+lineData[2]+","+lineData[4]);
				place.setSpeed(lineData[5]);
				place.setRadius(lineData[6]);
				colP.add(place);
			}
			return colP;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	//A constructor who gets Impulsive
	public game () {
	}
	//A constructor who gets parmetrs. 
	public game(String name, String point, String speed, String radius, String picture, String id) {
		this.name=name;
		this.point=point;
		this.speed=speed;
		this.radius=radius;
		this.picture=picture;
		this.id=id;
	}
	//A constructor who gets pakmen.
	public game(pakmen p) {
		this.name=p.getname();
		this.point=p.getPoint();
		this.speed=p.getSpeed();
		this.radius=p.getRadius();
		this.picture=p.getPicture();
		this.id=p.getId();
	}
	//A constructor who gets furit.
	public game(furit f) {
		this.name=f.getname();
		this.point=f.getPoint();
		this.speed="0";
		this.radius="0";
		this.picture=f.getPicture();
		this.id=f.getId();	
	}
	////**Private variables///
	private String name;
	private String point;
	private String speed;
	private String radius;
	private String picture;
	private String id;
	/////*****geters and seters//////
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getRadius() {
		return radius;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static String getfurit() {
		return furit;
	}

	}


