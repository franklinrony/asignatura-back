/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package net.academiadecodigo.asignatura.rest.facade;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.academiadecodigo.asignatura.rest.entities.Departamento;

/**
 *
 * @author Franklin Rony Cortez
 */
@Stateless
@LocalBean
public class DepartamentoFacade extends AbstractFacade<Departamento> {
   
    @PersistenceContext(unitName = "asignaturaPU")
    private EntityManager em;
    
    
    public DepartamentoFacade(Class<Departamento> entityClass) {
        super(entityClass);
    }

     // Default constructor
    public DepartamentoFacade() {
        super(Departamento.class); // Call the constructor of AbstractFacade
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
