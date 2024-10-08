package com.gustavoacacio.listadecompra.domain.service.compra;


import com.gustavoacacio.listadecompra.core.service.JpaServiceImpl;
import com.gustavoacacio.listadecompra.domain.mapper.CompraMapper;
import com.gustavoacacio.listadecompra.domain.mapper.ItemMapper;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.TipoHistorico;
import com.gustavoacacio.listadecompra.domain.repository.jpa.CompraRepository;
import com.gustavoacacio.listadecompra.domain.service.historico.HistoricoItemService;
import com.gustavoacacio.listadecompra.domain.service.item.ItemService;
import com.gustavoacacio.listadecompra.exception.RegistroNaoEncontradoException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraServiceImpl extends JpaServiceImpl<Compra, Long, CompraRepository> implements CompraService {

    private final CompraMapper compraMapper;
    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private final HistoricoItemService historicoItemService;

    public CompraServiceImpl(CompraRepository repo,
                             CompraMapper compraMapper,
                             ItemService itemService,
                             ItemMapper itemMapper,
                             HistoricoItemService historicoItemService) {
        super(repo);
        this.compraMapper = compraMapper;
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.historicoItemService = historicoItemService;
    }

    @CacheEvict(value = {"listaDeCompra", "listaDeItem"}, allEntries = true)
    public CompraDto salvar(CompraDto compraDto) {
        buscarItens(compraDto);
        compraDto = compraMapper.toDto(super.salvar(compraMapper.toEntity(compraDto)));
        salvarHistoricoItem(compraDto);
        return compraDto;
    }

    private void buscarItens(CompraDto compraDto) {
        if (!compraDto.getItems().isEmpty()) {
            List<ItemDto> itens = new ArrayList<>();
            for (int i = 0; i < compraDto.getItems().size(); i++) {
                var item = compraDto.getItems().get(i);
                var itemEncontrado = itemService.buscarPorId(item.getId())
                        .orElseThrow(() -> new RegistroNaoEncontradoException(item.getId(), item.getClass().getName()));
                ItemDto itemDto = itemMapper.toDto(itemEncontrado);
                compraDto.setValorTotal(calcularTotal(compraDto.getValorTotal(), itemDto.getValor(), item.getQuantidade()));
                itens.add(itemDto);
            }
            compraDto.setItems(itens);
        }
    }

    private BigDecimal calcularTotal(BigDecimal valorTotal, BigDecimal valorProduto, Long quantiade) {
        return valorTotal.add(valorProduto.multiply(BigDecimal.valueOf(quantiade)));
    }

    private void salvarHistoricoItem(CompraDto compra) {
        HistoricoItemDto historicoItemDto = HistoricoItemDto.builder()
                .compraId(compra.getId())
                .build();

        compra.getItems().forEach(i -> {
            HistoricoItemDto h = fabricarHistorico(historicoItemDto, i);
            historicoItemService.salvar(TipoHistorico.TIPO_HISTORICO_ITEM.getFactory().fabricar(h));
        });
    }

    private HistoricoItemDto fabricarHistorico(HistoricoItemDto historicoItemDto, ItemDto itemDto) {
        historicoItemDto.setItemId(itemDto.getId());
        historicoItemDto.setValorItem(itemDto.getValor());
        historicoItemDto.setLocalId(itemDto.getLocalId());
        return historicoItemDto;
    }

    @Override
    @Cacheable(value = "listaDeCompra", key = "#pageable.pageNumber")
    public Page<CompraDto> listar(Pageable pageable) {
        Page<Compra> compraPage = super.listarPagina(pageable);
        List<CompraDto> comprasDtosList = compraPage.getContent()
                .stream().map(compraMapper::toDto)
                .toList();
        return new PageImpl<>(comprasDtosList, pageable, compraPage.getTotalElements());
    }
}
