import java.sql.*;
import java.util.*;

public class App {

    static void register(String uname, String pass) {

        try {
            String query = "INSERT INTO players (username , password) VALUES ('" + uname + "','" + pass + "')";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpggame", "root", "Townhall@8");
            Statement st1 = conn.createStatement();
            st1.executeUpdate(query);
            System.out.println("new user created");
        } catch (Exception e) {
            System.out.println("exception occured either username alreday exixts or ");
            System.out.println(e);
        }

    }

    static void login(String u, String p) {
        try {
            String query = "select password from players where username =" + "'" + u + "'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpggame", "root", "Townhall@8");
            Statement st1 = conn.createStatement();
            ResultSet rs1 = st1.executeQuery(query);
            rs1.next();
            String mypass = rs1.getString(1);

            if (mypass.equals(p)) {
                System.out.println("login successful welcome " + u);
                System.out.println("now you will be taken to character creation zone");
                System.out.println("still working on it");
                // character_creation(u);
            } else {
                System.out.println("wrong password");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void character_creation(String uname) {
        System.out.println("");

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con =
        // DriverManager.getConnection("jdbc:mysql://localhost:3306/rpggame", "root",
        // "Townhall@8")
        // Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery("select * from players");
        // rs.next();
        // String s = rs.getString(2);
        // System.out.print(s);
        System.out.println("Are you a new user or existing user ?");
        System.out.println("1.new user(register)");
        System.out.println("2.Existing user (login)");
        int choice1 = sc.nextInt();
        sc.nextLine();

        if (choice1 == 1) {
            System.out.println("please provide your username and password for registeration");
            System.out.println("username (all usernames are unique):  ");
            String usrname = sc.nextLine();
            System.out.println("");
            System.out.println("password :");
            String pass = sc.nextLine();
            System.out.println("");
            register(usrname, pass);
        } else if (choice1 == 2) {
            System.out.println("please provide your username and password for login");
            System.out.println("username (all usernames are unique):  ");
            String usrname = sc.nextLine();
            System.out.println("");
            System.out.println("password :");
            String pass = sc.nextLine();
            System.out.println("");
            login(usrname, pass);
        } else {
            System.out.println("invalid input");
            return;
        }

    }
}
