package client;

import gestion.Banque;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {
        Registry registry;
        try{
            registry = LocateRegistry.getRegistry(13001);
            Banque stub = (Banque) registry.lookup("AccesBanqueDistance:<ecrireIciLeNomDeVotreBanque>");

            int id = stub.creerCompte("AKPATA", "Kodjo", 3000);
            System.out.println("Compte "+id+ " créer avec succès !");
            System.out.println("Solde du compte " +id+ " est: "+stub.getSolde(id));
        }catch (RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
}
