<<<<<<< HEAD

package pe.openebusiness.ebank.filter;

import java.io.Serializable;
import java.util.Date;

public class PaymentFilter implements Serializable {
	
	private Date transaction_date;
	
	private Integer fee_number;

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public Integer getFee_number() {
		return fee_number;
	}

	public void setFee_number(Integer fee_number) {
		this.fee_number = fee_number;
	}

}
=======
package pe.openebusiness.ebank.filter;

import java.io.Serializable;
import java.util.Date;

public class PaymentFilter implements Serializable {
	
	private Date transaction_date;
	
	private Integer fee_number;

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public Integer getFee_number() {
		return fee_number;
	}

	public void setFee_number(Integer fee_number) {
		this.fee_number = fee_number;
	}

}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
