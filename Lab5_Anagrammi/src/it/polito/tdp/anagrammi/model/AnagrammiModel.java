package it.polito.tdp.anagrammi.model;


import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class AnagrammiModel {
	
	AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	
	public Set<String> calcolaAnagrammi(String parola){
		Set<String> anagrammi = new HashSet<String>();
		String parziale = "";
		calcola(parziale,parola,0,anagrammi);
		return anagrammi;
	}
	
	
	
	private void calcola(String parziale,String parola, int passo, Set<String> anagrammi){
		
		//condizione di terminazione
		//se il passo ha raggiunto lunghezza della parola 
		// ho ottenuto la parola intera che è anagramma di se stessa
		//la aggiungo al Set ed esco con return
		if(passo == parola.length()){
			anagrammi.add(parziale);
			return;
		}
		//se il passo non ha ancora raggiunto la lunghezza della parola
		for(int i = 0; i< parola.length(); i++){
			//ciclo le lettere della parola finchè la lunghezza di parziale è pari
			//alla lunghezza della parola intera-1
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))){
				//incrementa parziale di una lettera
				parziale += parola.charAt(i);
				//passo successivo
				calcola(parziale, parola, passo + 1,anagrammi);
				//aggiornamento di parziale e backtracking 
				parziale = parziale.substring(0,parziale.length()-1);
			}
		}
			
	}
	//contatore delle lettere all'interno della parola
	private static int charCounter(String s, char c){
		int count = 0;
	    for (int i=0; i < s.length(); i++)
	    {
	        if (s.charAt(i) == c)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);
	}
	
	
}