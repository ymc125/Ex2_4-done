package GIS;
import java.util.ArrayList;
import java.util.Iterator;
import Geom.Point3D;
//The class represents  A department that suits pakmen and furit.
//* @author yitzhak.
public class ShortestPathAlgo {
	public game game;
	public ArrayList<furit> fur_temp=new ArrayList<>();
	public ArrayList<pakmen> pak_temp=new ArrayList<>();
	public ArrayList<pointalgo> pointalgo=new ArrayList<>();
	//Perform deep copy
	public ShortestPathAlgo(ArrayList<furit> fur_temp,ArrayList<pakmen> pak_temp) {
		this.	fur_temp.addAll(fur_temp);
		this.pak_temp.addAll(pak_temp);
		this.game=game;
	}
	//The main function works recursively and you call the CLOSE class. 
	//And check for the fruit we chose if there is a faster Pacman to reach it.
	public int algo() {
		{
			if(this.isEmpty()) {
				return -1;
			}
			ArrayList<pointalgo> closs=new ArrayList<pointalgo>();
			closs(pak_temp,fur_temp);
			Iterator<pointalgo> clo = pointalgo.iterator();
			pakmen pa=null;
			furit fur=null;double time=Double.MAX_VALUE;
			while(clo.hasNext()) {
				pointalgo p=clo.next();
				double timetop=p.getTime();
				if (timetop< time ) {
					time=timetop;
					fur= p.getFurit();
					pa=p.getPakmen();
				}
			}
			//A specific fruit is added to each specific pacman that fits its orbit.
			pa.getPath_pak().list.add(fur.getPoint());
			fur_temp.remove(fur);	
		}
		return algo();
	}
	//A department that receives a collection of fruits and pakmens 
	//and returns a special point containing a fruit , pakmen  and time.
	public void closs(ArrayList<pakmen> pak_temp, ArrayList<furit> fur_temp ) {
		double dis=0, distop=Integer.MAX_VALUE;
		furit fur=null, bestfurit=null; pakmen pak=null;Point3D position=null;
		Iterator<pakmen> pakmen = game.pakmen.iterator();
		while(pakmen.hasNext()) {
			pak=(pakmen) pakmen.next();
			position=pak.path_pak.list.get(pak.path_pak.list.size()-1);
			Iterator<furit> furit = game.furit.iterator();
			while(furit.hasNext()) {
				fur=(furit) furit.next();
				dis=position.distance2D( fur.getPoint());
				if (dis<distop)
					distop=dis;
				bestfurit=fur;
			}
			double time=(distop-pak.getRadius())/pak.getSpeed();
			pointalgo.add(new pointalgo(bestfurit, pak, time));
		}
	}
	private double distance3d(Point3D point3d, Point3D point3d2) {
		// TODO Auto-generated method stub
		return 0;
	}
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	private void addAll(String fruits) {
		// TODO Auto-generated method stub
	}
}