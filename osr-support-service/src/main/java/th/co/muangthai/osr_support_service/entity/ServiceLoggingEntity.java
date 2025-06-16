package th.co.muangthai.osr_support_service.entity;

import java.util.Date;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SERVICE_LOGGING")
public class ServiceLoggingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SERVICE_LOGGING")
	@SequenceGenerator(sequenceName = "SEQ_SERVICE_LOGGING", allocationSize = 1, name = "SEQ_SERVICE_LOGGING")

	@Column(name = "ID")
	private Long id;
	@Column(name = "CHANNEL_CODE")
	private String channelCode;
	@Column(name = "REQUEST_JSON")
	private String requestJson;
	@Column(name = "RESPONSE_JSON")
	private String responseJson;
	@Column(name = "SECTION")
	private String section;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "TIME_USAGE")
	private String timeUsage;
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	@Column(name = "CREATED_DATE")
	private Date createdDate = new Date();
	@Column(name = "RULE_LIST")
	private String ruleList;
	
	@Column(name = "COLLECTOR_USAGE_TIME")
	private String colectorUsageTime;
	@Column(name = "COLLECTOR_LIST")
	private String collectorList;
	@Column(name = "SERVICE_USAGE_TIME")
	private String serviceUsageTime;
	
	@Column(name = "ALL_RULE_EXECUTE_LOG")
	private String allRuleLog;
	
}
