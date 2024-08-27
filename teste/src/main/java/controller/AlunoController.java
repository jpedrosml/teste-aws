package controller;



import model.Aluno; 
import repo.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exceptions.AlunoExistenteException;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	

	@Autowired
	private AlunoRepository alunoRepository;
	
	//C
    @PostMapping
    public Aluno adicionarAluno(@RequestBody Aluno aluno) {
    	if(alunoRepository.existsById(aluno.getId())) {
    		throw new AlunoExistenteException(aluno.getId());
    	}
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
                .map(existingAluno -> {
                    existingAluno.setNome(aluno.getNome());
                    existingAluno.setIdade(aluno.getIdade());
                    existingAluno.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
                    existingAluno.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());
                    existingAluno.setNomeProfessor(aluno.getNomeProfessor());
                    existingAluno.setNumeroSala(aluno.getNumeroSala());
                    alunoRepository.save(existingAluno);
                    return ResponseEntity.ok(existingAluno);
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

