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
        clear();
        this.input=input;
    }
    public String input(){
        return input;
    }

    @Override
    public String toString() {
        ArrayList<String> temp=new ArrayList<>();
        StringBuffer ret=new StringBuffer();

        Comparator<Entry<String,Integer>> stringComp=(Entry<String, Integer> o1, Entry<String, Integer> o2)->{
            int s1 = o1.getValue();
            int s2 = o2.getValue();
            return s2 - s1;
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
                temp.add(mapped.getKey()+" is seen "+mapped.getValue()+" times");
            }
            ++i;
        }

        temp.sort((String s1, String s2)->{
            return s1.compareToIgnoreCase(s2);
        });

        for (String s : temp) {
            ret.append(s+"\n");
        }

        return ret.toString();
    }

    public String stringBuff(){
        int begin=0;
        StringBuffer  str=new StringBuffer();
        String rem="./ \\ '(){}[],|<>?!@#$%^&*()_-+= ;:";

        for (int i = 0; i < input.length(); i++) {
            if( rem.indexOf(input.charAt(i)) > -1){
                add(input.substring(begin, i));
                begin=i+1;
            }
        }
        add(input.substring(begin));
        map.remove("");

        ArrayList<Entry<String,Integer>> con= new ArrayList<>();
        con.addAll(map.entrySet());

        Collections.sort(con,(Entry<String,Integer> o1, Entry<String,Integer>o2)->{
            int s1 = o1.getValue();
            int s2 = o2.getValue();
            return s2 - s1;
        });

        int end=0;
        ArrayList<String> ret=new ArrayList<>();
        for (Entry<String,Integer> entry : con) {
            if(end<50)
                ret.add(entry.getKey()+" is seen "+entry.getValue()+" times");
            end++;
        }

        ret.sort((String s1,String s2)->{
            return s1.compareToIgnoreCase(s2);
        });

        for (String s : ret) {
            str.append(s+"\n");
        }

        return str.toString();
    }

    public void add(String which){
       map.merge(which.toLowerCase(),1,Integer::sum);
    }

    public boolean run(){
        String[] words=input.split(" +");
        for (String s : words) {
            add(s);
        }
        System.out.println("Done");
        return true;
    }
}
