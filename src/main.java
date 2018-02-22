import java.util.HashMap;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		EconomyClass eco = new EconomyClass();
		Map<String, Boolean> m = new HashMap();
		m = eco.getSeatChart();
		

		
		FirstClass first = new FirstClass();
		Airplane p = new Airplane(eco, first);

		Menu menu = new Menu(p);
		
		menu.menu();
		


	}

}
