package model.enums;

public enum AgeGroups {
	// GROUP0 -> �뿰�졊�� 誘몄꽕�젙
	// GROUP1 -> 10��
	// GROUP2 -> 2~30��
	// GROUP3 -> 4~50��
	// GROUP4 -> 60�� �씠�긽
	
	GROUP0("�뿰�졊��"), 
	GROUP1("10��"), 
	GROUP2("20~30��"), 
	GROUP3("40~50��"), 
	GROUP4("60�� �씠�긽");
	
	@SuppressWarnings("unused")
	private final String ageGroups;
	
	private AgeGroups(String ageGroups) {
		this.ageGroups = ageGroups;
	}
	
	public static AgeGroups findByAgreGroups(String ageGroups) {
		
		for(AgeGroups ageGroup : AgeGroups.values()) {
			
			if(ageGroup.equals(ageGroups))
				return ageGroup;
		}
		
		throw new RuntimeException();
		
	}

}
