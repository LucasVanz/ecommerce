package tech.ada.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.ecommerce.DTO.CEP;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.service.EnderecoService;


@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<CEP> getByCep(@PathVariable("cep") String cep){
        return new ResponseEntity<>(enderecoService.buscaPorCep(cep), HttpStatus.OK);
    }


    @RequestMapping(value = "", method = { RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco){
        try {
            return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
