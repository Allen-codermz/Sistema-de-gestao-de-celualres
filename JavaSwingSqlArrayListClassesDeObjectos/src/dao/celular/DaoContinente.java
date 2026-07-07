package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.celular.Conexao;
import model.celular.Continente;

public class DaoContinente {

	public static ArrayList<Continente> listaDecontinentes() throws SQLException, ClassNotFoundException{
		ArrayList<Continente> continentes = new ArrayList<Continente>();
        PreparedStatement stmt = null;
        Connection con = Conexao.conectar();
        stmt=con.prepareStatement("SELECT * FROM Continente");  
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){ 
	        int codigoContinente=rs.getInt(1);
	        String Continente=rs.getString(2);
	       continentes.add(new Continente(codigoContinente, Continente));
        }
        con.close(); 
      return continentes;
  }
	
}
