package gestion;

public class Compte {

    private int id;
    private String nom;
    private String prenom;
    private double solde;

    public Compte(int id, String nom, String prenom, double solde) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getSolde() {
        return solde;
    }

    public boolean depot(double montant){
        if(montant < 10) return false;
        solde+=montant;
        return true;
    }

    public boolean retrait(double montant){
        if((solde - montant) < -100) return false;
        solde-=montant;
        return true;
    }
}
