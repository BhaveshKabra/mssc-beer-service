package org.bhavesh.microsservices.mssc.service;

import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.springframework.stereotype.Service;


import java.util.UUID;

public interface BeerService {

    BeerDTO getById(UUID beerId);
    BeerDTO save(BeerDTO beerDTO);
    BeerDTO update(UUID beerId,BeerDTO beerDTO);

    void delete(UUID beerId);
}
