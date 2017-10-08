package com.ifpb.TCCQuery.entidades;

public class Usuario {
    
    private String nome;
    private String cidade;
    private String nascimento;
    private String universidade;
    private String campus;
    private String email;
    private String senha;
    private String sexo;
    private String foto;

    public Usuario() {
    }

    public Usuario(String nome, String cidade, String nascimento, 
            String universidade, String campus, String email, String senha, 
            String sexo, String foto) {
        this.nome = nome;
        this.cidade = cidade;
        this.nascimento = nascimento;
        this.universidade = universidade;
        this.campus = campus;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", cidade=" + cidade + 
                ", nascimento=" + nascimento + ", universidade=" + 
                universidade + ", campus=" + campus + ", email=" + 
                email + ", senha=" + senha + ", sexo=" + sexo + 
                ", foto=" + foto + '}';
    }
 
}
