class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int extraGas = 0;
        int start = 0;
        int deficit = 0;
        
        for(int i=0;i<n;i++) {
            extraGas += (gas[i] - cost[i]);
            if(extraGas < 0) {
                start = i + 1;
                deficit -= extraGas;
                extraGas = 0;
            } 
        }
        
        if(extraGas >= deficit) return start;
        return -1;
    }
}
