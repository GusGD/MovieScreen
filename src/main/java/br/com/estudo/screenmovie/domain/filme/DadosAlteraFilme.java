package br.com.estudo.screenmovie.domain.filme;

import java.util.UUID;

public record DadosAlteraFilme(UUID id, String nome, Integer duracao, Integer ano, String genero) { }
