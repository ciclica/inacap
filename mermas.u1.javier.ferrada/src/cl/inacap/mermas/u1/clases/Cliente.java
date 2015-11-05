package cl.inacap.mermas.u1.clases;

import java.util.ArrayList;

public class Cliente {
	
	public int    cli_id;
	public String cli_Nombre;
	public String cli_Direccion;
	public String cli_Rut;
	public String cli_Estado;
	
	
	//Metodo lista de Usuarios
	
	public ArrayList<Cliente> listaCliente()
		{
			ArrayList<Cliente> lista = new ArrayList<Cliente>();
			
			Cliente newcliente = new Cliente();
			newcliente.cli_id = 1;
			newcliente.cli_Nombre = "Almacen Donde mi Mami";
			newcliente.cli_Direccion = "aqui al lado 2300, la florida";
			newcliente.cli_Rut = "13.858.585-9";
			newcliente.cli_Estado = "ACTIVO";
			
			
			lista.add(newcliente);
			
			newcliente = new Cliente();
			newcliente.cli_id = 2;
			newcliente.cli_Nombre = "MiniMarket Mary con Julio";
			newcliente.cli_Direccion = "4 esquinas 23, la granaja";
			newcliente.cli_Rut = "77.888.777-9";
			newcliente.cli_Estado = "ACTIVO";
			
			lista.add(newcliente);
			
			return lista;
		}
		
		
		//Forma String de la clase se usa para mostrar el contenido en objetos 
		public String toString()
		{
			return String.valueOf(this.cli_id) + " : " + this.cli_Nombre + " (" + this.cli_Rut + ")"; 
		}
	
	//
	
	public void InsertaCliente(String insNombre, String insDireccion,
							 String insRut)
	{
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Cliente inscliente;
		ArrayList<Cliente> listau = listaCliente();
		int largo = listau.size() + 1;  
		
		inscliente = new Cliente();
		
		inscliente.cli_id = largo;
		inscliente.cli_Nombre = insNombre;
		inscliente.cli_Direccion = insDireccion;
		inscliente.cli_Rut = insRut;
		inscliente.cli_Estado = "Nuevo";
		
		lista.add(inscliente);
		
		
	}
	
	

}
