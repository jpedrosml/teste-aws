package controller;



import model.Aluno; 
import repo.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	

	@Autowired
	private AlunoRepository alunoRepository;
	
	//C
    @PostMapping
    public Aluno adicionarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
	
	//R
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscaAluno(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	//U
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoRepository.findById(id)
                .map(alunoExistente -> {
                    alunoExistente.setNome(aluno.getNome());
                    alunoExistente.setIdade(aluno.getIdade());
                    alunoExistente.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
                    alunoExistente.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());
                    alunoExistente.setNomeProfessor(aluno.getNomeProfessor());
                    alunoExistente.setNumeroSala(aluno.getNumeroSala());
                    alunoRepository.save(alunoExistente);
                    return ResponseEntity.ok(alunoExistente);
                })
                .orElse(ResponseEntity.notFound().build());
    }
	
	//D 
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerAluno(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    alunoRepository.delete(aluno);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

