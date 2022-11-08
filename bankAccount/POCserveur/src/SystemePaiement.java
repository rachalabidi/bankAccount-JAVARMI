import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class SystemePaiement extends UnicastRemoteObject implements Creditable {

    static ArrayList<Compte> comptes = new ArrayList<Compte>();

    public SystemePaiement() throws RemoteException {

        super();

        Compte c1 = new Compte(1, 10000);
        Compte c2 = new Compte(2, 5000);
        Compte c3 = new Compte(3, 200);
        Compte c4 = new Compte(4, 3927);

        comptes.add(0, c1);
        comptes.add(1, c2);
        comptes.add(2, c3);
        comptes.add(3, c4);

    }

    public double crediter(int id, double montant) {
        Compte compte = comptes.get(id - 1);
        compte.setSolde(compte.getSolde() + Math.abs(montant));
        System.out.println("Credité $" +montant +"du compte avec l'ID ="+id);
        return(compte.getSolde());
    }

    public double debiter(int id, double montant) throws PaymentException {
        Compte compte = comptes.get(id - 1);
        if (compte.getSolde() < montant) {
            throw new PaymentException("Solde insuffisant!\tSolde: $"+ compte.getSolde() + "\tMontant: $" + montant);
        }
        compte.setSolde(compte.getSolde() - Math.abs(montant));
        System.out.println("Débie $" +montant +"du compte avec l'ID ="+id);
        return(compte.getSolde());
    }

    public double lireSolde(int id) {
        Compte compte = comptes.get(id - 1);
        System.out.println(" Sold du compte avec l'ID ="+id +":"+ compte.getSolde());
        return compte.getSolde();
    }


}