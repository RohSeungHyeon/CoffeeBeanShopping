package user.model.enums;

public enum AgeGroups {
	// GROUP0 -> 연령대 미설정
	// GROUP1 -> 10대
	// GROUP2 -> 2~30대
	// GROUP3 -> 4~50대
	// GROUP4 -> 60대 이상
	
	GROUP0("연령대"), 
	GROUP1("10대"), 
	GROUP2("20~30대"), 
	GROUP3("40~50대"), 
	GROUP4("60대 이상");
	
	@SuppressWarnings("unused")
	private final String ageGroups;
	
	private AgeGroups(String ageGroups) {
		this.ageGroups = ageGroups;
	}
	
	public static AgeGroups findByAgreGroups(AgeGroups ageGroups) {
		
		for(AgeGroups ageGroup : AgeGroups.values()) {
			
			if(ageGroup.equals(ageGroups))
				return ageGroup;
		}
		
		throw new RuntimeException();
		
	}

}
