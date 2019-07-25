package advanced.course.p2.optionalAPI;

import java.util.Optional;

public class F2OptionalCodeSugar {

    public static class PhoneNum {
        private String number = "050-444-3333";
        public String getNumber() {
            return number;
        }
    }

    public static class Driver {
        private PhoneNum phoneNum = new PhoneNum();
        public PhoneNum getPhoneNum() {
            return phoneNum;
        }
    }

    public static class Taxi {
        private Driver driver = new Driver();
        public Driver getDriver() {
            return driver;
        }
    }

    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        callTaxiDriver(taxi);
        callTaxiDriverWithOptional(taxi);
    }


    private static void callTaxiDriver(Taxi taxi) {
        if (taxi != null) {
            Driver driver = taxi.getDriver();
            if (driver != null) {
                PhoneNum phoneNum = driver.getPhoneNum();
                if (phoneNum != null) {
                    String number = phoneNum.getNumber();
                    System.out.println("Calling " + number);
                }
            }
        }
    }

    private static void callTaxiDriverWithOptional(Taxi taxi) {
        String number = Optional.ofNullable(taxi)
                .map(Taxi::getDriver)
                .map(Driver::getPhoneNum)
                .map(PhoneNum::getNumber)
                .get();
        System.out.println("Calling " + number);
    }
}
