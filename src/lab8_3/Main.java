package lab8_3;

public class Main {
    public static void main(String[] args) {
        Storage s1 = new Storage("data1000.txt");
        s1.update("update1000.txt");

        Storage s2 = new Storage("data1000.txt");
        s2.update("update1000000.txt");

        Storage s3 = new Storage("data1000000.txt");
        s3.update("update1000.txt");

        Storage s4 = new Storage("data1000000.txt");
        s4.update("update1000000.txt");
    }
}
