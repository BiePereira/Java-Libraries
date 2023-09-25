/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

//Imports para pegar data do mês
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Sparks
 */
public class Calendario {
	
	//Funções de cálculo de datas
	//*--------------------------------------------------------------------------------------------------------*//
	
	//Retorna a data atual dd/MM/yyyy
	public static String todayBars(){
		String data = "";
		try{
			Date date_data = new Date(System.currentTimeMillis()); 
			SimpleDateFormat novo = new SimpleDateFormat("dd/MM/yyyy");
			data = novo.format(date_data);
		}
		catch(Exception e){}
		
		return data;
	}
	
	//Retorna a data atual yyyy-MM-dd
	public static String todayTraces(){
		String data = "";
		try{
			Date date_data = new Date(System.currentTimeMillis()); 
			SimpleDateFormat novo = new SimpleDateFormat("yyyy-MM-dd");
			data = novo.format(date_data);
		}
		catch(Exception e){}
		
		return data;
	}
	
	//Retorna a data atual yyyyMMdd
	public static String todayAllTogheter(){
		String data = "";
		try{
			Date date_data = new Date(System.currentTimeMillis()); 
			SimpleDateFormat novo = new SimpleDateFormat("yyyyMMdd");
			data = novo.format(date_data);
		}
		catch(Exception e){}
		
		return data;
	}
	
	//Retorna a data de "amanhã" dd/MM/yyyy
	public static String nextDayBars(){
		String data = "";
		try{
			Calendar calendar = Calendar.getInstance();
			Date date_data = new Date(System.currentTimeMillis());
			calendar.setTime(date_data);
			calendar.add(Calendar.DAY_OF_YEAR, +1);
			
			SimpleDateFormat novo = new SimpleDateFormat("dd/MM/yyyy");
			data = novo.format(calendar.getTime());
		}
		catch(Exception e){}
		
		return data;
		
	}
	
	//Retorna a data de "amanhã" yyyy-MM-dd
	public static String nextDayTraces(){
		String data = "";
		try{
			Calendar calendar = Calendar.getInstance();
			Date date_data = new Date(System.currentTimeMillis());
			calendar.setTime(date_data);
			calendar.add(Calendar.DAY_OF_YEAR, +1);
			
			SimpleDateFormat novo = new SimpleDateFormat("yyyy-MM-dd");
			data = novo.format(calendar.getTime());
		}
		catch(Exception e){}
		
		return data;
		
	}
	
	//Retorna a mesma data do próximo mês dd/MM/yyyy
	public static String nextMonthBars(){
		String data = "";
		try{
			Calendar calendar = Calendar.getInstance(); 
			Date date_data = new Date(System.currentTimeMillis());
			calendar.setTime(date_data);
			calendar.add(Calendar.MONTH, +1);
			
			SimpleDateFormat novo = new SimpleDateFormat("dd/MM/yyyy");
			data = novo.format(calendar.getTime());
		}
		catch(Exception e){}
		
		return data;
		
	}
	
	//Retorna a mesma data do próximo mês yyyy-MM-dd
	public static String nextMonthTraces(){
		String data = "";
		try{
			Calendar calendar = Calendar.getInstance(); 
			Date date_data = new Date(System.currentTimeMillis());
			calendar.setTime(date_data);
			calendar.add(Calendar.MONTH, +1);
			
			SimpleDateFormat novo = new SimpleDateFormat("yyyy-MM-dd");
			data = novo.format(calendar.getTime());
		}
		catch(Exception e){}
		
		return data;
		
	}
	
	//Funções de diminuição de data
	//*--------------------------------------------------------------------------------------------------------*//
	
	//Recebe a data dd/MM/yyyy e transforma em MM/yyyy
	public static String BarsGetMonthYearBars(String data){
		try{
			SimpleDateFormat antigo = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat novo = new SimpleDateFormat("MM/yyyy");
			Date date_data = antigo.parse(data);
			data = novo.format(date_data);
		}catch(Exception e){}
		
		return data;
	}
	
	//Recebe a data dd/MM/yyyy e retorna o mês
	public static String BarsGetMonth(String data){
		try{
			SimpleDateFormat antigo = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat novo = new SimpleDateFormat("MM");
			Date date_data = antigo.parse(data);
			data = novo.format(date_data);
		}catch(Exception e){}
		
		return data;
	}
	
	//Recebe a data dd/MM/yyyy e retorna o ano
	public static String BarsGetYear(String data){
		try{
			SimpleDateFormat antigo = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat novo = new SimpleDateFormat("yyyy");
			Date date_data = antigo.parse(data);
			data = novo.format(date_data);
		}catch(Exception e){}
		
		return data;
	}
	
	
	//Funções de troca de formatos de data
	//*--------------------------------------------------------------------------------------------------------*//
	
	
	//Recebe a data yyyy-MM-dd e transforma em dd/MM/yyyy
	public static String tracesToBars(String data){
		try{
			SimpleDateFormat antigo = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat novo = new SimpleDateFormat("dd/MM/yyyy");
			Date date_data = antigo.parse(data);
			data = novo.format(date_data);
		}catch(Exception e){}
		
		return data;
	}
	
	//Recebe a data dd/MM/yyyy e transforma em MM-dd-yyyy
	public static String barsToTraces(String data){
		try{
			SimpleDateFormat antigo = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat novo = new SimpleDateFormat("yyyy-MM-dd");
			Date date_data = antigo.parse(data);
			data = novo.format(date_data);
		}catch(Exception e){}
		
		return data;
	}
	
	//Recebe a data yyyyMMdd e transforma em dd/MM/yyyy
	public static String nullsToBars(String data){
		try{
			SimpleDateFormat antigo = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat novo = new SimpleDateFormat("dd/MM/yyyy");
			Date date_data = antigo.parse(data);
			data = novo.format(date_data);
		}catch(Exception e){}
		
		return data;
	}
	
	//Recebe a data dd/MM/yyyy e transforma em yyyyMMdd
	public static String barsToNulls(String data){
		try{
			SimpleDateFormat antigo = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat novo = new SimpleDateFormat("yyyyMMdd");
			Date date_data = antigo.parse(data);
			data = novo.format(date_data);
		}catch(Exception e){}
		
		return data;
	}
}
