import java.util.*;
public class onetimepad {
    static String cipher="";
    static String Key="";
    static void onetimeCipher(String txt) {
        Scanner ob=new Scanner(System.in);
        String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Enter key to be used. Key should be equal in length as the plaintext.");
        Key=ob.nextLine().toUpperCase();
        for(int i=0;i<txt.length();i++){
            char ch1=txt.charAt(i);
            char ch2=Key.charAt(i);
            int sum= characters.indexOf(ch1) + characters.indexOf(ch2);
            cipher=cipher+(characters.charAt(sum%characters.length()));
        }

        System.out.println(cipher);
    }

    static void onetimeDecipher(String txt){
        String plainText="";
        String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String k=Key;
        for(int i=0;i<txt.length();i++){
             char ch=txt.charAt(i);
             char keyChar=Key.charAt(i);
            for(int j=0;j<characters.length();j++){
                if(characters.charAt(j)==ch){
                    for(int k=0; k<characters.length();k++){
                        if(characters.charAt(k)==keyChar){
                            plainText =plainText + characters.charAt((j-k)%26);
                        }
                        else
                        continue;
                    }
                }
                else
                continue;
            }
        }
        System.out.println("Plaintext: "+plainText);
    }
}