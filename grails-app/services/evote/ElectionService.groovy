package evote

/**
 * ElectionService
 * A service class encapsulates the core business logic of a Grails application
 */
class ElectionService {
	
	private Election election

    def vote(String nif, Long partyId) {
		
		Person person = Person.findByNif(nif)
		Party party = Party.get(partyId)
		 
		if (!person || !party) {
			throw new IllegalArgumentException()
		}
		
		Vote vote = new Vote(voter: person, choice: party)
		vote.save()
		election.addToVotes(vote)
		election.save()
    }
	
	def totalNumberOfVotes() {
		if (!election.votes) {
			return 0
		} else { 
			return election.votes.size()
		}
	}

	def startElection(String name) {
		election = new Election(name: name)
		election.start()
		election.save()
	}
	
	def endElection() {
		election.end()
	}
	
	def electionResults() {
		if (election.isOpen()) {
			throw new IllegalAccessException()
		} else {
			def results = [:]
			election.votes.each { vote ->
				if (results[vote.choice.name]) {
					results[vote.choice.name] += 1
				} else {
					results[vote.choice.name] = 1
				}
			}
			return results
		}
		
	}
	
}
