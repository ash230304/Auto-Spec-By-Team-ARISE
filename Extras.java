public class Extras {
    private boolean sunroof;
    private boolean navigation;
    private boolean premiumSound;

    public Extras(boolean sunroof, boolean navigation, boolean premiumSound) {
        this.sunroof = sunroof;
        this.navigation = navigation;
        this.premiumSound = premiumSound;
    }

    public boolean isSunroof() { return sunroof; }
    public boolean isNavigation() { return navigation; }
    public boolean isPremiumSound() { return premiumSound; }
}