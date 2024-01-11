import java.util.*;
public class caesar {
    static String cipher="";
    static int shift;
    static void caesarCipher(String txt) {
        Scanner ob=new Scanner(System.in);
        char characters[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String name= txt.toUpperCase();
        System.out.println("Enter value of shift: ");
        shift=ob.nextInt();
        System.out.println();
        for(int i=0;i<name.length();i++){
            char ch=name.charAt(i);
            for(int j=0;j<characters.length;j++){
                if(characters[j]==ch){
                    cipher=cipher + characters[(j+shift)%26];
                }
                else
                continue;
            }
        }

        System.out.println("CipherText generated: "+cipher);
    }

    static void caesarDedcipher(String txt){
        String plainText="";
        String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<txt.length();i++){
             char ch=txt.charAt(i);
            for(int j=0;j<characters.length();j++){
                if(characters.charAt(j)==ch){
                    plainText =plainText + characters.charAt((j-shift)%26);
                }
                else
                continue;
            }
        }
        System.out.println("Plaintext: "+plainText);
    }
    
}
