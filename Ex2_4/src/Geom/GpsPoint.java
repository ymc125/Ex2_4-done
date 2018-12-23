package Geom;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;
@XmlRootElement
public class GpsPoint implements Geom_element  {
 
	private double lat;
	private double lon;
	private double alt;
	@XmlElement
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	@XmlElement
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	@XmlElement
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	@Override
	public double distance3D(Point3D p) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double distance2D(Point3D p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
