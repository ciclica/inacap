package cl.inacap.mermas.u1.clases;

import java.util.ArrayList;



public class Usuario {
	public int  usr_id;
	public String usr_Nombre;
	public String usr_Login;
	public String usr_Clave;
	
	//Metodo lista de Usuarios
	
	public ArrayList<Usuario> listaUsuarios()
		{
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			
			Usuario usuario = new Usuario();
			usuario.usr_id = 1;
			usuario.usr_Nombre = "juan Perez";
			usuario.usr_Login = "juan";
			usuario.usr_Clave = "juan";
			
			lista.add(usuario);
			
			usuario = new Usuario();
			usuario.usr_id = 2;
			usuario.usr_Nombre = "pedro Perez";
			usuario.usr_Login = "pedro";
			usuario.usr_Clave = "pedro";
			
			lista.add(usuario);
			
			return lista;
		}
		
	
		// Metodo ValidaUsuario
	
		public boolean validarUsuario(String login, String contrasena)
		{
			Usuario usuario;
			ArrayList<Usuario> usuarios = listaUsuarios();
			int largo = usuarios.size();
			for(int i=0;i < largo;i++)
			{
				usuario = usuarios.get(i);
				if(usuario.usr_Login.equals(login) && usuario.usr_Clave.equals(contrasena))
				{
					return true;
				}
			}
			
			return false;
		}
		
		//Forma String de la clase se usa para mostrar el contenido en objetos 
		public String toString()
		{
			return String.valueOf(this.usr_id) + " : " + this.usr_Nombre + " (" + this.usr_Login + ")"; 
		}
	
	
}
