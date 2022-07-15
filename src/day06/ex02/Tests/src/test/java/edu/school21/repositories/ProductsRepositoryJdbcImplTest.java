package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {
    private ProductsRepository productsRepository;
    private DataSource dataSource;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "semi-hard cheese", 356),
            new Product(2L, "onion", 25),
            new Product(3L, "mineral water", 79)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(3L, "mineral water", 79);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(2L, "lemons", 39);
    final Product EXPECTED_SAVE_PRODUCT = new Product(4L, "sausages", 341);

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql").addScript("data.sql").build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindById() {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, productsRepository.findById(3L).get());
    }

    @Test
    void testFindAll() {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testSave() {
        productsRepository.save(EXPECTED_SAVE_PRODUCT);
        Assertions.assertEquals(EXPECTED_SAVE_PRODUCT, productsRepository.findById(4L).get());
    }

    @Test
    void testUpdate() {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, productsRepository.findById(2L).get());
    }

    @Test
    void testDelete() {
        Product productForSave = new Product(12L, "banana", 59);
        productsRepository.save(productForSave);
        Product productForDelete = productsRepository.findById(12L).get();
        productsRepository.delete(productForDelete.getIdentifier());
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }
}
