package ViewModel;

import Model.productItem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewProduct extends ViewModel.Connection {

    public static ArrayList getProductsList() {

        java.sql.Connection connect = getConnection();
        ArrayList<productItem> products = new ArrayList<>();
        try {
            Statement statement = connect.createStatement();
            ResultSet view = statement.executeQuery("SELECT id,product_name,cost,quantity FROM products");
            while (view.next()) {
                productItem product = new productItem(view.getString("product_name"), view.getDouble("cost"),
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

    public static String[][] tableData() {
        String[][] data = new String[getProductsList().size()][4];
        ArrayList<productItem> products = getProductsList();
        for (int i = 0; i < getProductsList().size(); i++) {
            data[i][0] = String.valueOf(products.get(i).getId());
            data[i][1] = products.get(i).getProductName();
            data[i][2] = String.valueOf(products.get(i).getCost());
            data[i][3] = String.valueOf(products.get(i).getQuantity());
        }
        return data;
    }
}
