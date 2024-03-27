package Shop;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private final Category[] categories;
    private final Map<String, User> users;

    Shop() {
        this.categories = new Category[2];
        this.users = new HashMap<>();

        // Делаем инициализацию товаров и категорий

        Category categoryMilks = new Category("Молочная продукция");
        Product[] milks = new Product[] {
                new Product("Молоко", 80, 180),
                new Product("Творог", 150, 110),
                new Product("Сметана", 60, 140)
        };
        for (Product milk : milks) {
            categoryMilks.putInCategory(milk.getId(), milk);
        }

        Category categoryGrocerys = new Category("Бакалея");
        Product[] grocerys = new Product[] {
                new Product("Чай", 80, 63),
                new Product("Кофе", 320, 127),
                new Product("Сахар", 70, 52),
                new Product("Соль", 20, 17),
                new Product("Мука", 65, 49)
        };
        for (Product grocery : grocerys) {
            categoryGrocerys.putInCategory(grocery.getId(), grocery);
        }

        categories[0] = categoryMilks;
        categories[1] = categoryGrocerys;

        // Регистрация пользователей
        users.put("Наталья", new User("Natali", "123"));
        users.put("Anna", new User("Anna", "567"));
        users.put("Lolita", new User("Lolita", "Lola655009"));
        users.put("Gena", new User("Gena", "qwe123"));
    }

    void trade() {
        // Состояние магазина
        printShop();

        // Продажи
        System.out.println("Продано:");
        this.saleProduct("Наталья", 5, 2);
        this.saleProduct("Lolita", 4, 1);
        this.saleProduct("Gena", 6, 1);
        this.saleProduct("Lolita", 6, 1);
        this.saleProduct("Lolita", 7, 7777);
        this.saleProduct("Anna", 13, 100);
        this.saleProduct("Gena", 8, 3333);
        System.out.println("       \n");

        // Показ состояния магазина
        printShop();
    }

    void printShop() {
        System.out.println("Магазин:");
        for (Category category : this.categories) {
            System.out.println(category);
        }
        System.out.println("       \n");
    }

    void saleProduct(String userName, int productId, int count) {
        Product product = this.getProduct(productId);
        System.out.print(userName +
                " покупаемый товар с id = " + productId +
                " количество " + count + " штук. ");
        if (product == null) {
            System.out.println("Товара нет в наличии.");
        } else if (product.getCount() < count) {
            System.out.println("Такого количества '" + product.getName() + "' нет в наличии.");
        } else {
            this.users.get(userName).getBasket().putInBasket(productId, count);
            product.saleProduct(count);
            System.out.println("Куплено " + count + " '" + product.getName() + "'!");
        }
    }

    Product getProduct(int productId) {
        for (Category category : this.categories) {
            Product product = category.getProduct(productId);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

}