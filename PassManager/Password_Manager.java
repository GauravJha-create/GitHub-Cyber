import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;

class Password_Manager{
    public static String JDBC_URL="jdbc:mysql://localhost:3306/";
    public static String user="root";
    public static String password="jhagaurav7500";
    public static String DBname="Password_Manager";
    public static String tName="Passwords";

    public static String email="", name="", pass="";

    static void information(){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter your e-mail: ");
        email=ob.nextLine();

        System.out.println("Enter your Name: ");
        name=ob.nextLine();

        System.out.println("Enter your Password: ");
        pass=ob.nextLine();
    }
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
            try(Connection con=DriverManager.getConnection(JDBC_URL, user, password);
            Statement stat=con.createStatement()) {

                DatabaseMetaData dbm=con.getMetaData();
                ResultSet resultSet = dbm.getCatalogs();
                
                boolean databaseExists = false;

                while (resultSet.next()) {
                    String dbName = resultSet.getString("TABLE_CAT");
                    if (dbName.equalsIgnoreCase(DBname)) {
                        databaseExists = true;
                        break;
                    }
                }
                
                if(databaseExists){
                    System.out.println("DataBase exists. Using "+DBname);
                }
                else{
                    String createDB="CREATE DATABASE " + DBname;
                    stat.executeUpdate(createDB);
                    System.out.println("New Database Created- PASSWORD_MANAGER");
                }

                String useDB="USE "+DBname;
                stat.executeUpdate(useDB);

                String createTable="CREATE TABLE IF NOT EXISTS "+tName+"(ID INT auto_increment Primary Key, NAME varchar(50), EMAIL varchar(100), PASSWORD varchar(50))";
                stat.executeUpdate(createTable);
                System.out.println("creating table...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("TABLE (PASSWORDS) CREATED SUCCESSFULLY");

                char ch;

                do{
                    information();

                    String insData="INSERT INTO "+tName+"(NAME, EMAIL, PASSWORD) VALUES('"+ name +"', '"+ email +"', '"+ pass+ "');";
                    stat.executeUpdate(insData);
                    
                    System.out.println("Enter 'Y' to enter another data");
                    ch=ob.next().charAt(0);
                }while(ch=='Y' || ch=='y');
            }

            catch(SQLException e){
                e.printStackTrace();
            }
        }

    }