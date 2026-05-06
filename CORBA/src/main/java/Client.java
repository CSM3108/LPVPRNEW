import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            StringService stringService = StringServiceHelper.narrow(ncRef.resolve_str("StringService"));

            String original = "Hello Distributed World";
            String reversed = stringService.reverseString(original);
            String uppercased = stringService.convertToUppercase(original);

            System.out.println("Original String: " + original);
            System.out.println("Reversed String: " + reversed);
            System.out.println("Uppercase String: " + uppercased);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}