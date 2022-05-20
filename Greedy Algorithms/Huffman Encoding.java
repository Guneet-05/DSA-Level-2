class Solution {
    
ArrayList<String> ans = new ArrayList<String>();
   class Node implements Comparable<Node>{
       int data;
       Node left;
       Node right;
       Node(int data){
           this.data=data;
           this.left=left;
           this.right=right;
       }
       public int compareTo(Node o){
           if(this.data == o.data){
               return 1;
           }
           return this.data-o.data;
       }
   }
    void sol(Node root,String s){
       if(root==null)
           return;
       if(root.left==null&&root.right==null){
           ans.add(s);
           return;
       }    
       if(root.left!=null)
            sol(root.left,s+"0");
       if(root.right!=null)
            sol(root.right,s+"1");
       
   }
public ArrayList<String> huffmanCodes(String S, int f[], int N)
   {
       // Code here
Node root=null;
PriorityQueue<Node> pq = new PriorityQueue<>();
for(int i=0;i<N;i++){
   Node n = new Node(f[i]);
   pq.add(n);
}
while(pq.size()>1){
   Node l=pq.poll();
   Node r=pq.poll();
   root= new Node(l.data+r.data);
   root.left=l;
   root.right=r;
   pq.add(root);
   
}
root=pq.remove();
 sol(root,"");
 return ans;
   }
}
