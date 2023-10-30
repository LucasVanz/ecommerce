package tech.ada.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.ClienteEndereco;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.repository.ClienteEnderecoRepository;
import tech.ada.ecommerce.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    //faz o papel do construtor
    //@Autowired
    ClienteRepository clienteRepository;

    ClienteEnderecoRepository clienteEnderecoRepository;

    public ClienteService(ClienteRepository clienteRepository, ClienteEnderecoRepository clienteEnderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteEnderecoRepository = clienteEnderecoRepository;
    }

    public List<Cliente> buscarTodosClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public List<Cliente> buscarTodosAtivos(){
        List<Cliente> clientes = clienteRepository.findByAtivo();
        return clientes;
    }
    public Cliente criarCliente(Cliente cliente){
        Cliente clienteNew;
        if(cliente.getId() != null) {
            clienteNew = new Cliente(cliente.getId(), cliente.getNomeCompleto(), cliente.getDataNascimento(), cliente.getCpf(), cliente.getEmail(), cliente.getSenha(), cliente.isAtivo());
        }else {
            clienteNew = cliente;
        }
        return clienteRepository.save(clienteNew);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
    public Cliente buscaPorId(Long id){
        Optional<Cliente> optCliente = clienteRepository.findById(id);
        return optCliente.orElseThrow(() -> new RuntimeException("Não existe cliente com esse 'id'"));
    }

    public List<Cliente> buscaPorNome(String nome){
        return clienteRepository.findByNomeCompletoCustom(nome);
    }

    public void ativarUser(boolean ativo, Long id){
        clienteRepository.ativarUsuario(ativo, id);
    }

    public void adicionarEndereco(Long id, Endereco endereco){
        Optional<Cliente> optCliente = clienteRepository.findById(id);
        Cliente cliente = optCliente.orElseThrow(() -> new RuntimeException("Não existe cliente com esse 'id'"));
        ClienteEndereco clienteEndereco = new ClienteEndereco();
        clienteEndereco.setEndereco(endereco);
        clienteEndereco.setCliente(cliente);
        clienteEnderecoRepository.save(clienteEndereco);
    }
}
