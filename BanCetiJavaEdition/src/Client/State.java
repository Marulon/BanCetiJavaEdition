/*
 Marlon Giovanni Ibarra Villanueva
 */
package Client;
import Forms.frmLogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class State extends JFrame{
    public State (){
        Start();
    }
    
    private void btnExpPress(){
        
    }
    private void btnCancelPress(){
        frmLogin.x.setVisible(true);
        dispose();
    }
    
    private final JButton btnExp = new JButton ();
    private final JButton btnCancel = new JButton();
    private final JTextArea txtState = new JTextArea();
    
    private void Start(){
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setBounds(0,0,330,160);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Estado de cuenta");
        setLocationRelativeTo(null);
        
        ////OBJ
        btnExp.setBounds(10,10,150,20);
        btnCancel.setBounds(10,10,150,20);
        txtState.setBounds(10,10,150,20);
        
        ////ActionListener
        btnCancel.addActionListener(action);
        btnExp.addActionListener(action);
        ////ADD
        add(btnExp);
        add(btnCancel);
        add(txtState);
    }
    
    ActionListener action = (e)->{
        if (e.getSource() == btnCancel){
            btnCancelPress();
        }else if (e.getSource() == btnExp){
            btnExpPress();
        }
    };
}
