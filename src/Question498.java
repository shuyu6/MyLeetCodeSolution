public class Question498 {
    public static void main(String[] args) {
        var solution = new Solution();
        solution.findDiagonalOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}});

    }
    static class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            // calculate the size of the result
            int mMax = mat.length;
            int nMax = mat[0].length;
            int[] result = new int[mMax * nMax];

            // m is row, n is column
            int m=0, n=0;

            for(int i=0; i<result.length;i++){
                result[i] = mat[m][n];

                if((m+n)%2 == 0){ // going up
                    // reach end of the column
                    if(n==nMax-1) m++;
                    // reached top of the row
                    else if(m==0) n++;
                    // continue to go diagonal
                    else{
                        m--;
                        n++;
                    }
                } else{ // going down
                    // reach bottom of the row
                    if(m==mMax-1) n++;
                    //  reach start of the column
                    else if(n==0) m++;
                    // continue to go diagonal
                    else{
                        n--;
                        m++;
                    }
                }
            }
            return result;
        }
    }
}
