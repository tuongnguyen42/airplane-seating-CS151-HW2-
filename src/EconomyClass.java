import java.util.HashMap;
import java.util.Map;

public class EconomyClass {
	private int numRows = 30;
	private int numSeats = 6;
	public Map<String, Boolean> seatChart = new HashMap<>();
	
	EconomyClass(){
		for (int i = 0; i < numRows ; i++){
			for(int j = 0; j <numSeats; j++) {
				seatChart.put(String.valueOf(i)+ String.valueOf(j), true);
			}
		}
	}
	
	public Map<String, Boolean> getSeatChart() {
		return seatChart;
	}
	

}
