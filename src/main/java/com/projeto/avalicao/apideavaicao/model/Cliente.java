package com.projeto.avalicao.apideavaicao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.projeto.avalicao.apideavaicao.annotationCustom.ValidSexo;

@Entity
@Table(name = "TB_Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TX_Nome")
	@NotBlank(message = "O campo nome é obrigatorio")
	private String nome;
	
	@Column(name="DT_dataNascimento")
	@Past(message = "Não permitido valores futuros") 
	private Date dataNascimento;
	
	@Column(name="NR_Idade")
	@Min(value = 0, message = "Permitidos valores acima de 0" )
	@Max(value = 130, message = "Permitidos valores ate 130" )
	private int idade;
	
	@Column(name="Fl_Sexo")
	@ValidSexo(message = "Permitido apenas os caracteres M ou F" )
	private char sexo; 
	
	@ManyToOne
	@NotNull(message = "A cidade é obrigatorio")
	private Cidade cidade;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
