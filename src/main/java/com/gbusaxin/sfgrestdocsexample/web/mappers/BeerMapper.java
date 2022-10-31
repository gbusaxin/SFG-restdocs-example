package com.gbusaxin.sfgrestdocsexample.web.mappers;

import com.gbusaxin.sfgrestdocsexample.domain.Beer;
import com.gbusaxin.sfgrestdocsexample.web.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
