package pe.openebusiness.ebank.bind;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataTableResponse<T> implements Serializable {
	
	private List<T> data = new ArrayList<T>();
	
	private Integer recordsTotal;
	
	private Integer recordsFiltered;
	
	private Integer draw;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

}
