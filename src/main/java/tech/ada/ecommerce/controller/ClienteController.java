package tech.ada.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/todos")
    public List<Cliente> getClientes(){
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/ativos")
    public List<Cliente> getClientesAtivos(){
        return clienteService.buscarTodosAtivos();
    }
//    @RequestMapping("")
//    public List<Cliente> getClientes(){
//        return clienteService.buscarTodosClientes();
//    }

//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = { RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
         try {
             return new ResponseEntity<>(clienteService.criarCliente(cliente), HttpStatus.CREATED);
         }catch (Exception exception){
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id){
        return new ResponseEntity<>(clienteService.buscaPorId(id), HttpStatus.OK);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Cliente>> getClienteByName(@RequestParam("nome") String nome){
        return new ResponseEntity<>(clienteService.buscaPorNome(nome), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id){
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PutMapping("")
//    public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente){
//        try {
//            return new ResponseEntity<>(clienteService.criarCliente(cliente), HttpStatus.CREATED);
//        }catch (Exception exception){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> ativarDesativarCliente(@PathVariable("id") Long id, @RequestParam("ativo") boolean ativo){
        clienteService.ativarUser(ativo, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/endereco/{id}")
    public ResponseEntity<Void> adicionarEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco){
        clienteService.adicionarEndereco(id, endereco);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PutMapping("/endereco/{id}")
//    public ResponseEntity<Void> adicionarEndereco(@RequestParam("id") Long id, @RequestParam Endereco endereco){
//        clienteService.adicionarEndereco(id, endereco);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
