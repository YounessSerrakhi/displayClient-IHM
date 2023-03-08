package Controller;

import Model.Client;
import Model.ClientComparator;
import Model.DBcontext;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DAOClient {




    ClientComparator cmp=new ClientComparator();
    public DAOClient() {
    }
//with files
    /*public Client getFirst() {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asus\\Desktop\\file.txt"))) {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] data = line.split(",");

        return  new Client(Integer.parseInt(data[0]), data[1],Integer.parseInt(data[2]));
    }*/
    public Client getFirst() {
        DBcontext DB = new DBcontext();
        try {
            return  DB.getClients().get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public Client getClient(int id) {
        ArrayList<Client> list = this.getList();
        if (list.get(list.size()-1).getId() < id) return new Client(0,"Finish",0);
        for (Client elem:list ) {
            if(elem.getId()==id)return  elem;
        }
        return new Client(99999999,"Finish",0);
    }*/
    public Client getClient(int id) {
        DBcontext DB = new DBcontext();
        ArrayList<Client> list = null;
        try {
            list = DB.getClients();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (list.get(list.size()-1).getId() < id && list.get(0).getId() > id) return new Client(0,"Finish",0);
        for (Client elem:list ) {
            if(elem.getId()==id)return elem;
        }
        return new Client(99999999,"Finish",0);

    }



    /*public ArrayList<Client> getList() {
        String line = null;
        ArrayList<Client> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asus\\Desktop\\file.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                Client c = new Client(Integer.parseInt(fields[0]), fields[1],Integer.parseInt(fields[2]));
                data.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(data,this.cmp);
        return data;
    }*/

    /*public void delete(int id) {
        ArrayList<Client> data = getList();
        Iterator<Client> iterator = data.iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getId() == id) {
                iterator.remove();
            }
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\asus\\Desktop\\file.txt"))) {
            for (Client elem : data) {
                br.write(elem.getId() + "," + elem.getNom() + "," + elem.getTotal() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

/*
    public void add(String nom,int total){
        ArrayList<Client> data = getList();
        data.add(new Client(data.get(data.size() - 1).getId()+1,nom,total));
        Collections.sort(data,cmp);
        try (BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\asus\\Desktop\\file.txt"))) {
            String line;
            for (Client elem:data) {
                br.write(elem.getId()+","+ elem.getNom()+","+ elem.getTotal()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


}
