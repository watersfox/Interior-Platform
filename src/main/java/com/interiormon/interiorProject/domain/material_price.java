package com.interiormon.interiorProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class material_price {

    @Id
    private int MAT_CODE;
    
    private String MAT_CAT;
    private String MAT_NAME;
    private double MAT_PRICE;
}
