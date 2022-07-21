package org.bhavesh.microsservices.mssc.repositories;

import org.bhavesh.microsservices.mssc.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
