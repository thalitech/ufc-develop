package com.ufc.sistemaufc.model;

public class Lutador {

    private String usuario;
    private String nome;
    private Integer idade;
    private String sexo;
    private String cpf;
    private String email;
    private String celular;
    private Double peso;
    private String categoria;
    private String cidade;
    private String estado;
    private String pais;

    public Lutador() {
	super();
    }

    public Lutador(String usuario, String nome, Integer idade, String sexo, String cpf, String email, String celular,
		   String pais, Double peso, String categoria, String cidade, String estado) {
	super();
	this.usuario = usuario;
	this.nome = nome;
	this.idade = idade;
	this.sexo = sexo;
	this.cpf = cpf;
	this.email = email;
	this.celular = celular;
	this.pais = pais;
	this.peso = peso;
	this.categoria = categoria;
	this.cidade = cidade;
	this.estado = estado;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Integer getIdade() {
	return idade;
    }

    public void setIdade(Integer idade) {
	this.idade = idade;
    }

    public String getSexo() {
	return sexo;
    }

    public void setSexo(String sexo) {
	this.sexo = sexo;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getCelular() {
	return celular;
    }

    public void setCelular(String celular) {
	this.celular = celular;
    }

    public Double getPeso() {
	return peso;
    }

    public void setPeso(Double peso) {
	this.peso = peso;
    }

    public String getCategoria() {
	return categoria;
    }

    public void setCategoria(String categoria) {
	this.categoria = categoria;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public String getPais() {
	return pais;
    }

    public void setPais(String pais) {
	this.pais = pais;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Lutador other = (Lutador) obj;
	if (cpf == null) {
	    if (other.cpf != null)
		return false;
	} else if (!cpf.equals(other.cpf))
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Lutador [usuario=" + usuario + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", cpf=" + cpf
	    + ", email=" + email + ", celular=" + celular + ", peso=" + peso + ", categoria=" + categoria
	    + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + "]";
    }
	
}
