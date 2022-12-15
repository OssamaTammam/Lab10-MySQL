package ViewModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import View.productItem;

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

    public static int validateThenAdd(productItem product) {
        if (product.getProductName().equals("") || product.getCost() == 0 || product.getQuantity() == 0) {
            return -1; //-1 means some fields are empty
        } else if (product.getCost() <= 0 || product.getQuantity() < 0) {
            return -2; //-2 means some fields are negative or zero
        } else {
            addProduct(product);
            return 1; //1 means product added successfully
        }
    }
}


