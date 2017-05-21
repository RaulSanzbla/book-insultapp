package org.openshift;
<<<<<<< HEAD
import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.Statement;
=======
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement;
>>>>>>> 5a34d24cf86a5349448626d1cf5eb061654e9b89
public class InsultGenerator { public String generateInsult() {
      String vowels = "AEIOU";
      String article = "an";
      String theInsult = "";
try {
  38 |
Chapter 5: Adding Dependencies and a Database
String databaseURL = "jdbc:postgresql://";
       databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
       databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
       String username = System.getenv("POSTGRESQL_USER");
       String password = System.getenv("PGPASSWORD");
       Connection connection = DriverManager.getConnection(databaseURL, username,
       password);
if (connection != null) {
String SQL = "select a.string AS first, b.string AS second, c.string AS noun from short_adjective a , long_adjective b, noun c ORDER BY random() limit 1"; Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(SQL);
while (rs.next()) {
if (vowels.indexOf(rs.getString("first").charAt(0)) == -1) { article = "a";
         }
         theInsult =  String.format("Thou art %s %s %s %s!", article,
         rs.getString("first"), rs.getString("second"), rs.getString("noun"));
        }
        rs.close();
        connection.close();
}
} catch (Exception e) {
return "Database connection problem!"; }
return theInsult; }
}