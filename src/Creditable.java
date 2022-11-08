import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Creditable extends Remote {
    public double debiter(int id, double montant) throws RemoteException, PaymentException;
    public double crediter(int id, double montant) throws RemoteException;
    public double lireSolde(int id) throws RemoteException;
}