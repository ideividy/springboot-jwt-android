package br.com.proximus.politicohonesto.models;

public class Deputado {

    private Long id;
    private Long idDadosAbertos;
    private String uri;
    private String nome;
    private String siglaPartido;
    private String siglaUf;
    private Long idLegislatura;
    private String urlFoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDadosAbertos() {
        return idDadosAbertos;
    }

    public void setIdDadosAbertos(Long idDadosAbertos) {
        this.idDadosAbertos = idDadosAbertos;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public Long getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(Long idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Deputado{" +
                "id=" + id +
                ", idDadosAbertos=" + idDadosAbertos +
                ", uri='" + uri + '\'' +
                ", nome='" + nome + '\'' +
                ", siglaPartido='" + siglaPartido + '\'' +
                ", siglaUf='" + siglaUf + '\'' +
                ", idLegislatura=" + idLegislatura +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
