package th.co.muangthai.osr_support_service.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import th.co.muangthai.osr_support_service.entity.ServiceLoggingEntity;
import th.co.muangthai.osr_support_service.model.Results;
import th.co.muangthai.osr_support_service.model.Rules;
import th.co.muangthai.osr_support_service.repository.ServiceLoggingRepository;
import th.co.muangthai.osr_support_service.request.RequestSearchTransaction;
import th.co.muangthai.osr_support_service.response.ResponseSearchTransaction;

@Service
public class SearchTransactionService {
	
	private Logger logger = LogManager.getLogger(SearchTransactionService.class);
	
	@Autowired
	private ServiceLoggingRepository serviceLoggingRepository;
	
	
	public ResponseSearchTransaction searchTransaction(RequestSearchTransaction request) {
		 
		ResponseSearchTransaction response = new ResponseSearchTransaction();
		List<Results> resultList = new ArrayList<Results>();		
		
		List<ServiceLoggingEntity> serviceLogging = serviceLoggingRepository.getServiceLogging(request);
		
		for(ServiceLoggingEntity log : serviceLogging) {
			Results result = new Results();
			result.setTransactionId(log.getTransactionId());
			result.setStatus(log.getStatus());
			result.setCreatedDate(log.getCreatedDate());
			result.setTimeUsage(log.getTimeUsage());
			result.setServiceUsage(log.getServiceUsageTime());
			result.setCollectorUsage(log.getCollectorUsageTime());
			result.setDateTime(log.getDateTime().toLocalDateTime());
			
			//json
			try {
				ObjectMapper mapper = new ObjectMapper();
				JsonObject jsonObject = JsonParser.parseString(log.getResponseJson()).getAsJsonObject();
				JsonObject jsonResponseBody = jsonObject.getAsJsonObject("responseBody");
				JsonElement jsonMessageBackendList = jsonResponseBody.getAsJsonArray("messageBackendList");
				
				List<Rules> rulesList = mapper.readValue(jsonMessageBackendList.toString(), new TypeReference<List<Rules>>() {});
				result.setRules(rulesList);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resultList.add(result);
		}
		
		response.setResponse(resultList);
		
		return response;
	}

}
