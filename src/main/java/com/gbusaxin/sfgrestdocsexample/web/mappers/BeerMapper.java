package com.gbusaxin.sfgrestdocsexample.web.mappers;

import com.gbusaxin.sfgrestdocsexample.domain.Beer;
import com.gbusaxin.sfgrestdocsexample.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Mapper(uses = {DateMapper.class}, componentModel = "spring")
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
