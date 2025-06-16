package th.co.muangthai.osr_support_service.response;

import java.util.List;

import lombok.Data;
import th.co.muangthai.osr_support_service.model.Results;

@Data
public class ResponseSearchTransaction {
	
	private List<Results> response;
}
