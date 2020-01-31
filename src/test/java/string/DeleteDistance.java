package string;

/*
The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in order to get the same string.
 For instance, the deletion distance between "heat" and "hit" is 3:

By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
We cannot get the same string from both strings by deleting 2 letters or fewer.
Given the strings str1 and str2,
 write an efficient function deletionDistance that returns the deletion distance between them.
  Explain how your function works, and analyze its time and space complexities.

input:  str1 = "dog", str2 = "frog"
output: 3

input:  str1 = "some", str2 = "some"
output: 0

input:  str1 = "some", str2 = "thing"
output: 9

input:  str1 = "", str2 = ""
output: 0

 */
public class DeleteDistance {
    static int deletionDistance(String str1, String str2) {
        // your code goes here
        String small = (str1.length() >= str2.length())? str2: str1;
        String large = (str1.length() > str2.length())? str1: str2;

        int left = 0;
        int right = small.length()-1;
        int count=0;

        while(left <= right){
            // left
            int o = large.indexOf(small.charAt(left));
            if(o == -1) {
                count++;
                left++;
                continue;
            } else count+=o;

            large= large.substring(o+1);
            left++;

            // right , 0
            o = large.lastIndexOf(small.charAt(right));
            if(o == -1){
                count++;
                right--;
                continue;
            }
            else count += large.length() - o -1;  // maybe -1 also
            large= large.substring(0,o);
            right--;

        }


        return count + large.length();
    }

    public static void main(String[] args) {
        System.out.println(deletionDistance("aabcd","abccab"));
    }

}
