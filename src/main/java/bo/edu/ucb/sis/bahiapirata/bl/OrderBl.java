package bo.edu.ucb.sis.bahiapirata.bl;

import bo.edu.ucb.sis.bahiapirata.dao.OrderDao;
import bo.edu.ucb.sis.bahiapirata.model.OrderModel;
import bo.edu.ucb.sis.bahiapirata.model.ProductOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class OrderBl {

    private OrderDao orderDao;

    @Autowired
    public OrderBl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<OrderModel> findAllActives() {
        return this.orderDao.findAllActives();
    }

    public OrderModel findOrderById(int orderId) {
        return this.orderDao.findOrderById(orderId);
    }

    public List<ProductOrderModel> findProductsByOrderId(int orderId) {
        return this.orderDao.findProductsByOrderId(orderId);
    }

    public ProductOrderModel updateProductOrder(Integer productOrderId, Integer qttyCommit, Integer qttyReceived, Integer userId) {
        return this.orderDao.updateProductOrder(productOrderId, qttyCommit, qttyReceived, userId);
    }

    public OrderModel updateOrder(String orderStatus, Integer orderId, Integer userId ) {
        return this.orderDao.updateOrder(orderStatus, orderId, userId);
    }
}