package th.co.muangthai.osr_support_service.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import th.co.muangthai.osr_support_service.request.RequestSearchTransaction;
import th.co.muangthai.osr_support_service.response.ResponseSearchTransaction;
import th.co.muangthai.osr_support_service.service.SearchTransactionService;

@RestController
@RequestMapping("/api")
public class OsrAppSupportController {
	
	private Logger logger = LogManager.getLogger(OsrAppSupportController.class);
	
	@Autowired
	private SearchTransactionService searchTransactionService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/searchTransaction",produces = "application/json")
	public ResponseEntity<ResponseSearchTransaction> searchTransaction(@RequestBody @Valid RequestSearchTransaction request) {
		ResponseSearchTransaction response  = new ResponseSearchTransaction();
		
		try {
			response = searchTransactionService.searchTransaction(request);
			logger.info("print response");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<ResponseSearchTransaction>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return ResponseEntity.ok(response);
	}
	

}
