import java.util.HashMap;
import java.util.Map;

public class FirstClass {
	private int numRows = 5;
	private int numSeats = 4;
	public Map<String, Boolean> seatChart = new HashMap<>();
	
	FirstClass(){
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
