package evote

/**
 * VotingController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class VotingController {
	
	def electionService

	def vote(String nif, Long party) {
		electionService.vote(nif, party)
		render(view:'thanks', model:[userId: nif, partyId: party])
	}
	
	def startElection(String name) {
		electionService.startElection(name)
	}
	
	def endElection() {
		electionService.endElection()	
	}
	
	def showElectionResults() {
		def results = electionService.electionResults()
		render(model:[results: results])
	}
}
