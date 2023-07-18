package br.com.estudo.screenmovie.domain.filme;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "filmes")
public class Filme {

  private String nome;
  @Column(name = "duracao_em_minutos")
  private Integer duracaoEmMinutos;
  @Column(name = "ano_lancamento")
  private Integer anoLancamento;
  private String genero;

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  public Filme(DadosCadastroFilme dados) {
    this.nome = dados.nome();
    this.duracaoEmMinutos = dados.duracao();
    this.anoLancamento = dados.ano();
    this.genero = dados.genero();
  }

  public Filme() {

  }

  @Override
  public String toString() {
    return "Filme{" +
      "nome='" + nome + '\'' +
      ", duracaoEmMinutos=" + duracaoEmMinutos +
      ", anoLancamento=" + anoLancamento +
      ", genero='" + genero + '\'' +
      '}';
  }

  public String getNome() {
    return nome;
  }

  public Integer getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public Integer getAnoLancamento() {
    return anoLancamento;
  }

  public String getGenero() {
    return genero;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  public void atualizaDados(DadosAlteraFilme dados) {
    this.nome = dados.nome();
    this.anoLancamento = dados.ano();
    this.duracaoEmMinutos = dados.duracao();
    this.genero = dados.genero();
  }
}
