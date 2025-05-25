
package com.example.goinventory.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class AdminManageProduct_controller {


    @FXML
    private TextField manCatagoryTxtfild;
    @FXML
    private VBox manPriceTxt;
    @FXML
    private TextField manProNameTxt;

   @FXML
private TableView<ProductInventory> manageProTable;

@FXML
private TableColumn<ProductInventory, Integer> ID;

@FXML
private TableColumn<ProductInventory, String> manProName;

@FXML
private TableColumn<ProductInventory, String> manCataory;

@FXML
private TableColumn<ProductInventory, Double> manProPrice;

@FXML
private TableColumn<ProductInventory, Integer> manProQuntity;


private Connection connection;

public void initialize() {
    try {
            connection = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    ID.setCellValueFactory(new PropertyValueFactory<>("id"));
    manProName.setCellValueFactory(new PropertyValueFactory<>("name"));
    // manCataory.setCellValueFactory(SimpleStringProperty(cellData.getValue().getCategory().getName()));  
    manProPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    manProQuntity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    loadProductTable();
}



private void loadProductTable() {
    ObservableList<ProductInventory> productList = FXCollections.observableArrayList();

 String query = "SELECT p.product_id, p.quintity, p.invoice_amount, " +
               "c.catagoryId AS category_id, c.category_name AS category_name, " +
               "pi.name AS product_name, pi.price " +
               "FROM user_inventory p " +
               "JOIN productinventory pi ON p.product_id = pi.id " +
               "JOIN categories c ON pi.Ncategory_id = c.catagoryId";


    try (PreparedStatement stmt = connection.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            int quantity = rs.getInt("quintity");
            double price = rs.getDouble("price");

            int categoryId = rs.getInt("category_id");
            String categoryName = rs.getString("category_name");
            Category category = new Category(categoryId, categoryName);

            productList.add(new ProductInventory(id, name, quantity, price, category));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    manageProTable.setItems(productList);
}


private ProductInventory getProductByName(String name) throws SQLException {
    String query = "SELECT id, price, Ncategory_id FROM productinventory WHERE name = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            double price = rs.getDouble("price");
            int catId = rs.getInt("Ncategory_id");
            return new ProductInventory(id, name, 0, price, new Category(catId, ""));
        } else {
            throw new SQLException("Product not found: " + name);
        }
    }
}

    @FXML
void manResetbtn(ActionEvent event) {
    manProNameTxt.clear();
    manCatagoryTxtfild.clear();
    ((TextField) manPriceTxt.getChildren().get(0)).clear(); 
    manageProTable.getSelectionModel().clearSelection();
}

@FXML
void manSavebtn(ActionEvent event) {
    String name = manProNameTxt.getText();
    String priceText = ((TextField) manPriceTxt.getChildren().get(0)).getText();

    if (name.isEmpty() || priceText.isEmpty()) {
        System.out.println("Fill all fields.");
        return;
    }

    try {
        // Get product from productinventory
        ProductInventory product = getProductByName(name);

        String insertInventory = "INSERT INTO user_inventory (product_id, quintity, invoice_amount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertInventory)) {
            stmt.setInt(1, product.getId());
            stmt.setInt(2, 0); // default quantity
            stmt.setDouble(3, product.getPrice());
            stmt.executeUpdate();
        }

        loadProductTable();
        manResetbtn(null);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

 




    @FXML
void manUpdatebtn(ActionEvent event) {
    ProductInventory selected = manageProTable.getSelectionModel().getSelectedItem();
    if (selected == null) return;

    String priceText = ((TextField) manPriceTxt.getChildren().get(0)).getText();

    try {
        double invoiceAmount = Double.parseDouble(priceText);

        String updateQuery = "UPDATE user_inventory SET invoice_amount = ? WHERE product_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            stmt.setDouble(1, invoiceAmount);
            stmt.setInt(2, selected.getId());
            stmt.executeUpdate();
        }

        loadProductTable();
        manResetbtn(null);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

   
@FXML
void manDeletebtn(ActionEvent event) {
    ProductInventory selected = manageProTable.getSelectionModel().getSelectedItem();
    if (selected == null) return;

    String deleteQuery = "DELETE FROM productinventory WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
        stmt.setInt(1, selected.getId());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    loadProductTable();
    manResetbtn(null);
}














private int getOrCreateCategoryId(String categoryName) throws SQLException {
    // Check if category exists
    String selectQuery = "SELECT catagoryId FROM categories WHERE category_name = ?";
    try (PreparedStatement stmt = connection.prepareStatement(selectQuery)) {
        stmt.setString(1, categoryName);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("catagoryId");
        }
    }

    // If not exists, insert new category
    String insertQuery = "INSERT INTO categories (category_name) VALUES (?)";
    try (PreparedStatement stmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, categoryName);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            return keys.getInt(1);
        } else {
            throw new SQLException("Failed to retrieve generated category ID.");
        }
    }
}




}
