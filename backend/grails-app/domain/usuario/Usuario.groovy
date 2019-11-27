package usuario

import grails.rest.Resource

@Resource(uri = '/usuario', formats = ["json"])
class Usuario {

    String nome
    String email

    static constraints = {
        nome nullable: false
        email nullable: false

    }
}
