package com.php.java14examples.record;

import com.php.java14examples.entity.ProductEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record ProductRecordDTO(@NotNull @NotEmpty String name, @Max(1) @Min(0) int status){

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .name(this.name)
                .status(this.status)
                .build();
    }

}
