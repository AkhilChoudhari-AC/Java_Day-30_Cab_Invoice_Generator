package Com.BridgeLabz.CabInvoiceGenerator;

public class InvoiceService {
    private RideRepository rideRepository;

    /**
     * default constructor for InvoiceService
     */
    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    /**
     * create method calculateFare for calculating both kind of rides Premium Rides
     * and normal rides
     *
     * @param ride
     * @return
     */
    public double calculateFare(Ride ride) {
        return Math.max(ride.rideCategory.minFare,
                ride.getDistance() * ride.rideCategory.costPerKm + ride.getTime() * ride.rideCategory.costPerTime);
    }

    /**
     * InvoiceSummary method for getting the part of the invoice
     *
     * @param rides
     * @return
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * method created addRides for Given a user id
     *
     * @param userId
     * @param ride
     */
    public void addRides(String userId, Ride[] ride) {
        rideRepository.addRide(userId, ride);
    }

    /**
     * the invoice service gets the list of rides from the ride repository, and
     * return the invoice
     *
     * @param userId
     * @return
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

}

