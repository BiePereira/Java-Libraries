
package Model;

//Imports para pegar data do mês
import Main.FormMain;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//Import para tabela dinâmica
import javax.swing.table.DefaultTableModel;

//Imports para utilizar o banco de dados
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

//Imports para uso do ServerSocket (evitar dois programas ao mesmo tempo)
import java. io.*;
import java.net.*;

/**
 *
 * @author Sparks
 */
public class ConexaoBanco {
	
	//nome do Software
	public static String nomeSW = "Alba SB 2.2";
	
	protected static Connection c = null;
	protected static ServerSocket s;

	public static Date data;
	public static String data_read= "";
    public static String data_save = "";
	public static SimpleDateFormat formatarDateBD;
    //public SimpleDateFormat formatarDateBD2;
	
	public ConexaoBanco(){
		
	}
	
	public static void getSocket(){
        try{
            s = new ServerSocket(9581);
        }
        catch(Exception e){
            FormMain.jOptionPanelMorning.showMessageDialog(null,
                    "Desculpa, apenas uma instância do programa deve estar rodando!",
                    nomeSW, FormMain.jOptionPanelMorning.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void fecharSocket(){
        try{
            s.close();
        }
        catch(Exception e){
            
        }
    }
	
    public static Connection getConnection(){
		//testar se já não há uma instância rodando
        getSocket();
		
		//Trecho de código para buscar a data do mês
        data = new Date(System.currentTimeMillis());  
		formatarDateBD = new SimpleDateFormat("yyyyMMdd");
		data_read = formatarDateBD.format(data);
        formatarDateBD = new SimpleDateFormat("yyyy-MM-dd");
        data_save = formatarDateBD.format(data);
		
		try {
            //String url = "jdbc:mysql://localhost:3306/salaostarbella?user=root&password=root";
            String url = "jdbc:mysql://localhost:3306/albasb2_database(testes)";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println(url);
            c = (Connection) DriverManager.getConnection(url,"root", "");
            System.out.println("Conectado ao banco!");
        } catch (Exception e){ 
        }
		return c;
    }
	
	public static void closeConnection(){
		try{
			c.close();
		}
		catch (Exception e){
			
		}
	}
	
	public static String iniciaValores(){
		String retorno = "novo_dia";
		int resultado;
		String saldo_anterior = "";
		String query;
        try{
            //busca o último livro caixa
			query = "SELECT * FROM lc_livro_caixa " +
					"ORDER BY id_lc_livro_caixa DESC " +
					"LIMIT 1";
			System.out.println(query);
            Statement st = (Statement) c.createStatement();
            ResultSet rs = st.executeQuery(query);
			//caso encontre
            if (rs != null){
				System.out.println("Resultado de querty");
                if(rs.next()){   
					System.out.println("Tem um no sistema");
                    //caso a última data seja a de hoje
                    if (data_save.equals(rs.getString("data"))){
                        System.out.println("Data já estava no banco!");
                        retorno = "dia_existente";
                    }
					//se não, deve-se salvar uma nova data (de hoje)
					else {
						saldo_anterior = rs.getString("saldo");
						System.out.println("Entrou no coiso do saldo anterior");
					};
                }
				//se ainda não houverem livros caixa no sistema (primeira rodagem)
				else{
					System.out.println("Não achou nada");
					try{
						query = "INSERT INTO lc_livro_caixa (data, saldo, total_entrada, total_saida) VALUES "
								+ "('" + data_save + "', 0, 0, 0)";
						System.out.println(query);
						st = (Statement) c.createStatement();
						resultado = st.executeUpdate(query);
							if (resultado == 1){
								System.out.println("PRIMEIROS DADOS SALVOS NO PROGRAMA!");
								retorno = "primeiro_dia";
							}
					} catch (Exception e){            
					}	
				}
			}
		st.close();
		rs.close();
        } catch (Exception e){   
        }
		if(retorno.equals("novo_dia")){
			//System.out.println("O resultado é 0");
			try{
            query = "INSERT INTO lc_livro_caixa (data, saldo, total_entrada, total_saida) values "
                    + "('" + data_save + "', " + saldo_anterior + ", 0, 0)";
            System.out.println(query);
            Statement st = (Statement) c.createStatement();
            resultado = st.executeUpdate(query);
                if (resultado == 1){
                    System.out.println("Dados salvos no banco. (criar box de aviso)");
                }
			st.close();
			} catch (Exception e){            
			}
		}
		return retorno;
	}
	
	public void atualizaMain(){
		
	}
}
