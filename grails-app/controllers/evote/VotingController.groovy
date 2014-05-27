package evote

/**
 * VotingController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class VotingController {
	
	def electionService

	def vote() {
		log.info("Voting")
		electionService.vote(userId, partyName)
		render(view:'thanks')
	}
}
