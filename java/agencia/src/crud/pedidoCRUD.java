package crud;

import java.util.Scanner;
import dao.passagemDAO;
import dao.ClienteDAO;
import modelos.Cliente;
import modelos.passagem;
import modelos.pedido;
import dao.pedidoDAO;

public class pedidoCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PedidoDAO pediDAO = new pedidoDAO();
		
		int opcao = 0, id = 0;
		String numPedido = "", dataPedido = "";
		do{
			
			System.out.println("\n ================ SISTEMA GERIR O BANCO DE DADOS DA PASSAGEM ================");
			System.out.println(" 1-CRIAR  2-CONSULTAR  3-ATUALIZAR   4-DELETAR  5-CONSULTAR PELO ID  0-SAIR");
             opcao = s.nextInt();
             s.nextLine();
			
             switch(opcao) {
             case 1:
            	 System.out.println("digite o numero do pedido");
            	 numPedido = s.nextLine();
            	 System.out.println("digite a data do pedido");
            	 dataPedido = s.nextLine();
            	 PedidoDAO pedido1 = new pediDAO(numPedido, dataPedido);
            	 pediDAO.create(pedido1);
            	 break;
            	 
            	 
             case 2:
            	 for(PedidoDAO p : pediDAO.read()) {
            		System.out.println(p.toString());
            	 }
            	 
            	 break;
            	 
            	 
             case 3:
            	 System.out.println("digite o Id do pedido");
            	 id = s.nextInt();
            	 System.out.println("digite o numero do pedido");
            	 numPedido = s.nextLine();
            	 System.out.println("digite a data do pedido");
            	 dataPedido = s.nextLine();
            	 PedidoDAO pedido2 = new pediDAO (id, numPedido, dataPedido);
            	 pediDAO.update(pedido2); 
            	 break;
            	 
            	 
             case 4:
            	 System.out.println("digite um id do pedido");
            	 id = s.nextInt();
            	 s.nextLine();
            	 pediDAO.delete(id);
            	 break;
            	 
            	 
             case 5:
            	 System.out.println("digite um id do pedido");
            	 id = s.nextInt();
            	 s.nextLine();
            	 PedidoDAO pedido3 = pediDAO.readById (id);
            	 System.out.println("cliente3.toString");
            	 break;
            	 
            	 
             default:
            	 System.out.println("=========== VOCÊ SAI DO BANCO DE DADOS DA AGENCIA ========== ");
            	 break;
             }
             
		}while(opcao != 0);
        System.out.println(" NÃO FOI POSSIVEL CONCLUIR. POR FAVOR RETORNE DO INICIO ");
	}



	

}


