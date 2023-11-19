enum class Nivel(val value: String) { 
    BASICO("Básico"), 
    INTERMEDIARIO("Intermediário"), 
    AVANCADO("Avançado")
}

data class Usuario(
    var nome: String
)

data class ConteudoEducacional(
    var nome: String,
    var nivel: Nivel,
    val duracao: Int = 60
)

data class Formacao(
    val nome: String, 
    var conteudos: List<ConteudoEducacional>
) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun listarInscritos(): List<String> {
        return inscritos.map { it.nome }
    }
    
    fun listarConteudos(): List<String> {
        return conteudos.map {
            it.nome + " - " + it.nivel.value + " (" + it.duracao + "h)"
        }
    }
}

fun main() {
    
    val jake = Usuario("Jake")
    val finn = Usuario("Finn")
    
    val conteudoA = ConteudoEducacional("Kotlin basics", Nivel.BASICO, 20)
    val conteudoB = ConteudoEducacional("Kotlin functions", Nivel.INTERMEDIARIO, 40)
    val conteudoC = ConteudoEducacional("Kotlin special topics", Nivel.AVANCADO)
    
    val formacaoKotlin = Formacao(
        "Kotlin DIO", 
        listOf(
            conteudoA, 
            conteudoB, 
            conteudoC
        )
    )
    
    formacaoKotlin.matricular(jake)
    formacaoKotlin.matricular(finn)
    
    formacaoKotlin.run {
        println("Inscritos na Formação $nome: " + listarInscritos())
        println("Conteúdos: " + listarConteudos())
    }
    
    
}