package com.example.goinventory.Model;
 



import javafx.beans.property.*;

    public class Employee {
        private final IntegerProperty id;
        private final StringProperty name;
        private final StringProperty mobileNumber;
        private final StringProperty email;
        private final StringProperty location;
        private final StringProperty workingStatus;
        private final DoubleProperty salary;

        public Employee(int id, String name, String mobileNumber, String email, String location, String workingStatus, double salary) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.mobileNumber = new SimpleStringProperty(mobileNumber);
            this.email = new SimpleStringProperty(email);
            this.location = new SimpleStringProperty(location);
            this.workingStatus = new SimpleStringProperty(workingStatus);
            this.salary = new SimpleDoubleProperty(salary);
        }

        public int getId() { return id.get(); }
        public String getName() { return name.get(); }
        public String getMobileNumber() { return mobileNumber.get(); }
        public String getEmail() { return email.get(); }
        public String getLocation() { return location.get(); }
        public String getWorkingStatus() { return workingStatus.get(); }
        public double getSalary() { return salary.get(); }

        // Properties (for table binding if needed)
        public IntegerProperty idProperty() { return id; }
        public StringProperty nameProperty() { return name; }
        public StringProperty mobileNumberProperty() { return mobileNumber; }
        public StringProperty emailProperty() { return email; }
        public StringProperty locationProperty() { return location; }
        public StringProperty workingStatusProperty() { return workingStatus; }
        public DoubleProperty salaryProperty() { return salary; }
    }


