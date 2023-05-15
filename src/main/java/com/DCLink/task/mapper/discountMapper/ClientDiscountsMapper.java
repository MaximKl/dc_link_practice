package com.DCLink.task.mapper.discountMapper;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class ClientDiscountsMapper {
    public String apply(float basicDisc, float productDisc, float productFixedDisc) {
        StringBuilder discounts = new StringBuilder("");
        if (basicDisc > 0)
            discounts.append(MessageFormat.format("Базова знижка на продукт: {0}%; ", basicDisc));
        if (productDisc > 0)
            discounts.append(MessageFormat.format("Відсоткова знижка на продукт: {0}%; ", productDisc));
        if (productFixedDisc > 0)
            discounts.append(MessageFormat.format("Фіксована знижка на продукт: {0} грн; ", productFixedDisc));

        if (discounts.toString().isBlank())
            discounts.append("У вас немає знижок");

        return discounts.toString();
    }
}
