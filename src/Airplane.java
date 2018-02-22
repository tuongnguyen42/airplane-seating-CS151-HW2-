
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Airplane {
	private EconomyClass ec;
	private FirstClass fc;
	private String posPref;


	Airplane(EconomyClass ec,FirstClass fc){
		this.ec = ec;
		this.fc = fc;
	}
	

	
	private boolean seatAvailableEco(String row,String column) {
		return ec.getSeatChart().get(row+column);
		
	}
	private boolean seatAvailableFirst(String row,String column) {
		return fc.getSeatChart().get(row+column);
		
	}
	
	public void printSeat() {
		
		String outputEc= "";
		String outputFc ="";

		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 6; j++) {

				if(outputEc.length()%8 ==0) {
					outputEc +="\n";
				}
				
				if (outputEc.length()%4 == 0) {
				outputEc += " ";
				}	
				if(ec.getSeatChart().get(String.valueOf(i)+String.valueOf(j))) {
					outputEc +="*";
				}				
				if(!ec.getSeatChart().get(String.valueOf(i)+String.valueOf(j))) {
					outputEc +="x";
				}
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {

				if(outputFc.length()%6 ==0) {
					outputFc +="\n";
				}
				
				if (outputFc.length()%3 == 0) {
					outputFc += " ";
				}	
				if(fc.getSeatChart().get(String.valueOf(i)+String.valueOf(j))) {
					outputFc +="*";
				}				
				if(!fc.getSeatChart().get(String.valueOf(i)+String.valueOf(j))) {
					outputFc +="x";
				}
			}
		}
		System.out.println("*******FIRST CLASS SEATS*******");
		System.out.println(outputFc);
		System.out.println("\n\n*******ECONOMY SEATS*******");
		System.out.println(outputEc);

	}
	
	public void addPassenger() {

		String leftColumn = "0";
		String rightColumn = "0";
		Passenger[] p = input();
		Queue<String> prefQ= new LinkedList<String>();
		

		
		for (int j = 0; j < p.length; j++) {
			if(p[0].getClassPref().equals("E")) {
				if(p[j].getSeatingPref().equals("W")) {
					leftColumn = "0";
					rightColumn = "5";
				}
				if(p[j].getSeatingPref().equals("M")) {
					leftColumn = "1";
					rightColumn = "4";
				}
				if(p[j].getSeatingPref().equals("I")) {
					leftColumn = "2";
					rightColumn = "3";
				}

			}
			
			if(p[0].getClassPref().equals("F")) {
				if(p[j].getSeatingPref().equals("W")) {
					leftColumn = "0";
					rightColumn = "3";
				}

				if(p[j].getSeatingPref().equals("I")) {
					leftColumn = "1";
					rightColumn = "2";
				}

			}
			
			
			if (p[0].getClassPref().equals("E")) {
				for (int i = 0; i < 30; i ++) {
					if (seatAvailableEco(String.valueOf(i), leftColumn)) {
						ec.seatChart.put(String.valueOf(i)+leftColumn, false);
						System.out.println("Passenger(s) added!");
						break;

					}
					if (seatAvailableEco(String.valueOf(i), rightColumn)) {
						ec.seatChart.put(String.valueOf(i)+rightColumn, false);
						System.out.println("Passenger(s) added!");
						break;

					}
						
				}

			}
			if (p[0].getClassPref().equals("F")) {
				for (int i = 0; i < 5; i ++) {
					if (seatAvailableFirst(String.valueOf(i), leftColumn)) {
						fc.seatChart.put(String.valueOf(i)+leftColumn, false);
						System.out.println("Passenger(s) added!");
						break;
					}
					if (seatAvailableFirst(String.valueOf(i), rightColumn)) {
						fc.seatChart.put(String.valueOf(i)+rightColumn, false);
						System.out.println("Passenger(s) added!");
						break;
					}

				}


			}
		}
		
		if (ec.getSeatChart().size() == 180-1 && fc.getSeatChart().size() == 30-1)
			System.out.println("Plane is full!");



		
	}

	

	public static Passenger[] input() {
		Scanner scan = new Scanner(System.in);
		String classPref;
		String seatPref;
		int numPass;
		
		System.out.println("Please enter class (F for first class, E for economy");
		classPref = scan.nextLine();
		System.out.println("Number of passengers");
		numPass = scan.nextInt();
		Passenger[] passengerArr = new Passenger[numPass];
		if(numPass == 1) {
			System.out.println("Please enter seat preference (W for window, M for middle, I for isle)");
			seatPref = scan.next();
			passengerArr[0] = new Passenger(seatPref, classPref);
		}
		else if(numPass >1) {
			for(int i = 0; i< numPass; i++) {
				System.out.println("Please enter seat preference for passenger " + (i+1) + " (W for window, M for middle, I for isle)");

					seatPref = scan.next();

				passengerArr[i] = new Passenger(seatPref, classPref);
			}

			
		}

		return passengerArr;
	
	}
	

	

}
