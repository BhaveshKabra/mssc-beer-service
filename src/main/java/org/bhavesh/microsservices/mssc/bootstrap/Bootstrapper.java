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
    public static final String BEER_1_UPC="0631234200036";
    public static final String BEER_2_UPC="0631234200019";
    public static final String BEER_3_UPC="0083783375213";

    @Override
    public void run(String... args) {
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
                    .upc(BEER_1_UPC)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .price(new BigDecimal("11.95"))
                    .beerStyle("PALE ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No Hammers on the Bar")
                    .price(new BigDecimal("11.95"))
                    .beerStyle("PALE ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .build());
        }
        System.out.println("LoadedBeers:"+beerRepository.count());
    }
}
