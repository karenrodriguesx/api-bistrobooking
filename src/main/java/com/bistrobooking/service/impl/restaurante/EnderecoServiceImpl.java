package com.bistrobooking.service.impl.restaurante;

import com.bistrobooking.dto.restaurante.EnderecoDTO;
import com.bistrobooking.entity.Endereco;
import com.bistrobooking.repository.restaurante.EnderecoRepository;
import com.bistrobooking.service.base.restaurante.EnderecoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoServiceImpl(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EnderecoDTO buscarPorId(Long id) {
        return repository.buscarPorId(id).orElseThrow(
                () -> new IllegalArgumentException("Endereço não encontrado!"));
    }

    @Override
    public Page<EnderecoDTO> listar(Pageable pageable) {
        return repository.listar(pageable);
    }

    @Override
    public EnderecoDTO salvar(EnderecoDTO form) {
        Endereco endereco = new Endereco();
        endereco.setCep(form.getCep());
        endereco.setLogradouro(form.getLogradouro());
        endereco.setComplemento(form.getComplemento());
        endereco.setBairro(form.getBairro());
        endereco.setLocalidade(form.getLocalidade());
        endereco.setUf(form.getUf());

        Endereco enderecoSalvo = repository.save(endereco);

        form.setId(enderecoSalvo.getId());

        return form;
    }

    @Override
    public EnderecoDTO atualizar(Long id, EnderecoDTO form) {
        Endereco endereco = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Endereço não encontrado!"));

        endereco.setId(id);
        endereco.setCep(form.getCep());
        endereco.setLogradouro(form.getLogradouro());
        endereco.setComplemento(form.getComplemento());
        endereco.setBairro(form.getBairro());
        endereco.setLocalidade(form.getLocalidade());
        endereco.setUf(form.getUf());

        repository.save(endereco);

        return form;
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
