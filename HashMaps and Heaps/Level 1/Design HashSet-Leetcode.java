class MyHashSet {

    private class HMNode {
        int key;
        HMNode next;
        
        HMNode(){}
        
        HMNode(int key) {
            this.key = key;
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
    
    public MyHashSet() {
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
    
    public void add(int key) {
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
            HMNode node = new HMNode(key);
            buckets[newBucketID].addLast(node);
            noOfNodes++;
            loadingFactor = (noOfNodes * 1.0) / noOfBuckets;
          
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
    
    public boolean contains(int key) {
      int bucketID = getBucketID(key);
      HMNode data = getData(bucketID,key);
      
      if(data != null) return true;
      else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
