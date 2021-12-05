import java.util.List;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		int i = 0;
		int resultado = 0;
		List<Producto> listadoObjetos = null;
		BaseDeDatosOO bdoo = new BaseDeDatosOO();
		//-------------------------------------------------------
		Producto p = null;
		int id =0;
		float precio =0f;
		String nombre = "";
		int cantidad =0;
		int opcion = -1;
		Scanner capturaDeDatos = new Scanner(System.in);
		
		do {
			System.out.println("***********************************************************************");
			System.out.println("*******************GESTOR DE PRODUCTOS*********************************");
			System.out.println("***********************************************************************");
			
			System.out.println("Elija un opción");
			System.out.println("");
			System.out.println("1)Crear un producto");
			System.out.println("2)Borrar un producto");
			System.out.println("3)Leer un producto");
			System.out.println("4)modificar un producto");
			System.out.println("5)listar un producto");
			System.out.println("0)Salir");
			System.out.println("");
			System.out.println("Opción");
			opcion = capturaDeDatos.nextInt();
			
			
			if(opcion == 1) {
				//create-------------------------------------------------------------------------------------------------
				System.out.println("Introduzca el id del producto");
				id = capturaDeDatos.nextInt();
				System.out.println("Introduzca el precio del producto");
				precio = capturaDeDatos.nextFloat();
				System.out.println("Introduzca el nombre del producto");
				capturaDeDatos.nextLine();//Limpiar el enter
				nombre = capturaDeDatos.nextLine();
				System.out.println("Introduzca la cantidad del producto");
				cantidad = capturaDeDatos.nextInt();
				
				p = new Producto(id, precio, nombre, cantidad);
				bdoo.create(p);
				System.out.println("Producto creado correctamente");
				
			}else if(opcion == 2) {
				//delete-------------------------------------------------------------------------------------------------
				System.out.println("Introduzca el id del producto");
				id = capturaDeDatos.nextInt();
				if(bdoo.delete("DELETE FROM Producto p WHERE p.id="+id)==1) {
					System.out.println("Borrado correctamente");
				}else {
					System.out.println("Error al borrar");
				}
				
			}else if (opcion == 3) {
				System.out.println("Introduzca la cantidad del producto");
				cantidad = capturaDeDatos.nextInt();
				//read---------------------------------------------------------------------------------------------------
				listadoObjetos = bdoo.read("SELECT pro FROM  Producto pro WHERE cantidad>" + cantidad);
				for(i=0; i<listadoObjetos.size(); i++) {
					System.out.println("id: "+listadoObjetos.get(i).getId()+"---"+
										"precio: "+listadoObjetos.get(i).getPrecio()+"---"+
										"nombre: "+listadoObjetos.get(i).getNombre()+"---"+
										"cantidad: "+listadoObjetos.get(i).getCantidad()+"---");
				}
				
			}else if (opcion == 4) {
				//update-------------------------------------------------------------------------------------------------
				System.out.println("Referencias------");
				listadoObjetos = bdoo.listarProducto();
				for(i=0; i<listadoObjetos.size(); i++) {
					System.out.println("id: "+listadoObjetos.get(i).getId()+"---"+
										"precio: "+listadoObjetos.get(i).getPrecio()+"---"+
										"nombre: "+listadoObjetos.get(i).getNombre()+"---"+
										"cantidad: "+listadoObjetos.get(i).getCantidad()+"---");
				}
				System.out.println("--------------");
				System.out.println("Introduzca el id del producto");
				id = capturaDeDatos.nextInt();
				System.out.println("Introduzca el precio del producto");
				precio = capturaDeDatos.nextFloat();
				System.out.println("Introduzca el nombre del producto");
				capturaDeDatos.nextLine();//Limpiar el enter
				nombre = capturaDeDatos.nextLine();
				System.out.println("Introduzca la cantidad del producto");
				cantidad = capturaDeDatos.nextInt();
				if(bdoo.update("UPDATE Producto SET cantidad="+cantidad+", nombre='"+nombre+"', precio = "+precio+"  WHERE id ="+id)==1) {
					System.out.println("Actualizado correctamente");
					
				}else {
					System.out.println("Error al actualizar");
				}
				
			}else if (opcion == 5) {
				//list------------------------------------------------------------------------------------------------------
				listadoObjetos = bdoo.listarProducto();
				for(i=0; i<listadoObjetos.size(); i++) {
					System.out.println("id: "+listadoObjetos.get(i).getId()+"---"+
										"precio: "+listadoObjetos.get(i).getPrecio()+"---"+
										"nombre: "+listadoObjetos.get(i).getNombre()+"---"+
										"cantidad: "+listadoObjetos.get(i).getCantidad()+"---");
				}
				
			}else if (opcion !=0) {
				System.out.println("Opción erronea");
			}
			
		}while(opcion !=0);
		System.out.println("Programa finalizado");
		
		
		
		
		
		
		//**********************************************************************************************************
		
		/*Producto p = new Producto(3, 50.0f, "llave inglesa", 2000);
		bdoo.create(p);*/
		//read---------------------------------------------------------------------------------------------------
		/*listadoObjetos = bdoo.read("SELECT pro FROM  Producto pro WHERE cantidad>500");
		for(i=0; i<listadoObjetos.size(); i++) {
			System.out.println("id: "+listadoObjetos.get(i).getId()+"---"+
								"precio: "+listadoObjetos.get(i).getPrecio()+"---"+
								"nombre: "+listadoObjetos.get(i).getNombre()+"---"+
								"cantidad: "+listadoObjetos.get(i).getCantidad()+"---");
		}*/
		
		//update--------------------------------------------------------------------------------------------------
		/*if(bdoo.update("UPDATE Producto SET cantidad=550 WHERE id = 1")==1) {
			System.out.println("Actualizado correctamente");
		}else {
			System.out.println("Error al actualizar");
		}*/
		
		//delete-------------------------------------------------------------------------------------------------
		/*if(bdoo.delete("DELETE FROM Producto p WHERE p.precio <100")==1) {
			System.out.println("Borrado correctamente");
		}else {
			System.out.println("Error al borrar");
		}*/
		
		
		System.out.println("--------------------------------------------------------------------------------------");
		//list------------------------------------------------------------------------------------------------------
		/*listadoObjetos = bdoo.listarProducto();
		for(i=0; i<listadoObjetos.size(); i++) {
			System.out.println("id: "+listadoObjetos.get(i).getId()+"---"+
								"precio: "+listadoObjetos.get(i).getPrecio()+"---"+
								"nombre: "+listadoObjetos.get(i).getNombre()+"---"+
								"cantidad: "+listadoObjetos.get(i).getCantidad()+"---");
		}*/
	}

}
