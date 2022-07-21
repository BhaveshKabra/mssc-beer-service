package org.bhavesh.microsservices.mssc.bootstrap;

import org.bhavesh.microsservices.mssc.domain.Beer;
import org.bhavesh.microsservices.mssc.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrapper implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public Bootstrapper(BeerRepository beerRepository)
    {
        this.beerRepository=beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0)
        {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .price(new BigDecimal("12.95"))
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(377010000000L)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .price(new BigDecimal("11.95"))
                    .beerStyle("PALE ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(377010000002L)
                    .build());
        }
        System.out.println("LoadedBeers:"+beerRepository.count());
    }
}
