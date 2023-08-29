package mediarte.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mediarte.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicosController {

    @Autowired
    private MedicoRespository respository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody  @Valid DadosCadastroMedico dados) {
    respository.save(new Medico(dados));

    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return respository.findAll(paginacao).map(DadosListagemMedico::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody  @Valid DadosAtualizacaoMedico dados) {
        var medico = respository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        respository.deleteById(id);
    }
}
