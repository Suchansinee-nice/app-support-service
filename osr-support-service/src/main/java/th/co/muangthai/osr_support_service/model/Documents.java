package th.co.muangthai.osr_support_service.model;


import lombok.Data;

@Data
public class Documents {
	
	private String code;
	private String descTH;
	private String descEN;
	private String type;
	private String rule;
	private String rule6CheckOnly;
	private DocumentGroup documentGroup;
}
