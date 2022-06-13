public class Main {

    public static void main(String[] args) {
        Thread thread1 = new ThreadExample("퐁");
        Thread thread2 = new ThreadExample("당");
        Thread thread3 = new ThreadExample("!");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
