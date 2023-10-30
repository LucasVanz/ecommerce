package tech.ada.ecommerce.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Cliente;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeCompleto(String nome);
    List<Cliente> findByNomeCompletoLike(String nome);
    @Query("SELECT c FROM Cliente c WHERE c.nomeCompleto LIKE concat('%', :nome, '%')")
    List<Cliente> findByNomeCompletoCustom(String nome);

    @Query("SELECT c FROM Cliente c WHERE c.ativo = true")
    List<Cliente> findByAtivo();

    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    List<Cliente> findByCustom();
    @Modifying
    @Query("UPDATE Cliente c SET c.ativo = :ativo WHERE c.id = :id")
    void ativarUsuario(@Param("ativo") boolean ativo, @Param("id") Long id);

    @Query(value = "UPDATE Cliente c SET c.ativo = :ativo WHERE c.id = :id", nativeQuery = true)
    void ativarUsuario2(@Param("ativo") boolean ativo, @Param("id") Long id);

    Optional<Cliente> findByEmail(String email);

}
