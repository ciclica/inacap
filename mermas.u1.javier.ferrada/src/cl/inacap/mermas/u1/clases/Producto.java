package cl.inacap.mermas.u1.clases;

import java.util.ArrayList;

public class Producto {

	

	public int    pro_id;
	public String pro_Descripcion;
	public String pro_Valor;
	
	
	
	//Metodo lista de Usuarios
	
	public ArrayList<Producto> listaProducto()
		{
			ArrayList<Producto> lista = new ArrayList<Producto>();
			
			Producto  newProd = new Producto();
			newProd.pro_id = 1;
			newProd.pro_Descripcion = "Juego de Veterraga";
			newProd.pro_Valor = "$ 1.200";
			
			
			lista.add(newProd);
			
			newProd = new Producto();
			newProd.pro_id = 2;
			newProd.pro_Descripcion = "Chumbeque con Miel";
			newProd.pro_Valor = "$ 2.200";
			
			lista.add(newProd);
			
			newProd = new Producto();
			newProd.pro_id = 3;
			newProd.pro_Descripcion = "Empanada Mongoliana";
			newProd.pro_Valor = "$ 1.800";
			
			lista.add(newProd);
			
			newProd = new Producto();
			newProd.pro_id = 4;
			newProd.pro_Descripcion = "Sopaipleto";
			newProd.pro_Valor = "$ 1.500";
			
			lista.add(newProd);
			
			newProd = new Producto();
			newProd.pro_id = 5;
			newProd.pro_Descripcion = "Sushi Stoso";
			newProd.pro_Valor = "$ 3.500";
			
			lista.add(newProd);
			
			return lista;
		}
		
	
	
		
		//Forma String de la clase se usa para mostrar el contenido en objetos 
		public String toString()
		{
			return String.valueOf(this.pro_id) + " : " + this.pro_Descripcion + " (" + this.pro_Valor + ")"; 
		}
	
	
	
	
}
