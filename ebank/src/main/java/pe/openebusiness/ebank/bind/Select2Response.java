package pe.openebusiness.ebank.bind;
package pe.openebusiness.ebank.bind;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Select2Response<T> implements Serializable {
	
	private List<T> items = new ArrayList<T>();
	
	private Integer total;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
