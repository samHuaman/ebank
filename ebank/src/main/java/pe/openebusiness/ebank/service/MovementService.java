<<<<<<< HEAD
package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.MovementFilter;
import pe.openebusiness.ebank.model.Movement;

public interface MovementService {

	DataTableResponse<Movement> getMovemetDataTableByAccount(DataTableRequest<MovementFilter> request,
			Integer account_id);

}
=======
package pe.openebusiness.ebank.service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.MovementFilter;
import pe.openebusiness.ebank.model.Movement;

public interface MovementService {

	DataTableResponse<Movement> getMovemetDataTableByAccount(DataTableRequest<MovementFilter> request,
			Integer account_id);

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
