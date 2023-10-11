package crud;
import java.util.Scanner;
import dao.passagemDAO;
import dao.pedidoDAO;
import dao.ClienteDAO;
import modelos.Cliente;
import modelos.passagem;
import modelos.pedido;
public class ClienteCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ClienteDAO genteDAO = new ClienteDAO();
		
		int opcao = 0, id = 0;
		String nome = "", contato = "";
		do{
			
			System.out.println("\n ================ SISTEMA GERIR O BANCO DE DADOS DO CLIENTE ================");
			System.out.println(" 1-CRIAR  2-CONSULTAR  3-ATUALIZAR   4-DELETAR  5-CONSULTAR PELO ID  0-SAIR");
             opcao = s.nextInt();
             s.nextLine();
			
             switch(opcao) {
             case 1:
            	 System.out.println("digite o nome");
            	 nome = s.nextLine();
            	 System.out.println("digite o contato");
            	 contato = s.nextLine();
            	 ClienteDAO cliente1 = new genteDAO(nome, contato);
            	 genteDAO.create(cliente1);
            	 break;
            	 
            	 
             case 2:
            	 for(ClienteDAO c : genteDAO.read()) {
            		System.out.println(c.toString());
            	 }
            	 
            	 break;
            	 
            	 
             case 3:
            	 System.out.println("digite o Id");
            	 id = s.nextInt();
            	 System.out.println("digite o nome");
            	 nome = s.nextLine();
            	 System.out.println("digite o contato");
            	 contato = s.nextLine();
            	 ClienteDAO cliente2 = new genteDAO (id, nome, contato);
            	 genteDAO.update(cliente2);
            	 break;
            	 
            	 
             case 4:
            	 System.out.println("digite um id");
            	 id = s.nextInt();
            	 s.nextLine();
            	 genteDAO.delete(id);
            	 break;
            	 
            	 
             case 5:
            	 System.out.println("digite um id");
            	 id = s.nextInt();
            	 s.nextLine();
            	 Cliente cliente3 = genteDAO.readById (id);
            	 System.out.println("cliente3.toString");
            	 break;
            	 
            	 
             default:
            	 System.out.println("=========== VOCÊ SAI DO BANCO DA AGENCIA.========== ");
            	 break;
             }
             
		}while(opcao != 0);
        System.out.println(" NÃO FOI POSSIVEL CONCLUIR. POR FAVOR RETORNE DO INICIO");
	}
}

