package com.gnoatto.people.controllers;

import com.gnoatto.people.models.PessoaModel;
import com.gnoatto.people.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoas")
public class springController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaModel>>listarPessoas() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criarPessoa(@RequestBody PessoaModel pessoaModel) {
        return ResponseEntity.status(201)
                .body(pessoaService.criarPessoa(pessoaModel));
    }
}