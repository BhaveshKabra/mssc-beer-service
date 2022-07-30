package org.bhavesh.microsservices.mssc.web.controller;

import lombok.AllArgsConstructor;
import org.bhavesh.microsservices.mssc.service.BeerService;
import org.bhavesh.microsservices.mssc.service.BeerServiceImpl;
import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer/")
@AllArgsConstructor
public class BeerController {

    public final BeerService beerService;
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId)
    {
        BeerDTO beerDTO=beerService.getById(beerId);
        if(beerDTO!=null)
            return new ResponseEntity<> (beerDTO, HttpStatus.OK);
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @PostMapping
    public ResponseEntity<BeerDTO> saveNewBeer(@RequestBody @Validated BeerDTO beerDTO)
    {
        return new ResponseEntity<>(beerService.save(beerDTO),HttpStatus.CREATED);
    }
    @PatchMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> updateBeer(@PathVariable UUID beerId,@RequestBody @Validated BeerDTO beer)
    {
        return new ResponseEntity <> (beerService.update(beerId,beer),HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<BeerDTO> removeBeer(@RequestBody UUID beerId)
    {
        //beerDTO.
        beerService.delete(beerId);
        return new ResponseEntity <> (HttpStatus.NO_CONTENT);
    }
}
