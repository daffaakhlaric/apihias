package com.hias.apps.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPilihanDto {


    @JsonProperty("productId")
    private Long productId;

    @JsonCreator
    public ProductPilihanDto(
            @JsonProperty("productId")
                    Long productId) {

        this.productId = productId;

    }


    public Long getProductId(Long productId) {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
