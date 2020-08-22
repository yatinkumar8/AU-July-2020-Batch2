import java.util.Scanner;
import java.util.Arrays;


class PrimeException extends RuntimeException{

}

public class UncheckedException {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Count: ");
        int count = s.nextInt();
        boolean[] prime=new boolean[count+1];
        prime[0]=true;
        prime[1]=true;
        for (int i = 2; i * i <= count; i++){
            if (!prime[i]){
                for (int j = i * i; j <= count; j+=i){
                    prime[j] = true;
                }
            }
        }
        
        for(int i=0; i<=count;i++){
            try{
                if (!prime[i]){
                    throw new PrimeException();
                }
            }catch(PrimeException e){
                System.out.println("Prime:"+i);
            }
        }
    }
}