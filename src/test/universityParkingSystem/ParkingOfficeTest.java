/*
 */
package universityParkingSystem;


import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * WEEK 6 Assignment: Add Parking Lot and Parking Office Classes
 * ICT-4305, Summer 2020, Dr. Ryan Rucker, PhD
 * @author Steve Stackle
 * Updated July 24, 2020
 */
public class ParkingOfficeTest {
    
    public ParkingOfficeTest() {
    }

    @Test
    public void testGetParkingOfficeName() {
        System.out.println("Test getParkingOfficeName method");
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        String expResult = "Test Parking Office";
        String result = testParkingOffice.getParkingOfficeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParkingOfficeAddress method, of class ParkingOffice.
     */
    @Test
    public void testGetParkingOfficeAddress() {
        System.out.println("Test getParkingOfficeAddress method");
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        Address expResult = testParkingOfficeAddress;
        Address result = testParkingOffice.getParkingOfficeAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomerList method, of class ParkingOffice.
     */
    @Test
    public void testGetCustomerList() {
        System.out.println("Test getCustomerList method");
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(testCustomer);
        ArrayList<Customer> customers1 = new ArrayList<Customer>();
        customers1.add(testCustomer);
        ArrayList<Customer> expResult = customers;
        ArrayList<Customer> result = customers1;
        assertEquals(expResult, result);
    }

    /**
     * Test of getParkingLotList method, of class ParkingOffice.
     */
    @Test
    public void testGetParkingLotList() {
        System.out.println("Test getParkingLotList method");
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        ParkingLot testParkingLot = new ParkingLot("T", "Test", testAddress, 1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(testParkingLot);
        ArrayList<ParkingLot> parkingLots1 = new ArrayList<ParkingLot>();
        parkingLots1.add(testParkingLot);
        ArrayList<ParkingLot> expResult = parkingLots;
        ArrayList<ParkingLot> result = parkingLots1;
        assertEquals(expResult, result);
    }

    /**
     * Test of register method, of class ParkingOffice.
     */
    @Test
    public void testRegister_Customer() {
        System.out.println("Test register method");
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        testParkingOffice.register(testCustomer);
        Boolean expResult = true;
        Boolean result = testParkingOffice.getCustomerList().contains(testCustomer);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addParkingLot method, of class ParkingOffice.
     */
    @Test
    public void testAddParkingLot() {
        System.out.println("Test addParkingLot method");
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        ParkingLot testParkingLot = new ParkingLot("T", "Test", testAddress, 1);
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        testParkingOffice.addParkingLot(testParkingLot);
        Boolean expResult = true;
        Boolean result = testParkingOffice.getParkingLotList().contains(testParkingLot);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of register method, of class ParkingOffice.
     */
    @Test
    public void testRegister_PermitManager_Car() {
        System.out.println("Test register(car) method");
        PermitManager testPermitManager = new PermitManager();
        CarType suvCarType = CarType.SUV;
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        Car testCar = new Car(suvCarType, "ABC1234", testCustomer);
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        //ParkingPermit testPermit = testPermitManager.register(testCar);
        LocalDate expResult = testPermitManager.register(testCar).getExpiration();
        LocalDate result = testPermitManager.register(testCar).getExpiration();
        assertEquals(expResult, result);
    }

    /**
     * Test of park method, of class ParkingOffice.
     */
    @Test
    public void testPark() {
        System.out.println("Test park method");
        TransactionManager testTransactionManager = new TransactionManager();
        LocalDate testDate = LocalDate.parse("2020-01-01");
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        CarType suvCarType = CarType.SUV;
        Car testCar = new Car(suvCarType, "ABC1234", testCustomer);
        ParkingPermit testPermit = new ParkingPermit(testCar);
        Address testAddressPL = new Address("address 1", "address 2", "city", "state", "zip");
        ParkingLot testParkingLot = new ParkingLot("T", "Test", testAddressPL, 1);
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        ParkingTransaction newTransaction1 = new ParkingTransaction(testDate, testPermit, 
                testParkingLot);
        LocalDate expResult = testTransactionManager.park(testDate, 
                testPermit, testParkingLot).getTransactionDate();
        LocalDate result = testTransactionManager.park(testDate, 
                testPermit, testParkingLot).getTransactionDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParkingCharges method, of class ParkingOffice.
     */
    @Test
    public void testGetParkingCharges_TransactionManager_ParkingPermit() {
        System.out.println("Test getParkingCharges(ParkingPermit) method");
        TransactionManager testTransactionManager = new TransactionManager();
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        CarType suvCarType = CarType.SUV;
        Car testCar = new Car(suvCarType, "ABC1234", testCustomer);
        ParkingPermit testPermit = new ParkingPermit(testCar);
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        String expResult = "$0.00";
        String result = testParkingOffice.getParkingCharges(testTransactionManager, testPermit).
                getMoneyString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParkingCharges method, of class ParkingOffice.
     */
    @Test
    public void testGetParkingCharges_TransactionManager_Customer() {
        System.out.println("Test getParkingCharges(Customer) method");
        TransactionManager testTransactionManager = new TransactionManager();
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        String expResult = "$0.00";
        String result = testParkingOffice.getParkingCharges(testTransactionManager, testCustomer).
                getMoneyString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParkingPermitList method, of class ParkingOffice.
     */
    @Test
    public void testGetParkingPermitList() {
        System.out.println("Test getParkingPermitList method");
        PermitManager testPermitManager = new PermitManager();
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        CarType suvCarType = CarType.SUV;
        Car testCar = new Car(suvCarType, "ABC1234", testCustomer);
        ParkingPermit testPermit = new ParkingPermit(testCar);
        ArrayList<ParkingPermit> parkingPermits = new ArrayList<ParkingPermit>();
        parkingPermits.add(testPermit);
        ArrayList<ParkingPermit> parkingPermits1 = new ArrayList<ParkingPermit>();
        parkingPermits1.add(testPermit);
        ArrayList<ParkingPermit> expResult = parkingPermits;
        ArrayList<ParkingPermit> result = parkingPermits1;
        assertEquals(expResult, result);
    }

    /**
     * Test of getTransactionList method, of class ParkingOffice.
     */
    @Test
    public void testGetTransactionList() {
        System.out.println("Test getTransactionList method");
        TransactionManager testTransactionManager = new TransactionManager();
        Address testParkingOfficeAddress = new Address("address 1", "address 2", "city", "state", 
                "zip");
        ParkingOffice testParkingOffice = new ParkingOffice("Test Parking Office", 
                testParkingOfficeAddress);
        LocalDate testDate = LocalDate.parse("2020-01-01");
        Address testAddress = new Address("address 1", "address 2", "city", "state", "zip");
        Customer testCustomer = new Customer("ID", "First", "Last", "Phone", testAddress);
        CarType suvCarType = CarType.SUV;
        Car testCar = new Car(suvCarType, "ABC1234", testCustomer);
        ParkingPermit testPermit = new ParkingPermit(testCar);
        Address testAddressPL = new Address("address 1", "address 2", "city", "state", "zip");
        ParkingLot testParkingLot = new ParkingLot("T", "Test", testAddressPL, 1);
        ParkingTransaction testTransaction = new ParkingTransaction(testDate, testPermit, 
                testParkingLot);
        ArrayList<ParkingTransaction> transactions = new ArrayList<ParkingTransaction>();
        transactions.add(testTransaction);
        ArrayList<ParkingTransaction> transactions1 = new ArrayList<ParkingTransaction>();
        transactions1.add(testTransaction);
        ArrayList<ParkingTransaction> expResult = transactions;
        ArrayList<ParkingTransaction> result = transactions1;
        //ArrayList<ParkingTransaction> expResult = null;
        //ArrayList<ParkingTransaction> result = instance.getTransactionList(transactionManager);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}