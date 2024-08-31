import java.util.ArrayList;
import java.io.*;

public class Palavras {
    public ArrayList<String> palavras;
    public String mensagemVitoria;

    public Palavras() {
        // Alocar um ArrayList
        this.palavras = new ArrayList<String>();
        // Carregar palavras da memória
        carregarPalavras();
    }

    private void carregarPalavras() {
        String arquivoPalavras = "br-utf8.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivoPalavras));
            String linha;

            while ((linha = br.readLine()) != null) {
                palavras.add(linha);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sortearPalavra() {
        long horarioNoRelogio = System.currentTimeMillis();
        int indiceSorteado = (int) (horarioNoRelogio % palavras.size());

        return palavras.get(indiceSorteado);

    }

    public String checarPalavra(String palavraFornecida, String palavraOriginal) throws PalavraNaoExisteException {
        String resultado = "";
        // Verificar se uma palavra esta contido no arraylist
        if(!palavras.contains(palavraFornecida) || palavraFornecida.length() > 5){
            throw new PalavraNaoExisteException();
        }
        // Se houver: verifica cada indice
        for(int i = 0; i < palavraFornecida.length(); i++){
            char contido = palavraFornecida.charAt(i);
            if(contido == palavraOriginal.charAt(i)){
                resultado += "+ ";
            }else if(palavraOriginal.indexOf(contido) != -1){
                resultado += "- ";
            }else resultado += "* ";
        }

            return resultado;
    }

}
