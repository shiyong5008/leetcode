class Solution {
    public boolean isPowerOfTwo(int n) {

        /*
        if (n>0 && (n&(n-1)) == 0) return true;
        else return false;

         */

        if (n>0 && (n&(-n)) == n) return true;
        else return false;



    }
}
