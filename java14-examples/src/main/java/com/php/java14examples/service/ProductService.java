package com.php.java14examples.service;

import com.php.java14examples.record.ProductRecord;

public interface ProductService {

    // Text blocks (preview)
    static final String FIND_BY_ID = """
               SELECT *
               FROM products
               WHERE id = ?
               """;

    static final String INSERT = """
                INSERT INTO products(name, status)
                VALUES(?, ?)
               """;

    ProductRecord findById(final Long id);

    ProductRecord createProduct(final String name, final int status);
}
