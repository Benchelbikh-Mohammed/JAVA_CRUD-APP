import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pilote {
	
	static String connectionUrl = "jdbc:sqlserver://DESKTOP-CFA3BQT;databaseName=Benchelbikh;integratedSecurity=true;";

	
	
	public static void insertToDb(String nom , String prenom) throws ClassNotFoundException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        

        try (Connection con = DriverManager.getConnection(connectionUrl)) {
        	PreparedStatement stmt = con.prepareStatement("insert into pilote (nom, prenom) values (?, ?)");
        	
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
        	PreparedStatement stmt = con.prepareStatement("UPDATE pilote SET nom = ?, prenom = ? WHERE piloteID = ?");
        	
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
        	PreparedStatement st = con.prepareStatement("DELETE FROM pilote WHERE piloteID = ?");
            st.setInt(1, id);
            st.executeUpdate(); 
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	public static String[] getOneRow(int id) throws ClassNotFoundException   {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
		String[] res = new String[2];

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT nom , prenom FROM pilote where piloteID = " + id + "" ;
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                res[0] = rs.getString("Nom");
                res[1] = rs.getString("Prenom");
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		return res;
		
	}
	
	
	public static void getPilotes() throws ClassNotFoundException {
    	
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM pilote";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("Nom") + " " + rs.getString("Prenom"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
