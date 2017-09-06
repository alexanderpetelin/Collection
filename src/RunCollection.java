import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Created by DnS on 06.09.2017.
 */
public class RunCollection {
    public static void main(String[] args) {
        //task1();
        task2();
    }

    static private void task1() {
        HashMap<String, Integer> hm = new HashMap<>();
        try {
            String[] rows = new Scanner(new File("Lesson3Task1.txt")).useDelimiter("\\Z").next().split(" ");
            for (String s : rows) {
                Integer count = hm.get(s);
                if (count == null)
                    hm.put(s, 1);
                else
                    hm.put(s, count + 1);
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Проблема чтения файла");
        }
        catch(Exception ex){
            System.out.println("Инициализация данных невозможна");
        }

        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + ": " + pair.getValue() + " повторений");
    //            it.remove(); // avoids a ConcurrentModificationException
        }

    }

    static private void task2() {
        Phonebook phonebook = new Phonebook();
        try {
            FileReader reader = new FileReader("Lesson3Task2.txt");
            BufferedReader in = new BufferedReader(reader);
            String string;
            while ((string = in.readLine()) != null) {
                String[] data = string.split(" ");
                phonebook.add(data[0], data[1]);
            }
            in.close();
            reader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Проблема чтения файла");
        }
        catch(Exception ex){
            System.out.println("Инициализация данных невозможна");
        }

        Iterator it = phonebook.iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + ": " );
            HashSet< String > phones = (HashSet<String>) pair.getValue();

            Iterator phonesit = phones.iterator();
            while (phonesit.hasNext()) {
                String str = (String)phonesit.next();
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
