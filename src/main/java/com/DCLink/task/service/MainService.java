package com.DCLink.task.service;

import com.DCLink.task.dto.defaultDTO.*;
import com.DCLink.task.dto.discountDTO.AllClientPossibilitiesDTO;
import com.DCLink.task.dto.discountDTO.ProductDiscountErrorDTO;
import com.DCLink.task.exception.NotFoundException;
import com.DCLink.task.exception.TypeErrorException;
import com.DCLink.task.mapper.defaultMapper.*;
import com.DCLink.task.mapper.discountMapper.AllClientPossibilitiesMapper;
import com.DCLink.task.mapper.discountMapper.ProductFinalPriceMapper;
import com.DCLink.task.model.Client;
import com.DCLink.task.model.ClientPossibilities;
import com.DCLink.task.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.DCLink.task.constants.InputCheck.isLongNumber;
import static com.DCLink.task.constants.InputCheck.isFloatNumber;

@Service
@AllArgsConstructor
public class MainService {


    private final BrandRepository brandRepository;

    private final TypeRepository typeRepository;

    private final ClientRepository clientRepository;

    private final ProductRepository productRepository;

    private final ClientPossibilitiesRepository clientPossibilitiesRepository;

    private final BrandMapper brandMapper;
    private final ClientMapper clientMapper;
    private final PossibilitiesMapper possibilitiesMapper;
    private final ProductMapper productMapper;
    private final ProductTypeMapper productTypeMapper;
    private final ProductFinalPriceMapper productFinalPriceMapper;

    private final AllClientPossibilitiesMapper allClientPossibilitiesMapper;


    public List<ProductTypeDTO> getAllProductTypes() {
        return typeRepository.findAllBy().stream().map(productTypeMapper).toList();
    }

    public List<BrandDTO> getAllProductBrands() {
        return brandRepository.findAllBy().stream().map(brandMapper).toList();
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAllBy().stream().map(productMapper).toList();
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAllBy().stream().map(clientMapper).toList();
    }

    public List<ClientPossibilitiesDTO> getAllClientPossibilities() {
        return clientPossibilitiesRepository.findAllBy().stream().map(possibilitiesMapper).toList();
    }

    public ResponseEntity getClientDiscount(String clientId, String productId) {
        if (!isLongNumber(clientId) || !isLongNumber(productId))
            throw new TypeErrorException();

        long clientNumId = Long.parseLong(clientId);
        long productNumId = Long.parseLong(productId);
        String response = clientRepository.getPriceWithDiscount(clientNumId, productNumId);
        Optional<ClientPossibilities> cp = clientPossibilitiesRepository.getFullClientPossibilities(clientNumId, productNumId);

        if (cp.isEmpty() && !isFloatNumber(response)) {
            return new ResponseEntity(
                    new ProductDiscountErrorDTO(response, productNumId, clientNumId, Timestamp.valueOf(LocalDateTime.now())),
                    HttpStatus.OK);
        }

        if (cp.isEmpty() && isFloatNumber(response)) {
            return new ResponseEntity(productFinalPriceMapper.apply(
                    Float.parseFloat(response),
                    productRepository.findById(productNumId).get(),
                    clientRepository.findById(clientNumId).get()), HttpStatus.OK);
        }

        return new ResponseEntity(productFinalPriceMapper.applyWithPossibilities(
                Float.parseFloat(response),
                productRepository.findById(productNumId).get(),
                cp.get()), HttpStatus.OK);

    }

    public AllClientPossibilitiesDTO getAllChosenClientPossibilities(String clientId) {
        if (!isLongNumber(clientId))
            throw new TypeErrorException();

        return allClientPossibilitiesMapper.apply(
                clientRepository.findById(Long.parseLong(clientId)).orElseThrow(() -> new NotFoundException(clientId)),
                clientPossibilitiesRepository.findAllByClientId(Long.parseLong(clientId)));

    }

}
