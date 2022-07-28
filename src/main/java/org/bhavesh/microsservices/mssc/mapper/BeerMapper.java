package org.bhavesh.microsservices.mssc.mapper;

import org.bhavesh.microsservices.mssc.domain.Beer;
import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beertoBeerDTO(Beer beer);
    Beer beerDTOtoBeer(BeerDTO beer);
}