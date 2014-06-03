package evote

import grails.test.mixin.TestFor
import spock.lang.*

/**
 *
 */
class VotingControllerIntegrationSpec extends Specification {
	
	private static String VALID_NIF = "111A"
	private static Long VALID_PARTY_ID = 1L
	
	def electionService
	
	VotingController votingController
	
    def setup() {
		votingController = new VotingController()
		votingController.electionService = electionService
		votingController.startElection("Comarcales 2014")
    }

    def cleanup() {
    }

    void "Cuando una persona vota, se le muestra la vista de 'gracias'"() {
		given:
			votingController.params.nif = VALID_NIF
			votingController.params.party = VALID_PARTY_ID
		when:
			votingController.vote()
		then:
			votingController.modelAndView.viewName == '/voting/thanks'
			1 == electionService.totalNumberOfVotes()
    }
	
	void "Cuando se cierran las elecciones, se mostrará el resultado"() {
		given:
			votingController.params.nif = VALID_NIF
			votingController.params.party = VALID_PARTY_ID
			Party party = Party.get(VALID_PARTY_ID)
			votingController.vote()
			votingController.endElection()
		when:
			votingController.showElectionResults()
		then:
			votingController.modelAndView.model == [results: ["${party.name}" : 1]]
		
	}
}
