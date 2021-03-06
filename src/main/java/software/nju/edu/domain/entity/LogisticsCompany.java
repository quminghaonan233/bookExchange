package software.nju.edu.domain.entity;

import java.util.Date;

public enum LogisticsCompany {
    SF("顺丰", 1, "shunfeng"),
    ZT("中通", 2, "zhongtong"),
    ST("申通", 3, "shentong"),
    YT("圆通", 4, "yuantong"),
    HT("汇通", 5, "huitongkuaidi"),
    YD("韵达", 6, "yunda"),
    YZ("邮政包裹/平邮", 7, "youzhengguonei"),
    EMS("EMS", 8, "ems"),
    TT("天天", 9, "tiantian"),
    DB("德邦", 10, "debangwuliu");
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String name;
	private int value;
	private String type;
    
    private LogisticsCompany(String name1, int companyID, String name2)
    {
        this.name = name1;
        this.value = companyID;
        this.type = name2;
    }
        
}