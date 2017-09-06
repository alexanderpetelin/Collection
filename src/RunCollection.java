import java.io.*;
import java.util.*;

import java.util.Scanner;

/**
 * Created by DnS on 06.09.2017.
 */
public class RunCollection {
    public static void main(String[] args) throws IOException {
        //task1();

        createFile();
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
    static private void createFile() throws IOException {
        FileWriter file = new FileWriter("Lesson3Task2.txt");
        file.write("Иванов 8-923-111-11-11\n");
        file.write("Петров 8-452-490-52-11\n");
        file.write("Иванов 8-197-328-09-10\n");
        file.write("Иванов 8-197-328-09-11\n");
        file.write("Сидоров 8-987-123-65-47\n");
        file.write("Петров 8-111-490-52-11");
        file.close();
    }
}
