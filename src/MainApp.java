import java.rmi.registry.*;
import java.util.*;
import java.awt.*;
import javax.sql.rowset.serial.*;

public class MainApp {

    public static void main(String[] args) {

        Client client1 = new Client(1, "Yasmine");
        Client client2 = new Client(2, "Rasha");
        Client client3 = new Client(3, "Rasha");
        Client client4 = new Client(4, "Wadye");

        Scanner scanner = new Scanner(System.in);

        try {

            Registry registry = LocateRegistry.getRegistry(1099);
            Creditable servicePaiement = (Creditable) registry.lookup("SyetemePaiement");

            System.out.print("Veuillez saisir votre ID: ");
            int id = scanner.nextInt();
             boolean Op=true;
            while ( Op) {
                System.out.println("\n[0] Lire Solde\t\t[1] Créditer\t[2] Débiter \t[3] Quitter ");
                System.out.print("Entrez le numéro de l'opération: ");
                int operation = scanner.nextInt();

                switch (operation) {

                    // Afficher le solde
                    case 0:
                        System.out.println("\nVotre solde: $" + servicePaiement.lireSolde(id));
                        break;

                    // Créditer
                    case 1:
                        System.out.print("\nVeuillez entrer le montant à ajouter: ");
                        double montant = scanner.nextDouble();
                        System.out.println("\nVotre solde est désormais de $" + servicePaiement.crediter(id, montant));
                        break;

                    // Débiter
                    case 2:
                        try {
                            System.out.print("\nVeuillez entrer le montant à retirer: ");
                            double montantd = scanner.nextDouble();
                            System.out.println("\nVotre solde est désormais de $" + servicePaiement.debiter(id, montantd));
                        } catch (PaymentException pe) {
                            System.out.println("\n" + pe);
                        }
                        break;
                    case 3:
                        Op=false;
                        break;

                    default:
                        System.out.println("Choix invalide!");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
