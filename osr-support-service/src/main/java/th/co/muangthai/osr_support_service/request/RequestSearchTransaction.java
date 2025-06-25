package th.co.muangthai.osr_support_service.request;



import java.util.Date;
import lombok.Data;

@Data
public class RequestSearchTransaction {
	
	private String refNo;
	private String transactionId;
	private Date createdDate;
	
}
