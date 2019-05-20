/*

 */
package Client;
import ConnectionPackage.*;
import Forms.frmLogin;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Money extends JFrame{
    
    private User user;
    
    public Money (User us){
        user = us;
        Start();
        
    }
    
    private void btnCancelPress(){
        frmLogin.x.setVisible(true);
        dispose();
    }
    
    private void btnDepositPress(){
        Deposit x = new Deposit(user);
        dispose();
    }
    
    private void btnWithdrawalsPress(){
        Withdrawals x = new Withdrawals(user);
        dispose();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Inicializacion">
    private final JLabel lblMoney = new JLabel();
    private final JButton btnCancel = new JButton("Cancelar");
    private final JButton btnDeposit = new JButton("Depositar");
    private final JButton btnWithdrawals = new JButton("Retirar");
    
    private void Start(){
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setBounds(0,0,330,160);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Saldo");
        setLocationRelativeTo(null);
        
        ////OBJ
        lblMoney.setBounds(10,10,200,50);
        lblMoney.setFont(new Font ("Verdana", Font.BOLD, 16));
        lblMoney.setText("SALDO: "+user.Money);
        
        btnDeposit.setBounds(10,60,150,20);
        btnWithdrawals.setBounds(170,60,150,20);
        btnCancel.setBounds(90,80,150,20);
        
        ////ActionListener
        btnCancel.addActionListener(action);
        btnDeposit.addActionListener(action);
        btnWithdrawals.addActionListener(action);
        
        ////ADD
        add(btnCancel);
        add(btnDeposit);
        add(btnWithdrawals);
        add(lblMoney);
    }
    
    ActionListener action = (e)->{
        if (e.getSource() == btnCancel){
            btnCancelPress();
        }else if (e.getSource() == btnDeposit){
            btnDepositPress();
        }else if (e.getSource() == btnWithdrawals){
            btnWithdrawalsPress();
        }
    };
    // </editor-fold>
}
