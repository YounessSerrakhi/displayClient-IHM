package Vue;

import Model.Client;
import Controller.DAOClient;
import Model.DBcontext;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {

    Container container=getContentPane();
    JLabel userLabel=new JLabel("NOM");
    JLabel totalLabel=new JLabel("Total");
    JTextField userTextField=new JTextField();
    JTextField totalField=new JTextField();
    JButton nextButton=new JButton("Suivant");
    JButton resetButton=new JButton("RESET");
    JButton displayButton=new JButton("afficher");
    JButton addButton=new JButton("ajouter");
    JButton removeButton=new JButton("supprimer");
    JButton previousButton=new JButton("précedent");
    //JCheckBox showPassword=new JCheckBox("Show Password");
    int id=1;

    Form()
    {
        //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    public void setLocationAndSize()
    {
        //Setting location and Size of each component using setBounds() method.
        userLabel.setBounds(50,150,100,30);
        totalLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        totalField.setBounds(150,220,150,30);
        //showPassword.setBounds(150,250,150,30);
        displayButton.setBounds(50,300,100,30);
        nextButton.setBounds(150,300,100,30);
        previousButton.setBounds(250,300,100,30);
        resetButton.setBounds(350,300,100,30);
        addButton.setBounds(125,400,100,30);
        removeButton.setBounds(275,400,100,30);


    }
    public void addComponentsToContainer()
    {
        //Adding each component to the Container
        container.add(userLabel);
        container.add(totalLabel);
        container.add(userTextField);
        container.add(totalField);
        //container.add(showPassword);
        container.add(displayButton);
        container.add(nextButton);
        container.add(previousButton);
        container.add(resetButton);
        container.add(addButton);
        container.add(removeButton);
    }

    public void addActionEvent()
    {
        //adding Action listener to components
        nextButton.addActionListener(this);
        resetButton.addActionListener(this);
        displayButton.addActionListener(this);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        previousButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==displayButton){
            DAOClient DC = new DAOClient();
            Client c = DC.getFirst();
            userTextField.setText(c.getNom());
            totalField.setText(Integer.toString(c.getTotal()));
        }
        if(e.getSource()==nextButton) {
            Client cl;
            do {
                id++;
                DAOClient DC = new DAOClient();
                cl = DC.getClient(id);
                if (cl.getId()==0) {
                    JOptionPane.showMessageDialog(this, "this is the last client\n tap previous or reset to return");
                }
                userTextField.setText(cl.getNom());
                totalField.setText(Integer.toString(cl.getTotal()));
            } while (cl.getId() == 99999999);
        }
        if(e.getSource()==previousButton) {
            Client cl;
            do {
                id--;
                DAOClient DC = new DAOClient();
                cl = DC.getClient(id);
                if (cl.getId()==0) {
                    JOptionPane.showMessageDialog(this, "this is the first client");
                }
                //id=cl.getId();
                userTextField.setText(cl.getNom());
                totalField.setText(Integer.toString(cl.getTotal()));
            } while (cl.getId() == 99999999);
        }
        if(e.getSource()==resetButton){
            id=1;
            DAOClient DC = new DAOClient();
            Client cl = DC.getFirst();
            userTextField.setText(cl.getNom());
            totalField.setText(Integer.toString(cl.getTotal()));
        }
        if(e.getSource()==addButton){
            DBcontext DB = new DBcontext();
            try {
                DB.addClient(userTextField.getText(),Integer.parseInt(totalField.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "added successfly");
        }
        if(e.getSource()==removeButton){
            DBcontext DB = new DBcontext();
            try {
                DB.deleteClient(id);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "removed successfly");
        }
    }
}

class Login {
    public static void main(String[] a){
        Form frame=new Form();
        frame.setTitle("Form Client");
        frame.setVisible(true);
        frame.setBounds(10,10,500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}