import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class Serveur {

    public static void main(String[] args) {

        try {

            Creditable sp =  new SystemePaiement();
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("server started");
            registry.rebind("SyetemePaiement", sp);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
