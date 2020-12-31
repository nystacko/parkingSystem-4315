/*
 */
package universityParkingSystem;
import java.util.*;  
import java.time.*;

/**
 * WEEK 9 Assignment: Car, Parking Permit, Parking Transaction, Parking Office Classes
 * ICT-4305, Summer 2020, Dr. Ryan Rucker, PhD
 * @author Steve Stackle
 * Updated August 16, 2020
 */
/**
 * This class builds a ParkingOffice object out of 2 strings and 2 ArrayLists.
 * It contains getter methods for each attribute. It also contains methods to register a customer
 * and add Customer and ParkingLot objects to their respective ArrayLists.
 * It also uses methods of the Transaction Manager and Permit Manager classes to register(),
 * park(), getParkingCharges(), and get their ArrayLists.
 */
public class ParkingOffice {
   
    private String parkingOfficeName;
    private Address parkingOfficeAddress;
    private ArrayList<Customer> listOfCustomers;
    private ArrayList<ParkingLot> listOfParkingLots;
    
    public ParkingOffice(String parkingOfficeName, Address parkingOfficeAddress) {
        this.parkingOfficeName = parkingOfficeName;
        this.parkingOfficeAddress = parkingOfficeAddress;
        listOfCustomers = new ArrayList<Customer>();
        listOfParkingLots = new ArrayList<ParkingLot>(); 
    }

    public String getParkingOfficeName() {
        return parkingOfficeName;
    }
    public Address getParkingOfficeAddress() {
        return parkingOfficeAddress;
    }
    public ArrayList<Customer> getCustomerList() {
        return listOfCustomers;
    }
    public ArrayList<ParkingLot> getParkingLotList() {
        return listOfParkingLots;
    }
    public void register(Customer customer) {
        listOfCustomers.add(customer);
        System.out.println("Customer " + customer.getCustomerName() + " has been registered.");
    }

    public void addParkingLot(ParkingLot newParkingLot) {
        listOfParkingLots.add(newParkingLot);
        System.out.println("Parking Lot " + newParkingLot.getParkingLotName() + " has been added to"
                + " the list.");
    }
    // Create a new Parking Permit using the register(car) method of the Permit Manager class.
    public ParkingPermit register(PermitManager permitManager, Car car) {
        ParkingPermit newPermit = permitManager.register(car);
        return newPermit;
    }
    // Create a new Parking Transaction using the park(date, parkingPermit, parkingLot)
    //             method of the Transaction Manager class.
    public ParkingTransaction park(TransactionManager transactionManager, LocalDate date, 
            ParkingPermit parkingPermit, ParkingLot parkingLot) {
        ParkingTransaction newTransaction = transactionManager.park(date, parkingPermit, 
                parkingLot);
        // addTransaction(newTransaction);
        return newTransaction;
    }
    // Create a new Parking Charges Money object using the getParkingCharges(parkingPermit) method 
    // of the Transaction Manager class.
    public Money getParkingCharges(TransactionManager transactionManager, 
            ParkingPermit parkingPermit) {
        Money permitParkingCharges = transactionManager.getParkingCharges(parkingPermit);
        return permitParkingCharges;
    }
    // Create a new Parking Charges Money object using the getParkingCharges(customer) method 
    // of the Transaction Manager class.
    public Money getParkingCharges(TransactionManager transactionManager, 
            Customer customer) {
        Money permitParkingCharges = transactionManager.getParkingCharges(customer);
        return permitParkingCharges;
    }
    // Get the Parking Permit list from the Permit Manager class.
    public ArrayList<ParkingPermit> getParkingPermitList(PermitManager permitManager) {
        ArrayList<ParkingPermit> permitList = permitManager.getParkingPermitList();
        return  permitList;
    }
    // Get the Parking Transaction list from the Transaction Manager class.
    public ArrayList<ParkingTransaction> getTransactionList(TransactionManager transactionManager) {
        ArrayList<ParkingTransaction> transactionList = transactionManager.getTransactionList();
        return  transactionList;
    }
}
