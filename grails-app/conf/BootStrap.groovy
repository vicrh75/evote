import evote.Election
import evote.Party
import evote.Person

class BootStrap {

    def init = { servletContext ->
		Election election = new Election(name:"Elecciones 2014").save(failOnError:true)
		Party partidoRoble = new Party(name: "Roble")
		partidoRoble.save(failOnError:true)
		Party partidoManzano = new Party(name: "Manzano")
		partidoManzano.save(failOnError:true)
		Party partidoHelecho = new Party(name: "Helecho")
		partidoHelecho.save(failOnError:true)
		Person homer = new Person(name: "Homer Simpson", nif: "111A")
		homer.save(failOnError:true)
		Person leela = new Person(name: "Turanga Leela", nif: "222B")
		leela.save(failOnError:true)
		Person tintin = new Person(name: "Tintin", nif: "333C")
		tintin.save(failOnError:true)
		Person rick = new Person(name: "Rick Morty", nif: "999Z")
		rick.save(failOnError:true)
		election.addToAllowedVoters(homer)
		election.addToAllowedVoters(leela)
		election.addToAllowedVoters(tintin)
		election.save(failOnError:true)
    }
    def destroy = {
    }
}
