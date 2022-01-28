package objetsDistants;

import gestion.Banque;
import gestion.Compte;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class BanqueImpl implements Banque{

    private String nomBanque;
    private List<Compte> comptes;
    private int idCompte;

    public BanqueImpl(String nomBanque){
        this.nomBanque = nomBanque;
        comptes = new ArrayList<>();
        idCompte = 0;
    }

    @Override
    public int creerCompte(String nom, String prenom, double soldeInitial) throws RemoteException {
        idCompte++;
        comptes.add(new Compte(idCompte, nom, prenom, soldeInitial));
        return idCompte;
    }

    @Override
    public Boolean depot(int idCompte, double montant) throws RemoteException {
        Compte cpte = getCompte(idCompte);
        if(cpte != null){
            cpte.depot(montant);
            return true;
        }
        return false;
    }

    @Override
    public Boolean retrait(int idCompte, double montant) throws RemoteException {
        Compte cpte = getCompte(idCompte);
        if(cpte != null){
            cpte.retrait(montant);
        }
        return false;
    }

    @Override
    public Boolean virement(int idCompte, int idCompte2, double montant) throws RemoteException {
        Compte cpte1 = getCompte(idCompte);
        Compte cpte2 = getCompte(idCompte);
        if(cpte1 !=null && cpte2 != null){
            cpte1.retrait(montant);
            cpte2.depot(montant);
            return true;
        }
        return false;
    }

    @Override
    public double getSolde(int idCompte) throws RemoteException {
        Compte cpte = getCompte(idCompte);
        if(cpte != null) return cpte.getSolde();
        return -200;
    }


    public Compte getCompte(int id){
        for(Compte cpte: comptes){
            if(cpte.getId() == id){
                return cpte;
            }
        }
        return null;
    }
}
