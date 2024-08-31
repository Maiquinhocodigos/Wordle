public class Letreco {
    private String palavraOriginal;
    private Integer tentativas;
    private Palavras palavras;
    private Boolean ganhou;

    public Letreco() {
        this.palavras = new Palavras();
        this.ganhou = false;
        this.tentativas = 0;
    }

    public void iniciarPartida() {
        // Alocar uma palavra de "palavras" para "palavraOriginal"
        this.palavraOriginal = palavras.sortearPalavra();
        // print com as instruções do jogo
        this.menuInicial();
    }

    public String inserirJogada(String palavra) throws PalavraNaoExisteException{
        // Validar a palavra em palavras
        String jogada;
        try{
            jogada = this.palavras.checarPalavra(palavra, this.palavraOriginal);
            if (jogada.equals("+ + + + + ")){
                this.ganhou = true;
            }
        } catch (PalavraNaoExisteException error){
            return "";
        }
        this.tentativas++;
        // retornar o resultado para main
        return jogada;
    }

    public void menuInicial() {
        System.out.println("===================\n" + "BEM VINDO AO LETRECO!\n" + "===================\n");
        System.out.println(
                "Vou te apresentar as regras do jogo, logo em seguida uma partida será iniciada para que você possa testar o game\n");
        try {
            Thread.sleep(3000); // Vai pausar o código por 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Instru\u00E7\u00F5es:\r\n" + //
                "- O computador escolher\u00E1 uma palavra aleat\u00F3ria de cinco letras.\r\n" + //
                "- Voc\u00EA tem seis tentativas para adivinhar a palavra.\r\n" + //
                "- Ap\u00F3s cada palpite, voc\u00EA receber\u00E1 feedback sobre o seu palpite:\r\n" + //
                " - Um \"+\" indica uma letra correta na posi\u00E7\u00E3o correta.\r\n" + //
                " - Um \"-\" indica uma letra correta na posi\u00E7\u00E3o errada.\r\n" + //
                " - Um \"*\" indica uma letra incorreta.\r\n" + //
                "Vamos come\u00E7ar!\r\n\n");

    }

    public Integer getTentativas(){
        return this.tentativas;
    }

    public Boolean getGanhou(){
        return this.ganhou;
    }

    public String getPalavraOriginal(){
        return this.palavraOriginal;
    }
}
