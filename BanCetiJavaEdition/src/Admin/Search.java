/*
Marlon Giovanni Ibarra Villanueva
 */
package Admin;
import Forms.*;
import javax.swing.*;
import java.awt.event.*;
import ConnectionPackage.*;

public class Search extends Add{
    
    private User user;
    
    public Search (int id){
        super();
        StartPlus();
        
        user = DataBase.connection.Search(id);
        txtCard.setText(user.Card);
        txtMoney.setText(user.Money.toString());
        txtName.setText(user.Name);
        txtPin.setText(user.Pin.toString());
        slAdmin.setSelected(user.AdminAcces);
        try{
        btnDelete.addActionListener((e)->{
            DataBase.connection.Delete(id);
            btnCancelPress();
        });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    @Override
    protected void btnAddPress(){
        try{
            user.AdminAcces = slAdmin.isSelected();
            user.Card = txtCard.getText();
            user.Money = Float.parseFloat(txtMoney.getText());
            user.Name = txtName.getText();
            user.Pin = Integer.parseInt(txtPin.getText());
            DataBase.connection.Update(user);
            btnCancelPress();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private final JButton btnDelete = new JButton("Eliminar"); 
    
    private void StartPlus(){
        ///Reajuste
        setTitle("Buscar");
        
        btnAdd.setText("Modificar");
        
        ///new
        btnDelete.setBounds(85,245,150,20);
        
        add(btnDelete);
    }
}
