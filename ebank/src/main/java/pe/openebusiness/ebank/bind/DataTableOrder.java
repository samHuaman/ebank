package pe.openebusiness.ebank.bind;

import java.io.Serializable;

public class DataTableOrder implements Serializable {
	
	private String Property;
	
	private String Direction;

	public String getProperty() {
		return Property;
	}

	public void setProperty(String property) {
		Property = property;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}	

}
