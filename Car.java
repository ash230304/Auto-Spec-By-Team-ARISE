public class Car {
    private String make;
    private String model;
    private String engine;
    private String transmission;
    private String color;
    private String wheels;
    private double basePrice;

    public Car(String make, String model, String engine, String transmission, String color, String wheels, double basePrice) {
        if (make == null || make.isEmpty()) throw new IllegalArgumentException("Make is required.");
        if (model == null || model.isEmpty()) throw new IllegalArgumentException("Model is required.");
        if (engine == null || engine.isEmpty()) throw new IllegalArgumentException("Engine is required.");
        if (transmission == null || transmission.isEmpty()) throw new IllegalArgumentException("Transmission is required.");
        if (color == null || color.isEmpty()) throw new IllegalArgumentException("Color is required.");
        if (wheels == null || wheels.isEmpty()) throw new IllegalArgumentException("Wheels are required.");
        if (basePrice <= 0) throw new IllegalArgumentException("Base price must be positive.");

        this.make = make;
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.wheels = wheels;
        this.basePrice = basePrice;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getEngine() { return engine; }
    public String getTransmission() { return transmission; }
    public String getColor() { return color; }
    public String getWheels() { return wheels; }
    public double getBasePrice() { return basePrice; }
}