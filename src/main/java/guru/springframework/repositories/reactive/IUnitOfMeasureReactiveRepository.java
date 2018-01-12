package guru.springframework.repositories.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import guru.springframework.domain.UnitOfMeasure;
import reactor.core.publisher.Mono;

public interface IUnitOfMeasureReactiveRepository extends ReactiveCrudRepository<UnitOfMeasure, String> {
	
	Mono<UnitOfMeasure> findByDescription(String description);
}
