class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> res = new ArrayList<>();
        while(N != 0) {
            if(N >= 2000) {
                N = N - 2000; 
                res.add(2000);
            } else if(N >= 500) {
                N = N - 500;
                res.add(500);
            } else if(N >= 200) {
                N = N - 200;
                res.add(200);
            }else if(N >= 100) {
                N = N - 100;
                res.add(100);
            } else if(N >= 50) {
                N -= 50;
                res.add(50);
            } else if(N >= 20) {
                N -= 20;
                res.add(20);
            } else if(N >= 10) {
                N -= 10;
                res.add(10);
            } else if(N >= 5) {
                N -= 5;
                res.add(5);
            } else if(N >= 2) {
                N -= 2;
                res.add(2);
            } else if(N >= 1) {
                N -= 1;
                res.add(1);
            }
        }
        
        return res;
    }
}
