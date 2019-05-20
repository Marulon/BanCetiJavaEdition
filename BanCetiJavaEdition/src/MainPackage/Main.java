/*
Marlon Giovanni Ibarra Villanueva
 */
package MainPackage;
import Forms.frmLogin;
import ConnectionPackage.*;

public class Main {
    public static void main (String []args){
        frmLogin app = new frmLogin();
        DataBase.connection.Start();
    }
}
