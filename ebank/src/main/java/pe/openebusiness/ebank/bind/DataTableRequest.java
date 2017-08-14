package pe.openebusiness.ebank.bind;

import java.io.Serializable;


public class DataTableRequest<TModel> extends DataTableModelRequest<TModel> implements Serializable {
	
	private Integer draw;
	
	private Integer start;
	
	private Integer length;

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

}
