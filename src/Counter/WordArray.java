package counter;

import java.util.*;
import java.util.Map.Entry;

public class WordArray {
    private HashMap<String, Integer> map;
    private String input;

    public WordArray(String input) {
        this.input = input;

        map =new HashMap<>();
    }

    public WordArray() {
        map =new HashMap<>();
    }

    private void clear(){
        map.clear();
    }

    public void input(String input){
        this.input=input;
    }
    public String input(){
        return input;
    }

    @Override
    public String toString() {
        StringBuffer temp=new StringBuffer();

        Comparator<Entry<String,Integer>> stringComp=(Entry<String, Integer> o1, Entry<String, Integer> o2)->{
            int s1 = o1.getValue();
            int s2 = o2.getValue();
            return s1 - s2;
        };
        Set<Entry<String,Integer>> entries=map.entrySet();

        List<Entry<String,Integer>> listConversion=new ArrayList<>(entries);

        Collections.sort(listConversion,stringComp);

        LinkedHashMap<String,Integer> sorted=new LinkedHashMap<>(listConversion.size());

        for(Entry<String,Integer> entry:listConversion){
            sorted.put(entry.getKey(),entry.getValue());
        }

        int i=0;
        for(Entry<String,Integer> mapped:sorted.entrySet()){
            if(i<50){
                temp.append(mapped.getKey()+": Seen "+mapped.getValue()+ " Times\n");
            }
            i++;
        }

        return temp.toString();
    }

    public void add(String which){
       map.merge(which,1,Integer::sum);
    }
}
