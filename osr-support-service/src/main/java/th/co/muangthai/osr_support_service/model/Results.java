package th.co.muangthai.osr_support_service.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Results {
	
	private String transactionId;
	private Date createdDate;
	private LocalDateTime dateTime;
	private String status;
	private String timeUsage;
	private String collectorUsage;
	private String serviceUsage;
	private List<Rules> rules;
	private List<Documents> documents;
	private String channelCode;
	private String section;
}
