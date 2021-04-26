package lab8_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Storage {
//    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<Integer, Product> products= new HashMap<>();
    private String filename;

    public Storage(String filename) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.filename = filename;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String items[] = line.split(" ");
            int identifier = Integer.parseInt( items[0].trim() );
            String name    = items[1].trim();
            int amount     = Integer.parseInt( items[2].trim() );
            int price      = Integer.parseInt( items[3].trim() );
            Product p = new Product(identifier, name, amount, price);
//            products.add(identifier, p);
            products.put(identifier, p);
        }
        scanner.close();
    }

    public void update(String filename) {
        Scanner scanner = null;
        int lineCounter = 0;
        int readCounter = 0;
        int updateCounter = 0;
        long startTime = System.currentTimeMillis();
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineCounter++;
            if (line.isEmpty()) {
                continue;
            }
            readCounter++;
            String items[] = line.split(" ");
            int identifier = Integer.parseInt( items[0].trim() );
            int newAmount  = Integer.parseInt( items[1].trim() );
            Product p = products.get(identifier);
            if ( p != null) {
                products.get(identifier).increaseAmount(newAmount);
                updateCounter++;
            }
        }
        scanner.close();
        System.out.printf("%-20s %-20s Exec Time=%8s,   Lines %-9s, updated %10s / %-10s (failed %s)%n",
                this.filename, filename, System.currentTimeMillis() - startTime,
                lineCounter, updateCounter, readCounter, readCounter - updateCounter );
    }
}
