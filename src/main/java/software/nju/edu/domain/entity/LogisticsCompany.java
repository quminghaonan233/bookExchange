package software.nju.edu.domain.entity;


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
 
    @SuppressWarnings("unused")
	private String name;
    @SuppressWarnings("unused")
	private int value;
    @SuppressWarnings("unused")
	private String type;
    
    private LogisticsCompany(String name1, int companyID, String name2)
    {
        this.name = name1;
        this.value = companyID;
        this.type = name2;
    }
        
}