package com.restaurant.Mappers.Administration.Units;


import com.restaurant.Dto.Administration.Unit.UnitDto;
import com.restaurant.Models.Unit;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface UnitMapper {

    UnitDto modelToDto ( Unit unit);

    List<UnitDto> modelsToDtos(List<Unit> units);

    Unit dtoToUnit ( UnitDto unit);

}
