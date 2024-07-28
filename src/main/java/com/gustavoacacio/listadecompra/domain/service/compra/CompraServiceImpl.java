package com.gustavoacacio.listadecompra.domain.service.compra;


import com.gustavoacacio.listadecompra.core.service.ServiceAbstract;
import com.gustavoacacio.listadecompra.domain.mapper.CompraMapper;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.repository.CompraRepository;
import com.gustavoacacio.listadecompra.domain.service.item.ItemService;
import com.gustavoacacio.listadecompra.exception.RegistroNaoEncontradoException;
import com.gustavoacacio.listadecompra.producer.ItemProducer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        CompraDto compraDtoNova = fabricarCompra(compraDto);
        var compraSalva = compraMapper.toDto(super.salvar(compraMapper.toEntity(adicionarItens(compraDto, compraDtoNova))));
        compraSalva.getItems().forEach(itemProducer::fabricarHistorico);
        return compraSalva;
    }

    public CompraDto fabricarCompra(CompraDto compraDto) {
        Compra compra = Compra.builder().build();
        if (Objects.nonNull(compraDto.getId())) {
            compra = repo.findById(compraDto.getId()).orElseThrow(() -> new RegistroNaoEncontradoException(compraDto.getId(), CompraDto.class.getName()));
        } else {
            compra = repo.save(compra);
        }
        return compraMapper.toDto(compra);
    }

    private CompraDto adicionarItens(CompraDto compraDto, CompraDto compraDtoNova) {
        List<ItemDto> items = new LinkedList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ItemDto itemDto : compraDto.getItems()) {
            if (Objects.nonNull(itemDto.getId())) {
                var item = itemService.buscarPorId(itemDto.getId());
                if (item.isPresent()) {
                    itemDto.setId(item.get().getId());
                    itemDto.setCompraId(compraDtoNova.getId());
                    items.add(itemDto);
                } else {
                    itemDto.setCompraId(compraDtoNova.getId());
                    items.add(itemDto);
                }
            } else {
                itemDto.setCompraId(compraDtoNova.getId());
                items.add(itemDto);
            }
            valorTotal = valorTotal.add(itemDto.getValor().multiply(BigDecimal.valueOf(itemDto.getQuantidade())));
        }
        compraDtoNova.setItems(items);
        compraDtoNova.setValorTotal(valorTotal);
        return compraDtoNova;
    }

    @Override
    public Page<CompraDto> listar(Pageable pageable) {
        Page<Compra> compraPage = super.listarPagina(pageable);
        List<CompraDto> comprasDtosList = compraPage.getContent()
                .stream().map(compraMapper::toDto)
                .toList();
        return new PageImpl<>(comprasDtosList, pageable, compraPage.getTotalElements());
    }
}
