package service;

import java.util.HashMap;

public class DictDB {
    public HashMap<String,String> dictionary;
    public DictDB(){
        dictionary=new HashMap<>();
        dictionary.put("dog", "con cho");
        dictionary.put("cat","con meo");
    }
}
