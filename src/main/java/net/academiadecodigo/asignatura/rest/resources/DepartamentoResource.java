/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.academiadecodigo.asignatura.rest.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import net.academiadecodigo.asignatura.rest.entities.Departamento;
import net.academiadecodigo.asignatura.rest.facade.DepartamentoFacade;

/**
 *
 * @author cash america
 */
@Produces("application/json")
@Consumes("application/json")
@Path("departamentos")
public class DepartamentoResource {
    
@EJB
DepartamentoFacade departamentoFacade;

    @GET
    public Response getDepartamentos() {
        List<Departamento> departamentos = departamentoFacade.findAll();

        return Response
                .ok(departamentos)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Response getDepartamentoById(@PathParam("id") BigDecimal id) {
        Departamento departamento = departamentoFacade.find(id);
        
        if (departamento != null) {
            return Response.ok(departamento).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Departamento no encontrado").build();
        }
    }
}
