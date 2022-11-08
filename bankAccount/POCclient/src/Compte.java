import java.util.concurrent.atomic.*;
import java.util.*;
import java.util.Random;

public class Compte {

    private int id;
    private double solde;

    public Compte(double solde) {
        Random random = new Random();
        int upperBound = 10000;
        this.id = random.nextInt(upperBound);
        this.solde = solde;
    }

    public void setSolde(double newSolde) {
        this.solde = newSolde;
    }

    public double getSolde() {
        return this.solde;
    }

    public void printAccountInfo() {
        System.out.println("Account ID: " + this.id + "\tSolde: " + this.solde);
    }

}
