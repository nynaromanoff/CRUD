package usuario

import grails.gorm.services.Service


@Service(Usuario)
interface UsuarioDataService {
    Usuario save(String nome, String email)


}
