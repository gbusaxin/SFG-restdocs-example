package com.gbusaxin.sfgrestdocsexample.web.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Data
@Getter
@Setter
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Long version;
    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String beerName;
    @NotNull
    private String beerStyle;

    @NotNull
    @Positive
    private Long upc;

    @NotNull
    @Positive
    private BigDecimal price;

    private Integer minOnHand;
    private Integer quantityToBrew;

    @Builder
    public BeerDto(UUID id, Long version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate, String beerName, String beerStyle, Long upc, BigDecimal price, Integer minOnHand, Integer quantityToBrew) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
        this.minOnHand = minOnHand;
        this.quantityToBrew = quantityToBrew;
    }
}
