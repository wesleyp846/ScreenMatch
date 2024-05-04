package br.com.alura.screenmatch.model;

import java.util.OptionalDouble;

public class Serie {
    //a funcionalidade dessa classe é para traduzir os dados de forma mais amigavel ao publico
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    //categoria é usada como um enum, o mesmo que uma lista de opções em Java
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    public Serie(DadosSerie dadosSerie){
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        //container generico que retorna/transforma em um double se erro volta um valor 0
        //Tento obter um valor double se eu não conseguir atribuo 0
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        //fromstring chama o metodo estatico criado em categoria enum. depois de split é pra separar e pegar a palavra quando vem mais de um
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = dadosSerie.sinopse();
    }
}
