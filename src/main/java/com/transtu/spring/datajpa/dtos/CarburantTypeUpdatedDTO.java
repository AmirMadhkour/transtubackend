package com.transtu.spring.datajpa.dtos;

import java.util.Optional;

public class CarburantTypeUpdatedDTO {

    private Optional<String> label = Optional.empty();

    public CarburantTypeUpdatedDTO() {
    }

    public CarburantTypeUpdatedDTO(Optional<String> label) {
        this.label = label;
    }

    public Optional<String> getLabel() {
        return label;
    }

    public void setLabel(Optional<String> label) {
        this.label = label;
    }

    
}
