
public class Process {
	
	private double aTime, eTime;
	
	public Process(){}
	
	public Process(double aT, double eT){
		
		aTime = aT;
		eTime = eT;
		
	}

	public void setAr(double randA) {
		aTime = randA;
		
	}

	public void setEx(double randB) {
		eTime = randB;
		
	}

	public double getAr() {
		
		return aTime;
	}
	
public double getEx() {
		
		return eTime;
	}
	

}
