package pe.openebusiness.ebank.util;

public class Helpers {
	
	public static boolean intToBoolean(int number) {
		if (number < 0 || number > 1) {
			throw new RuntimeException("Invalid number to convert to boolean");
		}
		
		if (number == 0) {
			return false;
		}
		else if (number == 1) {
			return true;
		}
		
		return false;
	}

}
