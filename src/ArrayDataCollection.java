
import java.util.Scanner;

public class ArrayDataCollection implements DataCollection {

	static Scanner scanner = new Scanner(System.in);
	private static int SIZE;
	private Process [] theProcesses;
	private int size;
	static final double lambda = .5;
	static final double mu = .6;
	private int selected;
	private int count;

	public ArrayDataCollection(int i){

		//System.out.print("Enter the amount of processes: ");
		SIZE = i;
		theProcesses = new Process[SIZE];
		size = 0;
	

	}

	public ArrayDataCollection() {
		this(SIZE);
	}

	

	@Override
	public void reset(Process someProcess) {
		int i = 0;							//	To run through the array
		changeSelected(-1);					//	In case we do not have a match
		while ( (selected == -1) && (i < size) ) {
			if ( theProcesses[i] == someProcess )
				changeSelected(i);
			i++;
		}

	}

	@Override
	public void reset() {

		changeSelected(0);

	}

	@Override
	public Process next() {
		Process result = null;

		if ((size > 0) && (selected >= 0) && (selected < size)){
			result = theProcesses[selected];
			changeSelected(selected + 1);
		}

		return result;
	}

	private void changeSelected(int i) {

		selected = i;

	}

	@Override
	public void add(Process someProcess) {

		if (selected == theProcesses.length) {
			Process[] temp = new Process[theProcesses.length * 2];
			for(int i = 0; i< theProcesses.length; i++)
				temp[i] = theProcesses[i];
			theProcesses = temp;
		}


		theProcesses[size] = someProcess;			//	Set the new element as		
		changeSelected(size++);	

	}

	@Override
	public boolean hasNext() {
		return (size > 0) && (selected >= 0) && (selected < size);
	}



}
