package tech.ada.ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import tech.ada.ecommerce.DTO.CEP;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.repository.EnderecoRepository;


@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    public CEP buscaPorCep(String cep){
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://viacep.com.br/ws/";
//        ResponseEntity<CEP> response = restTemplate.getForEntity(url + cep + "/json", CEP.class);
//        return response.getBody();
        String url = "http://viacep.com.br/ws/";
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        CEP result =  webClient.get().uri(cep + "/json").retrieve().bodyToMono(CEP.class).block();
        return result;
    }

    public Endereco saveEndereco(Endereco endereco){
        CEP cep = buscaPorCep(endereco.getCep());
        endereco.setUf(cep.getUf());
        endereco.setCidade(cep.getLocalidade());
        endereco.setBairro(cep.getBairro());
        endereco.setLogradouro(cep.getLogradouro());
        return enderecoRepository.save(endereco);
    }
}
