package com.ism.erp.prodman.dto;

import lombok.Data;

@Data
public class ItemDto {

    private Long id;
    private String name;
    private String type;
    private String code;
    private Double width;
    private Double weight;
    private Double depth;
    private Double height;
    private Boolean active;
    private Double costPrice;
    private String description;

}
