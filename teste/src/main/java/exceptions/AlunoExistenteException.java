package exceptions;

public class AlunoExistenteException extends RuntimeException {
    public AlunoExistenteException(Long id) {
        super("Aluno com ID " + id + " já está cadastrado.");
    }
}