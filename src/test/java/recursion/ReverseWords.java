package recursion;

public class ReverseWords {
    static void reverse(char [] str, int s, int e){

        //for(int i =e-1;i< s;i--){
        //check its a space mark teh index
        while( s <e){
            //swap
            swap(str,s,e);
            s++;
            e--;
        }
    }


    static char[]  swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return arr;
    }

    /**
     * it doest use any buffer space excpet the current buffer
     * @param str
     * @return
     */
    static char[] reverseString(char[] str){
        int e=str.length-1;
        reverse(str,0,e);
        for(int i =e; i>0;i--){
            //check its a space mark teh index
            if(str[i]==' '){
                reverse(str,i+1,e);
                e=i-1;
            }
        }
        //reverse the last word
        reverse(str,0,e);

        return str;
    }

    public static void main(String[] args) {
         System.out.print(ReverseWords.reverseString(new char[]{'a','b',' ','c','d'}));
    }
}
