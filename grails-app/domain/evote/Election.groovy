package evote

/**
 * Election
 * A domain class describes the data object and it's mapping to the database
 */
class Election {
	
    static	mapping = {
    }
    
	static	constraints = {
    }
	
	String name
	static hasMany = [allowedVoters: Person, votes: Vote]

}