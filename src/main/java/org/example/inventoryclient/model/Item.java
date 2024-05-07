package org.example.inventoryclient.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Item {
    private Integer quantity, valueInStock  ;
    private String name, color, description;
}
