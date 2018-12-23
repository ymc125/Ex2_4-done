package File_format;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import GIS.GISMetaData;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.Meta_data;
import GIS.GISElement;
import GIS.GISLayer;

import Geom.Point3D;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Csv2kml  {

	public GISLayer layersCreator (String path) throws  IOException{
	
    String csvFile = path;
    String line = "";
    String cvsSplitBy = ",";
    
    //GISLayer layer=new GISLayer();
    int count=1;
    //Set<GISElement> elements=new HashSet<GISElement>();
    GISLayer layer=new GISLayer();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
    {
    	
        while ((line = br.readLine()) != null) 
        {
        	
        	System.out.println();
            String[] geoInfo = line.split(cvsSplitBy);
            if( count > 3) {
           
            Meta_data data=new GISMetaData(geoInfo[0] ,geoInfo[1] ,geoInfo[2] ,geoInfo[3] ,geoInfo[4] ,geoInfo[5] ,geoInfo[9] ,geoInfo[10]);
            Point3D point=new Point3D(Double.parseDouble(geoInfo[6]),Double.parseDouble(geoInfo[7]),Double.parseDouble(geoInfo[8]));
            GISElement element=new GISElement(data,point);
            layer.add(element);
            }
        	else
        		count++;
        }

    } catch (IOException e) 
    {
    	System.out.println("##########");
        e.printStackTrace();
    }

 
   /* PrintWriter writer = new PrintWriter(new File("tryout2.kml"));
    writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    writer.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
    writer.println("<Document>");
    writer.println("<Folder>");
    writer.println("<name/>");
    for (GIS_element element : layer) {
        writer.println("<Placemark>");
        writer.println("<name/>");
       // Date date = new Date(element.getData().getUTC());
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //    writer.println("<description><![CDATA[Timestamp: <b>" + element.getData().getUTC() + "</b><br/>Date: <b>" + df.format(date) + "</b>]]></description>");
        //writer.println("<description>");
        writer.println("<Point>");
        writer.println("<coordinates>" + ((Point3D) element.getGeom()).y() + "," + ((Point3D) element.getGeom()).x() + "," + ((Point3D) element.getGeom()).z() + "</coordinates>");
        writer.println("</Point>");
        writer.println("</Placemark>");
    }
    writer.println("</Folder>");
    writer.println("</Document>");
    writer.println("</kml>");
    writer.close();*/
    return layer;

}
	
	
	
}
