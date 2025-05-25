import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarBuildDAO {
    private final String url = "jdbc:mysql://localhost:3306/carbuild_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String user = "root";
    private final String password = "TEAMARISE"; // Set your DB password

    // Method to load the MySQL driver explicitly
    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create(CarBuild build) {
        loadDriver();  // <-- Add this line
        String sql = "INSERT INTO CarBuild (make, model, engine, transmission, color, wheels, basePrice, seatMaterial, dashboardMaterial, ambientLighting, sunroof, navigation, premiumSound) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, build.getMake());
            stmt.setString(2, build.getModel());
            stmt.setString(3, build.getEngine());
            stmt.setString(4, build.getTransmission());
            stmt.setString(5, build.getColor());
            stmt.setString(6, build.getWheels());
            stmt.setDouble(7, build.getBasePrice());
            stmt.setString(8, build.getInteriorOptions().getSeatMaterial());
            stmt.setString(9, build.getInteriorOptions().getDashboardMaterial());
            stmt.setBoolean(10, build.getInteriorOptions().isAmbientLighting());
            stmt.setBoolean(11, build.getExtras().isSunroof());
            stmt.setBoolean(12, build.getExtras().isNavigation());
            stmt.setBoolean(13, build.getExtras().isPremiumSound());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CarBuild> readAll() {
        loadDriver();  // <-- Add here too
        List<CarBuild> builds = new ArrayList<>();
        String sql = "SELECT * FROM CarBuild";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                builds.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builds;
    }

    public CarBuild readById(int id) {
        loadDriver();  // <-- And here
        String sql = "SELECT * FROM CarBuild WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(int id, CarBuild build) {
        loadDriver();  // <-- Add here
        String sql = "UPDATE CarBuild SET make=?, model=?, engine=?, transmission=?, color=?, wheels=?, basePrice=?, seatMaterial=?, dashboardMaterial=?, ambientLighting=?, sunroof=?, navigation=?, premiumSound=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, build.getMake());
            stmt.setString(2, build.getModel());
            stmt.setString(3, build.getEngine());
            stmt.setString(4, build.getTransmission());
            stmt.setString(5, build.getColor());
            stmt.setString(6, build.getWheels());
            stmt.setDouble(7, build.getBasePrice());
            stmt.setString(8, build.getInteriorOptions().getSeatMaterial());
            stmt.setString(9, build.getInteriorOptions().getDashboardMaterial());
            stmt.setBoolean(10, build.getInteriorOptions().isAmbientLighting());
            stmt.setBoolean(11, build.getExtras().isSunroof());
            stmt.setBoolean(12, build.getExtras().isNavigation());
            stmt.setBoolean(13, build.getExtras().isPremiumSound());
            stmt.setInt(14, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        loadDriver();  // <-- Add here too
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM CarBuild WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private CarBuild mapResultSet(ResultSet rs) throws SQLException {
        Car car = new Car(
            rs.getString("make"),
            rs.getString("model"),
            rs.getString("engine"),
            rs.getString("transmission"),
            rs.getString("color"),
            rs.getString("wheels"),
            rs.getDouble("basePrice")
        );
        InteriorOptions interior = new InteriorOptions(
            rs.getString("seatMaterial"),
            rs.getString("dashboardMaterial"),
            rs.getBoolean("ambientLighting")
        );
        Extras extras = new Extras(
            rs.getBoolean("sunroof"),
            rs.getBoolean("navigation"),
            rs.getBoolean("premiumSound")
        );
        return new CarBuild(car, interior, extras);
    }
}
