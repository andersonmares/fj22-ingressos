package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Objects;

/**
 * Created by nando on 03/03/17.
 */
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Duration duracao;
    private String genero;
    private BigDecimal preco = BigDecimal.ZERO;
        
    /**
     * @deprecated hibernate only
     */
    public Filme() {

    }
    
    public Filme(String nome, Duration duracao, String genero, BigDecimal preco) {
		this.nome = nome;
		this.duracao = duracao;
		this.genero = genero;
		this.preco = preco;
	}
    
    
    
    public Filme(String nome) {
		super();
		this.nome = nome;
	}

	public BigDecimal getPreco() {
    	if(Objects.nonNull(preco)) {
    		return preco.setScale(2, RoundingMode.HALF_UP);
    	}
    	return BigDecimal.ZERO;
    }
    
    public void setPreco(BigDecimal preco) {
    	this.preco = preco;
    }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = Duration.ofMinutes(duracao);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
