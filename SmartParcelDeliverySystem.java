class PackageDelivery {
    private String trackingNumber; //stores the package data
    private String senderName;
    private String destinationZone;
    private double weight;
    private double baseRate;
    public PackageDelivery(String trackingNumber, String senderName, String destinationZone, double weight, double baseRate) { //constructor
        this.trackingNumber = trackingNumber; //assigning values 
        this.senderName = senderName;
        this.destinationZone = destinationZone;
        this.weight = weight;
        this.baseRate = baseRate;
    }
    public String getTrackingNumber() { //getter method
        return trackingNumber; //gives value back
    }
    public String getSenderName() {//getter method
        return senderName;//gives value back
    }
    public String getDestinationZone() {//getter method
        return destinationZone;//gives value back
    }
    public double getWeight() {//getter method
        return weight;//gives value back
    }
    public double getBaseRate() {//getter method
        return baseRate;//gives value back
    }
    public double calculateShippingCost() { //calculates price
        double exfee = 0; //variable with placeholder
        if (destinationZone.equalsIgnoreCase("Local")) { //checks if the zone is local (not case sensitive)
            exfee = 5; //adds $5
        }
        else if (destinationZone.equalsIgnoreCase("National")) { //checks if the zone is national (not case sensitive)
            exfee = 15; //adds $15
        }
        else if (destinationZone.equalsIgnoreCase("International")) { //checks if the zone is international (not case sensitive)
            exfee = 40; //adds $40
        }
        return baseRate + (weight * 2.50) + exfee; //calculates total cost
    }
    public int estimateDeliveryDays() { //how many days delivery will take
        if (destinationZone.equalsIgnoreCase("Local")) { //if local --> 2 days
            return 2;
        }
        else if (destinationZone.equalsIgnoreCase("National")) { //if national --> 5 days
            return 5;
        }
        else {
            return 10; //if international --> 10 days
        }
    }
    public void displayInfo() { //prints out the info
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Sender Name: " + senderName);
        System.out.println("Destination Zone: " + destinationZone);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Base Rate: $" + baseRate);
    }
}
class StandardPackage extends PackageDelivery { //child class inheriting parent class (extends)
    private boolean signatureRequired; //this only standardpackage has
    public StandardPackage(String trackingNumber, String senderName, String destinationZone, double weight, double baseRate, boolean signatureRequired) { //constructor
        super(trackingNumber, senderName, destinationZone, weight, baseRate); //reuses code
        this.signatureRequired = signatureRequired;
    }
    @Override //replaces parent's cost formula
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost(); //base cost from the parent
        if (signatureRequired) {
            cost += 7; //adds $7 if a signature if required
        }
        return cost; //final price
    }
    @Override //replaces old code 
    public int estimateDeliveryDays() {
        return super.estimateDeliveryDays(); 
    }
    @Override //replaces old code 
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Package Type: Standard Package");
        System.out.println("Signature Required: " + signatureRequired);
    }
}
class FragilePackage extends PackageDelivery { //child class inheriting parent class (extends)
    private double insuranceValue; //this only fragilepackage has
    private boolean specialHandlingRequired; //this only fragilepackage has
    public FragilePackage(String trackingNumber, String senderName, String destinationZone, double weight, double baseRate, double insuranceValue, boolean specialHandlingRequired) { //constructor
        super(trackingNumber, senderName, destinationZone, weight, baseRate); //reuses code
        this.insuranceValue = insuranceValue;
        this.specialHandlingRequired = specialHandlingRequired;
    }
    @Override //replaces old code 
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost();
        cost += (insuranceValue * 0.02); //adds insurance by 2%
        if (specialHandlingRequired) {
            cost += 20; //handles extra fees
        }
        return cost;
    }
    @Override //replaces old code 
    public int estimateDeliveryDays() {
        return super.estimateDeliveryDays() + 1; //fragile items take a day more
    }
    @Override
    public void displayInfo() { //prints out code
        super.displayInfo();
        System.out.println("Package Type: Fragile Package");
        System.out.println("Insurance Value: $" + insuranceValue);
        System.out.println("Special Handling Required: " + specialHandlingRequired);
    }
}
class ExpressPackage extends PackageDelivery {  //child class inheriting parent class (extends)
    private boolean sameDayDelivery;//this only expresspackage has
    private boolean weekendDelivery;//this only expresspackage has
    public ExpressPackage(String trackingNumber, String senderName, String destinationZone, double weight, double baseRate, boolean sameDayDelivery, boolean weekendDelivery) { //constructor
        super(trackingNumber, senderName, destinationZone, weight, baseRate); //reuses code
        this.sameDayDelivery = sameDayDelivery;
        this.weekendDelivery = weekendDelivery;
    }
    @Override//replaces old code 
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost();
        cost = cost * 1.5; //50% more cost
        if (sameDayDelivery) { 
            cost += 35; //same day delivery --> $35 added to the cost
        }
        if (weekendDelivery) {
            cost += 15; //weekend delivery --> $15 added to the cost
        }
        return cost; //returns the final cost
    }
    @Override //replaces old code 
    public int estimateDeliveryDays() {
        if (sameDayDelivery) {
            return 1; //1 day for same day delivery 
        }
        int days = super.estimateDeliveryDays() - 2; //faster delievery
        if (days < 1) { //days cant be 0 or less than 0
            days = 1;
        }
        return days; //returns amount of days to deliver
    }
    @Override //replaces old code 
    public void displayInfo() { //prints out code
        super.displayInfo();
        System.out.println("Package Type: Express Package");
        System.out.println("Same Day Delivery: " + sameDayDelivery);
        System.out.println("Weekend Delivery: " + weekendDelivery);
    }
}
class ColdStoragePackage extends PackageDelivery { //child class inheriting parent class (extends)
    private double requiredTemperature; //this only coldstoragepackage has
    private int storageHours;//this only coldstoragepackage has
    public ColdStoragePackage(String trackingNumber, String senderName, String destinationZone, double weight, double baseRate, double requiredTemperature, int storageHours) { //constructor
        super(trackingNumber, senderName, destinationZone, weight, baseRate); //reuses code
        this.requiredTemperature = requiredTemperature;
        this.storageHours = storageHours;
    }
    @Override //replaces old code 
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost();
        cost += (storageHours * 4); //storage costs $4/hr
        if (requiredTemperature < 0) { 
            cost += 25; //extra $25 to freeze things
        }
        return cost; //return final cost
    }
    @Override //replaces old code 
    public int estimateDeliveryDays() {
        int days = super.estimateDeliveryDays() - 1; //faster delivery
        if (days < 1) { //days cant be 0 or less than 0
            days = 1;
        }
        return days; //returns amount of days to deliver
    }
    @Override //replaces old code 
    public void displayInfo() { //prints out code
        super.displayInfo();
        System.out.println("Package Type: Cold Storage Package");
        System.out.println("Required Temperature: " + requiredTemperature + "°C");
        System.out.println("Storage Hours: " + storageHours);
    }
}
public class DeliveryApp { //main class
    public static void main(String[] args) {
        PackageDelivery[] packages = new PackageDelivery[4]; //has all package types
        packages[0] = new StandardPackage( "PKG101", "Ravi Kumar", "Local", 4.5, 10.0, true); //stores different child objects in the parent array
        packages[1] = new FragilePackage("PKG102", "Anita Shah", "National", 6.0, 12.0, 500.0, true); //stores different child objects in the parent array
        packages[2] = new ExpressPackage("PKG103", "Michael Lee", "International", 3.0, 20.0, false, true); //stores different child objects in the parent array
        packages[3] = new ColdStoragePackage("PKG104", "SJCC Lab", "National", 10.0, 25.0, -5.0, 8); //stores different child objects in the parent array
        System.out.println("Smart Parcel Delivery Report");
        System.out.println("----------------------------------");
        for (PackageDelivery p : packages) { //loops through each package
            p.displayInfo(); //prints out code
            System.out.println("Shipping Cost: $" + p.calculateShippingCost());
            System.out.println("Estimated Delivery Days: " + p.estimateDeliveryDays());
            System.out.println("----------------------------------");
        }
    }
}
