package Client;

import Client.remise.Remise;
import Client.remise.RemiseVip;

import java.net.SocketTimeoutException;

public class Client {
    public Client(String nom, String tel, double total) {
        this.nom = nom;
        this.tel = tel;
        this.total = total;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private String nom;
    private String tel;
    private double total;

    public void setIremise(Remise iremise) {
        Iremise = iremise;
    }
    public double getRemise(){
        return Iremise.remise(total);
    }

    protected Remise Iremise;




}
