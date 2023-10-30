package tech.ada.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.service.ClienteService;
import tech.ada.ecommerce.service.ProdutoService;

import java.util.List;

//@RestController
//@RequestMapping("/api/v1")
public class helloWorld {

//    @Autowired
//    ClienteService clienteService;
//    @Autowired
//    ProdutoService produtoService;
//
//    @GetMapping("/{nome}")
//    public List<Cliente> buscarClientes(@PathVariable("nome") String nome){
//        return clienteService.buscaPorNome(nome);
//    }
//
//    @GetMapping("/p/{nomeProduto}")
//    public List<Produto> buscarProdutos(@PathVariable("nomeProduto") String nomeProduto){
//        return produtoService.buscarPorNome(nomeProduto);
//    }
//
//    @GetMapping("/d/{descricao}")
//    public List<Produto> buscarProdutosDesc(@PathVariable("descricao") String descricao){
//        return produtoService.buscarPorDescricao(descricao);
//    }
//    @GetMapping("/s/{sku}")
//    public List<Produto> buscarProdutosSku(@PathVariable("sku") String sku){
//        return produtoService.buscarPorSku(sku);
//    }
}
