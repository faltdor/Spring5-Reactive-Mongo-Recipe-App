package guru.springframework.repositories.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import guru.springframework.domain.Category;
import reactor.core.publisher.Mono;

public interface ICategoryReactiveRepository extends ReactiveCrudRepository<Category, String> {
	
	Mono<Category> findByDescription(String description);
}
