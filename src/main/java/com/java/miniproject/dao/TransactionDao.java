package com.java.miniproject.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import com.java.miniproject.dao.TransactionDao;
import com.java.miniproject.model.Transaction;

@Repository
public class TransactionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer save(Transaction trx) {
        try {
            int rows = jdbcTemplate.update(
                    "INSERT INTO public.tbl_transaction (id, user_id, product_id) VALUES(?, ?, ?);",
                    new Object[] { trx.getId(), trx.getUserId(), trx.getProductId() });
            return rows;
        } catch (Exception e) {
            return 0;
        }
    }

}
