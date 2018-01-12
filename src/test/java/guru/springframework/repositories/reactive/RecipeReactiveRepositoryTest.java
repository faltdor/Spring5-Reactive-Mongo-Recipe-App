package guru.springframework.repositories.reactive;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.reactive.IRecipeReactiveRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryTest {

	@Autowired
	IRecipeReactiveRepository recipeReactive;
	
	@Before
	public void setup() {
		recipeReactive.deleteAll().block();
	}
	
	@Test
	public void testRecipeSave() {
		Recipe recipe = new Recipe();
		recipe.setDescription("Any desceiption");
		
		recipeReactive.save(recipe).block();
		
		Long count = recipeReactive.count().block();
		
		assertThat(Long.valueOf(1L)).isEqualTo(count);
		
		
	}
	
	
}
