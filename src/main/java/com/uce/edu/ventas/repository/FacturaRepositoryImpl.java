package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	// Join Types en Jakarta Persistence

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> mQ = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero = : numero",
				Factura.class);
		mQ.setParameter("numero", numero);
		Factura fac = mQ.getSingleResult();
		fac.getDetallesFactura().size(); // le digo que cargue el detalle bajo demanda
		return fac;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM factura f INNER JOIN detalle_factura d on f.fact_id =
		// d.defa_id

		// JPQL: SELECT f FROM Factura f INNER JOIN f.detallesFactura d
		String jpql = "SELECT f FROM Factura f JOIN f.detallesFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
//		for (Factura f : lista) {
//			f.getDetallesFactura().size();
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		String jpql = "SELECT f FROM Factura f RIGHT JOIN f.detallesFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		String jpql = "SELECT f FROM Factura f LEFT JOIN f.detallesFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		String jpql = "SELECT f FROM Factura f FULL JOIN f.detallesFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub

		// SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id = d.defa_id
		// JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE f.id = d.factura.id
		// f = d.factura
		TypedQuery<Factura> mQ = this.entityManager
				.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		List<Factura> lista = mQ.getResultList();
		for (Factura f : lista) {
			f.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		// SELECT f FROM Factura f JOIN FETCH f.detalleFactura d
		TypedQuery<Factura> mQ = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detallesFactura d", Factura.class);
		return mQ.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		// SQL: UPDATE factura set fact_fecha =: fechaNueva WHERE fact_fecha >=
		// fechaActual
		// JPQL: UPDATE Factura f SET f.fecha =: fechaNueva WHERE f.fecha >=
		// :fechaActual
		Query mQ = this.entityManager
				.createQuery("UPDATE Factura f SET f.fecha =: fechaNueva WHERE f.fecha >= :fechaActual");
		mQ.setParameter("fechaNueva", fechaNueva);
		mQ.setParameter("fechaActual", fechaActual);

		// cantidad de registros afectados/actualizados
		return mQ.executeUpdate();
	}

	public Factura seleccionar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		// SQL: DELETE FROM factura WHERE fact_numero =: numero
		// JPQL: DELETE FROM Factura f WHERE f.numero =: numero
		Query mQ = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =: numero");
		mQ.setParameter("numero", numero);

		// "No hay executeDelete, solo Update"
		return mQ.executeUpdate();
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> mQ = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero, f.fecha) FROM Factura f ",
				FacturaDTO.class);
		return mQ.getResultList();
	}

	@Override
	public Factura seleccionarUnionFacturaDetalle() {
		// TODO Auto-generated method stub
		Query mQ = this.entityManager.createNativeQuery("SELECT fact_cedula FROM factura f WHERE f.fact_id =4",
				Factura.class);
		Factura fac = (Factura) mQ.getSingleResult();
		fac.getDetallesFactura().size();
		return fac;
	}

}
