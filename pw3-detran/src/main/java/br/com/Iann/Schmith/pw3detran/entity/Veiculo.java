package br.com.Iann.Schmith.pw3detran.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
	@Column(name = "idVeiculo")
	private int id;
	
	@Column(name = "renavam")
	private String renavam;
	
	@Column(name = "placa")
	private String placa;

	@Column(name = "modelo")
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "proprietario")
	private Pessoa proprietario;
	
}
