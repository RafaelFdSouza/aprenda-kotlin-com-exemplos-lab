enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {       
        inscritos.add(usuario)
    }
    
    fun inscritosPorNome(){
        for(inscrito in inscritos){
            println(inscrito.nome)
        }
    }
     fun conteudosFormacao(){
        for(conteudo in conteudos){
            println("${conteudo.nome} : ${conteudo.duracao} horas")
        }
    }
}


fun main() {
       
    //Criar usuarios
    val rafael = Usuario("Rafael", "rafael.gmail.com")
    val maria  = Usuario("Maria", "maria.outlook.com")
    val rita = Usuario("Rita", "rita.outlook.com")
    
    //Criar conteudos
    val oopKotlin = ConteudoEducacional("Orientação a Objetos com Kotlin", 8)
    val jetpack = ConteudoEducacional("Dominando o Android Jetpack", 10)
    
    val listaConteudosAndroid = mutableListOf<ConteudoEducacional>()
    listaConteudosAndroid.add(oopKotlin)
    listaConteudosAndroid.add(jetpack)
    
    //Criar formacao
    val formacaoAndroid = Formacao("Formação Android Developer", listaConteudosAndroid, Nivel.AVANCADO)
    
    //Simulando matricula
    formacaoAndroid.matricular(rafael)
    formacaoAndroid.matricular(rita)  
    
    println("Os seguintes usuários estão matriculados em ${formacaoAndroid.nome} :")
    formacaoAndroid.inscritosPorNome()
    println("Conteúdos da formação: ")
    
    println("${formacaoAndroid.conteudosFormacao()}")
    println("${formacaoAndroid.nivel}")
 }
    