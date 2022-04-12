import kotlin.system.exitProcess

fun main() {
    println("Bem-vindo a SymCity!")
    println("Sistema de cálculo de impostos.")

    var nome: String? = null
    var profissao: String? = null

    val salarios = obterSalarios(2)

    val impostosCalculados = calcImpostos(salarios)

    while (true){
        println("Digite [MENU] para mostrar as opções:")

        when (readln().lowercase()) {
            "menu" -> menu()
            "cadastrar", "c" -> {
                println("Digite seu nome:")
                nome = readln()
                println("Digite sua profissão:")
                profissao = readln()
            }
            "mostrar", "m" -> mostrarDados(nome, profissao)
            "salario", "s" -> formataSalario(salarios)
            "imposto", "i" -> mostrarImpostos(impostosCalculados)
            "sair" -> exitProcess(0)
            else -> println("Opção inválida.")
        }
    }

}

fun obterSalarios(vetorSize: Int): Array<Double>{
    var vetorSalario = Array(vetorSize) { i -> obtemValor(i) }
    return vetorSalario
}

fun obtemValor(num: Int): Double {
    println("Digite o valor do salário referente ao ${num + 1}º mês:")
    return readln().toDouble()
}

fun calcImpostos(salarioObtido: Array<Double>): Array<String>{
    val impostos = Array(salarioObtido.size){
        i -> when{
            salarioObtido[i] <= 2000 -> "R$  0.00"
            salarioObtido[i] <= 3500 -> "R$${("%.2f".format(salarioObtido[i] * 0.08))
                .replace(",", ".")}"
            salarioObtido[i] <= 4500 -> "R$${("%.2f".format(salarioObtido[i] * 0.18))
                .replace(",", ".")}"
            else -> "R$${("%.2f".format(salarioObtido[i] * 0.28))
                .replace(",", ".")}"
        }
    }

    return impostos
}

fun mostrarImpostos(vetorImposto: Array<*>){
    println("\n\n------Impostos------\n")
    for (item in vetorImposto) println(item)
    println("\n")
}

fun formataSalario(salario: Array<Double>){
    println("\n\n------Salários------\n")
    for(item in salario) println("R$${("%.2f".format(item))
        .replace(",", ".")}")
    println("\n")
}

fun mostrarDados(nome: String?, profissao: String?){
    if(nome == null || profissao == null) {
        println("\n\nCadastre-se primeiro.\n\n")
    }else{
        println("\n\n------Dados do Usuário------\n")
        println("Nome: $nome")
        println("Profissão: $profissao\n\n")
    }
}

fun menu(){
    println("\nMenu")
    println("Para cadastrar seus dados, digite [C]adastrar.")
    println("Para mostrar os seus dados cadastrais, digite [M]ostrar.")
    println("Para mostrar os seus salários mensais, digite [S]alario.")
    println("Para mostrar os seus impostos calculados, digite [I]mpostos.")
    println("Para sair, digite [SAIR].")
    println("Por favor, digite uma opção:\n")
}



