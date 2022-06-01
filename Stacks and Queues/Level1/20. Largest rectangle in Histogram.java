class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st=new Stack<>();
        int[] rb=new int[n];  //nse on the right
        int[] lb=new int[n]; //nse on the left

        st.push(heights.length-1);
        rb[heights.length-1]=heights.length;

        for(int i=heights.length-2;i>=0;i--)
        {
            while(st.size()>0 && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                rb[i]=heights.length;
            }
            else
            {
                rb[i]=st.peek();
            }
            st.push(i);
        }

        st=new Stack<>();
        st.push(0);
        lb[0]=-1;
        for(int i=1;i<heights.length;i++)
        {
            while(st.size()>0 && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                lb[i]=-1;
            }
            else
            {
                lb[i]=st.peek();
            }
            st.push(i);
        }

        int maxArea=0;
        for(int i=0;i<heights.length;i++)
        {
            int width=rb[i]-lb[i]-1;
            int area=heights[i]*width;
            if(area>maxArea)
            {
                maxArea=area;
            }
        }
        return maxArea;
    }
}
