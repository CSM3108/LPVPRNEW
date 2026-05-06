import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class Server {
    public static void main(String[] args) {
        try {
            StringServiceImpl servant = new StringServiceImpl();
            ORB orb = ORB.init(args, null);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(servant);
            StringService href = StringServiceHelper.narrow(ref);

            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            ncRef.rebind(ncRef.to_name("StringService"), href);

            rootPOA.the_POAManager().activate();
            System.out.println("Server ready and waiting for clients...");
            orb.run();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
