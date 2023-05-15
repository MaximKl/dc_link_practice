package com.DCLink.task.repository;

import com.DCLink.task.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAllBy();

    @Query(value = "exec computeProductPrice @client_id=:client,@product_id=:product", nativeQuery = true)
    String getPriceWithDiscount(@Param("client") long clientId,@Param("product") long productId);

}
