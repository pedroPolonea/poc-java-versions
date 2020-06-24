package com.php.java14examples.service.rowmapper;

import com.php.java14examples.record.ProductRecord;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRecordRowMapper implements RowMapper<ProductRecord> {
    @Override
    public ProductRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new ProductRecord(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("status"),
                getStatusDescription(rs.getInt("status"))
        );
    }

    private String getStatusDescription(final int status){
        return switch (status){
            case 1 -> "ATIVE";
            case 0 -> "INATIVE";
            default -> throw new IllegalStateException("Unexpected value: " + status);
        };
    }
}
