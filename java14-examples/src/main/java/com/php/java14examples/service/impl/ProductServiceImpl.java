package com.php.java14examples.service.impl;

import com.php.java14examples.record.ProductRecord;
import com.php.java14examples.service.ProductService;
import com.php.java14examples.service.rowmapper.ProductRecordRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final JdbcTemplate jdbcTemplate;

    private ProductRecordRowMapper productRecordRowMapper;

    public ProductServiceImpl(JdbcTemplate jdbcTemplate, ProductRecordRowMapper productRecordRowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.productRecordRowMapper = productRecordRowMapper;
    }

    public ProductRecord findById(Long id){
        return jdbcTemplate.queryForObject(FIND_BY_ID, productRecordRowMapper, id);
    }

    @Override
    public ProductRecord createProduct(String name, int status) {

        var preparedStatementCreator = getPreparedStatement()
                .newPreparedStatementCreator(List.of(name, status));
        var generatedKey = new GeneratedKeyHolder();

        jdbcTemplate.update(preparedStatementCreator, generatedKey);

        // Pattern Maching for instanceof (preview)
        if (generatedKey.getKey() instanceof Long id) {
            return new ProductRecord(
                    id,
                    name,
                    status,
                    getStatusDescription(status)
            );
        }
        throw new IllegalArgumentException("Could not create record.");
    }

    private String getStatusDescription(final int status){
        // Switch (stable version)
        return switch (status){
            case 1 -> "ATIVE";
            case 0 -> "INATIVE";
            default -> throw new IllegalStateException("Unexpected value: " + status);
        };
    }

    private PreparedStatementCreatorFactory getPreparedStatement(){
        return  new PreparedStatementCreatorFactory(INSERT, List.of(
                new SqlParameter(Types.VARCHAR, "name"),
                new SqlParameter(Types.INTEGER, "status")
        )) {{
            setReturnGeneratedKeys(true);
            setGeneratedKeysColumnNames("id");
        }};
    }
}
