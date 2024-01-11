import java.util.*;
public class vignere {
    static String cipher="";
    static String Key="";
    static void vignereCipher(String txt) {
        Scanner ob=new Scanner(System.in);
        String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String name=txt.toUpperCase();
        System.out.println("Enter key to be used");
        String key=ob.nextLine().toUpperCase();
        String usagekey="";
        for(int i=0;i<name.length();i++){
            usagekey=usagekey+key.charAt(i%key.length());
        }  
        Key=usagekey;
        for(int i=0;i<name.length();i++){
            char ch1=name.charAt(i);
            char ch2=usagekey.charAt(i);
            int sum= characters.indexOf(ch1) + characters.indexOf(ch2);
            cipher=cipher+(characters.charAt(sum%characters.length()));
        }

        System.out.println(cipher);
    }

    static void vignereDecipher(String txt){
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