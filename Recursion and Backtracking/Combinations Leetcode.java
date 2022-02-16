class Solution {
    
    public void combine(List<List<Integer>> combinations,List<Integer> combination,int boxNo,int n,int k) {
        
        if(boxNo == n) {
           
            if(combination.size() == k) {
               List<Integer> copy = new ArrayList<>(combination);
               combinations.add(copy);
            }
            
            return;
        }
        
        //yes call-> add this current item to the current box
        combination.add(boxNo + 1); //since boxNo = 0 when item is 1
        combine(combinations,combination,boxNo + 1,n,k);
        combination.remove(combination.size() - 1);
        
        //no call
        combine(combinations,combination,boxNo + 1,n,k);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combine(combinations,combination,0,n,k);
        return combinations;
    }
}
