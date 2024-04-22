package org.example.inventoryclient.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private Integer quantityInStock, valueInStock  ;
    private String name;
}
