/*
Marlon Giovanni Ibarra Villanueva
 */
package Forms;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import ConnectionPackage.*;
import java.util.ArrayList;

public class frmLogin extends JFrame{
    
    public static frmMenu x;
    
    public frmLogin (){
        Start();
    }
    
    public void btnLoginPress(){
        ArrayList<User> users = DataBase.connection.Search();
        for (User user:users){
            if (user.Card.equals(txtUser.getText())){
                if (user.Pin == Integer.parseInt(txtPassword.getText())){
                    x = new frmMenu (user);
                    dispose();
                }
            }
        }
    }
    
    
// <editor-fold defaultstate="collapsed" desc="Inicializacion">
    private final JTextField txtUser = new JTextField ();
    private final JTextField txtPassword = new JTextField ();
    private final JButton btnLogin = new JButton ("LOGIN");
    private final JLabel l1 = new JLabel ("Usuario: ");
    private final JLabel l2 = new JLabel ("Contraseña: ");
    private final JLabel image = new JLabel (new ImageIcon
        ((new ImageIcon("Images/LogoBanCeti.jpg"))
                .getImage()
                .getScaledInstance(200, 270, Image.SCALE_SMOOTH)
        ));
    
    private void Start (){
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setBounds(0,0,240,480);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
        setLocationRelativeTo(null);
        
        //OBJ
        image.setBounds(10,10,200,270);
        l1.setBounds(10,290,150,30);
        txtUser.setBounds(10,320,150,20);
        l2.setBounds(10,340,150,30);
        txtPassword.setBounds(10,370,150,20);
        btnLogin.setBounds(10,410,150,20);
        btnLogin.addActionListener(Action);
        
        //ADD OBJ
        add(txtPassword);
        add(txtUser);
        add(btnLogin);
        add(l1);
        add(l2);
        add(image);
    }
    ActionListener Action= (e)->{
            if (e.getSource() == btnLogin){
                btnLoginPress();
            }
        };

    
}
// </editor-fold>