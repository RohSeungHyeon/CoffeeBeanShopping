package user.model.enums;


public enum Genders {
	
	F("F"), M("M");
	
	@SuppressWarnings("unused")
	private final String genders;
	
	private Genders(String genders) { this.genders = genders; }
	
	public static Genders findByGenders(Genders genders) {
		
		for(Genders gender : Genders.values()) {
			if(gender.equals(genders))
				return gender;
		}
		
		throw new RuntimeException();
	}
}
