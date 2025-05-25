public class CarBuild extends Car {
    private InteriorOptions interiorOptions;
    private Extras extras;

    public CarBuild(Car car, InteriorOptions interiorOptions, Extras extras) {
        super(car.getMake(), car.getModel(), car.getEngine(), car.getTransmission(), car.getColor(), car.getWheels(), car.getBasePrice());
        this.interiorOptions = interiorOptions;
        this.extras = extras;
    }

    public InteriorOptions getInteriorOptions() { return interiorOptions; }
    public Extras getExtras() { return extras; }

    public double calculateTotalPrice() {
        double total = getBasePrice();
        if (interiorOptions.isAmbientLighting()) total += 500;
        if (extras.isSunroof()) total += 1200;
        if (extras.isNavigation()) total += 1500;
        if (extras.isPremiumSound()) total += 1000;
        return total;
    }

    @Override
    public String toString() {
        return String.format("Build: %s %s (%s, %s) - $%.2f | Color: %s | Wheels: %s | Interior: %s/%s (Lighting: %s) | Extras: Sunroof=%s, Nav=%s, Sound=%s",
                getMake(), getModel(), getEngine(), getTransmission(), getBasePrice(), getColor(), getWheels(),
                interiorOptions.getSeatMaterial(), interiorOptions.getDashboardMaterial(), interiorOptions.isAmbientLighting(),
                extras.isSunroof(), extras.isNavigation(), extras.isPremiumSound());
    }
}