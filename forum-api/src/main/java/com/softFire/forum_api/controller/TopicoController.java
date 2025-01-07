package com.softFire.forum_api.controller;

import com.softFire.forum_api.model.Topico;
import com.softFire.forum_api.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    @PostMapping
    public Topico adicionar(@RequestBody Topico topico) {
        return topicoRepository.save(topico);
    }

    @PutMapping("/{id}")
    public Topico alterar(@PathVariable Long id, @RequestBody Topico topico) {
        Topico existente = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        existente.setTitulo(topico.getTitulo());
        existente.setMensagem(topico.getMensagem());
        return topicoRepository.save(existente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }
}
