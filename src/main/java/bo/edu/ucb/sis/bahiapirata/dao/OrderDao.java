package bo.edu.ucb.sis.bahiapirata.dao;

import bo.edu.ucb.sis.bahiapirata.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrderModel> findAllActives() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION

        String query = "SELECT ord.order_id, ord.address, ord.warehouse_id, ord.order_date, ord.prepared_date, ord.shipped_date, ord.delivered_date, ord.order_status,\n" +
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
                                    resultSet.getInt(14),
                                    resultSet.getInt(15),
                                    resultSet.getString(16)
                            ),
                            resultSet.getInt(3),
                            new UserModel(
                                    resultSet.getInt(9),
                                    resultSet.getString(10),
                                    resultSet.getString(11),
                                    resultSet.getString(12),
                                    resultSet.getString(13)
                            ),
                            resultSet.getTimestamp(4),
                            resultSet.getTimestamp(5),
                            resultSet.getTimestamp(6),
                            resultSet.getTimestamp(7),
                            resultSet.getString(8)
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

        String query = "SELECT ord.order_id, ord.address, ord.warehouse_id, ord.order_date, ord.prepared_date, ord.shipped_date, ord.delivered_date, ord.order_status,\n" +
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
                                            resultSet.getInt(14),
                                            resultSet.getInt(15),
                                            resultSet.getString(16)
                                    ),
                                    resultSet.getInt(3),
                                    new UserModel(
                                            resultSet.getInt(9),
                                            resultSet.getString(10),
                                            resultSet.getString(11),
                                            resultSet.getString(12),
                                            resultSet.getString(13)
                                    ),
                                    resultSet.getTimestamp(4),
                                    resultSet.getTimestamp(5),
                                    resultSet.getTimestamp(6),
                                    resultSet.getTimestamp(7),
                                    resultSet.getString(8)
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

    public ProductOrderModel updateProductOrder(Integer productOrderId, Integer qttyCommit, Integer qttyReceived, Integer userId) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION

        String query = "UPDATE \"product_order\" ord\n" +
                "SET    qtty_commit = ?,\n" +
                "        qtty_received = ?,\n" +
                "        tx_id = usr.user_id,\n" +
                "        tx_username = usr.username,\n" +
                "        tx_host = 'local',\n" +
                "        tx_date = now()\n" +
                "FROM  \"user\" usr\n" +
                "WHERE provider_product_id = ?\n" +
                "    AND usr.user_id = ?" +
                "    AND usr.status = 1\n" +
                "    AND ord.status = 1\n" +
                "RETURNING *";

        ProductOrderModel result = null;

        try {
            result = jdbcTemplate.queryForObject(query,
                    new Object [] {qttyCommit, qttyReceived, productOrderId, userId},
                    new RowMapper<ProductOrderModel>() {
                        @Override
                        public ProductOrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                            return new ProductOrderModel(
                                    resultSet.getInt(1),
                                    resultSet.getInt(2),
                                    resultSet.getInt(3),
                                    resultSet.getDouble(4),
                                    resultSet.getInt(5),
                                    resultSet.getInt(6),
                                    resultSet.getInt(7)
                            );
                        }
                    });
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException();
        }
        return result;
    }

    public OrderModel updateOrder(String orderStatus, Integer orderId, Integer userId ) {
        String aux_date = "";
        if(orderStatus.compareTo( "prepared" ) == 0){
            aux_date = "prepared_date";
        }else if(orderStatus.compareTo( "shipped" ) == 0){
            aux_date = "shipped_date";
        }else if(orderStatus.compareTo( "delivered" ) == 0){
            aux_date = "delivered_date";
        }else{
            return null;
        }
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query = "UPDATE \"order\" ord\n" +
                "SET    order_status = ?,\n" +
                "       "+aux_date+" = now(),\n" +
                "       tx_id = usr.user_id,\n" +
                "       tx_username = usr.username,\n" +
                "       tx_host = 'local',\n" +
                "       tx_date = now()\n" +
                "FROM  \"user\" usr\n" +
                "WHERE order_id = ?\n" +
                "  AND usr.user_id = ?\n" +
                "  AND usr.status = 1\n" +
                "  AND ord.status = 1\n" +
                "RETURNING *";

        OrderModel result = null;
        try {
            result = jdbcTemplate.queryForObject(query,
                    new Object [] {orderStatus, orderId, userId},
                    new RowMapper<OrderModel>() {
                        @Override
                        public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                            return new OrderModel(
                                    resultSet.getInt(1),
                                    resultSet.getString(5),
                                    resultSet.getInt(2),
                                    resultSet.getInt(3),
                                    resultSet.getInt(4),
                                    resultSet.getTimestamp(6),
                                    resultSet.getTimestamp(7),
                                    resultSet.getTimestamp(8),
                                    resultSet.getTimestamp(9),
                                    resultSet.getString(10)
                            );
                        }
                    });
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException();
        }
        return result;
    }

    public OrderModel deleteOrder(Integer orderId, Integer userId ) {

        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query = "UPDATE \"order\" ord\n" +
                "SET    status = 0,\n" +
                "       tx_id = usr.user_id,\n" +
                "       tx_username = usr.username,\n" +
                "       tx_host = 'local',\n" +
                "       tx_date = now()\n" +
                "FROM  \"user\" usr\n" +
                "WHERE order_id = ?\n" +
                "  AND usr.user_id = ?\n" +
                "  AND usr.status = 1\n" +
                "  AND ord.status = 1\n" +
                "RETURNING *";

        OrderModel result = null;
        try {
            result = jdbcTemplate.queryForObject(query,
                    new Object [] {orderId, userId},
                    new RowMapper<OrderModel>() {
                        @Override
                        public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                            return new OrderModel(
                                    resultSet.getInt(1),
                                    resultSet.getString(5),
                                    resultSet.getInt(2),
                                    resultSet.getInt(3),
                                    resultSet.getInt(4),
                                    resultSet.getTimestamp(6),
                                    resultSet.getTimestamp(7),
                                    resultSet.getTimestamp(8),
                                    resultSet.getTimestamp(9),
                                    resultSet.getString(10)
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
