package th.co.muangthai.osr_support_service.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.muangthai.osr_support_service.entity.ServiceLoggingEntity;
import th.co.muangthai.osr_support_service.repository.ServiceLoggingRepository;
import th.co.muangthai.osr_support_service.request.RequestSearchTransaction;
import th.co.muangthai.osr_support_service.response.ResponseSearchTransaction;

@Service
public class SearchTransactionService {
	
	private Logger logger = LogManager.getLogger(SearchTransactionService.class);
	
	@Autowired
	private ServiceLoggingRepository serviceLoggingRepository;
	
	
	public ResponseSearchTransaction searchTransaction(RequestSearchTransaction reuqest) {
		
		 List<ServiceLoggingEntity> serviceLogging = serviceLoggingRepository.getServiceLogging(reuqest);
		
		return null;
	}

}
