package AI.hello;
public class Board {
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;
    //Board size
    private static int rows_range=6;
    private static int cols_range=7;
    // Max barnching depth
    private static int branching_depth_k=10;
    // current state of board
    private static int[][]state=new int[rows_range][cols_range];
    // with bruning or without bruning
    public static boolean bruning=true;
    public static int explored_nodes=0;
    public static boolean isFull(){
        for(int i=0;i<cols_range;i++){
            if(state[rows_range-1][i]==0){
                return false;
            }
        }
        return true;
    }
    public static void with_bruning(boolean with_bruning){
        bruning=with_bruning;
    }

    public static void setState(int[][] grid) {
        state = grid;
    }

    public static int[][] getState() {
        return state;
    }

    public static int getRows_range() {
        return rows_range;
    }
    public static int getCols_range() {
        return cols_range;
    }
    public static void changeBoardSize(int cols,int rows){
        rows_range=rows;
        cols_range=cols;
    }
    public static void change_Branching_depth_k(int k){
        branching_depth_k=k;
    }

    public static int getBranching_depth_k(){
        return branching_depth_k;
    }

    // Make human player take decision and change state of board
    public static boolean human_take_decision(int col){
        if(col<cols_range){
        for(int i=0;i<rows_range;i++){
            if(state[i][col]==0) {
                state[i][col] = PLAYER2;
                return true;
            }
        }
            return false;
        }
        return false;


    }

    //AI agent take decision and change state of board
    public static Node take_decision(){
        Node initial_node=new Node(state,null,0);
        int oldHeuristic = Huristic_Function.eval_state(state,0);
        explored_nodes=0;
        if(bruning){
            state= MinMax.Maximize(initial_node,oldHeuristic,true,-10000,10000).getState();
        }
        else {
            state= MinMax.Maximize(initial_node,oldHeuristic,false,0,0).getState();
        }
        long end=System.currentTimeMillis()/1000;
        return initial_node;
    }
    public static void copy_array(int[][]arr1,int[][] arr2){
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                arr1[i][j]=arr2[i][j];
            }
        }
    }

    //print take decision tree
    public static void print_tree(Node initial_node){
        // print each level of tree in row
        for(int i=0;i<Board.getRows_range();i++){

        }
    }
}
