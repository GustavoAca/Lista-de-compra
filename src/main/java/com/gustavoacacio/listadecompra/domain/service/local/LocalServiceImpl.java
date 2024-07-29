package com.gustavoacacio.listadecompra.domain.service.local;

import com.gustavoacacio.listadecompra.core.service.ServiceAbstract;
import com.gustavoacacio.listadecompra.domain.mapper.LocalMapper;
import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.LocalDto;
import com.gustavoacacio.listadecompra.domain.repository.LocalRepository;
import com.gustavoacacio.listadecompra.exception.RegistroJaCadastradoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocalServiceImpl extends ServiceAbstract<Local, UUID, LocalRepository> implements LocalService {

    private final LocalMapper localMapper;

    protected LocalServiceImpl(LocalRepository repo,
                               LocalMapper localMapper) {
        super(repo);
        this.localMapper = localMapper;
    }

    @Override
    public LocalDto cadastrar(LocalDto localDto) {
        if (repo.findByNome(localDto.getNome()).isPresent()) {
            throw new RegistroJaCadastradoException("Local já cadastrado");
        }
        return localMapper.toDto(super.salvar(localMapper.toEntity(localDto)));
    }

    @Override
    public Page<LocalDto> listarPaginado(Pageable pageable) {
        Page<Local> locaisPage = super.listarPagina(pageable);

        List<LocalDto> itemDtoList = locaisPage.getContent()
                .stream()
                .map(localMapper::toDto)
                .toList();

        return new PageImpl<>(itemDtoList, pageable, locaisPage.getTotalElements());
    }
}