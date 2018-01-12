package guru.springframework.repositories.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import guru.springframework.domain.Recipe;

public interface IRecipeReactiveRepository extends ReactiveCrudRepository<Recipe, String> {

}
