package com.ifpb.TCCQuery.entidades;

import org.bson.Document;

public class Tcc {
   
    private int id;
    private String titulo;
    private String autor;
    private String orientador;
    private String palavrasChave;
    private String resumo;
    private int ano;
    private String area;
    private String pdf;

    public Tcc() {
    }

    public Tcc(int id, String titulo, String autor, String orientador, String palavrasChave, String resumo, int ano, String area, String pdf) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.orientador = orientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.ano = ano;
        this.area = area;
        this.pdf = pdf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Tcc{" + "titulo=" + titulo + ", autor=" + autor + ", orientador=" + orientador + ", palavrasChave=" + palavrasChave + ", resumo=" + resumo + ", ano=" + ano + ", area=" + area + ", pdf=" + pdf + '}';
    }

    public Document toDocument() {
        Document doc = new Document()
                .append("titulo", titulo)
                .append("autor", autor)
                .append("orientador", orientador)
                .append("palavrasChave", palavrasChave)
                .append("resumo", resumo)
                .append("ano", ano)
                .append("area", area)
                .append("pdf", pdf);
        return doc;
    }
    
    public Tcc fromDocument(Document doc){
        titulo = doc.getString("titulo");
        autor = doc.getString("autor");
        orientador = doc.getString("orientador");
        palavrasChave = doc.getString("palavrasChave");
        resumo = doc.getString("resumo");
        ano = doc.getInteger("ano");
        area = doc.getString("area");
        pdf = doc.getString("pdf");
        return this;
    } 
}
