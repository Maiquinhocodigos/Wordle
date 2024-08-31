import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Letreco novaPartida = new Letreco();
        Scanner scanner = new Scanner(System.in);

        novaPartida.iniciarPartida();

        while(novaPartida.getTentativas() < 6){
            System.out.println("Digite o palpite #" + (novaPartida.getTentativas() + 1) + ": ");
            String palpitePalavra = scanner.nextLine();
            palpitePalavra = palpitePalavra.toLowerCase();
            String result = novaPartida.inserirJogada(palpitePalavra);
            if (novaPartida.getGanhou()) break;
            if (result == ""){
                System.out.println("\nPalpite Invalido, insira outro!");
            } else{
                System.out.println(result);
            }
        }

        if (novaPartida.getGanhou()){
            System.out.println("Parabens voce acertou a palavra " + novaPartida.getPalavraOriginal() + "!");
        } else {
            System.out.println("Voce Perdeu! A palavra era " + novaPartida.getPalavraOriginal() + "!");
        }


        scanner.close();
    }
}
