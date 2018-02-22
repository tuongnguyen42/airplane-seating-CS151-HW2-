import java.util.Scanner;

public class Menu {
	static Airplane plane;


	Menu(Airplane p){
		this.plane = p;
	}
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("Enter choice:");
		System.out.println("1 = Add passenger");
		System.out.println("2 = Print seat");
		System.out.println("3 = Quit");
		
		choice = scan.nextInt();
		
		switch(choice) {
			case 1: plane.addPassenger();
				break;
			case 2: plane.printSeat();
				break;
			case 3: System.exit(0);
				break;
			default: menu();
		}
		menu();

		
		
	}

}
