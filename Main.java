import java.util.*;

// Abstract Vehicle class
abstract class Vehicle {
    protected String vehicleID;
    protected String modelName;
    protected double rentalRate;
    protected boolean isRented;

    public Vehicle(String vehicleID, String modelName, double rentalRate) {
        this.vehicleID = vehicleID;
        this.modelName = modelName;
        this.rentalRate = rentalRate;
        this.isRented = false;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        this.isRented = rented;
    }

    public abstract double calculateRentalCost(int days);

    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Model     : " + modelName);
        System.out.println("Rate/Day  : ₹" + rentalRate);
        System.out.println("Rented    : " + (isRented ? "Yes" : "No"));
    }
}

// Interface Rentable
interface Rentable {
    void rentVehicle();
    void returnVehicle();
}

// Car class
class Car extends Vehicle implements Rentable {
    public Car(String vehicleID, String modelName, double rentalRate) {
        super(vehicleID, modelName, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public void rentVehicle() {
        if (!isRented) {
            isRented = true;
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car was not rented.");
        }
    }
}

// Bike class
class Bike extends Vehicle implements Rentable {
    public Bike(String vehicleID, String modelName, double rentalRate) {
        super(vehicleID, modelName, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public void rentVehicle() {
        if (!isRented) {
            isRented = true;
            System.out.println("Bike rented successfully.");
        } else {
            System.out.println("Bike is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Bike returned successfully.");
        } else {
            System.out.println("Bike was not rented.");
        }
    }
}

// Truck class
class Truck extends Vehicle implements Rentable {
    public Truck(String vehicleID, String modelName, double rentalRate) {
        super(vehicleID, modelName, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public void rentVehicle() {
        if (!isRented) {
            isRented = true;
            System.out.println("Truck rented successfully.");
        } else {
            System.out.println("Truck is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Truck returned successfully.");
        } else {
            System.out.println("Truck was not rented.");
        }
    }
}

// RentalService class to manage everything
class RentalService {
    private Map<String, Vehicle> vehicleMap;

    public RentalService() {
        vehicleMap = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getVehicleID(), vehicle);
    }

    public void rentVehicle(String vehicleID, int days) {
        Vehicle vehicle = vehicleMap.get(vehicleID);
        if (vehicle != null && !vehicle.isRented()) {
            ((Rentable) vehicle).rentVehicle();
            double cost = vehicle.calculateRentalCost(days);
            System.out.println("Rental cost for " + days + " days: ₹" + cost);
        } else {
            System.out.println("Vehicle not found or already rented.");
        }
    }

    public void returnVehicle(String vehicleID) {
        Vehicle vehicle = vehicleMap.get(vehicleID);
        if (vehicle != null && vehicle.isRented()) {
            ((Rentable) vehicle).returnVehicle();
        } else {
            System.out.println("Vehicle not found or not currently rented.");
        }
    }

    public void showAllVehicles() {
        System.out.println("======= Vehicle List =======");
        for (Vehicle v : vehicleMap.values()) {
            v.displayInfo();
            System.out.println("-----------------------------");
        }
    }
}

// Main class to simulate the rental system
public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();

        // Adding vehicles
        rentalService.addVehicle(new Car("CAR001", "Hyundai Verna", 1500));
        rentalService.addVehicle(new Bike("BIKE001", "Royal Enfield", 500));
        rentalService.addVehicle(new Truck("TRUCK001", "Eicher Pro", 2000));

        rentalService.showAllVehicles();

        // Renting and returning vehicles
        rentalService.rentVehicle("CAR001", 3);
        rentalService.returnVehicle("CAR001");

        rentalService.rentVehicle("BIKE001", 2);
        rentalService.returnVehicle("BIKE001");

        rentalService.showAllVehicles();
    }
}

