/*
Marlon Giovanni Ibarra Villanueva
 */
package Client;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import ConnectionPackage.*;
import Forms.frmLogin;

public class Deposit extends JFrame{
    
    protected User user;
    
    public Deposit (User us){
        user = us;
        Start();
        lblMoney.setText("DEPOSITAR");
    }
   
    protected void btnDepositPress(){
        try{
            float result = user.Money + Float.parseFloat(txtDeposit.getText());
                user.Money = result;
                DataBase.connection.Update(user);
                JOptionPane.showMessageDialog(null,"Deposito realizado");
                btnCancelPress();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    protected void btnCancelPress(){
        frmLogin.x.setVisible(true);
        dispose();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Inicializacion">
    protected final JButton btnDeposit = new JButton("Depositar");
    protected final JButton btnCancel = new JButton("Cancelar");
    protected final JLabel lblMoney = new JLabel("SALDO: ");
    protected final JLabel lbl1 = new JLabel("Ingrese Cantidad: ");
    protected final JTextField txtDeposit = new JTextField();
    
    private void Start (){
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setBounds(0,0,340,180);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Depositar");
        setLocationRelativeTo(null);
        
        ///OBJ
        lblMoney.setBounds(10,10,150,40);
        lblMoney.setFont(new Font("Verdana",Font.BOLD,12));
        lblMoney.setText("SALDO: "+user.Money);
        lbl1.setBounds(10,60,120,30);
        txtDeposit.setBounds(120,67,150,20);
        btnDeposit.setBounds(10,100,150,20);
        btnCancel.setBounds(170,100,150,20);
        ///ActionListener
        btnCancel.addActionListener(action);
        btnDeposit.addActionListener(action);
        ////ADD
        add(lbl1);
        add(lblMoney);
        add(btnCancel);
        add(btnDeposit);
        add(txtDeposit);
    }
    
    ActionListener action = (e)->{
        if (e.getSource() == btnDeposit){
            btnDepositPress();
        }else if (e.getSource() == btnCancel){
            btnCancelPress();
        }
    };
    // </editor-fold>
}
