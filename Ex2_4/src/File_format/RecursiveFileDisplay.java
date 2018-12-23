package File_format;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Geom.Point3D;
import GIS.GISProject;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.GIS_project;

public class RecursiveFileDisplay {
	



		public static GIS_project projectCreator(String path) throws IOException {
			File currentDir = new File(path); // current directory
			ArrayList<String> list=displayDirectoryContents(currentDir);
			GIS_project project=new GISProject();
			for(String dir : list) {
				Csv2kml ck=new Csv2kml();
				GIS_layer layer=ck.layersCreator(dir);
				project.add(layer);
			}
			
			PrintWriter writer = new PrintWriter(new File("ex2_4.kml"));
		    writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		    writer.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		    writer.println("<Document>");
		    writer.println("<Folder>");
		    writer.println("<name/>");
		    for(GIS_layer layers: project) {
		    for (GIS_element element : layers) {
		        writer.println("<Placemark>");
		        writer.println("<name/>");
		       // Date date = new Date(element.getData().getUTC());
		        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        writer.println("<description><![CDATA[Timestamp: <b>" + element.getData().getUTC() + "</b><br/>Date: <b></b>]]></description>");
		        //writer.println("<description>");
		        writer.println("<Point>");
		        writer.println("<coordinates>" + ((Point3D) element.getGeom()).y() + "," + ((Point3D) element.getGeom()).x() + "," + ((Point3D) element.getGeom()).z() + "</coordinates>");
		        writer.println("</Point>");
		        writer.println("</Placemark>");
		    }
		    }
		    writer.println("</Folder>");
		    writer.println("</Document>");
		    writer.println("</kml>");
		    writer.close();
		    
		    System.out.println("Done!");
			return project;
		}

		public static ArrayList<String> displayDirectoryContents(File dir) {
			 ArrayList<String> alist=new ArrayList<String>(); 
		     

			try {
				File[] files = dir.listFiles();
				for (File file : files) {
					if (file.isDirectory()) {
					        

						System.out.println("directory:" + file.getCanonicalPath());
						alist.add(file.getCanonicalPath());
						displayDirectoryContents(file);
					} else {
						System.out.println("     file:" + file.getCanonicalPath());
						alist.add(file.getCanonicalPath());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		//System.out.println(alist.toString());
		
		return alist;
	}
	}





