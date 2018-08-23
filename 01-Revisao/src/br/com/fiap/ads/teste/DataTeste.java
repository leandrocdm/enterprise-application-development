package br.com.fiap.ads.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataTeste {

	public static void main(String[] args) {
		//Criar uma variável de Calendar e atribuir uma data
		Calendar hoje = Calendar.getInstance(); 
		
		//Formatador de data (Date)
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//imprimir a data
		System.out.println(sdf.format(hoje.getTime()));
		
		//Pegar uma string e transformar em data
		String formatura = "12/12/2018";
		
		try {
			Date f = sdf.parse(formatura);
			Calendar f2 = Calendar.getInstance();
			f2.setTime(f);
			System.out.println(f);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Criar uma data especifica
		Calendar carnaval = 
				new GregorianCalendar(2018, Calendar.FEBRUARY, 9);
		//Imprimir a data formatado
		System.out.println(sdf.format(carnaval.getTime()));
		
	}
	
}