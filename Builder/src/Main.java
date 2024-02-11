public class Main {
    public static void main(String[] args) {
        // Kullanım örneği:
        Car car = Car.builder()
                .make("Toyota")
                .model("Corolla")
                .year(2020)
                .color("Red")
                .horsepower(132)
                .build();
        System.out.println(car);

        // Örnek 2:
        Car car2 = Car.builder()
                .make("Volkswagen")
                .model("Passat")
                .year(2019)
                .color("Black")
                .horsepower(190)
                .build();
        System.out.println(car2);
    }
}

