package com.inf3fm.elden.charityconnect;

public class ONG {

    private long id;
    private String nome;
    private String nomeRep;
    private String email;
    private String telefone;
    private String cep;
    private String cnpj;
    private String uf;
    private byte[] foto;

    public ONG(long id, String nome, String nomeRep, String email, String telefone, String cep, String cnpj, String uf, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.nomeRep = nomeRep;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.cnpj = cnpj;
        this.uf = uf;
        this.foto = foto;
    }

    public ONG(long id, String nome, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeRep() {
        return nomeRep;
    }

    public void setNomeRep(String nomeRep) {
        this.nomeRep = nomeRep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
