/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package net.academiadecodigo.asignatura.rest.facade;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import net.academiadecodigo.asignatura.rest.entities.Municipio;

/**
 *
 * @author cash america
 */
@Stateless
@LocalBean
public class MunicipioFacade extends AbstractFacade<Municipio> {
  @PersistenceContext(unitName = "asignaturaPU")
    private EntityManager em;
  
    public MunicipioFacade(Class<Municipio> entityClass) {
        super(entityClass);
    }
       public MunicipioFacade() {
        super(Municipio.class); // Call the constructor of AbstractFacade
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

   public List<Municipio> municipiosPorIdDep(BigDecimal id) {
        TypedQuery<Municipio> query = em.createQuery(
                "SELECT m FROM Municipio m WHERE m.deptId.deptId = :id", Municipio.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
