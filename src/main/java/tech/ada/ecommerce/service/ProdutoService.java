package tech.ada.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> buscarTodosProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscaPorId(Long id){
        Optional<Produto> optProduto = produtoRepository.findById(id);
        return optProduto.orElseThrow(() -> new RuntimeException("Não existe produto com esse 'id'"));
    }

    public List<Produto> buscarPorNome(String nome){
        Sort sort = Sort.by(Sort.Direction.ASC);
        List<Produto> produtosCrescente = produtoRepository.findAll(sort);
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> buscarPorDescricao(String descricao){
        return produtoRepository.findByDescricao(descricao);
    }

    public List<Produto> buscarPorSku(String sku){
        return produtoRepository.findBySku(sku);
    }
}
