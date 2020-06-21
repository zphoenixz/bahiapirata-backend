package bo.edu.ucb.sis.bahiapirata.dao;

import bo.edu.ucb.sis.bahiapirata.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrderModel> findAllActives() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION

        String query = "SELECT ord.order_id, ord.address, ord.warehouse_id, ord.date,\n" +
                "       usr.user_id, usr.username, usr.email, usr.phone_number, usr.cat_user_status,\n" +
                "        prov.provider_id, prov.provider_name, prov.cat_country\n" +
                "FROM \"order\" ord\n" +
                "JOIN \"user\" usr ON ord.order_user_id = usr.user_id\n" +
                "JOIN \"provider\" prov ON ord.provider_id = prov.provider_id\n" +
                "WHERE\n" +
                "    usr.status =  1\n" +
                "     AND ord.status = 1\n" +
                "     AND prov.status = 1";

        List<OrderModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<OrderModel>() {
                @Override
                public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new OrderModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            new ProviderModel(
                                    resultSet.getInt(10),
                                    resultSet.getInt(11),
                                    resultSet.getString(12)
                            ),
                            resultSet.getInt(3),
                            new UserModel(
                                    resultSet.getInt(5),
                                    resultSet.getString(6),
                                    resultSet.getString(7),
                                    resultSet.getString(8),
                                    resultSet.getString(9)
                            ),
                            resultSet.getTimestamp(4)
                    );
                }
            });
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException();
        }
        return result;
    }

    public OrderModel findOrderById(int orderId) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION

        String query = "SELECT ord.order_id, ord.address, ord.warehouse_id, ord.date,\n" +
                "   usr.user_id, usr.username, usr.email, usr.phone_number, usr.cat_user_status,\n" +
                "   prov.provider_id, prov.provider_name, prov.cat_country\n" +
                "FROM \"order\" ord\n" +
                "JOIN \"user\" usr ON ord.order_user_id = usr.user_id\n" +
                "JOIN \"provider\" prov ON ord.provider_id = prov.provider_id\n" +
                "WHERE\n" +
                "ord.order_id = ?\n" +
                "AND usr.status =  1\n" +
                "AND ord.status = 1\n" +
                "AND prov.status = 1";

        OrderModel result = null;
        try {
            result = jdbcTemplate.queryForObject(query,
                    new Object [] {orderId},
                    new RowMapper<OrderModel>() {
                        @Override
                        public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                            return new OrderModel(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    new ProviderModel(
                                            resultSet.getInt(10),
                                            resultSet.getInt(11),
                                            resultSet.getString(12)
                                    ),
                                    resultSet.getInt(3),
                                    new UserModel(
                                            resultSet.getInt(5),
                                            resultSet.getString(6),
                                            resultSet.getString(7),
                                            resultSet.getString(8),
                                            resultSet.getString(9)
                                    ),
                                    resultSet.getTimestamp(4)
                            );
                        }
                    });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public List<ProductOrderModel> findProductsByOrderId(int orderId) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION

        String query = "SELECT pord.provider_product_id, pord.order_id,\n" +
                "       prod.product_id, prod.product_code, prod.cat_product_type, prod.product_name, prod.product_description, prod.product_attributes,\n" +
                "       pord.unit_price, pord.qtty_requested, pord.qtty_commit, pord.qtty_received\n" +
                "FROM \"product_order\" pord\n" +
                "         JOIN \"order\" ord ON ord.order_id = pord.order_id\n" +
                "         JOIN \"product\" prod ON pord.product_id = prod.product_id\n" +
                "WHERE\n" +
                "    pord.order_id = ?\n" +
                "  AND pord.status =  1\n" +
                "  AND ord.status = 1\n" +
                "  AND prod.status = 1";

        List<ProductOrderModel> result = null;

        try {
            result = jdbcTemplate.query(query,
                    new Object [] {orderId},
                    new RowMapper<ProductOrderModel>() {
                        @Override
                        public ProductOrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                            return new ProductOrderModel(
                                    resultSet.getInt(1),
                                    resultSet.getInt(2),
                                    new ProductModel(
                                            resultSet.getInt(3),
                                            resultSet.getString(4),
                                            resultSet.getString(5),
                                            resultSet.getString(6),
                                            resultSet.getString(7),
                                            resultSet.getString(8)
                                    ),
                                    resultSet.getDouble(9),
                                    resultSet.getInt(10),
                                    resultSet.getInt(11),
                                    resultSet.getInt(12)
                            );
                        }
                    });
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException();
        }
        return result;
    }
}
