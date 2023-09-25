/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Sparks
 */
public class Monetario {
	
	//Funções de troca de sinal das casas decimais
	//*--------------------------------------------------------------------------------------------------------*//
	
	//recebe uma String com um valor numérico (0,00) e retorna uma String com valor numérico (0.00)
	public static String CommaToDot(String valor){
		valor = conta_ocorrencias(',', valor);
		valor = valor.replace(",",".");
		return valor;
	} 
	
	//recebe uma String com um valor numérico (0.00) e retorna uma String com valor numérico (0,00)
	public static String DotToComma(String valor){
		valor = conta_ocorrencias('.', valor);
		valor = valor.replace(".",",");
		return valor;
	}
	
	//recebe o sinal de casas decimais e adiciona o sinal mais o valor de centavos (00) caso o número seja inteiro
	public static String conta_ocorrencias(char caracter ,String valor){     
        int count_caractere = 0;
		int count_after_caractere = 0;
		int i;
        
		for (i = 0;i<valor.length();i++){     
            if(count_caractere == 1){
				count_after_caractere++;
			}
			if(valor.charAt(i)==caracter){     
                count_caractere++;    
            }
        }
		
		//se não houver o caractere
		if(count_caractere == 0){
			valor = valor + caracter + "00";
		}
		
		//se houver menos de 2 dígitos após o caractere
		else if(count_caractere > 0 && count_after_caractere < 2){
			for(i = count_after_caractere; i < 2; i++){
				valor = valor + "0";
			}
		}
		
		//se o caractere era o último caractere do valor (Ex.: 40,)
		/*else if(valor.charAt(valor.length()-1) == caracter){
			valor = valor + "00";
		}*/
		
        return valor;     
    } 
	
	//Recebe o valor e a porcentagem desejada do mesmo. Retorna x% do valor
	public static String getPorcentagem(String valor, String porcentagem){
		BigDecimal valor_big = new BigDecimal(valor);			
		BigDecimal multiplicacao = new BigDecimal(porcentagem);
		BigDecimal divisao = new BigDecimal("100");

		valor_big = valor_big.multiply(multiplicacao, MathContext.DECIMAL128);
		valor_big = valor_big.divide(divisao, MathContext.DECIMAL128);
		
		//arredonda o valor para dois dígitos
		valor_big = valor_big.setScale(2,RoundingMode.HALF_UP);
		
		valor = valor_big + "";
		return valor;
	}
	
	//Recebe o valor e o total. Retorna a porcentagem do valor em relação ao total
	public static String getPorcentoDe(String valor, String total){
		BigDecimal valor_big = new BigDecimal(valor);
		BigDecimal total_big = new BigDecimal(total);
		BigDecimal multiplicacao = new BigDecimal("100");
		
		valor_big = valor_big.multiply(multiplicacao, MathContext.DECIMAL128);
		valor_big = valor_big.divide(total_big, MathContext.DECIMAL128);
		
		//arredonda o valor para dois dígitos
		valor_big = valor_big.setScale(2,RoundingMode.HALF_UP);
		
		valor = valor_big + "";
		return valor;
	}
}
