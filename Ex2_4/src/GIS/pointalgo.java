package GIS;

public class pointalgo {
	furit furit;
	pakmen pakmen;
	public furit getFurit() {
		return furit;
	}

	public void setFurit(furit furit) {
		this.furit = furit;
	}

	public pakmen getPakmen() {
		return pakmen;
	}

	public void setPakmen(pakmen pakmen) {
		this.pakmen = pakmen;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	double time;

	public pointalgo() {
	}

	public pointalgo(furit furit,pakmen pakmen,double time) {
		this.furit=furit;
		this.pakmen=pakmen;
		this.time=time;
	}

}