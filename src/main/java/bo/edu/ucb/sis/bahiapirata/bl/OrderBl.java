package bo.edu.ucb.sis.bahiapirata.bl;

import bo.edu.ucb.sis.bahiapirata.dao.OrderDao;
import bo.edu.ucb.sis.bahiapirata.model.OrderModel;
import bo.edu.ucb.sis.bahiapirata.model.ProductOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
