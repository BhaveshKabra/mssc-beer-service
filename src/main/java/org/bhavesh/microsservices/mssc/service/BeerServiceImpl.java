package org.bhavesh.microsservices.mssc.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bhavesh.microsservices.mssc.domain.Beer;
import org.bhavesh.microsservices.mssc.mapper.BeerMapper;
import org.bhavesh.microsservices.mssc.repositories.BeerRepository;
import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    @Override
    public BeerDTO getById(UUID beerId) {
        Optional<Beer> optBeer=beerRepository.findById(beerId);
        return beerMapper.beertoBeerDTO(optBeer.orElse(Beer.builder().build()));
    }
    @Override
    public BeerDTO save(BeerDTO beerDTO) {
        return beerMapper.beertoBeerDTO (beerRepository.save(beerMapper.beerDTOtoBeer(beerDTO)));
    }
    @Override
    public BeerDTO update(UUID beerId, BeerDTO beerDTO)
    {
        Optional<Beer> optBeer=beerRepository.findById(beerId);
        if(optBeer.isPresent())
        {
            Beer beer=optBeer.get();
            beer.setBeerName(beerDTO.getBeerName());
            beer.setBeerStyle(beerDTO.getBeerStyle().name());
            beer.setPrice(beerDTO.getPrice());
            beer.setUpc(beerDTO.getUpc());
            return beerMapper.beertoBeerDTO(beerRepository.save(beer));
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(UUID beerId)
    {
        beerRepository.deleteById(beerId);
    }
}
