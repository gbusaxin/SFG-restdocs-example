package com.gbusaxin.sfgrestdocsexample.bootstrap;

import com.gbusaxin.sfgrestdocsexample.domain.Beer;
import com.gbusaxin.sfgrestdocsexample.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    private void loadBeerObject(){
        if (beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Baltika")
                    .beerStyle("Zavod")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(213123123L)
                    .price(new BigDecimal("21.54"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Ohota")
                    .beerStyle("Smert")
                    .quantityToBrew(100)
                    .minOnHand(9)
                    .upc(3123123L)
                    .price(new BigDecimal("42.54"))
                    .build());
        }
    }
}
