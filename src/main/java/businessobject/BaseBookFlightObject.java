package businessobject;

public class BaseBookFlightObject {
    private String departureDate = null;
    private String from = null;
    private String to = null;
    private boolean oneway;
    private String passengers = null;
    private boolean redeemPoints;

    public BaseBookFlightObject(String departureDate, String from, String to, boolean oneway, String passengers, boolean redeemPoints) {
        this.departureDate = departureDate;
        this.from = from;
        this.to = to;
        this.oneway = oneway;
        this.passengers = passengers;
        this.redeemPoints = redeemPoints;
    }

    private BaseBookFlightObject(){}


    public String getPassengers() {
        return this.passengers;
    }

    public boolean getRedeemPoints() {
        return this.redeemPoints;
    }

    public String getdepartureDate() {
        return this.departureDate;
    }


    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public boolean getOneway() {
        return this.oneway;
    }

    public static Builder newBuilder(){
        return new BaseBookFlightObject().new Builder();
    }

    public class Builder{
        public Builder(){}
        public Builder getPassengers(String passengers) {
            BaseBookFlightObject.this.passengers = passengers;
            return this;
        }

        public Builder getRedeemPoints(boolean redeemPoints) {
            BaseBookFlightObject.this.redeemPoints = redeemPoints;
            return this;
        }

        public Builder getdepartureDate(String departureDate) {
            BaseBookFlightObject.this.departureDate = departureDate;
            return this;
        }


        public Builder getFrom(String from) {
            BaseBookFlightObject.this.from = from;
            return this;
        }

        public Builder getTo(String to) {
            BaseBookFlightObject.this.to = to;
            return this;
        }

        public Builder getOneway(boolean oneway) {
            BaseBookFlightObject.this.oneway = oneway;
            return this;
        }

        public BaseBookFlightObject build(){
            return BaseBookFlightObject.this;
        }

    }

}
