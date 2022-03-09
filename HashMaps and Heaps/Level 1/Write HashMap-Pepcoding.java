import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    
    private class HMNode {
        K key;
        V value;
        HMNode next;
        
        HMNode(){}
        
        HMNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private LinkedList<HMNode>[] buckets;
    private int noOfNodes;
    private int noOfBuckets;
    private double loadingFactor;
    
    public HashMap() {
        noOfBuckets = 4;
        noOfNodes = 0;
        loadingFactor = 0.0;
        init();
    }
    
    public void init() {
        buckets = new LinkedList[noOfBuckets];
        
        for(int i=0;i<noOfBuckets;i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public int getBucketID(K key) {
        //O(1)
        int hashCode = key.hashCode();
        int bucketID = (Math.abs(hashCode)) % noOfBuckets;
        return bucketID;
    }
    
    public HMNode getData(int bucketID, K key) {
        for(HMNode node : buckets[bucketID]) {
            if(node.key.equals(key) == true) {
                return node; //data already exist
                //return its index in the LL
            }
            
        }
        
        return null; //data does not exist
    }
    
    public void put(K key, V value) throws Exception {
      // write your code here
      
      //O(1)
      int bucketIdx = getBucketID(key);
      HMNode data = getData(bucketIdx,key);
      
      if(data == null) {
          //Insertion (does not exist)
          double newLoadingFactor = (noOfNodes + 1.0) / noOfBuckets;
          
          if(newLoadingFactor > 2.0) {
            //rehashing
            LinkedList<HMNode>[] oldBuckets = buckets;
            noOfBuckets = 2 * noOfBuckets;
            init();
            
            for(int i=0;i<oldBuckets.length;i++) {
                for(HMNode node: oldBuckets[i]) {
                    int bucketID = getBucketID(node.key);
                    buckets[bucketID].addLast(node);
                }
            }
          } 
            int newBucketID = getBucketID(key);
            HMNode node = new HMNode(key,value);
            buckets[newBucketID].addLast(node);
            noOfNodes++;
            loadingFactor = (noOfNodes * 1.0) / noOfBuckets;
          
      } else {
          //Updation (key already exist)
          data.value = value;
      }
    }

    public V get(K key) throws Exception {
      // write your code here
      int bucketID = getBucketID(key);
      HMNode data = getData(bucketID,key);
      
      if(data != null) {
        return data.value;
      } else {
        return null;  
      }
    }

    public boolean containsKey(K key) {
      // write your code here
      int bucketID = getBucketID(key);
      HMNode data = getData(bucketID,key);
      
      if(data != null) return true;
      else return false;
    }

    public V remove(K key) throws Exception {
      // write your code here
      int bucketID  = getBucketID(key);
      HMNode data = getData(bucketID,key);
      
      if(data == null) return null;
      
      V value = data.value;
      buckets[bucketID].remove(data);
      noOfNodes--;
      loadingFactor = (noOfNodes * 1.0) / noOfBuckets;
      return value;
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
      ArrayList<K> keys = new ArrayList<>();
      
      for(int i=0;i<noOfBuckets;i++) {
          for(HMNode node : buckets[i]) {
              keys.add(node.key);
          }
      }
      
      return keys;
    }

    public int size() {
      // write your code here
      return noOfNodes;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}
  
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
