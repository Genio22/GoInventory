package com.example.goinventory.Controller;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.example.goinventory.Model.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class User_Controller {
     @FXML
    public Button logout_user;
     @FXML
    public Button Send_Mail_button;
    @FXML
    private AnchorPane Dashbordfarme;
    @FXML
    private AnchorPane SandParcelframe;
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
    private Button Sandparcelbtn;
    @FXML
    private Button deliverdbtn;
    @FXML
    private Button paindingbtn;
    @FXML
    public Button Addpoductbtn;
    @FXML
    public Button ManageCategorybtn;

    @FXML
    private Text balancetxt;


    // Dashboad data
    @FXML
    private Text TotalPaingOrder;

    @FXML
    private Text TotalDeliverd;

    @FXML
    private Text TotalSandParcel;
    @FXML
    private PieChart userPaichart;
    

  

     // for send parcel

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
    private TextField catagoryNameInput;

   
     @FXML
    private TextField quantiryTextFild;

@FXML
private ComboBox<Category> sandParcel_cata_comobox;

@FXML
private ComboBox<ProductInventory> sandParcel_product_comobox;




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


    
// For add Inventory table
@FXML
private TableView<ProductInventory> addproductTable;

@FXML
private TableColumn<ProductInventory, Integer> proId;
@FXML
private TableColumn<ProductInventory, String> proName;
@FXML
private TableColumn<ProductInventory, String> proCatagry;
@FXML
private TableColumn<ProductInventory, Integer> proquantity;
@FXML
private TableColumn<ProductInventory, Double> proPrice;

    @FXML
private ComboBox<Category> CatagoryComobox;

    @FXML
    private TextField CatNametextfild;
    @FXML
    private TextField cataQuantitytextFild;
    @FXML
    private TextField cataPricetextFild;



    private Connection connection;

    public void buttonAction(ActionEvent e) {
        Dashbordfarme.setVisible(true);
        SandParcelframe.setVisible(false);
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
        // catagory table
        catagreyId.setCellValueFactory(new PropertyValueFactory<>("id"));
        catagoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        updateBalance();
        loadUserParcelStats();

    }

private void loadUserParcelStats() {
    int userId = IdStore.getloginId();

    int pendingCount = 0;
    int deliveredCount = 0;
    int totalParcels = 0;

    String sql = "SELECT status FROM user_inventory WHERE userId = ?";

    try (
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String status = rs.getString("status");
            totalParcels++;
            if ("Pending".equalsIgnoreCase(status)) {
                pendingCount++;
            } else if ("Delivered".equalsIgnoreCase(status)) {
                deliveredCount++;
            }
        }

        // Set values in Text fields
        TotalPaingOrder.setText(String.valueOf(pendingCount));
        TotalDeliverd.setText(String.valueOf(deliveredCount));
        TotalSandParcel.setText(String.valueOf(totalParcels));

        // Update PieChart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Delivered", deliveredCount),
                new PieChart.Data("Pending", pendingCount),
                new PieChart.Data("Total", totalParcels)
        );

        userPaichart.setData(pieChartData);
        userPaichart.setTitle("Parcel Status");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Balance update
    public void updateBalance() {
    String query = "SELECT amount FROM role_login WHERE id = ?";

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            double amount = rs.getDouble("amount");
            balancetxt.setText(String.format("%.2f", amount));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // Add parcel Ui
    @FXML
    void SandParcelbtn(ActionEvent event) {
         Dashbordfarme.setVisible(false);
        SandParcelframe.setVisible(true);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(false);
        ManageCategoryframe.setVisible(false);
        AddproductFrame.setVisible(false);

        loadCategoriesIntoComboBox(sandParcel_cata_comobox);
        setupCategorySelectionHandler();
        setupProductSelectionHandler();
        Submit_button(event);
        

        
        
    }

    // Add parcel submit button 
   int userId = IdStore.getloginId();
   @FXML
private void Submit_button(ActionEvent event) {
    String insertQuery = "INSERT INTO user_inventory (customer_name, phone_number, address, district, thana, note, cod_amount, invoice_amount, quintity, status, date, product_id, userId) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String productInvenQue = "SELECT quantity FROM productinventory WHERE id = ?";
    String updateproductInvenQue = "UPDATE productinventory SET quantity = quantity - ? WHERE id = ?";

    try (
        PreparedStatement pstmt = connection.prepareStatement(insertQuery);
        PreparedStatement selectStmt = connection.prepareStatement(productInvenQue);
        PreparedStatement updateStmt = connection.prepareStatement(updateproductInvenQue)
    ) {
        String name = name_textField.getText();
        String phone = phone_textField.getText();
        String address = address_textField.getText();
        String district = district_textField.getText();
        String thana = thana_textField.getText();
        String note = note_textField.getText();

        double codAmount = Double.parseDouble(codAmount_textField.getText());
        double invoiceAmount = Double.parseDouble(invoiceAmout_textField.getText());
        double quantity = Double.parseDouble(quantiryTextFild.getText());
        String status = "Pending";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        ProductInventory selectedProduct = (ProductInventory) sandParcel_product_comobox.getValue();
        if (selectedProduct == null) {
            System.err.println("Please select a product.");
            return;
        }

        int productId = selectedProduct.getId();

        // Check  quantity
        selectStmt.setInt(1, productId);
        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            double availquantity = rs.getDouble("quantity");
            if (availquantity < quantity) {
                System.err.println("Not enough quantity in stock. Available: " + availquantity);
                return;
            }
        } else {
            System.err.println("Product not found.");
            return;
        }

        // Step 2: Insert into user_inventory
        pstmt.setString(1, name);
        pstmt.setString(2, phone);
        pstmt.setString(3, address);
        pstmt.setString(4, district);
        pstmt.setString(5, thana);
        pstmt.setString(6, note);
        pstmt.setDouble(7, codAmount);
        pstmt.setDouble(8, invoiceAmount);
        pstmt.setDouble(9, quantity);
        pstmt.setString(10, status);
        pstmt.setString(11, date);
        pstmt.setInt(12, productId);
        pstmt.setInt(13, userId);

        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            // Step 3: Subtract quantity
            updateStmt.setDouble(1, quantity);
            updateStmt.setInt(2, productId);
            int updatedRows = updateStmt.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Product quantity reduced.");
            } else {
                System.err.println("Failed to update product quantity.");
            }

            System.out.println("Invoice added successfully!");
            clearForm();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.err.println("Please enter valid numeric values for COD, invoice amount, and quantity.");
    }
//    send_mail(event);
}


    public void send_mail(ActionEvent event) {
        // Extract and validate input fields
        String name = name_textField.getText().trim();
        String phone = phone_textField.getText().trim();
        String address = address_textField.getText().trim();
        String district = district_textField.getText().trim();
        String thana = thana_textField.getText().trim();
        String note = note_textField.getText().trim();
        String codText = codAmount_textField.getText().trim();
        String invoiceText = invoiceAmout_textField.getText().trim();
        String quantityText = quantiryTextFild.getText().trim();
        String status = "Pending";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Input validation
        if (name.isEmpty() || phone.isEmpty() || codText.isEmpty() || invoiceText.isEmpty() || quantityText.isEmpty()) {
            System.out.println("Please fill all required fields (Name, Phone, COD, Invoice, Quantity).");
            return;
        }

        double codAmount, invoiceAmount, quantity;
        try {
            codAmount = Double.parseDouble(codText);
            invoiceAmount = Double.parseDouble(invoiceText);
            quantity = Double.parseDouble(quantityText);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values for COD, Invoice Amount, and Quantity.");
            return;
        }

        // Create directory for saving invoice file
        File invoiceDir = new File("C:\\Users\\User\\Downloads\\GoInventory[1]\\GoInventory\\out\\Mail box\\Invoice");
        if (!invoiceDir.exists()) {
            invoiceDir.mkdirs();
        }

        // Create a safe file name
        String safeFileName = name.replaceAll("[^a-zA-Z0-9]", "_") + "_" + phone + "_Invoice.txt";
        File invoiceFile = new File(invoiceDir, safeFileName);

        // Write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(invoiceFile))) {
            writer.write("=========== Invoice ===========\n");
            writer.write("Customer Name  : " + name + "\n");
            writer.write("Phone Number   : " + phone + "\n");
            writer.write("Address        : " + address + "\n");
            writer.write("District       : " + district + "\n");
            writer.write("Thana          : " + thana + "\n");
            writer.write("Note           : " + note + "\n");
            writer.write("COD Amount     : " + codAmount + "\n");
            writer.write("Invoice Amount : " + invoiceAmount + "\n");
            writer.write("Quantity       : " + quantity + "\n");
            writer.write("Status         : " + status + "\n");
            writer.write("Date           : " + date + "\n");
            writer.write("================================\n");
            System.out.println("Invoice generated: " + invoiceFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing invoice file: " + e.getMessage());
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
        quantiryTextFild.clear();
    }
    // table load for  Deliverd and painding 

   public void tableload(ActionEvent event, String key, int userId) {
    ObservableList<Order> orderList = FXCollections.observableArrayList();
    String query = "SELECT * FROM user_inventory WHERE status = ? AND userId = ?";

    try (Connection connection = DB.getConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

        pstmt.setString(1, key);
        pstmt.setInt(2, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                orderList.add(new Order(
                        rs.getInt("invoice_id"),
                        rs.getString("customer_name"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("district"),
                        rs.getString("note"),
                        rs.getDouble("cod_amount"),
                        rs.getDouble("quintity"),
                        rs.getString("date")
                ));
            }

            if (key.equalsIgnoreCase("Pending")) {
                Order_Table2.setItems(orderList);
            } else if (key.equalsIgnoreCase("delivered")) {
                Oreder_Table1.setItems(orderList);
            }

        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }

    // Deliverd parcel ui
    @FXML
    void Deliverd_button(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        SandParcelframe.setVisible(false);
        Deliverdframe.setVisible(true);
        paindingframe.setVisible(false);
        AddproductFrame.setVisible(false);
        ManageCategoryframe.setVisible(false);
        tableload(event, "delivered" , userId);

    }

    // Painding parcel ui
    @FXML
    void Painding_button(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        SandParcelframe.setVisible(false);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(true);
        AddproductFrame.setVisible(false);
        ManageCategoryframe.setVisible(false);
        tableload(event, "Pending" , userId);
    }

    @FXML
    void Managecatagory(ActionEvent event) {
         Dashbordfarme.setVisible(false);
        SandParcelframe.setVisible(false);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(false);
        ManageCategoryframe.setVisible(true);
        AddproductFrame.setVisible(false);

        catagorySavebtn(event);
        catagoryTableLoad(event);

        CatagoryResetbtn(event);

    }


    @FXML
void catagorySavebtn(ActionEvent event) {
    String sql = "INSERT INTO categories (category_name, catauserid) VALUES (?, ?)";

    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        String categoryName = catagoryNameInput.getText();
        int userId = IdStore.getloginId();

        pstmt.setString(1, categoryName);
        pstmt.setInt(2, userId);
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
                int id = rs.getInt("catagoryId");
                String name = rs.getString("category_name");

                categoryList.add(new ProductCategory(
                        rs.getInt("catagoryId"),
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

        String sql = "UPDATE categories SET category_name = ? WHERE catagoryId = ?";

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

    


                                                // Add Inventory us starting
    @FXML
    void AddProduct(ActionEvent event) {
        Dashbordfarme.setVisible(false);
        SandParcelframe.setVisible(false);
        Deliverdframe.setVisible(false);
        paindingframe.setVisible(false);
        ManageCategoryframe.setVisible(false);
        AddproductFrame.setVisible(true);

        loadCategoriesIntoComboBox(CatagoryComobox);
        productSave(event);
        loadProductTable();
        ProductRecet( event);
        ProductUpdate( event);
        productDelete( event);

    }

    private void loadCategoriesIntoComboBox(ComboBox<Category> comboBox) {
    String sql = "SELECT catagoryId, category_name FROM categories WHERE catauserid = ?";
    
    try {
        int userId = IdStore.getloginId(); 

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, userId); 

        ResultSet rs = stmt.executeQuery();

        ObservableList<Category> categoryList = FXCollections.observableArrayList();
        while (rs.next()) {
            categoryList.add(new Category(
                rs.getInt("catagoryId"),
                rs.getString("category_name")));
        }

        comboBox.setItems(categoryList);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}



     @FXML
    void productSave(ActionEvent event) {
    String name = CatNametextfild.getText();
    String quantityStr = cataQuantitytextFild.getText();
    String priceStr = cataPricetextFild.getText();
    Category selectedCategory = (Category) CatagoryComobox.getValue();

    
    if (name.isEmpty() || quantityStr.isEmpty() || priceStr.isEmpty() || selectedCategory == null) {
        System.out.println("Please fill all fields and select a category.");
        return;
    }

    try {
        int quantity = Integer.parseInt(quantityStr);
        double price = Double.parseDouble(priceStr);
        int categoryId = selectedCategory.getId();
        

        String sql = "INSERT INTO productInventory (name, quantity, price, Ncategory_id) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setInt(2, quantity);
        pstmt.setDouble(3, price);
        pstmt.setInt(4, categoryId);

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Product added successfully.");
          
        }

    } catch (NumberFormatException e) {
        System.out.println("Quantity and price must be numeric.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    loadProductTable();
}

// Load product table in add Inventory ui
private void loadProductTable() {
    ObservableList<ProductInventory> productList = FXCollections.observableArrayList();

    String sql = "SELECT p.id, p.name, p.quantity, p.price, c.catagoryId, c.category_name " +
                 "FROM productInventory p " +
                 "JOIN categories c ON p.Ncategory_id = c.catagoryId " +
                 "WHERE c.catauserid = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        int userId = IdStore.getloginId(); // Get the currently logged-in user ID
        stmt.setInt(1, userId); // Apply filter

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Category category = new Category(
                rs.getInt("catagoryId"),
                rs.getString("category_name")
            );

            ProductInventory product = new ProductInventory(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("quantity"),
                rs.getDouble("price"),
                category
            );

            productList.add(product);
        }

        addproductTable.setItems(productList);

        proId.setCellValueFactory(new PropertyValueFactory<>("id"));
        proName.setCellValueFactory(new PropertyValueFactory<>("name"));
        proquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        proPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        proCatagry.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getCategory().getCategory())
        );

    } catch (SQLException e) {
        e.printStackTrace();
    }
}



    @FXML
void ProductRecet(ActionEvent event) {
    CatNametextfild.clear();
    cataQuantitytextFild.clear();
    cataPricetextFild.clear();
    CatagoryComobox.getSelectionModel().clearSelection();
    addproductTable.getSelectionModel().clearSelection();
}


    @FXML
void ProductUpdate(ActionEvent event) {
    ProductInventory selected = addproductTable.getSelectionModel().getSelectedItem();
    if (selected == null) {
        System.out.println("Select a product to update.");
        return;
    }

    String name = CatNametextfild.getText();
    String quantityStr = cataQuantitytextFild.getText();
    String priceStr = cataPricetextFild.getText();
    Category selectedCategory = (Category) CatagoryComobox.getValue();

    if (name.isEmpty() || quantityStr.isEmpty() || priceStr.isEmpty() || selectedCategory == null) {
        System.out.println("Please fill all fields and select a category.");
        return;
    }

    try {
        int quantity = Integer.parseInt(quantityStr);
        double price = Double.parseDouble(priceStr);

        String sql = "UPDATE productInventory SET name = ?, quantity = ?, price = ?, Ncategory_id = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, quantity);
        pstmt.setDouble(3, price);
        pstmt.setInt(4, selectedCategory.getId());
        pstmt.setInt(5, selected.getId());

        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Product updated.");
            loadProductTable();
        }

    } catch (NumberFormatException | SQLException e) {
        e.printStackTrace();
    }
}


    @FXML
void productDelete(ActionEvent event) {
    ProductInventory selected = addproductTable.getSelectionModel().getSelectedItem();
    if (selected == null) {
        System.out.println("Select a product to delete.");
        return;
    }

    try {
        String sql = "DELETE FROM productInventory WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, selected.getId());

        int rowsDeleted = pstmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Product deleted.");
            loadProductTable();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}




private void loadProductsByCategory(Category category) {
    ObservableList<ProductInventory> products = FXCollections.observableArrayList();
    String sql = "SELECT * FROM productInventory WHERE Ncategory_id = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, category.getId());

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            products.add(new ProductInventory(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("quantity"),
                rs.getDouble("price"),
                category
            ));
        }

        sandParcel_product_comobox.setItems(products);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


private void setupProductSelectionHandler() {
    sandParcel_product_comobox.setOnAction(event -> {
        ProductInventory selectedProduct = sandParcel_product_comobox.getValue();
        if (selectedProduct != null) {
            invoiceAmout_textField.setText(String.valueOf(selectedProduct.getPrice()));
        }
    });
}
private void setupCategorySelectionHandler() {
    sandParcel_cata_comobox.setOnAction(event -> {
        Category selectedCategory = sandParcel_cata_comobox.getValue();
        if (selectedCategory != null) {
            loadProductsByCategory(selectedCategory);
        }
    });
}



}