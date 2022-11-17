package com.restaurant.Mappers.Main;

import com.restaurant.Dto.Main.DishProductsDto;
import com.restaurant.Models.DishProducts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface DishProductsMapper {

    @Mapping(source = "product.name", target = "productName")
    DishProductsDto modelToDto( DishProducts dishProducts);
    List<DishProductsDto> modelsToDtos( List<DishProducts> dishProducts);

}
