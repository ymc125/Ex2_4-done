package GIS;

import Geom.Point3D;

public class range {


	public Point3D gpstopixel (Point3D  rr, int Height, int Width) 
	{	
		return new Point3D((int) Width * rr.x(),(int) Height * rr.y());			
	}

	public Point3D pixeltogps (Point3D  rr,double Height,double Width )
	{
		return new Point3D((float)rr.x() / Width,(float)rr.y() / Height);			
	}
//להוסיף את הדבר השלישי שרוצים בהינתן נקודה בין מינימום למשקסימום

//	public Point3D ranj (Point3D min, Point3D max, Point3D point) {
//
//		double p1 = (point.y()-min.y())/(max.y()-min.y());
//		double p2 = (point.x()-min.x())/(max.x()-min.x());
//
//		return new Point3D(p1,p2);		
//	}



}
