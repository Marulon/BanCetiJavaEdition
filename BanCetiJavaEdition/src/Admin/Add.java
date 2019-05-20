/*
Marlon Giovanni Ibarra Villanueva
 */
package Admin;
import ConnectionPackage.*;
import javax.swing.*;
import Forms.*;
import java.awt.Color;
import java.awt.event.*;

public class Add extends JFrame{
    
    public Add(){
        Start();
    }
    
    protected void btnAddPress() {
        try{
            User user = new User();
            user.AdminAcces = slAdmin.isSelected();
            user.Card = txtCard.getText();
            user.Money = Float.parseFloat(txtMoney.getText());
            user.Name = txtName.getText();
            user.Pin = Integer.parseInt(txtPin.getText());
            DataBase.connection.Save(user);
            frmLogin.x.setVisible(true);
            dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    protected void btnCancelPress() {
        frmLogin.x.setVisible(true);
        dispose();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Inicializacion">
    protected final JTextField txtName= new JTextField ();
    protected final JTextField txtCard= new JTextField ();
    protected final JTextField txtPin= new JTextField ();
    protected final JTextField txtMoney= new JTextField ();
    protected final JCheckBox slAdmin = new JCheckBox();
    protected final JLabel lblName = new JLabel("Nombre: ");
    protected final JLabel lblCard = new JLabel("Numero: ");
    protected final JLabel lblPin = new JLabel("Pin: ");
    protected final JLabel lblMoney = new JLabel("Dinero: ");
    protected final JLabel lblAdmin = new JLabel("Admin NO/SI: ");
    protected final JButton btnAdd = new JButton ("Agregar");
    protected final JButton btnCancel = new JButton ("Cancelar");
    
    protected void Start(){
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setBounds(0,0,320,300);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Agregar");
        setLocationRelativeTo(null);
        
        ///////OBJ
        //txt
        txtName.setBounds(100,17,150,20);
        txtCard.setBounds(100,57,150,20);
        txtPin.setBounds(100,97,150,20);
        txtMoney.setBounds(100,137,150,20);
        slAdmin.setBounds(100,177,30,20);
        //lbl
        lblName.setBounds(10,10,100,30);
        lblCard.setBounds(10,50,100,30);
        lblPin.setBounds(10,90,100,30);
        lblMoney.setBounds(10,130,100,30);
        lblAdmin.setBounds(10,170,100,30);
        //btn
        btnAdd.setBounds(10,225,150,20);
        btnCancel.setBounds(160,225,150,20);
        
        /////ActionListener
        btnAdd.addActionListener(Action);
        btnCancel.addActionListener(Action);
        
        ////Add OBJ
        add(txtCard);
        add(txtMoney);
        add(txtName);
        add(txtPin);
        add(lblAdmin);
        add(lblCard);
        add(lblMoney);
        add(lblName);
        add(lblPin);
        add(slAdmin);
        add(btnAdd);
        add(btnCancel);
    }
    ActionListener Action= (e)->{
            if (e.getSource() == btnAdd){
                btnAddPress();
            }else if (e.getSource() == btnCancel){
                btnCancelPress();
            }
        };
// </editor-fold>
    
}
