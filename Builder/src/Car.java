public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private int horsepower;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String make;
        private String model;
        private int year;
        private String color;
        private int horsepower;

        public Builder make(String make) {
            this.make = make;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder horsepower(int horsepower) {
            this.horsepower = horsepower;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.make = this.make;
            car.model = this.model;
            car.color = this.color;
            car.year = this.year;
            car.horsepower = this.horsepower;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", horsepower=" + horsepower +
                '}';
    }
}
