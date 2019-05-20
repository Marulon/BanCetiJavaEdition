/*
Marlon Giovanni Ibarra Villanueva
 */
package Admin;
import Forms.frmLogin;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Indication extends JFrame{
    public Indication (){
        Start();
    }
    
    
    private final JTextField txtIndication = new JTextField ();
    private final JButton btnIndication = new JButton ("Buscar");
    private final JButton btnCancel = new JButton ("Cancelar");
    
    private void Start(){
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setBounds(0,0,180,130);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Buscar");
        setLocationRelativeTo(null);
        
        txtIndication.setBounds(10,10,150,20);
        btnIndication.setBounds(10,40,150,20);
        btnCancel.setBounds(10,70,150,20);
        try{btnIndication.addActionListener((e)->{
            Search x = new Search(Integer.parseInt(txtIndication.getText()));
            dispose();    
            
        });
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        btnCancel.addActionListener((e)->{
            frmLogin.x.setVisible(true);
            dispose();
        });
        add(txtIndication);
        add(btnIndication);
        add(btnCancel);
    }
    
}
