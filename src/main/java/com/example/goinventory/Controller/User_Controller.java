package com.example.goinventory.Controller;

import java.io.BufferedWriter;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.goinventory.Database.DB;
import com.example.goinventory.Model.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class User_Controller {

    public Button logout_user;
    public Button Send_Mail_button;
    @FXML
    private AnchorPane Dashbordfarme;
    @FXML
    private AnchorPane AddParcelframe;
    @FXML
    private AnchorPane Deliverdframe;
    @FXML
    private AnchorPane paindingframe;
    @FXML
    public AnchorPane AddproductFrame;
    @FXML
    public AnchorPane ManageCategoryframe;

    @FXML
    private Button dashbtn;
    @FXML
    private Button addparcelbtn;
    @FXML
    private Button deliverdbtn;
    @FXML
    private Button paindingbtn;
    @FXML
    public Button Addpoductbtn;
    @FXML
    public Button ManageCategorybtn;

    @FXML
    private TextField address_textField;

    @FXML
    private TextField codAmount_textField;

    @FXML
    private TextField district_textField;

    @FXML
    private TextField invoiceAmout_textField;

    @FXML
    private TextField name_textField;

    @FXML
    private TextArea note_textField;

    @FXML
    private TextField phone_textField;

    @FXML
    private TextField thana_textField;

    @FXML
    private TextField weight_textField;
    @FXML
    private TextField catagoryNameInput;
    // For Deliverd Table
    @FXML
    private TableView<Order> Oreder_Table1;
    @FXML
    private TableColumn<Order, Integer> invoice_idfx1;
    @FXML
    private TableColumn<Order, String> customer_name1;
    @FXML
    private TableColumn<Order, String> phone_number1;
    @FXML
    private TableColumn<Order, String> address1;
    @FXML
    private TableColumn<Order, String> district1;
    @FXML
    private TableColumn<Order, String> note1;
    @FXML
    private TableColumn<Order, Double> amount1;
    @FXML
    private TableColumn<Order, Double> weight1;
    @FXML
    private TableColumn<Order, String> date1;

    // For Pending Table
    @FXML
    private TableView<Order> Order_Table2;
    @FXML
    private TableColumn<Order, Integer> invoice_idfx2;
    @FXML
    private TableColumn<Order, String> customer_name2;
    @FXML
    private TableColumn<Order, String> phone_number2;
    @FXML
    private TableColumn<Order, String> address2;
    @FXML
    private TableColumn<Order, String> district2;
    @FXML
    private TableColumn<Order, String> note2;
    @FXML
    private TableColumn<Order, Double> amount2;
    @FXML
    private TableColumn<Order, Double> weight2;
    @FXML
    private TableColumn<Order, String> date2;

    // For catagory table 
    @FXML
    private TableView<ProductCategory> catagoryTable;

    @FXML
    private TableColumn<ProductCategory, Integer> catagreyId;

    @FXML
    private TableColumn<ProductCategory, String> catagoryName;

    private Connection connection;

    public void buttonAction(ActionEvent e) {
        Dashbordfarme.setVisible(true);
        AddParcelframe.setVisible(false);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(false);
        AddproductFrame.setVisible(false);
        ManageCategoryframe.setVisible(false);

    }

    public void onlogout_user(ActionEvent e) {
        Stage stage = (Stage) logout_user.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindows();
    }

    // connection to Driver
    public void initialize() throws ClassNotFoundException {
        try {
            connection = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Deliverd Table
        invoice_idfx1.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        customer_name1.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phone_number1.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        address1.setCellValueFactory(new PropertyValueFactory<>("address"));
        district1.setCellValueFactory(new PropertyValueFactory<>("district"));
        note1.setCellValueFactory(new PropertyValueFactory<>("note"));
        amount1.setCellValueFactory(new PropertyValueFactory<>("amount"));
        weight1.setCellValueFactory(new PropertyValueFactory<>("weight"));
        date1.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Pending Table
        invoice_idfx2.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        customer_name2.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phone_number2.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        address2.setCellValueFactory(new PropertyValueFactory<>("address"));
        district2.setCellValueFactory(new PropertyValueFactory<>("district"));
        note2.setCellValueFactory(new PropertyValueFactory<>("note"));
        amount2.setCellValueFactory(new PropertyValueFactory<>("amount"));
        weight2.setCellValueFactory(new PropertyValueFactory<>("weight"));
        date2.setCellValueFactory(new PropertyValueFactory<>("date"));

        catagreyId.setCellValueFactory(new PropertyValueFactory<>("id"));
        catagoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

    }

    // Add parcel Ui
    @FXML
    void addbox(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        AddParcelframe.setVisible(true);
        Deliverdframe.setVisible(false);
        AddproductFrame.setVisible(false);
        ManageCategoryframe.setVisible(false);
        Submit_button(event);
    }

    // Add parcel submit button 
    @FXML
    private void Submit_button(ActionEvent event) {
        String insertQuery = "INSERT INTO user_inventory (customer_name, phone_number, address, district, thana, note, cod_amount, invoice_amount, weight, status, date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

            String name = name_textField.getText();
            String phone = phone_textField.getText();
            String address = address_textField.getText();
            String district = district_textField.getText();
            String thana = thana_textField.getText();
            String note = note_textField.getText();

            double codAmount = Double.parseDouble(codAmount_textField.getText());
            double invoiceAmount = Double.parseDouble(invoiceAmout_textField.getText());
            double weight = Double.parseDouble(weight_textField.getText());
            String status = "Pending";
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, address);
            pstmt.setString(4, district);
            pstmt.setString(5, thana);
            pstmt.setString(6, note);
            pstmt.setDouble(7, codAmount);
            pstmt.setDouble(8, invoiceAmount);
            pstmt.setDouble(9, weight);
            pstmt.setString(10, status);
            pstmt.setString(11, date);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Invoice added successfully!");
                clearForm();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println(" Please enter valid numeric values for COD, invoice amount, and weight.");
        }
    }

    // Send mail file generate
    public void send_mail(ActionEvent event) {
        String selectQuery = "SELECT * FROM user_inventory";

        File invoiceDir = new File("G:\\java project\\GoInventory-main\\GoInventory-main\\out\\Mail box\\Invoice");
        invoiceDir.mkdirs(); // Create directory if it doesn't exist

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                // Extract data
                String name = rs.getString("customer_name");
                String phone = rs.getString("phone_number");
                String address = rs.getString("address");
                String district = rs.getString("district");
                String thana = rs.getString("thana");
                String note = rs.getString("note");
                double codAmount = rs.getDouble("cod_amount");
                double invoiceAmount = rs.getDouble("invoice_amount");
                double weight = rs.getDouble("weight");
                String status = rs.getString("status");
                String date = rs.getString("date");

                // ai part e file e name jate error na dey tai useless part remove kortechi
                String safeFileName = name.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");

                File invoiceFile = new File(invoiceDir, safeFileName + "_" + phone + "_Invoice.txt");
                // shob string write hobe
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(invoiceFile))) {
                    writer.write("=========== Invoice ===========\n");
                    writer.write("Customer Name : " + name + "\n");
                    writer.write("Phone Number  : " + phone + "\n");
                    writer.write("Address       : " + address + "\n");
                    writer.write("District      : " + district + "\n");
                    writer.write("Thana         : " + thana + "\n");
                    writer.write("Note          : " + note + "\n");
                    writer.write("COD Amount    : " + codAmount + "\n");
                    writer.write("Invoice Amount: " + invoiceAmount + "\n");
                    writer.write("Weight        : " + weight + " kg\n");
                    writer.write("Status        : " + status + "\n");
                    writer.write("Date          : " + date + "\n");
                    writer.write("================================\n");
                } catch (IOException e) {
                    System.err.println("Failed to write invoice for " + name + ": " + e.getMessage());
                }
            }

            System.out.println("All invoices generated successfully in: " + invoiceDir.getAbsolutePath());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add parcel from clear after submit button
    private void clearForm() {
        name_textField.clear();
        phone_textField.clear();
        address_textField.clear();
        district_textField.clear();
        thana_textField.clear();
        note_textField.clear();
        codAmount_textField.clear();
        invoiceAmout_textField.clear();
        weight_textField.clear();
    }
    // table load for  Deliverd and painding 

    public void tableload(ActionEvent event, String key) {
        ObservableList<Order> orderList = FXCollections.observableArrayList();
        String query = "SELECT * FROM user_inventory WHERE status = ?";

        try (Connection connection = DB.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, key);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                orderList.add(new Order(
                        rs.getInt("invoice_id"),
                        rs.getString("customer_name"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("district"),
                        rs.getString("note"),
                        rs.getDouble("invoice_amount"),
                        rs.getDouble("weight"),
                        rs.getString("date")
                ));
            }

            if (key.equalsIgnoreCase("Pending")) {
                Order_Table2.setItems(orderList);
            } else if (key.equalsIgnoreCase("deleverd")) {
                Oreder_Table1.setItems(orderList);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Deliverd parcel ui
    @FXML
    void Deliverd_button(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        AddParcelframe.setVisible(false);
        Deliverdframe.setVisible(true);
        paindingframe.setVisible(false);
        AddproductFrame.setVisible(false);
        ManageCategoryframe.setVisible(false);
        tableload(event, "deleverd");

    }

    // Painding parcel ui
    @FXML
    void Painding_button(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        AddParcelframe.setVisible(false);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(true);
        AddproductFrame.setVisible(false);
        ManageCategoryframe.setVisible(false);
        tableload(event, "Pending");
    }

    @FXML
    void Managecatagory(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        AddParcelframe.setVisible(false);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(false);
        AddproductFrame.setVisible(false);
        ManageCategoryframe.setVisible(true);

        catagorySavebtn(event);
        catagoryTableLoad(event);

        CatagoryResetbtn(event);

    }

    @FXML
    void AddProduct(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        AddParcelframe.setVisible(false);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(false);
        ManageCategoryframe.setVisible(false);
        AddproductFrame.setVisible(true);
    }

    @FXML
    void catagorySavebtn(ActionEvent event) {
        String sql = "INSERT INTO categories (category_name) VALUES (?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            String categoryName = catagoryNameInput.getText();

            pstmt.setString(1, categoryName);
            pstmt.executeUpdate();

            System.out.println("Category added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        catagoryTableLoad(event);
    }

    @FXML
    public void catagoryTableLoad(ActionEvent event) {
        ObservableList<ProductCategory> categoryList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM categories";

        try (Connection connection = DB.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            categoryList.clear();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("category_name");

                categoryList.add(new ProductCategory(
                        rs.getInt("id"),
                        rs.getString("category_name")
                ));
            }

            catagoryTable.setItems(categoryList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        catagoryTable.setOnMouseClicked(mouseEvent -> {
            ProductCategory selected = catagoryTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                catagoryNameInput.setText(selected.getCategoryName());

            }
        });
    }

    @FXML
    void CatagoryUpdatebtn(ActionEvent event) {
        ProductCategory selectedCategory = catagoryTable.getSelectionModel().getSelectedItem();

        if (selectedCategory == null) {
            System.out.println("No category selected for update.");
            return;
        }

        String updatedName = catagoryNameInput.getText();
        if (updatedName.isEmpty()) {
            System.out.println("Category name cannot be empty.");
            return;
        }

        String sql = "UPDATE categories SET category_name = ? WHERE id = ?";

        try (Connection connection = DB.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, updatedName);
            pstmt.setInt(2, selectedCategory.getId());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Category updated successfully.");
            } else {
                System.out.println("Update failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        catagoryTableLoad(event);
    }

    @FXML
    void CatagoryResetbtn(ActionEvent event) {
        catagoryNameInput.clear();

        System.out.println("Input reset.");
    }

    // 
}
