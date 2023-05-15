package com.DCLink.task.mapper.discountMapper;

import com.DCLink.task.dto.discountDTO.ProductFinalPriceDTO;
import com.DCLink.task.model.Client;
import com.DCLink.task.model.ClientPossibilities;
import com.DCLink.task.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductFinalPriceMapper {

    private final ClientDiscountsMapper clientDiscountsMapper;

    public ProductFinalPriceDTO applyWithPossibilities(float finalPrice, Product product,
                                                       ClientPossibilities possibilities) {

        return new ProductFinalPriceDTO(
                MessageFormat.format("{0} {1} {2}",
                        possibilities.getClient().getSurname(),
                        possibilities.getClient().getName(),
                        possibilities.getClient().getPatronymicName()),
                possibilities.getClient().getBusinessName(),
                MessageFormat.format("{0} {1}", product.getBrand().getName(), product.getProductName()),
                finalPrice,
                product.getPrice(),
                product.getCost(),
                possibilities.getBrand() == null ?
                        MessageFormat.format("{0}", possibilities.getType().getName())
                        :
                        MessageFormat.format("{0} {1}", possibilities.getType().getName(), possibilities.getBrand().getName()),
                clientDiscountsMapper.apply(
                        possibilities.getClient().getBaseDiscount(),
                        possibilities.getDiscountPercent(),
                        possibilities.getDiscountMoney()),
                product.getId(),
                possibilities.getClient().getId(),
                Timestamp.valueOf(LocalDateTime.now()));

    }

    public ProductFinalPriceDTO apply(float finalPrice, Product product,
                                      Client client) {

        return new ProductFinalPriceDTO(
                MessageFormat.format("{0} {1} {2}",
                        client.getSurname(),
                        client.getName(),
                        client.getPatronymicName()),
                client.getBusinessName(),
                MessageFormat.format("{0} {1}", product.getBrand().getName(), product.getProductName()),
                finalPrice,
                product.getPrice(),
                product.getCost(),
                product.getType().getName(),
                clientDiscountsMapper.apply(
                        client.getBaseDiscount(),
                        0,
                        0),
                product.getId(),
                client.getId(),
                Timestamp.valueOf(LocalDateTime.now()));

    }

}
