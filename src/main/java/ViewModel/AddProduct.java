package ViewModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.productItem;

public class AddProduct extends ViewModel.Connection {
    public static void addProduct(productItem product) {

        Connection connect = getConnection();
        try {

            String sql = "INSERT INTO `products`(`ID`, `Product Name`, `Cost`, `Quantity`) VALUES (null,?,?,?)";
            assert connect != null;
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getCost());
            statement.setInt(3, product.getQuantity());
            statement.execute();
            System.out.println("Product added");
            connect.close();
        } catch (Exception e) {
            System.out.println("Couldn't add product");
        }
    }

    public static boolean validateThenAdd(productItem product) {
        if (product.getCost() <= 0 || product.getQuantity() < 0) {
            return false; //Some fields are negative or zero
        } else {
            addProduct(product);
            return true; //Product added successfully
        }
    }
}


