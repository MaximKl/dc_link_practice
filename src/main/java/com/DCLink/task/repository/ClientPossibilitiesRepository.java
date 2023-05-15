package com.DCLink.task.repository;

import com.DCLink.task.model.ClientPossibilities;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientPossibilitiesRepository extends CrudRepository<ClientPossibilities,Long> {
    List<ClientPossibilities> findAllBy();

    @Query(value = "exec getPossibilities @client_id=:client,@product_id=:product", nativeQuery = true)
    Optional<ClientPossibilities> getFullClientPossibilities(@Param("client") long clientId, @Param("product") long productId);

    List<ClientPossibilities> findAllByClientId(long clientId);

}
