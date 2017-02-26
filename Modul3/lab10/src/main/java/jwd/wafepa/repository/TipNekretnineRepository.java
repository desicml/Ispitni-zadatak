package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.TipNekretnine;
@Repository
public interface TipNekretnineRepository extends PagingAndSortingRepository<TipNekretnine, Long> {

	//Page<TipNekretnine>findByTipNekretnineId(Long nekretninaId);
}
