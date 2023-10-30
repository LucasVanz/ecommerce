package tech.ada.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Compra;
import tech.ada.ecommerce.model.ItemProduto;
import tech.ada.ecommerce.repository.CompraRepository;
import tech.ada.ecommerce.repository.ItemProdutoRepository;

import java.util.Optional;

@Service
public class CompraService {

        CompraRepository compraRepository;

        public CompraService(CompraRepository compraRepository) {
            this.compraRepository = compraRepository;
        }

        public Compra buscarCompra(Long id) {
            Optional<Compra> compra = compraRepository.findById(id);
            return compra.orElseThrow(() -> new RuntimeException("Compra nao encontrada"));
        }

//        public void salvarCompra(Compra compra, ItemProduto itemProduto) {
////        ItemProduto itemProduto = new ItemProduto();
////        compra.getItens().add(itemProduto);
//            Compra savedCompra = compraRepository.save(compra);
//            itemProduto.setCompra(savedCompra);
//            itemProdutoRepository.save(itemProduto);
//        }

    }

