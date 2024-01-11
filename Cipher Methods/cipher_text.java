import java.util.*;
class cipher_text{
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        caesar cc=new caesar();
        vignere vc=new vignere();
        onetimepad ot=new onetimepad();
        System.out.println("-----WELCOME TO THE CIPHERTEXT GENERATOR-----");
        System.out.println("ENTER THE TEXT YOU WANT TO CIPHER: ");
        String text=ob.nextLine().toUpperCase();
        System.out.println("ENTER YOUR CHOICE OF ENCRYPTION:");
        System.out.println("1. Casesar Cipher");
        System.out.println("2. Vignere Cipher");
        System.out.println("3. One-Time Pad \n");
        
        int choice=ob.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                cc.caesarCipher(text);
                break;
            
            case 2:
                vc.vignereCipher(text);
                break;

            case 3:
                ot.onetimeCipher(text);
                break;
        
            default:
                break;
        }

        System.out.println("Do you want to decipher the text? Y/N ");
        char ch=ob.next().charAt(0);
        if(ch=='Y' || ch=='y'){
            if(choice==1){
                cc.caesarDedcipher(cc.cipher);
            }

            if(choice==2){
                vc.vignereDecipher(vc.cipher);
            }

            if(choice==3){
                ot.onetimeDecipher(ot.cipher);
            }
        }

        else if(ch=='N' || ch=='n'){
            System.out.println("Don't forget to copy the cipher text :)");
        }

        else
        System.out.println("Invalid Input");

    }
}