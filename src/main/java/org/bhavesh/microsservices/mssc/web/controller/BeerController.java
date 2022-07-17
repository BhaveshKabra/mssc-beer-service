package org.bhavesh.microsservices.mssc.web.controller;

import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer/")
public class BeerController {

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId)
    {
        return new ResponseEntity<BeerDTO>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDTO beerDTO)
    {
        //beerDTO.
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable UUID beerId,@RequestBody BeerDTO beer)
    {
        //beerDTO.
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity removeBeer(@RequestBody UUID beerId)
    {
        //beerDTO.
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
