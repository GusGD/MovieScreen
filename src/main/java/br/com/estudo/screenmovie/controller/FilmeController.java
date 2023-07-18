package br.com.estudo.screenmovie.controller;

import br.com.estudo.screenmovie.domain.filme.DadosAlteraFilme;
import br.com.estudo.screenmovie.domain.filme.DadosCadastroFilme;
import br.com.estudo.screenmovie.domain.filme.Filme;
import br.com.estudo.screenmovie.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("/filmes")
public class FilmeController {

  @Autowired
  private FilmeRepository repository;
  @GetMapping("/formulario")
  public String carregaPaginaFormulario(String id, Model model) {
    if (id != null) {
      Filme filme = repository.findById(UUID.fromString(id)).orElse(null);
      model.addAttribute("filme", filme);
    }
    return "filmes/formulario";
  }


  @GetMapping()
  public String listaPaginaFilme(Model model){
    model.addAttribute("lista", repository.findAll());
    return "filmes/listagem";
  }

  @PostMapping
  @Transactional
  public String cadastraFilme(DadosCadastroFilme dados) {
    var filme = new Filme(dados);
    repository.save(filme);
    return "redirect:/filmes";
  }

  @PutMapping
  @Transactional
  public String editaFilme(DadosAlteraFilme dados) {
    if (dados.id() != null) {
      Filme filme = repository.findById(dados.id()).orElse(null);
      filme.atualizaDados(dados);
    }
    return "redirect:/filmes";
  }

  @DeleteMapping
  @Transactional
  public String excluiFilme(String id){
    System.out.println(id);
    repository.deleteById(UUID.fromString(id));
    return "redirect:/filmes";
  }
}
