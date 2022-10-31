package com.gbusaxin.sfgrestdocsexample.web.controller;

import com.gbusaxin.sfgrestdocsexample.repositories.BeerRepository;
import com.gbusaxin.sfgrestdocsexample.web.mappers.BeerMapper;
import com.gbusaxin.sfgrestdocsexample.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerMapper beerMapper;
    private final BeerRepository beerRepository;

    public BeerController(BeerMapper beerMapper, BeerRepository beerRepository) {
        this.beerMapper = beerMapper;
        this.beerRepository = beerRepository;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable(name = "beerId") @NotNull UUID id) {
        return new ResponseEntity<>(beerMapper.beerToBeerDto(beerRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        beerRepository.save(beerMapper.beerDtoToBeer(beerDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeerById(@PathVariable(name = "beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        beerRepository.findById(beerId).ifPresent(beer -> {
            beer.setBeerName(beerDto.getBeerName());
            beer.setBeerStyle(beerDto.getBeerStyle());
            beer.setPrice(beerDto.getPrice());
            beer.setUpc(beerDto.getUpc());
            beerRepository.save(beer);
        });
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
