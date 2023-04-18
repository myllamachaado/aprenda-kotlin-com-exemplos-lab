enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
data class Usuario(var nome : String)
data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var alunos : List<Usuario>) {
    val inscritos = mutableListOf<Usuario>()
    fun matricular(vararg usuarios: Usuario) {
        for(u in usuarios){ inscritos.add(u) }
        alunos = inscritos
    }
    override fun toString(): String = "Nome: " + nome +
                                "\nConteúdos: " + conteudos +
                                "\nAlunos: " + alunos
}

fun main() {

    // Cria conteúdos
    val PY001 = ConteudoEducacional(nome = "Pyton I", nivel = Nivel.BASICO)
    val PY002 = ConteudoEducacional(nome = "Pyton II", nivel = Nivel.DIFICIL)
    val ES001 = ConteudoEducacional(nome = "Estatística I", nivel = Nivel.BASICO)
    val ES002 = ConteudoEducacional(nome = "Estatística II", nivel = Nivel.INTERMEDIARIO)
    val BI001 = ConteudoEducacional(nome = "Power BI I", nivel = Nivel.BASICO)
    val JV001 = ConteudoEducacional(nome = "Java I", nivel = Nivel.BASICO)
    val JV002 = ConteudoEducacional(nome = "Java II", nivel = Nivel.DIFICIL)
    val DB001 = ConteudoEducacional(nome = "Banco de dados I", nivel = Nivel.BASICO)
    val SB001 = ConteudoEducacional(nome = "Spring MVC I", nivel = Nivel.BASICO)

    // Cria formações
    val formacaoPython = Formacao(nome = "Cientista de dados utilizando Python",
        conteudos = listOf(PY001, PY002, ES001, ES002, BI001),
        alunos = listOf())
    val formacaoJava = Formacao(nome = "Desenvolvedor Java Back-End",
        conteudos = listOf(JV001, JV002, DB001, SB001),
        alunos = listOf())

    // Cria usuarios
    val aluno1 = Usuario(nome = "Aline")
    val aluno2 = Usuario(nome = "Júlia")
    val aluno3 = Usuario(nome = "Matheus")
    val aluno4 = Usuario(nome = "Joana")

    // Matricula alunos
    formacaoPython.matricular(aluno1, aluno3)
    formacaoJava.matricular(aluno2, aluno4)

    print(formacaoPython)
    print("\n" + formacaoJava)

}
