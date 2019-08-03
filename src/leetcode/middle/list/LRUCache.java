package leetcode.middle.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LRUCache {
    //146
    HashMap<Integer,Integer> map = new HashMap<>();
    List<Integer> cache = new ArrayList<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.contains(key)){
            cache.remove(cache.indexOf(key));
            cache.add(0,key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key,value);
            cache.remove(cache.indexOf(key));
            cache.add(0,key);
        } else {
            map.put(key,value);
            cache.add(0,key);
            if (cache.size() > capacity){
                map.remove(cache.get(capacity));
                cache.remove(capacity);
            }
        }
    }

}
