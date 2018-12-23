package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {

	//A fixed radius of the earth
	private final int radius=6371000;

	@Override
	//Adds to a floating point, vector in meters
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) throws RuntimeException {
	//Check that the point is correct
		if (!isValid_GPS_Point(gps)) {
			throw new RuntimeException("Invalid point");
		}
		//Converts the point in meters to a floating point.
		//"x" Represents "lat". "y" Represents "lon". "z" Represents "alt".
		double x= Math.asin(local_vector_in_meter.x()/radius);
		x = x / Math.PI *180;
		x = gps.x() -x;
		
		double y=Math.asin(local_vector_in_meter.y()/(radius *  Math.cos(gps.x()/Math.PI/180)));
		y = y / Math.PI * 180;
		y=gps.y() - y;
		
		double z= gps.z()+local_vector_in_meter.z();
		return new Point3D (x,y,z);
	
	}
//gps0-start. gps1-end.
	@Override
	public double distance3d(Point3D gps0, Point3D gps1)  throws RuntimeException {//��� 100 �"� ����� �������
		
		if (!isValid_GPS_Point(gps0) || !isValid_GPS_Point(gps1)) {
			throw new RuntimeException("Invalid point");
		}
		
		double diff_lat = gps1.x() - gps0.x();
		double diffR_lat = diff_lat * Math.PI / 180;
		double toMeter_lat = Math.sin(diffR_lat) * radius;
		
		double diff_lon = gps1.y() - gps0.y();
		double diffR_lon = diff_lon *Math.PI / 180;
		double toMeter_lon = Math.sin(diffR_lon) * radius * Math.cos(gps0.x() * Math.PI/180);

		double disstance=Math.sqrt(toMeter_lat * toMeter_lat + toMeter_lon * toMeter_lon);
		
		return disstance;
	}
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1)   throws RuntimeException {
		
		//if (!isValid_GPS_Point(gps0) || !isValid_GPS_Point(gps1)) {
			//throw new RuntimeException("Invalid point");
		
		double diff_lat = gps1.x() - gps0.x();
		double diffR_lat = diff_lat * Math.PI / 180;
		double toMeter_lat = Math.sin(diffR_lat) * radius;
		
		double diff_lon = gps1.y() - gps0.y();
		double diffR_lon = diff_lon *Math.PI / 180;
		double toMeter_lon = Math.sin(diffR_lon) * radius * Math.cos(gps0.x() * Math.PI/180);
		 
		double diff_alt=gps1.z()-gps0.z();
		
		return new Point3D (toMeter_lat, toMeter_lon, diff_alt);
			}	
	
	

//https://stackoverflow.com/questions/9457988/bearing-from-one-coordinate-to-another
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		
		//protected static double bearing(double lat1, double lon1, double lat2, double lon2){
			 //azimut
			  double longitude1 = gps0.x();
			  double longitude2 = gps1.x();
			  double latitude1 = Math.toRadians(gps0.y());
			  double latitude2 = Math.toRadians(gps1.y());
			  double longDiff = Math.toRadians(longitude2-longitude1);
			  double y = Math.sin(longDiff)*Math.cos(latitude2);
			  double x = Math.cos(latitude1)*Math.sin(latitude2)-Math.sin(latitude1)*Math.cos(latitude2)*Math.cos(longDiff);
			  double azimuth = (Math.toDegrees(Math.atan2(y, x))+360)%360;
		
			 //distance
			  double dist=distance3d(gps0,gps1);
					
			 //elevation
			  double alt = (gps1.z()-gps0.z());
			  double elevation = Math.toDegrees((Math.asin(alt/dist)));
			  
			 //get arr
			  double [] arr = {azimuth,elevation,dist};
			  return arr;
			}


	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if ((p.x()>=-90 && p.x()<=90)
		&& (p.x()>=-180 && p.x()<=180)
		&& (p.z()>=-450))
			return true;
		return false;
			
	}

}
