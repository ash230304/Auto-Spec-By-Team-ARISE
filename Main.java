import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", "Hybrid", "Automatic", "Black", "Alloy", 30000);
        InteriorOptions interior = new InteriorOptions("Leather", "Wood", true);
        Extras extras = new Extras(true, true, true);
        CarBuild build = new CarBuild(car, interior, extras);

        CarBuildDAO dao = new CarBuildDAO();

        // CREATE
        dao.create(build);

        // READ ALL
        List<CarBuild> builds = dao.readAll();
        builds.forEach(System.out::println);

        // WRITE TO FILE
        CarBuildIO.saveListToFile(builds, "carbuilds.txt");

        // READ FILE
        List<String> lines = CarBuildIO.readFromFile("carbuilds.txt");
        lines.forEach(System.out::println);

        // UPDATE first build if exists
        if (!builds.isEmpty()) {
            dao.update(1, build);
        }

        // DELETE (optional demo)
        // dao.delete(1);
    }
}