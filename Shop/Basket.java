package Shop;

import java.util.Map;
import java.util.HashMap;

public class Basket {
    private static int counterId = 0;
    private final int id;
    private final Map<Integer, Integer> purchasedProducts = new HashMap<>();

    Basket() {
        counterId++;
        this.id = counterId;
    }

    public Map<Integer, Integer> getPurchasedProducts() {
        return purchasedProducts;
    }

    int getId() {
        return id;
    }

    Map<Integer, Integer> getProducts() {
        return getPurchasedProducts();
    }

    void putInBasket(int productId, int count) {
        getPurchasedProducts().put(productId, count);
    }

    @Override
    public String toString() {
        return "Корзина {" +
                "id = '" + id + "', " +
                "куплены товары с id = '" + getPurchasedProducts() + '\'' +
                '}';
    }

}