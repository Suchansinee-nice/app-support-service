package th.co.muangthai.osr_support_service.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.muangthai.osr_support_service.entity.ServiceLoggingEntity;
import th.co.muangthai.osr_support_service.request.RequestSearchTransaction;


@Repository
public class ServiceLoggingRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<ServiceLoggingEntity>  getServiceLogging(RequestSearchTransaction request) {
		
		StringBuilder sql  = new StringBuilder();
		List<Object> params = new ArrayList<>();
		List<ServiceLoggingEntity> list = new ArrayList<ServiceLoggingEntity>();
		
		params.add(request.getCreatedDate());
		
		sql.append("SELECT * FROM OSR.SERVICE_LOGGING where transaction_id = ? AND TRUNC(created_date) = ?");
		list = jdbcTemplate.query(sql.toString(), listRowmapper, params);
		
		return list;
		
	}
	
	private RowMapper<ServiceLoggingEntity> listRowmapper = new RowMapper<ServiceLoggingEntity>() {
		@Override
		public ServiceLoggingEntity mapRow(ResultSet rs, int arg1) throws SQLException {
			ServiceLoggingEntity log = new ServiceLoggingEntity();

			log.setAllRuleLog(rs.getString("ALL_RULE_EXECUTE_LOG"));
			log.setChannelCode(rs.getString("CHANNEL_CODE"));
			log.setCollectorList(rs.getString("COLLECTOR_LIST"));
			log.setCollectorUsageTime(rs.getString("COLLECTOR_USAGE_TIME"));
			log.setCreatedDate(rs.getDate("CREATED_DATE"));
			log.setRequestJson(rs.getString("REQUEST_JSON"));
			log.setResponseJson(rs.getString("RESPONSE_JSON"));
			log.setRuleList(rs.getString("RULE_LIST"));
			log.setSection(rs.getString("SECTION"));
			log.setServiceUsageTime(rs.getString("SERVICE_USAGE_TIME"));
			log.setStatus(rs.getString("STATUS"));
			log.setTimeUsage(rs.getString("TIME_USAGE"));
			log.setTransactionId(rs.getString("TRANSACTION_ID"));
			log.setServiceUsageTime(rs.getString("SERVICE_USAGE_TIME"));
			
			return log;
		}
	};

}
