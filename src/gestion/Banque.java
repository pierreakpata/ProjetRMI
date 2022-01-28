package gestion;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banque extends Remote {

    public int creerCompte(String nom, String prenom, double soldeInitial) throws RemoteException;
    public Boolean depot(int idCompte, double montant) throws RemoteException;
    public Boolean retrait(int idCompte, double montant) throws RemoteException;
    public Boolean virement(int idCompte, int idCompte2, double montant) throws RemoteException;
    public double getSolde(int idCompte) throws RemoteException;
}
