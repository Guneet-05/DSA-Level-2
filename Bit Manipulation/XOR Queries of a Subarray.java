class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pxa = new int[arr.length];
        pxa[0] = arr[0];
        
        for(int i=1;i<pxa.length;i++) {
            pxa[i] = (arr[i] ^ pxa[i-1]);
        }
        
        int[] res = new int[queries.length];
        
        for(int i=0;i<queries.length;i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if(left != 0)
                res[i] = (pxa[right] ^ pxa[left-1]);
            else res[i] = (pxa[right] ^ 0);
        }
        
        return res;
    }
}
