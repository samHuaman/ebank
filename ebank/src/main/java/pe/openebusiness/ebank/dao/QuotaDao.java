package pe.openebusiness.ebank.dao;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.filter.QuotaFilter;
import pe.openebusiness.ebank.model.Quota;

public interface QuotaDao {

    DataTableResponse<Quota> getQuotaDataTableByScheduleId(DataTableRequest<QuotaFilter> request, Integer scheduleId);
}
