public class PalavraNaoExisteException extends RuntimeException {
    PalavraNaoExisteException(){
        super("Palavra invalida. Leia as regras e tente novamente");
    }
}
