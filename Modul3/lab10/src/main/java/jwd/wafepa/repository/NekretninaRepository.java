package jwd.wafepa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Nekretnina;
@Repository
public interface NekretninaRepository extends PagingAndSortingRepository<Nekretnina, Long> {

}
