package pe.openebusiness.ebank.bind;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DataTableModelRequest<TModel> implements Serializable {
	
	private TModel filter;
	
	private Set<DataTableOrder> orderBy = new HashSet<DataTableOrder>();

	public TModel getFilter() {
		return filter;
	}

	public void setFilter(TModel filter) {
		this.filter = filter;
	}

	public Set<DataTableOrder> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Set<DataTableOrder> orderBy) {
		this.orderBy = orderBy;
	}

}
