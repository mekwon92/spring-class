package com.pilllaw.pilllaw.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPriceDto {

    private Long priceId;
    private Long pno;
    private Double price;
    private Double salePrice;
}
