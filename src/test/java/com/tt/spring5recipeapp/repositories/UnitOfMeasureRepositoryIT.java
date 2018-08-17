package com.tt.spring5recipeapp.repositories;

import com.tt.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescriptionTeaSpoon() {
        Optional<UnitOfMeasure> uomOption = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uomOption.get().getDescription());
    }

    @Test
    //@DirtiesContext // it will start spring context up second time and test will be a much longer!
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> uomOption = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", uomOption.get().getDescription());
    }
}