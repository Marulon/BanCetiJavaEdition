/*
 Marlon Giovanni Ibarra Villanueva
 */
package Client;

import ConnectionPackage.*;
import javax.swing.JOptionPane;

public class Withdrawals extends Deposit{
    
    public Withdrawals(User us){
        super(us);
        setTitle("Retirar");
        lbl1.setText("Cantidad a Retirar: ");
        btnDeposit.setText("Retirar");
        lblMoney.setText("SALDO: "+user.Money);
    }
    @Override
    protected void btnDepositPress (){
        try{
            float result = user.Money - Float.parseFloat(txtDeposit.getText());
                if (result>=0){
                    user.Money = result;
                    DataBase.connection.Update(user);
                    JOptionPane.showMessageDialog(null,"Retiro realizado");
                    btnCancelPress();
                }else{
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
