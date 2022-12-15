package ViewModel;

import View.productItem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewProduct extends ViewModel.Connection {

    public static ArrayList getProductsList() {

        java.sql.Connection connect = getConnection();
        ArrayList<productItem> products = new ArrayList<>();
        try {
            Statement statement = connect.createStatement();
            ResultSet view = statement.executeQuery("SELECT id,'product name',cost,quantity FROM products");
            while (view.next()) {
                productItem product = new productItem(view.getString("product name"), view.getDouble("cost"),
                        view.getInt("quantity"));
                product.setId(view.getInt("id"));
                products.add(product);
            }
            connect.close();
            return products;
        } catch (Exception e) {
            System.out.println("Couldn't get products");
        }
        return null;
    }
}
