

package evote



import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ElectionService)
@Mock ( [ Person, Party, Election, Vote ] )
class ElectionServiceSpec extends Specification {
	
	private String NON_EXISTING_NIF = "1234"
	private Long NON_EXISTING_PARTY_ID = 999L
	private String ELECTION_NAME = "Locales 2014" 

    def setup() {
		service.startElection(ELECTION_NAME)
    }

    def cleanup() {
    }

    void "Un voto necesita un nif de una persona que exista"() {
		given:
			Party party = new Party(name:"A")
		when:
			service.vote(NON_EXISTING_NIF, party.id)
		then:
			thrown IllegalArgumentException
    }
	
	void "Un voto necesita un partido existente"() {
		given:
			Person person = new Person(nif:"111A", name: "Pepe")
			person.save(failOnError:true)
		when:
			service.vote(person.nif, NON_EXISTING_PARTY_ID)
		then:
			thrown IllegalArgumentException
	}
	
	void "Cuando se emite un voto, se incrementa el número total de votos"() {
		given:
			Person person = new Person(nif:"111A", name: "Pepe")
			person.save(failOnError:true)
			Party party = new Party(name:"A")
			party.save(failOnError:true)
		when:
			service.vote(person.nif, party.id)
		then:
			1 == service.totalNumberOfVotes()
	}
	
	void "Cuando se empieza una elección, el número de votos totales es cero"() {
		expect:
			0 == service.totalNumberOfVotes()
	}

	void "Una persona no puede votar más de una vez"() {
	}
	
	void "Una persona que no esté en el censo no puede votar"() {
		
	}

	void "No se pueden ver los resultados de una elección en curso"() {
		when:
			def result = service.electionResults()
		then:
			thrown IllegalAccessException
	}
	
	void "Deben devolverse el total de votos para cada partido"() {
		setup:
			Party party = new Party(name:"A")
			party.save(failOnError:true)
			Person person = new Person(nif:"111A", name: "Pepe")
			person.save(failOnError:true)
			service.vote("111A", party.id)
			service.endElection()
		when:
			def result = service.electionResults()
		then:
			[ "A": 1 ] == result
	}
	
	
}
