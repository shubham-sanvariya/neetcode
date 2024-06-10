public class Word_Search {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Word_Search wordSearch = new Word_Search();
        wordSearch.exist(board,word);
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] vis=new boolean[board.length][board[0].length];

        for(int i=0;i < board.length;i++)
            for(int j=0;j < board[0].length;j++)
                if(board[i][j]==word.charAt(0) && recur(0,i,j,board,word,vis))
                    return true;

        System.out.println(false);
        return false;
    }

    public boolean recur(int index,int i,int j,char[][] board,String word,boolean[][] vis){
        // Base Case
        if(index==word.length()-1)
            return true;

        // Recursive

        // left
        if(j-1 >= 0 && vis[i][j-1]!=true && board[i][j-1]==word.charAt(index+1)){
            vis[i][j]=true;
            if(recur(index+1,i,j-1,board,word,vis)) return true;
            vis[i][j]=false;
        }

        // right
        if(j+1 < board[0].length && vis[i][j+1]!=true && board[i][j+1]==word.charAt(index+1)){
            vis[i][j]=true;
            if(recur(index+1,i,j+1,board,word,vis)) return true;
            vis[i][j]=false;
        }

        // up
        if(i-1 >= 0 && vis[i-1][j]!=true && board[i-1][j]==word.charAt(index+1)){
            vis[i][j]=true;
            if(recur(index+1,i-1,j,board,word,vis)) return true;
            vis[i][j]=false;
        }

        // down
        if(i+1 < board.length && vis[i+1][j]!=true && board[i+1][j]==word.charAt(index+1)){
            vis[i][j]=true;
            if(recur(index+1,i+1,j,board,word,vis)) return true;
            vis[i][j]=false;
        }

        return false;
    }

}
