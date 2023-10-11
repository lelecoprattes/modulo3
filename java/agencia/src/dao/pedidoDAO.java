package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.pedido;
import connection.ConnectionMySQL;

public class pedidoDAO {
	public void create(Pedidos pedi) {

		String sql ="insert into pedido (numPedido, dataPedido) values (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
		   conn = ConnectionMySQL.createConnectionMySQL();
				
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, pedi.getNumPedido());
		pstm.setString(2, pedi.getDataPedido());
		
		pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	}

		//read consulta
		public List<Pedidos> read(){
			List<Pedidos> clientes = new ArrayList<Pedidos>();
			
		    String sql = "select * from pedido";
		    
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				while (rset.next()){
					Pedidos pedi = new Pedidos();
					
					pedi.setId(rset.getInt("id_pedido"));
					pedi.setDataPedido(rset.getString("DataPedido"));
					
					pedi.add(pedi);
				}
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
			return  pedi;
		}
		
		//update atualizar
		public void update(Pedidos pedi) {
		
			 String sql = "update pedido set numPedido= ?, dataPedido = ? where id_pedido = ?";
			    
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {	
					
					conn = ConnectionMySQL.createConnectionMySQL();		
					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, pedi.getNumPedido());
					pstm.setString(2, pedi.getDataPedido());
					pstm.setInt(1, pedi.getId());
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		}
		//delete
			public void delete(int id) {
				 String sql = "delete from cliente where id_pedido = ?";
				 
					Connection conn = null;
					PreparedStatement pstm = null;
					ResultSet rset = null;
					
					try {	
						
						conn = ConnectionMySQL.createConnectionMySQL();
						pstm = conn.prepareStatement(sql);
						
						pstm.setInt(1, id);
						pstm.execute();
							
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
			}	
			
		//readById 
			public Pedidos readById(int id) {
				Pedidos pedi = new Pedidos();
				
				 String sql = "select* from cliente where id_pedido = ?";
				 
					Connection conn = null;
					PreparedStatement pstm = null;
					ResultSet rset = null;
					
					try {	
						
						conn = ConnectionMySQL.createConnectionMySQL();
						pstm = conn.prepareStatement(sql);
						
						pstm.setInt(1, id);
						rset =pstm.executeQuery();
						rset.next();
						pedi.setId(rset.getInt("id_pedido"));
						pedi.setNumPedido(rset.getString("numPedido"));
						pedi.setDataPedido(rset.getString("dataPedido"));
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
			return new Pedidos();
			}
	}



