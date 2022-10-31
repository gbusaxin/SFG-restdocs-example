package com.gbusaxin.sfgrestdocsexample.repositories;

import com.gbusaxin.sfgrestdocsexample.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
