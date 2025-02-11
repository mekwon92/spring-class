package com.pilllaw.pilllaw.dto.product;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long pno;
    private String pname;
    private String company;
    private Date bestBefore;
    private String effect;
    private String precautions;
    private String keep;
    private String cname;
    private String type;
}