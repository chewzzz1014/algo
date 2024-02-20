import java.util.ArrayList;
import java.util.Arrays;

public class BombsMap {
    public void solution(int N, int[] R, int[] C) {
        // Implement your solution here
        int M = R.length;
        String result = "";

        ArrayList<Integer> bombsX = new ArrayList<Integer>();
        ArrayList<Integer> bombsY = new ArrayList<Integer>();
        // ArrayList<Integer> bombsX = new ArrayList<Integer>(Arrays.asList(R));
        // ArrayList<Integer> bombsY = new ArrayList<Integer>(Arrays.asList(R));
        for(int i=0; i<M; i++){
            bombsX.add(R[i]);
            bombsY.add(C[i]);
        }

        ArrayList<Integer> rowNeighs = new ArrayList<>();
        ArrayList<Integer> colNeighs = new ArrayList<>();

        for(int row=0; row<N; row++){
            for(int col=0; col<N; col++){
                // it's a bomb
                int boomX = bombsX.indexOf(row);
                boolean matchY = false;

                if(boomX != -1){
                for(int i=0; !matchY && i<bombsY.size(); i++){
                    if(bombsY.get(i) == col)
                        if(i == boomX)
                            matchY = true;
                    }
                }
                if(boomX!=-1 && matchY){
                //if(bombsX.contains(row) && bombsY.contains(col)){
                    result += "B";
                }else{
                    //result += "N";
                    int neighbours = 0;

                    rowNeighs.add(row);
                    if (row == 0){
                       rowNeighs.add(row+1);
                    }
                    else if (row == M-1){
                       rowNeighs.add(row-1);
                    }else{
                       rowNeighs.add(row+1);
                       rowNeighs.add(row-1);
                    }

                    colNeighs.add(col);
                    if (col == 0){
                       colNeighs.add(col+1);
                    }
                    else if (col == M-1){
                       colNeighs.add(col-1);
                    }else{
                       colNeighs.add(col+1);
                       colNeighs.add(col-1);
                    }

                    for(int i=0; i<M; i++){
                        if(rowNeighs.contains(R[i])&&colNeighs.contains(C[i]))
                            neighbours++;
                    }

                    result += neighbours+"";

                    rowNeighs.clear();
                    colNeighs.clear();
                }

                if(col == N-1)
                    result += "\n";
            }
        }
         
        System.out.println(result);

/*
        // find neighbour

            

            (row-1, col), 
            (row+1, col), 

            (row-1, col-1), 
            (row-1, col+1), 

            (row+1, col-1), 
            (row+1, col+1), 

            (row, col+1), 
            (row, col-1)
        
        
           */
    }
}