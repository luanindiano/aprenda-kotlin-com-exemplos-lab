enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} matriculado!")
    }

    fun adicionarNovoConteudo(conteudoNovo: ConteudoEducacional) {
        conteudos.add(conteudoNovo)
    }
}

fun main() {
    val curso1 = ConteudoEducacional("Front-End")
    val formacao1 = Formacao("Desenvolvedor Web", Nivel.BASICO, mutableListOf(curso1))

    // Matricular usuário
    val usuario1 = Usuario("Luan")
    formacao1.matricular(usuario1)

    // Adicionar novo conteúdo
    val novoConteudo = ConteudoEducacional("Back-End")
    formacao1.adicionarNovoConteudo(novoConteudo)

	//adicionar novo aluno
    val usuario2 = Usuario("Pedro")
    formacao1.matricular(usuario2)
    
    //adicionar Formação
    val curso3 = ConteudoEducacional("Cibersecurity")
    val curso4 = ConteudoEducacional("LGPD")
    val formacao2 = Formacao("Redes", Nivel.AVANCADO, mutableListOf(curso3, curso4))
    
    //matricular usuario
    val usuario3 = Usuario("Gabrielle")
    formacao2.matricular(usuario3)
    formacao2.matricular(usuario1)

    // Imprimir informações
    println("Formação: ${formacao1.nome}, Nível: ${formacao1.nivel}")
    println("Conteúdos:")
    formacao1.conteudos.forEach { println("- ${it.nome}") }
    println("Inscritos:")
    formacao1.inscritos.forEach { println("- ${it.nome}") }
    
    // Imprimir novas informações
    println()
    println("Formação: ${formacao2.nome}, Nível: ${formacao2.nivel}")
    println("Conteúdos:")
    formacao2.conteudos.forEach { println("- ${it.nome}") }
    println("Inscritos:")
    formacao2.inscritos.forEach { println("- ${it.nome}") }
}