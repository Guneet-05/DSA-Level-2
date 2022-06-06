class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> stk = new Stack<>();
    	
    	for(int i=0;i<M.length;i++) {
    	    stk.push(i);
    	}
    	
    	while(stk.size() > 1) {
    	    int y = stk.pop();
    	    int x = stk.pop();
    	    if(M[x][y] == 1) {
    	        stk.push(y); //y may or may not be a celeb
    	    } else {
    	        stk.push(x); //x may or may not be a celeb
    	    }
    	}
    	
    	int x = stk.pop();
    	
    	for(int j=0;j<M.length;j++) {
    	    if(j == x) continue;
    	    if(M[x][j] == 1) {
    	        return -1;
    	    }
    	}
    	
    	for(int i=0;i<M.length;i++) {
    	    if(i == x) continue;
    	    if(M[i][x] == 0) {
    	        return -1;
    	    }
    	}
    	
    	return x;
    }
}
