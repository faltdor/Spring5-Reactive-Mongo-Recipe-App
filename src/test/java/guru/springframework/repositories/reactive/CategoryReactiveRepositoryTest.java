package guru.springframework.repositories.reactive;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.Category;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

	private static final String ANY_DESCRIPTION = "any description";
	@Autowired
	ICategoryReactiveRepository categoryReactiveRepository;

	@Before
	public void setUp() throws Exception {
		this.categoryReactiveRepository.deleteAll().block();
	}

	@Test
	public void testSave() {
		Category category = new Category();
		category.setDescription(ANY_DESCRIPTION);

		categoryReactiveRepository.save(category).block();

		Long count = categoryReactiveRepository.count().block();

		assertEquals(Long.valueOf(1L), count);
	}

	@Test
	public void testFindByDescription() throws Exception {
		Category category = new Category();
		category.setDescription(ANY_DESCRIPTION);

		categoryReactiveRepository.save(category).then().block();

		Category fetchedCat = categoryReactiveRepository.findByDescription(ANY_DESCRIPTION).block();

		assertNotNull(fetchedCat.getId());
	}
}
