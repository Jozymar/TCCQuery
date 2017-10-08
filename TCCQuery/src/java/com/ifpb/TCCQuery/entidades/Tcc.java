package com.ifpb.TCCQuery.entidades;

import org.bson.Document;

public class Tcc {
    private String id;
    private String titulo;
    private String autor;
    private String orientador;
    private String palavrasChave;
    private String resumo;
    private String ano;
    private String area;
    private String pdf;
    private String path;

    public Tcc() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Document toDocument() {
        Document doc = new Document()
                .append("id", id)
                .append("titulo", titulo)
                .append("autor", autor)
                .append("orientador", orientador)
                .append("palavrasChave", palavrasChave)
                .append("resumo", resumo)
                .append("ano", ano)
                .append("area", area)
                .append("pdf", pdf)
                .append("path", path); 
        return doc;
    }
    
    public Tcc fromDocument(Document doc){
        id = doc.getString("id");
        titulo = doc.getString("titulo");
        autor = doc.getString("autor");
        orientador = doc.getString("orientador");
        palavrasChave = doc.getString("palavrasChave");
        resumo = doc.getString("resumo");
        ano = doc.getString("ano");
        area = doc.getString("area");
        pdf = doc.getString("pdf");
        path = doc.getString("path");
        return this;
    } 
    
}