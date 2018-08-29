package br.com.proximus.politicohonesto.modelo;

public class Deputado {

    private Long id;
    private String nome;
    private String urlImage;
    private String siglaPartido;

    public Long getId() {
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    @Override
    public String toString() {
        return "Deputado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", siglaPartido='" + siglaPartido + '\'' +
                '}';
    }
}
