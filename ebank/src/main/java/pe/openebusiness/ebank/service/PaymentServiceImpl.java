package pe.openebusiness.ebank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.openebusiness.ebank.bind.DataTableRequest;
import pe.openebusiness.ebank.bind.DataTableResponse;
import pe.openebusiness.ebank.dao.PaymentDao;
import pe.openebusiness.ebank.filter.PaymentFilter;
import pe.openebusiness.ebank.model.Payment;

@Component
@Service(value = "paymentService")
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentDao paymentDao;

	@Override
	public DataTableResponse<Payment> getPaymentDataTable(DataTableRequest<PaymentFilter> request) {
		return paymentDao.getPaymentDataTable(request);
	}

}
