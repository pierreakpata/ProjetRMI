package serveur;

import gestion.Banque;
import objetsDistants.BanqueImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServeurBanque {

    public static void main(String[] args) {
        try{
            BanqueImpl banque = new BanqueImpl("LCL");
            Banque stub = (Banque) UnicastRemoteObject.exportObject(banque, 0);

            Registry registry = LocateRegistry.createRegistry(13001);
            registry.bind("AccesBanqueDistance:<ecrireIciLeNomDeVotreBanque>", stub);

            System.err.println("Serveur prêt");
        }catch (RemoteException | AlreadyBoundException e){
            e.printStackTrace();
        }

    }
}
