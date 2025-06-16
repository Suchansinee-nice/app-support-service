package th.co.muangthai.osr_support_service.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Results {
	
	private String transactionId;
	private Date createdDate;
	private String status;
	private String timeUsage;
	private String collectorUsage;
	private String serviceUsage;
	private List<Rules> rules;
}
