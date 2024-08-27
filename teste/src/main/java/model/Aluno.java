package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column
	private String nome;
    @Column
	private int idade;
    @Column
	private double notaPrimeiroSemestre;
    @Column
	private double notaSegundoSemestre;
    @Column
	private String nomeProfessor;
    @Column
	private int numeroSala;
    
    public Aluno() {
    }
	
	public Aluno(Long id, String nome, int idade, double notaPrimeiroSemestre, double notaSegundoSemestre,
			String nomeProfessor, int numeroSala) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.notaPrimeiroSemestre = notaPrimeiroSemestre;
		this.notaSegundoSemestre = notaSegundoSemestre;
		this.nomeProfessor = nomeProfessor;
		this.numeroSala = numeroSala;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getNotaPrimeiroSemestre() {
		return notaPrimeiroSemestre;
	}

	public void setNotaPrimeiroSemestre(double notaPrimeiroSemestre) {
		this.notaPrimeiroSemestre = notaPrimeiroSemestre;
	}

	public double getNotaSegundoSemestre() {
		return notaSegundoSemestre;
	}

	public void setNotaSegundoSemestre(double notaSegundoSemestre) {
		this.notaSegundoSemestre = notaSegundoSemestre;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	
}
