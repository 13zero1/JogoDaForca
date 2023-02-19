import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {

        String palavraSecreta = "brincadeira"; //Define a palavra a ser descoberta!
        String letraUsada = "";
        String palavraFinal = "";
        int numeroTentativa = 15; //Define o numero de tentativas!

        //colocando os tracinhos da palavra secreta...
        for (int i = 0; i < palavraSecreta.length(); i++) {

            palavraFinal += "_ ";

            //tentativas disponiveis...
            for (int tentativa = 1; ; numeroTentativa++) {

                if (tentativa == numeroTentativa) {
                    System.out.println("-- Game Over --");
                    System.out.println("A palavra secreta era '" + palavraSecreta + "'");

                }

                System.out.println("Rodada n." + tentativa + ": Qual é a próxima letra?");
                tentativa++;

                //tentativas do usuario...
                char sugestaoLetra = new Scanner(System.in).next().charAt(0);

                //verificando se a letra sugerida ja foi utilizada...
                if (letraUsada.indexOf(sugestaoLetra) >= 0) {
                    System.out.println("a letra " + letraUsada + " ja foi utilizada!");

                } else {
                    //armazenando a letra sugerida...
                    sugestaoLetra += sugestaoLetra;

                    //verificando se a letra sugerida ja foi utilizada esta na palavra secreta...
                    if (palavraSecreta.indexOf(sugestaoLetra) >= 0) {
                        palavraFinal = "";

                        //substituindo o espaço vazio pela letra...
                        for (int j = 0; j < palavraSecreta.length(); j++) {
                            palavraFinal += letraUsada.indexOf(palavraSecreta.charAt(j)) >= 0 ? palavraSecreta.charAt(j) : "_";
                        }

                        //verificando se ainda existe alguma letra secreta...
                        if (palavraFinal.contains("_")) {
                            System.out.println("Parabens! A palavra secreta tem a letra '" + sugestaoLetra + "'!");
                            System.out.println("Mais ainda nao acabou! Qual a próxima letra que vc sugere?");

                        } else {
                            System.out.println("Parabens! vc conseguiu descobrir a palavra secreta");

                        }

                    }
                    else {
                        System.out.println("Infelizmente a palavra secreta nao tem a letra " + letraUsada + "!");
                    }
                }
            }
        }
    }
}