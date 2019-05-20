/*
Marlon Giovanni Ibarra Villanueva
 */
package ConnectionPackage;
import java.sql.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;

public class DataBase {
    public static DataBase connection = new DataBase();
    private static Connection Data;
    private final String Path = "jdbc:sqlite:C:\\BanCeti\\DataBase.db";
    private String Query = "";
    private PreparedStatement Control;
    private Statement Table;
    
    private DataBase(){
    }
    
    public void Start (){
        try {
            File Adress = new File ("C:\\BanCeti\\");
            Adress.mkdir();
            if (Data!=null){
                Data.close();
            }
            Data = DriverManager.getConnection(Path);
            connection.CreateTable();
            Default();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            try {
                    if (Data!=null){
                        Data.close();
                    }
                } catch (SQLException exc) {
                    JOptionPane.showMessageDialog(null, exc);
                }
        }
    }
    
    private void CreateTable (){
        try{
            Query = "CREATE TABLE IF NOT EXISTS Users("
                    + "ID integer PRIMARY KEY AUTOINCREMENT, "
                    + "Card text NOT NULL, "
                    + "Name text NOT NULL, "
                    + "AdminAcces integer NOT NULL, "
                    + "Pin integer NOT NULL, "
                    + "Money real NOT NULL"
                    + ");";
        Table = Data.createStatement();
        Table.execute(Query);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void Default (){
        try{
            User user = Search(1);
            if (user.ID == null || user.Name == null){
                user.AdminAcces = true;
                user.Card = "123456789";
                user.ID = 1;
                user.Money = Float.parseFloat("999");
                user.Name = "Juan";
                user.Pin = 123;
                Save(user);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void Save (User user){
        try{
            Query = "INSERT INTO Users ("
                    + "Card, "
                    + "Name, "
                    + "AdminAcces, "
                    + "Pin, "
                    + "Money"
                    + ") "
                    + "VALUES(?,?,?,?,?)";
            Control = Data.prepareStatement(Query);
            Control.setString(1, user.Card);
            Control.setString(2, user.Name);
            Control.setInt(3, (user.AdminAcces) ? 1 : 0);
            Control.setInt (4, user.Pin);
            Control.setFloat(5, user.Money);
            Control.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public User Search (int id){
        User user = new User();
        try{
            Query = "SELECT * FROM Users WHERE ID = ?";
            Control = Data.prepareStatement(Query);
            Control.setInt(1, id);
            ResultSet result = Control.executeQuery();
            user.AdminAcces = (1==result.getInt("AdminAcces"));
            user.Card = result.getString("Card");
            user.ID = result.getInt("ID");
            user.Money = result.getFloat("Money");
            user.Name = result.getString("Name");
            user.Pin = result.getInt("Pin");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    public ArrayList<User> Search (){
        ArrayList<User> users = new ArrayList<>();
        try{
            Query = "SELECT * FROM Users";
            Control = Data.prepareStatement(Query);
            ResultSet result = Control.executeQuery();
            while (result.next()){
                User user = new User();
                user.AdminAcces = (1==result.getInt("AdminAcces"));
                user.Card = result.getString("Card");
                user.ID = result.getInt("ID");
                user.Money = result.getFloat("Money");
                user.Name = result.getString("Name");
                user.Pin = result.getInt("Pin");
                users.add(user);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return users;
    }
    
    public void Update (User user){
        try{
            Query = "UPDATE Users SET "
                    + "Name = ?, "
                    + "Card = ?, "
                    + "AdminAcces = ?, "
                    + "Pin = ?, "
                    + "Money = ?"
                    + "WHERE ID = ?";
            Control = Data.prepareStatement(Query);
            Control.setString(1, user.Name);
            Control.setString(2, user.Card);
            Control.setInt(3, (user.AdminAcces)? 1:0);
            Control.setInt(4, user.Pin);
            Control.setFloat(5, user.Money);
            Control.setInt(6, user.ID);
            Control.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void Delete (int id){
        try{
            Query = "DELETE FROM Users WHERE ID = ?";
            Control = Data.prepareStatement(Query);
            Control.setInt(1, id);
            Control.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
