<<<<<<< HEAD
<<<<<<< HEAD

package pe.openebusiness.ebank.dao;
=======
package pe.openebusiness.ebank.dao;
=======
package pe.openebusiness.ebank.dao;

import java.util.List;
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81

import java.util.List;
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.FeeFilter;
import pe.openebusiness.ebank.model.Fee;

public interface FeeDao {
	
	DataTableResponse<Fee> getFeeDataTable(DataTableRequest<FeeFilter> request, Integer schedule_id);
	
	List<Fee> getPendingFees(Integer schedule_id);

<<<<<<< HEAD
}
=======
}
<<<<<<< HEAD
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
