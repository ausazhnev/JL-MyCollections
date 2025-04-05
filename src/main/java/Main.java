public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda", 123);
        Car car2 = new Car("Mazda", 123);

        // Простое сравнение вернет false так как ссылки не равны
        System.out.println(car1 == car2);

        // Через метод equals до переопределения метода возвращает false
        // После переопределения возвращает true
        System.out.println(car1.equals(car2));

        // До переопределения метод hashCode возвращает разные значения.
        // после одинаковые
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
    }
}
