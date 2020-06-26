package bo.edu.ucb.sis.bahiapirata.model;

public class ProductOrderModel {
    private Integer productOrderId;
    private Integer orderId;
    private ProductModel product;
    private Integer productId;
    private Double unitPrice;
    private Integer qttyRequested;
    private Integer qttyCommit;
    private Integer qttyReceived;

    public ProductOrderModel(){
    }
    public ProductOrderModel(Integer productOrderId, Integer orderId, ProductModel product, Double unitPrice, Integer qttyRequested, Integer qttyCommit, Integer qttyReceived) {
        this.productOrderId = productOrderId;
        this.orderId = orderId;
        this.product = product;
        this.unitPrice = unitPrice;
        this.qttyRequested = qttyRequested;
        this.qttyCommit = qttyCommit;
        this.qttyReceived = qttyReceived;
    }

    public ProductOrderModel(Integer productOrderId, Integer orderId, Integer productId, Double unitPrice, Integer qttyRequested, Integer qttyCommit, Integer qttyReceived) {
        this.productOrderId = productOrderId;
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.qttyRequested = qttyRequested;
        this.qttyCommit = qttyCommit;
        this.qttyReceived = qttyReceived;
    }

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQttyRequested() {
        return qttyRequested;
    }

    public void setQttyRequested(Integer qttyRequested) {
        this.qttyRequested = qttyRequested;
    }

    public Integer getQttyCommit() {
        return qttyCommit;
    }

    public void setQttyCommit(Integer qttyCommit) {
        this.qttyCommit = qttyCommit;
    }

    public Integer getQttyReceived() {
        return qttyReceived;
    }

    public void setQttyReceived(Integer qttyReceived) {
        this.qttyReceived = qttyReceived;
    }

    @Override
    public String toString() {
        return "ProductOrderModel{" +
                "productOrderId=" + productOrderId +
                ", orderId=" + orderId +
                ", product=" + product +
                ", productId=" + productId +
                ", unitPrice=" + unitPrice +
                ", qttyRequested=" + qttyRequested +
                ", qttyCommit=" + qttyCommit +
                ", qttyReceived=" + qttyReceived +
                '}';
    }
}
