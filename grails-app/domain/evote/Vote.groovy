package evote

/**
 * Vote
 * A domain class describes the data object and it's mapping to the database
 */
class Vote {

	Person voter
	Party choice 
	
    static	mapping = {
    }
    
	static	constraints = {
    }
	
}
