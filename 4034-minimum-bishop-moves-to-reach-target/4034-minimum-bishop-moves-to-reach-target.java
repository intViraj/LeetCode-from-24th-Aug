class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int x=target[0];
        int y=target[1];
        int srcx=source[0];
        int srcy=source[1];
        if((srcx%2 ==0 && srcy%2==0) || (srcx%2!=0 && srcy%2!=0)){
            if(x%2!=0 &&  y%2==0)return -1;
            if(x%2==0 && y%2!=0)return -1;
        }else{
            if(x%2==0 &&  y%2==0)return -1;
            if(x%2!=0 && y%2!=0)return -1;
        }
        // int incx=0;
        // int incy=0;
        // int decx=0;
        // int decy=0;
        for(int i=1;i<=8;i++){
            int incx=srcx+i;
            int incy=srcy+i;

            int decx=srcx-i;
            int decy=srcy-i;
            if((incx==x && incy==y) || (decx==x && decy==y) || (incx==x && decy==y) || (decx==x && incy==y))return 1;
        }
        // if(srcy==y)return 1;
        return 2;
        
    }
}