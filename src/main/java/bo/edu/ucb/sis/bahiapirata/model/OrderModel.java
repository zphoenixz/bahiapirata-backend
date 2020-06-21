package bo.edu.ucb.sis.bahiapirata.model;

import java.sql.Timestamp;

public class OrderModel {
    private Integer orderId;
    private String address;
    private ProviderModel providerOrder;
    private Integer warehouseId;
    private UserModel userOrder;
    private Timestamp orderDate;

    public OrderModel() {
    }

    public OrderModel(Integer orderId, String address, ProviderModel providerOrder, Integer warehouseId, UserModel userOrder, Timestamp orderDate) {
        this.orderId = orderId;
        this.address = address;
        this.providerOrder = providerOrder;
        this.warehouseId = warehouseId;
        this.userOrder = userOrder;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProviderModel getProviderOrder() {
        return providerOrder;
    }

    public void setProviderOrder(ProviderModel providerOrder) {
        this.providerOrder = providerOrder;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public UserModel getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserModel userOrder) {
        this.userOrder = userOrder;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", address='" + address + '\'' +
                ", providerOrder=" + providerOrder +
                ", warehouseId=" + warehouseId +
                ", userOrder=" + userOrder +
                ", orderDate=" + orderDate +
                '}';
    }
}
