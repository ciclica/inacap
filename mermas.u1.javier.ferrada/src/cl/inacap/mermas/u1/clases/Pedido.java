package cl.inacap.mermas.u1.clases;

import java.util.ArrayList;

public class Pedido {
	
	public int    ped_id;
	public String ped_Cliente;
	public String ped_Producto;
	public String ped_Cantidad;
	public String ped_FechaEntrega;
	public String ped_Precio;
	public String ped_Vendedor;
	
	
	//Metodo lista de Usuarios
	
	public ArrayList<Pedido> listaPedidos()
		{
			ArrayList<Pedido> lista = new ArrayList<Pedido>();
			
			Pedido newpedido = new Pedido();
			newpedido.ped_id = 1;
			newpedido.ped_Cliente = "Almacen Mary con Jaun";
			newpedido.ped_Producto = "Chunchulex";
			newpedido.ped_Cantidad = "13";
			newpedido.ped_FechaEntrega = "01/09/2015";
			newpedido.ped_Precio = "23000";
			newpedido.ped_Vendedor = "juan";
			
			lista.add(newpedido);
			return lista;
		}
		
		//Forma String de la clase se usa para mostrar el contenido en objetos 
		public String toString()
		{
			return String.valueOf(this.ped_id) + " : " + this.ped_Cliente + " (" + this.ped_Precio + ")"; 
		}
	
	
	
	
}
