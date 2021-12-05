

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BaseDeDatosOO {
	private EntityManager em = null;
	
	public BaseDeDatosOO(){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("$objectdb/db/fabrica.odb");
		em = emf.createEntityManager();	
	}
	
	//CRUD----------------------------------------------------------------------------------------------
	
	//create---------------------------------------------------------
	public void create(Producto product) {
		
		em.getTransaction().begin();		
		em.persist(product);	
		em.getTransaction().commit();
	}
	
	//read---------------------------------------------------------
	public List<Producto> read(String consulta) {
		TypedQuery<Producto> query = em.createQuery(consulta, Producto.class);
		return  query.getResultList();
	}

	//update---------------------------------------------------------
	public int update(String consulta) {
		int resultado =0;
		em.getTransaction().begin();
		
		resultado= em.createQuery(consulta).executeUpdate();
				
		em.getTransaction().commit();
		return resultado;
	}
	
	//delete---------------------------------------------------------
	public int delete(String consulta) {
		int result = 0;
		em.getTransaction().begin();
		//executeUpdate(); devuelve un entero, se ejecuta dos veces el programma
		result= em.createQuery(consulta).executeUpdate();
		
		em.getTransaction().commit();
		
		return result;
	}
	
	//list----------------------------------------------------------
	public List<Producto> listarProducto() {
		TypedQuery<Producto> query = em.createQuery("SELECT pro FROM  Producto pro", Producto.class);
		return  query.getResultList();
	}
}
