package com.gustavoacacio.listadecompra.domain.service.compra;

import com.gustavoacacio.listadecompra.controller.dto.CompraDto;
import com.gustavoacacio.listadecompra.core.service.ServiceAbstract;
import com.gustavoacacio.listadecompra.domain.mapper.CompraMapper;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.repository.CompraRepository;
import com.gustavoacacio.listadecompra.domain.service.item.ItemService;
import com.gustavoacacio.listadecompra.exception.RegistroNaoEncontradoException;
import com.gustavoacacio.listadecompra.producer.ItemProducer;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class CompraServiceImpl extends ServiceAbstract<Compra, Long, CompraRepository> implements CompraService {

    private final CompraMapper compraMapper;
    private final ItemService itemService;
    private final ItemProducer itemProducer;

    public CompraServiceImpl(CompraRepository repo,
                             CompraMapper compraMapper,
                             ItemService itemService,
                             ItemProducer itemProducer) {
        super(repo);
        this.compraMapper = compraMapper;
        this.itemService = itemService;
        this.itemProducer = itemProducer;
    }

    public CompraDto salvar(CompraDto compraDto) {
        Compra compra = fabricarCompra(compraDto);
        List<ItemDto> items = adicionarItens(compraDto, compra.getId());
        var compraSalva = compraMapper.toDto(super.salvar(compraMapper
                .toEntity(CompraDto.builder()
                        .itemDtos(items)
                        .id(compra.getId())
                        .build())));
        compraSalva.itemDtos().forEach(itemProducer::fabricarHistorico);
        return compraSalva;
    }

    public Compra fabricarCompra(CompraDto compraDto) {
        Compra compra = Compra.builder().build();
        if (Objects.nonNull(compraDto.id())) {
            compra = repo.findById(compraDto.id()).orElseThrow(() -> new RegistroNaoEncontradoException(compraDto.id(), CompraDto.class.getName()));
        } else {
            compra = repo.save(compra);
        }
        return compra;
    }

    public List<ItemDto> adicionarItens(CompraDto compraDto, Long compraId) {
        List<ItemDto> items = new LinkedList<>();
        for (ItemDto itemDto : compraDto.itemDtos()) {
            if (Objects.nonNull(itemDto.getId())) {
                var item = itemService.buscarPorId(itemDto.getId());
                if (item.isPresent()) {
                    itemDto.setId(item.get().getId());
                    itemDto.setCompraId(compraId);
                    items.add(itemDto);
                } else {
                    itemDto.setCompraId(compraId);
                    items.add(itemDto);
                }
            } else {
                itemDto.setCompraId(compraId);
                items.add(itemDto);
            }
        }
        return items;
    }
}
