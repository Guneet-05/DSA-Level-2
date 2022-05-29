import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        
        for(int t=0;t<T;t++) {
            int length = scn.nextInt();
            int breadth = scn.nextInt();
            int tower = scn.nextInt();

            ArrayList<Integer> rows = new ArrayList<>();
            rows.add(0); rows.add(length + 1);
            ArrayList<Integer> cols = new ArrayList<>();
            cols.add(0); cols.add(breadth + 1);

            for(int i=0;i<tower;i++) {
                int row = scn.nextInt();
                rows.add(row);
                int col = scn.nextInt();
                cols.add(col);
            }

            Collections.sort(rows);
            Collections.sort(cols);

            int maxRow = 0;
            for(int i=1;i<rows.size();i++) {
                int curr = rows.get(i) - rows.get(i-1) - 1;
                maxRow = Math.max(maxRow,curr);
            }

            int maxCol = 0;
            for(int i=1;i<cols.size();i++) {
                int curr = cols.get(i) - cols.get(i-1) - 1;
                maxCol = Math.max(maxCol,curr);
            }

            System.out.println(maxRow * maxCol);
        }

        scn.close();
	}
}
