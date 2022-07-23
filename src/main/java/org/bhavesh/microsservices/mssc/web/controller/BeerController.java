package org.bhavesh.microsservices.mssc.web.controller;

import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer/")
public class BeerController {

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId)
    {
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> saveNewBeer(@RequestBody @Validated BeerDTO beerDTO)
    {
        //beerDTO.
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> updateBeer(@PathVariable UUID beerId,@RequestBody @Validated BeerDTO beer)
    {
        //beerDTO.
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<BeerDTO> removeBeer(@RequestBody UUID beerId)
    {
        //beerDTO.
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
