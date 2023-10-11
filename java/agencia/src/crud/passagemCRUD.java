package crud;

import java.util.Scanner;
import dao.pedidoDAO;
import dao.ClienteDAO;
import modelos.Cliente;
import modelos.passagem;
import modelos.pedido;
import dao.passagemDAO;

public class passagemCRUD {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			passagemDAO passageDAO = new passagemDAO();
			
			int opcao = 0, id = 0;
			String Destino = "", DataPassagem = "";
			do{
				
				System.out.println("\n ================ SISTEMA GERIR O BANCO DE DADOS DA PASSAGEM ================");
				System.out.println(" 1-CRIAR  2-CONSULTAR  3-ATUALIZAR   4-DELETAR  5-CONSULTAR PELO ID  0-SAIR");
	             opcao = s.nextInt();
	             s.nextLine();
				
	             switch(opcao) {
	             case 1:
	            	 System.out.println("digite o destino");
	            	 Destino = s.nextLine();
	            	 System.out.println("digite a data da passagem");
	            	 DataPassagem = s.nextLine();
	            	 passagemDAO passagem1 = new passageDAO(Destino, DataPassagem);
	            	 passageDAO.create(passagem1);
	            	 break;
	            	 
	            	 
	             case 2:
	            	 for(passagemDAO p : passageDAO.read()) {
	            		System.out.println(p.toString());
	            	 }
	            	 
	            	 break;
	            	 
	            	 
	             case 3:
	            	 System.out.println("digite o Id");
	            	 id = s.nextInt();
	            	 System.out.println("digite o Destino");
	            	 Destino = s.nextLine();
	            	 System.out.println("digite a data passagem");
	            	 DataPassagem = s.nextLine();
	            	 passagemDAO passagem2 = new passageDAO (id, Destino, DataPassagem);
	            	 passageDAO.update(passagem2); 
	            	 break;
	            	 
	            	 
	             case 4:
	            	 System.out.println("digite um id");
	            	 id = s.nextInt();
	            	 s.nextLine();
	            	 passageDAO.delete(id);
	            	 break;
	            	 
	            	 
	             case 5:
	            	 System.out.println("digite um id");
	            	 id = s.nextInt();
	            	 s.nextLine();
	            	 passagemDAO passagem3 = passageDAO.readById (id);
	            	 System.out.println("cliente3.toString");
	            	 break;
	            	 
	            	 
	             default:
	            	 System.out.println("=========== VOCÊ SAI DO BANCO DE DADOS DA AGENCIA.========== ");
	            	 break;
	             }
	             
			}while(opcao != 0);
	        System.out.println(" NÃO FOI POSSIVEL CONCLUIR. POR FAVOR RETORNE DO INICIO");
		}
	


		

	}


