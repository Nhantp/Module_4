package product.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Pattern(regexp = "SP-\\d{3}", message = "{create.id}")
    private Integer productId;
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max=50, message = "Vui lòng nhập nhỏ hơn 50 và lơn hơn 5")
    private String productName;
    @NotNull(message = "Vui lòng nhập giá tiền")
    @DecimalMin(value = "0.00", inclusive = true, message = "Price must be a positive number with up to 2 decimal places")
    @DecimalMax(value = "9999999.99", inclusive = true, message = "Price must be a positive number with up to 2 decimal places")
    @Digits(integer = 7, fraction = 2, message = "Price must be a positive number with up to 2 decimal places")
    private Double price;
    private Integer quantity;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="categoryId", referencedColumnName = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(Integer productId, String productName, Double price, Integer quantity, String description, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
