package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity // Faz com que a classe seja interpretada pelo bd como uma tabela.
@Table(name = "postagem")
public class Postagem {
	
	@Id // Transforma numa chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)// equivalente ao auto_increment do bd
	public long id;
	
	@NotNull
	@Size(min = 5, max = 100)
	public String titulo;
	
	@NotNull
	@Size(min = 10, max = 500)
	public String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date data = new java.sql.Date(System.currentTimeMillis());
	// Assim que passar um dado por essa classe, ele capta a data, hora e segundos.

	// Métodos getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
