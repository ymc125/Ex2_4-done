package GIS;
import java.util.ArrayList;

import Geom.Point3D;
	//import javafx.scene.shape.Path;

	//The class represents a collection of features for pakmen.
	//* @author yitzhak.
public class pakmen{
	//God the parameters that all Options the department uses:
	private String name;
	private Point3D point;
	private double  speed;
	private double radius;
	private String picture;
	private int id;
	Pathh path_pak;
	//God the parameters that the department uses:
	// @point represents g.p.s.
	//@speed represents meter/second
	//@radius represents in meters.
	public pakmen( Point3D point, double  speed, double radius ) {
		this.point=point;
		this.speed=speed;
		this.radius=radius;
		path_pak=new Pathh();
		path_pak.list.add(this.point);
		
	}
/////*****geters and seters//////
	public String getName() {
		return name;
	}	
	public Pathh getPath_pak() {
		return path_pak;
	}
	public void setPath_pak(Pathh path_pak) {
		this.path_pak = path_pak;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point3D getPoint() {
		return point;
	}
	public void setPoint(Point3D point) {
		this.point = point;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}