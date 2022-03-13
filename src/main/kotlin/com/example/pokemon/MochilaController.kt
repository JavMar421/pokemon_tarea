package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.image.ImageView
import javafx.stage.Stage
import kotlin.system.exitProcess

//he usado parte de el examen final que hice tranquilamente en mi casa por lo que los ID de algunas cosas no son pociones si no antidotos
//esto no afecta a la intefaz de usuario solo al codigo y el XML para ahorrar tiempo
class MochilaController() {

    @FXML
    private lateinit var antidoto:ImageView
    @FXML
    private lateinit var antiquemar:ImageView
    @FXML
    private lateinit var descongelante:ImageView
    @FXML
    private lateinit var desparalizar:ImageView




    @FXML
    fun antidotoClicked(){
        val id=1
        alertaCura(id)

        pokeselec.vidaRest+=10
        if (pokeselec.vidaRest>pokeselec.vidaMax){pokeselec.vidaRest=pokeselec.vidaMax}
        seleccionDePokemonController.actualizarEstado(pokeselec)
        pokemonSeleccionadoController.cargarPokemon(pokeselec)
        pokemonSeleccionadoController.actualizar()
    }
    @FXML
    fun antiquemarClicked(){
        val id=2
        alertaCura(id)
        pokeselec.vidaRest+=20
        if (pokeselec.vidaRest>pokeselec.vidaMax){pokeselec.vidaRest=pokeselec.vidaMax}
        seleccionDePokemonController.actualizarEstado(pokeselec)
        pokemonSeleccionadoController.cargarPokemon(pokeselec)
        pokemonSeleccionadoController.actualizar()
    }
    @FXML
    fun descongelanteClicked(){
        val id=3
        alertaCura(id)
        println(pokeselec.vidaRest.toString()+"<-- 10% es: -->"+pokeselec.vidaRest*10/100);
        pokeselec.vidaRest+=(pokeselec.vidaRest*10/100);
        if (pokeselec.vidaRest>pokeselec.vidaMax){pokeselec.vidaRest=pokeselec.vidaMax}
        seleccionDePokemonController.actualizarEstado(pokeselec)
        pokemonSeleccionadoController.cargarPokemon(pokeselec)
        pokemonSeleccionadoController.actualizar()

    }
    @FXML
    fun desparalizarClicked(){
        val id=4
        alertaCura(id)
        println(pokeselec.vidaRest.toString()+"<-- 20% es: -->"+pokeselec.vidaRest*20/100);
        pokeselec.vidaRest+=(pokeselec.vidaRest*20/100);
        if (pokeselec.vidaRest>pokeselec.vidaMax){pokeselec.vidaRest=pokeselec.vidaMax}
        seleccionDePokemonController.actualizarEstado(pokeselec)
        pokemonSeleccionadoController.cargarPokemon(pokeselec)
        pokemonSeleccionadoController.actualizar()

    }


    fun alertaCura(id: Int){
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.headerText = null
        alert.title = "Curar Pokemon"
        println("curando a: ${pokeselec.nombre}")
        if(pokeselec.vidaRest==pokeselec.vidaMax){
            alert.contentText = "El pokemon ya esta curado"
            val stage = antidoto.scene.window as Stage
            stage.close()
            //pokeselec.estado=0; pokeselec.fotoestado=" "
        }
        else{
            alert.contentText = "Pokemon curado con exito"
        }
        alert.showAndWait()

    }



    var pokemonSeleccionadoController=PokemonSeleccionadoController()
    var seleccionDePokemonController=SeleccionDePokemonController()

    var pokeselec=Pokemon("Arcanine","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1.gif",204,65,"src\\main\\resources\\com\\example\\pokemon\\Images\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1_combate.gif","")

    fun enviarDatosMochila(seleccionMohcilaController: PokemonSeleccionadoController){
        this.pokemonSeleccionadoController=seleccionMohcilaController
    }
    fun enviarDatosMochila2(seleccionMochilaController: SeleccionDePokemonController){
        this.seleccionDePokemonController=seleccionMochilaController
    }

    fun cargarPokemonMochila(pokemon :Pokemon) {
        pokemon.click=false
        pokeselec = pokemon
    }

}