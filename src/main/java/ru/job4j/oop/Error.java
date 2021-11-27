package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + this.active);
        System.out.println("status: " + this.status);
        System.out.println("message: " + this.message);
    }

    public static void main(String[] args) {
        Error er1 = new Error();
        Error er2 = new Error(true, 404, "Not Found");
        Error er3 = new Error(false, 500, "Internal Server Error");
        er1.printInfo();
        System.out.println();
        er2.printInfo();
        System.out.println();
        er3.printInfo();
    }
}
