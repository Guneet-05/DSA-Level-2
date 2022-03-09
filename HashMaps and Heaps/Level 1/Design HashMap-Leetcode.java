class MyHashMap {
    
      private class HMNode {
        int key;
        int value;
        HMNode next;
        
        HMNode(){}
        
        HMNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private LinkedList<HMNode>[] buckets;
    private int noOfNodes;
    private int noOfBuckets;
    private double loadingFactor;
    
    
      public void init() {
        buckets = new LinkedList[noOfBuckets];
        
        for(int i=0;i<noOfBuckets;i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public MyHashMap() {
       
        noOfBuckets = 4;
        noOfNodes = 0;
        loadingFactor = 0.0;
        init(); 
    }
    
     public int getBucketID(int key) {
        //O(1)
        Integer keyObj = new Integer(key);
        int hashCode = keyObj.hashCode();
        int bucketID = (Math.abs(hashCode)) % noOfBuckets;
        return bucketID;
    }
    
    public HMNode getData(int bucketID, int key) {
        for(HMNode node : buckets[bucketID]) {
            if(node.key == key) {
                return node; //data already exist
                //return its index in the LL
            }
            
        }
        
        return null; //data does not exist
    }
    
    
    
    public void put(int key, int value) {
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
    
    public int get(int key) {
        int bucketID = getBucketID(key);
      HMNode data = getData(bucketID,key);
      
      if(data != null) {
        return data.value;
      } else {
        return -1;  
      }
    }
    
    public void remove(int key) {
         int bucketID  = getBucketID(key);
      HMNode data = getData(bucketID,key);
      
      if(data == null) return;
      
      buckets[bucketID].remove(data);
      noOfNodes--;
      loadingFactor = (noOfNodes * 1.0) / noOfBuckets;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
