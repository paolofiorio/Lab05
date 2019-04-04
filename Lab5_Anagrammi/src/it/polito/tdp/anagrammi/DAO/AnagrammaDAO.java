package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {

	public boolean isCorrect(String anagramma){

		final String sql = 
				"SELECT nome " +
				"FROM parola " +
				"WHERE nome=?" ;
		
		
		final boolean result;
		
		try {
			Connection conn = ConnectDB.getConnection() ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setString(1, anagramma);
			
			ResultSet res = st.executeQuery() ;
			
			//la parola cercata esiste nel dizionario
			if(res.next()) {
				result = true;
				
			//la parola cercata non esiste nel dizionario
			} else {
				result = false;
			}
			
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false ;
		}
		return result ;
	}
}