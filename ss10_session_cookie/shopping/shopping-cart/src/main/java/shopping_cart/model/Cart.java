package shopping_cart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;
    private double totalPrice;

    public Cart() {
        cartItems = new ArrayList<>();
        totalPrice = 0;
    }

    public void addItem(Product product) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                totalPrice += product.getPrice();
                return;
            }
        }
        cartItems.add(new CartItem(product, 1));
        totalPrice += product.getPrice();
    }

    public void removeItem(Product product) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                cartItems.remove(item);
                totalPrice -= item.getProduct().getPrice() * item.getQuantity();
                break;
            }
        }
    }

    public void updateItem(Product product, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                int oldQuantity = item.getQuantity();
                item.setQuantity(newQuantity);
                totalPrice += product.getPrice() * (newQuantity - oldQuantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, newQuantity));
        totalPrice += product.getPrice() * newQuantity;
    }

    public void clearCart() {
        cartItems.clear();
        totalPrice = 0.0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
