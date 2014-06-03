package evote

/**
 * Election
 * A domain class describes the data object and it's mapping to the database
 */
class Election {
	
    static	mapping = {
    }
    
	static	constraints = {
		status(nullable:true)
    }
	
	String name
	String status
	static hasMany = [allowedVoters: Person, votes: Vote]
	
	public boolean isOpen() {
		return "STARTED".equals(status)
	}
	
	public boolean isClosed() {
		return "ENDED".equals(status)
	}
	
	public void start() {
		this.status = "STARTED"
	}
	
	public void end() {
		this.status = "ENDED"
	}

}