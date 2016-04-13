
public class SortableDataOrganizer extends DataOrganizer {

	/**
	 * Default constructor
	 * @param size 
	 */

	private int s;
	
	public SortableDataOrganizer() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("Select a number corresponding "
				+ "to a scheduling scheme: 1) FCFS "
				+ " 2) SJF  3) LJF  4) RR");
		s = scanner.nextInt();
		if(s == 1){
			fcfs();
		}
		else if(s == 2){
			sjf();
		}
		else if(s == 3){
			ljf();
		}
		else if(s==4){
			rr();
		}
	}
	
private void rr() {
	sort();
	collection.reset();
	
		
	}

private void ljf() {
		sort();
		collection.reset();
		results();
		
	}



private void sjf() {
		sort();
		collection.reset();
		results();
		
	}

private void fcfs() {
		sort();
		collection.reset();
		results();
		
	}

private void results() {
	int i = 0;
	double wT;
	double tT;
	double cT = 0;
	double fT;
	double tTavg = 0;
	double wTavg = 0;
	Process someProcess;
	while (collection.hasNext()) {
		someProcess = collection.next();
		double aT = someProcess.getAr();
		double eT = someProcess.getEx();
		
		if(i == 0)
			wT = 0;
		else
			wT = cT-aT;
		fT = aT + wT + eT;
		tT = fT - aT;
		tTavg += tT;
		wTavg += wT;
		cT=fT;
		
		
		System.out.print("Process: ");
		System.out.print(i);
		System.out.print("-- Arival Time: ");
		System.out.print(aT);
		System.out.print("-- Execution Time: ");
		System.out.print(eT);
		System.out.print("-- Wait Time: ");
		System.out.print(wT);
		System.out.print("-- Finish Time: ");
		System.out.print(fT);
		System.out.print("-- Turn Time: ");
		System.out.print(tT);
		System.out.print("-- Current Time: ");
		System.out.println(cT);
		i++;
	}
	System.out.print("-- Wavg Time: ");
	System.out.println(wTavg/i);
	System.out.print("-- Tavg Time: ");
	System.out.println(tTavg/i);
	
}

public void sort(){
		
		//sort collection in merge sort method
		//set as new collection
		collection  = mergeSplit(collection);
		//unHighlight items and reset
		collection.reset(null);
		
	}

	/**
	 * This is our recursive method which splits
	 * 
	 * @param collection
	 * @return
	 */
	public DataCollection mergeSplit(DataCollection collection){				
		
		//reset list for starting position 
		collection.reset();
		//updates the number of objects 
		//in the collection
		int size = getSize(collection);
		//middle of the collection
		int middle = size / 2;
		
		//if there isn't a collection
		//or only one object 
		if (collection == null || size <= 1)	
		{		
			return collection;
		}
		
		else{
			
			//creating an object for each half 
			//of the collection called recursively
			DataCollection head1 = new ArrayDataCollection();
			DataCollection head2 = new ArrayDataCollection();

			//loop through the list and add 
			//each object to the first collection
			//until middle is reached
			for (int i = 0; i < middle; i ++){ 
				head1.add((Process)collection.next());
			}
			
			//loop through the list and add 
			//each object to the second collection
			//until reaching the end 
			for(int i = middle; i<size; i++ ){
				head2.add((Process)collection.next());
			}
			
			//recursive call to merge sort 
			//method for each head
			head1 = mergeSplit (head1);
			head2 = mergeSplit (head2);	

			//calls merge method sending both heads 
			//as parameters and returns the result
			return mergeSort(head1, head2);
		}

	}

	/**
	 * This method sorts the collection and then merges them together
	 * @param head1
	 * @param head2
	 * @return
	 */
	private DataCollection mergeSort(DataCollection head1, DataCollection head2)	
	{
		//reset both collections 
		head1.reset();
		head2.reset();
		
		//collection object used to add objects 
		//as the collections are sorted
		DataCollection result = new ArrayDataCollection();
		
		//objects to hold references to the items
		Process p1 = head1.next();
		Process p2 = head2.next();
		
		
		//while both items are not null they are
		//compared and the smaller item is added
		//to the result collection
		while(p1 != null && p2 != null){
			if(s==1 || s==4){
			if(((Process)p1).getAr() >= ((Process)p2).getAr()){
				
				result.add((Process)p2);
				p2 = head2.next();
				
			}
			
			
			else if(((Process)p2).getAr() > ((Process)p1).getAr()){
				
				result.add((Process)p1);
				p1 = head1.next();
				
			}
			}
			else if(s==2){
				if(((Process)p1).getEx() >= ((Process)p2).getEx()){
					
					result.add((Process)p2);
					p2 = head2.next();
					
				}
				
				
				else if(((Process)p2).getEx() > ((Process)p1).getEx()){
					
					result.add((Process)p1);
					p1 = head1.next();
					
				}
			}
			else if(s==3){
				if(((Process)p1).getEx() <= ((Process)p2).getEx()){
					
					result.add((Process)p2);
					p2 = head2.next();
					
				}
				
				
				else if(((Process)p2).getEx() < ((Process)p1).getEx()){
					
					result.add((Process)p1);
					p1 = head1.next();
					
				}
			}
			
			
		}
		
		//adds remaining items if either 
		//item 1 or 2 is null and pulls out 
		//of the sorting algorithm above
		if(p2 == null){
			while(p1 != null){
				
				result.add((Process)p1);
				p1 = head1.next();
			}
		}
		else{
			while(p2 != null){
				
				result.add((Process)p2);
				p2 = head2.next();
			}
		}

		//result is returned to the 
		//mergeSplit metod
		
		return result;
	}
	
	/**
	 * Determines the size of the collection
	 * @param someCollection
	 * @return
	 */
	public int getSize(DataCollection someCollection){
		
		//size counter
		int s = 0;
		
		
		//loops through the collection
		//and increments our counter
		while(someCollection.hasNext()){
			someCollection.next();
			s++;
		}
		
		//reset the collection
		someCollection.reset();
		//return integer size
		return s;
	}

}
