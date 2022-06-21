package xyz.GPSforLEGENDS;

public class StrStr {

    public static void main(String[] args) {
        int res = strStr("mississippi", "issip");
    }

    public static int strStr(String haystack, String needle) {

        if(needle.isEmpty()) return 0;
        if(needle.length() > haystack.length()) return -1;

        outer:
        for(int i = 0; i < haystack.length(); i++){
            for(int k = 0; k < needle.length(); k++){
                if(haystack.charAt(i+k) == needle.charAt(k)){
                    if(k == needle.length()-1){
                        return i;
                    }
                } else{
                    continue outer;
                }
            }
        }

        return -1;
    }
}
