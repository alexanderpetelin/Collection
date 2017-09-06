import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by DnS on 06.09.2017.
 */
public class Phonebook implements Iterable{
    HashMap<String, HashSet< String >> phonebook;

    Phonebook(){
        phonebook = new HashMap<>();
    }

    public void add(String Sername, String phonenumber){
        HashSet< String > phones = phonebook.get(Sername);
        if (phones == null) {
            HashSet<String> hs = new HashSet<>();
            hs.add(phonenumber);
            phonebook.put(Sername, hs);
        }
        else {
            HashSet<String> hs = phonebook.get(Sername);
            hs.add(phonenumber);
        }
    }

    public HashSet<String> get(String Sername) {
        return phonebook.get(Sername);
    }

    @Override
    public Iterator iterator() {
        Iterator it = phonebook.entrySet().iterator();
        return it;
    }

}
