<template xmlns="http://www.w3.org/1999/xhtml">
  <v-app>
    <v-app-bar
      app
      dark
    >Vuetify and Axios</v-app-bar>
    <v-content>
        <v-form>
          <v-container>
            <v-row>
              <v-col
                cols="12"
                md="8">
                <v-text-field 
                  v-model="usuario.nome"
                  label="Nome: "
                  required
                  placeholder="Digite seu Nome"
                  > 
                </v-text-field>
                </v-col>

                <v-col
                cols="12"
                md="8">
                <v-text-field 
                  v-model="usuario.email"
                  label="E-mail: "
                  required
                  placeholder="Digite seu Email"> 
                </v-text-field>
                <v-btn 
                  @click.prevent="salvar"
                  large
                  color="primary">Salvar</v-btn>

                <v-btn @click.prevent="obterUsuarios"
                       large
                       color="success"
                       class="ml-2"
                       >Obter Usuários</v-btn>  
                </v-col>
            </v-row>
          </v-container>
        </v-form>
  <br>      
<hr>

<v-card 
    class="mx-auto"
    max-width="1400">
      
        <v-list-item-group>
          <v-list-item 
            v-for="usuario in usuarios" :key="usuario.id">
            <v-list-item-content>
              <v-list-item-title>
                <strong>Nome: </strong>{{ usuario.nome }} <br/>
                <strong>E-mail: </strong> {{ usuario.email }} <br/>
                <strong>ID: </strong> {{ usuario.id }} <br>
                <v-btn 
                  color="warning"
                  large
                  @click="editar(usuario)">Editar</v-btn>
                  <v-btn
                    color="error"
                    large
                    @click="excluir(usuario.id)"
                    class="ml-2">Excluir</v-btn>
              </v-list-item-title>
            </v-list-item-content>          
          </v-list-item>  
        </v-list-item-group>       
  
    </v-card>
   </v-content>
    </v-app>
</template>

<script>
export default {
  data() {
    return {
      usuarios: [],
      usuario: {
        id: '',
        nome: '',
        email: ''
      }
    }
  },
  methods: {
    editar(usuario) {
      console.log(this.carregar)
      //this.usuario.id = id
      //this.usuario = { ...this.usuarios[id] }
      this.usuario = usuario
    },

    excluir(id) {
      this.usuario.id = id
      this.$http.delete(`/usuario/${id}`)
  
    },

    limpar() {
      this.usuario.nome = ''
      this.usuario.email = ''
      this.usuario.id = null
    },
    salvar() {
      const metodo = this.usuario.id ? 'put' : 'post'
      const finalUrl = this.usuario.id ? `/${this.usuario.id}` : ''
      this.$http[metodo](`/usuario${finalUrl}`, this.usuario)
       .then(() => this.limpar())

      //this.$http.post('/usuario', this.usuario)
       //.then(() => this.limpar())
     
    },
    obterUsuarios() {
      this.$http('/usuario').then(res =>{
        this.usuarios = res.data 
      })
    }
  }

 // created() {
//   this.$http.post('usuarios.json', {
 //    nome: 'Maria',
 //    email: 'mariaana@gmail.com'
 //  }).then(res => {
 //    return console.log(res);
//   })
//  }
}
</script>

<style >

</style>