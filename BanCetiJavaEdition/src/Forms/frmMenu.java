/*
Marlon Giovanni Ibarra Villanueva
 */
package Forms;
import ConnectionPackage.User;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import Admin.*;
import Client.*;

public class frmMenu extends JFrame{
    
    private final User user;
    
    public frmMenu (User us){
        user = us;
        Start();
    }
    
    private void btnAddPress(){
        Add x = new Add();
        setVisible(false);
    }
    
    private void btnSearchPress(){
        Indication x = new Indication();
        setVisible(false);
    }
    
    private void btnStatePress(){
        State x = new State();
        setVisible(false);
    }
    
    private void btnMoneyPress(){
        Money x = new Money(user);
        setVisible(false);
    }
    
    private void btnDepositPress(){
        Deposit x = new Deposit(user);
        setVisible(false);
    }
    
    private void btnWithdrawalsPress(){
        Withdrawals x = new Withdrawals(user);
        setVisible(false);
    }
    
    private void btnExitPress(){
        frmLogin x = new frmLogin();
        dispose();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Inicializacion">
    private final JButton btnAdd = new JButton ("Agregar");
    private final JButton btnSearch = new JButton ("Buscar");
    private final JButton btnState = new JButton ("Estado de cuenta");
    private final JButton btnMoney = new JButton ("Saldo");
    private final JButton btnDeposit = new JButton ("Depositar");
    private final JButton btnWithdrawals = new JButton ("Retirar");
    private final JButton btnExit = new JButton ("Cerrar Sesion");
    private final JLabel lblName = new JLabel ("Name");
    private final JLabel image = new JLabel (new ImageIcon (
            new ImageIcon("Images/LogoBanCeti.jpg").getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH)
    ));
    
    private void Start (){
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setBounds(0,0,330,240);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu");
        setLocationRelativeTo(null);
        
        
        /////OBJ
        //admin
        btnAdd.setBounds(10,150,150,30);
        btnSearch.setBounds(170,150,150,30);
        //Client
        btnDeposit.setBounds(10,140,150,20);
        btnWithdrawals.setBounds(170,140,150,20);
        btnMoney.setBounds(10,170,150,20);
        btnState.setBounds(170,170,150,20);
        //Everybody
        image.setBounds(10,10,90,120);
        lblName.setBounds(120,10,200,30);
        lblName.setText("Bienvenido "+user.Name);
        btnExit.setBounds(120,60,150,20);
        
        /////ActionListener
        btnAdd.addActionListener(Action);
        btnSearch.addActionListener(Action);
        btnState.addActionListener(Action);
        btnMoney.addActionListener(Action);
        btnDeposit.addActionListener(Action);
        btnWithdrawals.addActionListener(Action);
        btnExit.addActionListener(Action);
        
        //ADD OBJ
        if (user.AdminAcces==true){
            add(btnAdd);
            add(btnSearch);
        }else{
            add(btnState);
            add(btnMoney);
            add(btnDeposit);
            add(btnWithdrawals);
        }
        add(lblName);
        add(image);
        add(btnExit);
    }
    
    ActionListener Action= (e)->{
            if (e.getSource() == btnAdd){
                btnAddPress();
            }else if (e.getSource() == btnDeposit){
                btnDepositPress();
            }else if (e.getSource() == btnMoney){
                btnMoneyPress();
            }else if (e.getSource() == btnSearch){
                btnSearchPress();
            }else if (e.getSource() == btnState){
                btnStatePress();
            }else if (e.getSource() == btnWithdrawals){
                btnWithdrawalsPress();
            }else if (e.getSource() == btnExit){
                btnExitPress();
            }
        };
    
}
// </editor-fold>