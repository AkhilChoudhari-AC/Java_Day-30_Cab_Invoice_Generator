package Com.BridgeLabz.CabInvoiceGenerator;

public class InvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final double COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5;

    /**
     * create method to calculate total fare as per distance and time
     *
     * @param distance -distance of per km cost is 10 rs
     * @param time     -per minute cost is 1rs
     * @return total fare -total fare to be calulated
     */
    public double calculateFare(double distance, int time) {
        return Math.max(MINIMUM_FARE, distance * COST_PER_KM + time * COST_PER_TIME);
    }

}


