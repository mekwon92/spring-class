package com.pilllaw.pilllaw.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPriceDto {

    private Long ppno;
    private Long pno;
    private Long price;
    private Long salePrice;
}
