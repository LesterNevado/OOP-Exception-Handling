import java.util.*;

public class ExceptionMain {
    public static void main(String[] args){
        	Scanner input = new Scanner(System.in);
            int attempt = 0;
            
            while(true){
                try{
                    System.out.print("Enter Password: ");
                    String pass = input.nextLine();

                    if (!pass.equals("password"))
                        throw new InvalidPassException("Invalid Password!");

                     System.out.println("Login Successful!");
                     input.close();
                     System.exit(0);
                    
                } catch (InvalidPassException e1){
                    System.out.println("Error found: " + e1.getMessage());
                    attempt++;
                    
                    if (attempt >= 3) {
                        try {
                            throw new FailedPassException("\nLogin Attempts Exceeded");
                        } catch (FailedPassException e2) {
                            System.out.println(e2.getMessage() + "\nLogin Unsuccessful!");
                            System.exit(0);
                        }
                    }

                    System.out.println();
                }
        }
    }
}
