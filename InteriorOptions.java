public class InteriorOptions {
    private String seatMaterial;
    private String dashboardMaterial;
    private boolean ambientLighting;

    public InteriorOptions(String seatMaterial, String dashboardMaterial, boolean ambientLighting) {
        if (seatMaterial == null || seatMaterial.isEmpty()) throw new IllegalArgumentException("Seat material is required.");
        if (dashboardMaterial == null || dashboardMaterial.isEmpty()) throw new IllegalArgumentException("Dashboard material is required.");

        this.seatMaterial = seatMaterial;
        this.dashboardMaterial = dashboardMaterial;
        this.ambientLighting = ambientLighting;
    }

    public String getSeatMaterial() { return seatMaterial; }
    public String getDashboardMaterial() { return dashboardMaterial; }
    public boolean isAmbientLighting() { return ambientLighting; }
}