package GIS;
import Geom.Point3D;
public class furit{
	//The class represents a collection of features for furit.
	//* @author yitzhak.
	private String name;
	private Point3D point;
	private String picture;
	private int id;
	//God the parameters that all Options the department uses:
	//@point represents for g.p.s.
	//@name 
	//@picture 
	//@id
	public furit(String name, Point3D point, String picture, int id) {
		this.name=name;
		this.setPoint(point);
		this.picture=picture;
		this.id=id;
	}
	/////*****geters and seters//////
	public furit () {//An empty constructor
	}
	public void setname(String name) {
		this.name=name;
	}
	public String getname() {
		return this.name;
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
	public Point3D getPoint() {
		return point;
	}
	public void setPoint(Point3D point) {
		this.point = point;
	}
}