import java.util.concurrent.atomic.*;
import java.util.*;
import java.util.Random;

public class Compte {

    private int id;
    private double solde;

    public Compte(int id, double solde) {
        this.id = id;
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