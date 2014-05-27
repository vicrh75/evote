package evote

/**
 * Person
 * A domain class describes the data object and it's mapping to the database
 */
class Person {

	/* Default (injected) attributes of GORM */
//	Long	id
//	Long	version

	String nif
	String name
	
    static	mapping = {
    }
    
	static	constraints = {
		nif(unique:true)
    }
	
	/*
	 * Methods of the Domain Class
	 */
//	@Override	// Override toString for a nicer / more descriptive UI 
//	public String toString() {
//		return "${name}";
//	}
}
