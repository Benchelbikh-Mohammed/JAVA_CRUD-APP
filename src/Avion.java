import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Avion {
	
	static String connectionUrl = "jdbc:sqlserver://DESKTOP-CFA3BQT;databaseName=Benchelbikh;integratedSecurity=true;";

	
	
	public static void insertToDb(String nom , String prenom) throws ClassNotFoundException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        

        try (Connection con = DriverManager.getConnection(connectionUrl)) {
        	PreparedStatement stmt = con.prepareStatement("insert into avion (nom, prenom) values (?, ?");
        	
        	stmt.setString(1, nom);
        	stmt.setString(2, prenom);
        	stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void UpdateRowDb(int id ,String nom , String prenom) throws ClassNotFoundException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        

        try (Connection con = DriverManager.getConnection(connectionUrl)) {
        	PreparedStatement stmt = con.prepareStatement("UPDATE avion SET nom = ?, prenom = ? WHERE avionID = ?");
        	
        	stmt.setString(1, nom);
        	stmt.setString(2, prenom);
        	stmt.setInt(1, id);
        	
        	stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void deleteFromDb(int id) throws ClassNotFoundException   {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        

        try (Connection con = DriverManager.getConnection(connectionUrl)) {
        	PreparedStatement st = con.prepareStatement("DELETE FROM avion WHERE avionID = ?");
            st.setInt(1, id);
            st.executeUpdate(); 
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	
	public static void getAvions() throws ClassNotFoundException {
    	
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM avion";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("nom") + " " + rs.getString("model"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
