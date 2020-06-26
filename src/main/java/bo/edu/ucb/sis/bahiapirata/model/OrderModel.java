package bo.edu.ucb.sis.bahiapirata.model;

import java.sql.Timestamp;

public class OrderModel {
    private Integer orderId;
    private String address;
    private ProviderModel providerOrder;
    private Integer warehouseId;
    private UserModel userOrder;
    private Timestamp orderDate;
    private Timestamp preparedDate;
    private Timestamp shippedDate;
    private Timestamp deliveredDate;
    private String orderStatus;


    public OrderModel(Integer orderId, String address, ProviderModel providerOrder, Integer warehouseId, UserModel userOrder, Timestamp orderDate, Timestamp preparedDate, Timestamp shippedDate, Timestamp deliveredDate, String orderStatus) {
        this.orderId = orderId;
        this.address = address;
        this.providerOrder = providerOrder;
        this.warehouseId = warehouseId;
        this.userOrder = userOrder;
        this.orderDate = orderDate;
        this.preparedDate = preparedDate;
        this.shippedDate = shippedDate;
        this.deliveredDate = deliveredDate;
        this.orderStatus = orderStatus;
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

    public Timestamp getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Timestamp shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Timestamp getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Timestamp preparedDate) {
        this.preparedDate = preparedDate;
    }

    public Timestamp getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Timestamp deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
                ", shippedDate=" + shippedDate +
                ", preparedDate=" + preparedDate +
                ", deliveredDate=" + deliveredDate +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
