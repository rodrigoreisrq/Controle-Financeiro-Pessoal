package com.reis.financeiro.service;

import com.reis.financeiro.entities.Registro;
import com.reis.financeiro.entities.TipoRegistroDTO;
import com.reis.financeiro.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {
    private final RegistroRepository repository;

    @Autowired
    public RegistroService(RegistroRepository repository){
        this.repository =repository;
    }

    public List<Registro> listarRegistros(){
        return repository.findAll();
    }

    public Registro adicionarRegistro(String nome, String descricao, String data, TipoRegistroDTO tipoRegistro){
        Registro registro = new Registro(nome, data, descricao, tipoRegistro);
        return repository.save(registro);
    }

    public void deletarRegistro(int id){
        repository.deleteById(id);

    }
    public Registro buscarPorId(int id){
        Registro registro = repository.findById(id).get();
        return registro;
    }
}
