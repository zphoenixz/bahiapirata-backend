package bo.edu.ucb.sis.bahiapirata.model;

public class ProductModel {
    private Integer productId;
    private String productCode;
    private String catProductType;
    private String productName;
    private String productDescription;
    private String productAttributes;

    public ProductModel(Integer productId, String productCode, String catProductType, String productName, String productDescription, String productAttributes) {
        this.productId = productId;
        this.productCode = productCode;
        this.catProductType = catProductType;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productAttributes = productAttributes;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCatProductType() {
        return this.catProductType;
    }

    public void setCatProductType(String catProductType) {
        this.catProductType = catProductType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(String productAttributes) {
        this.productAttributes = productAttributes;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", CatProductType='" + catProductType + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productAttributes=" + productAttributes +
                '}';
    }
}
