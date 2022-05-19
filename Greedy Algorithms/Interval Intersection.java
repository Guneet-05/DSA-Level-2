class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIdx = 0, lastIdx = 0;
        
        ArrayList<int[]> intersect = new ArrayList<>();
        
        while(firstIdx < firstList.length && lastIdx < secondList.length) {
            int s1 = firstList[firstIdx][0];
            int e1 = firstList[firstIdx][1];
            int s2 = secondList[lastIdx][0];
            int e2 = secondList[lastIdx][1];
            
            int start = Math.max(s1,s2);
            int end = Math.min(e1,e2);
            
            if(start <= end) {
                intersect.add(new int[]{start,end});
            }
            
            if(e1 < e2) firstIdx++;
            else lastIdx++;
        }
        
        int[][] res = new int[intersect.size()][2];
        for(int i=0;i<intersect.size();i++) {
            res[i] = intersect.get(i);
        }
        
        return res;
    }
}
