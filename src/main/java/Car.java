import java.util.Objects;

public class Car {
    private String brand;
    private int number;

    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    // Своя реализация метода equals
//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Car) {
//            Car car = (Car) obj;
//            return this.brand.equals(car.brand) && this.number == car.number;
//        } else {
//            return false;
//        }
//    }

    // Своя реализация метода hashCode
//    @Override
//    public int hashCode() {
//        return this.brand.hashCode() + this.number;
//    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }
}
