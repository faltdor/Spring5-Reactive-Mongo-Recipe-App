package guru.springframework.repositories.reactive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest {

	private static final String ANY_DESCRIPTION = "Any desceiption";
	
	@Autowired
	IUnitOfMeasureReactiveRepository measureReactiveRepository;
	
	@Before
	public void setup() {
		this.measureReactiveRepository.deleteAll().block();
	}
	
	
	
	@Test
	public void testSave() {
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setDescription(ANY_DESCRIPTION);
		
		measureReactiveRepository.save(unitOfMeasure).block();
		
		Long count = measureReactiveRepository.count().block();
		
		assertThat(Long.valueOf(1L)).isEqualTo(count);
	}
	
	@Test
	public void testFindByDescription() {
		
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setDescription(ANY_DESCRIPTION);
		
		measureReactiveRepository.save(unitOfMeasure).block();
		
		UnitOfMeasure fetchUnitOfMeasure  = measureReactiveRepository.findByDescription(ANY_DESCRIPTION).block();
		
		assertThat(fetchUnitOfMeasure.getDescription()).isEqualTo(ANY_DESCRIPTION);
	}
	
	

}
