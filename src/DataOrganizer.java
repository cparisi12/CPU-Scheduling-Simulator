
import java.util.Scanner;


public class DataOrganizer {

	private static final double lambda = .4;
	private static final double mu = .8;
	protected DataCollection collection;
	static Scanner scanner = new Scanner(System.in);


	
	
	public DataOrganizer()
	{
		System.out.print("Enter the amount of processes: ");
		int i = scanner.nextInt();
		
		
		collection = new ArrayDataCollection(i);
		for(int j = 0; j<i; j++){
			double randA = (-Math.log(Math.random()))/lambda;
			double randB = (-Math.log(Math.random()))/mu;
			
			Process temp = new Process();
			temp.setAr(randA);
			temp.setEx(randB);
			collection.add(temp);
		}
		
		
	}
	
	


	
}
