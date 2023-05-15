package com.DCLink.task.controller;

import com.DCLink.task.dto.defaultDTO.*;
import com.DCLink.task.dto.discountDTO.AllClientPossibilitiesDTO;
import com.DCLink.task.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dclink")
@AllArgsConstructor
public class MainController {

    private final MainService service;

    @GetMapping("/brands")
    public List<BrandDTO> allBrands() {
        return service.getAllProductBrands();
    }

    @GetMapping("/types")
    public List<ProductTypeDTO> allTypes() {
        return service.getAllProductTypes();
    }

    @GetMapping("/clients")
    public List<ClientDTO> allClients() {
        return service.getAllClients();
    }

    @GetMapping("/products")
    public List<ProductDTO> allProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/possibilities")
    public List<ClientPossibilitiesDTO> allPossibilities() {
        return service.getAllClientPossibilities();
    }

    @GetMapping("/product-with-discount/{clientId}/{productId}")
    public ResponseEntity getDiscountForClient(@PathVariable(name = "clientId") String clientId, @PathVariable(name = "productId") String productId) {
        return service.getClientDiscount(clientId, productId);
    }

    @GetMapping("/possibilities/{clientId}")
    public AllClientPossibilitiesDTO getAllClientPossibilities(@PathVariable(name = "clientId") String clientId) {
        return service.getAllChosenClientPossibilities(clientId);
    }

}
