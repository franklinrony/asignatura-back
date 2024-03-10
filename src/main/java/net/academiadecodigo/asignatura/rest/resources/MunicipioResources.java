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
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import net.academiadecodigo.asignatura.rest.entities.Municipio;
import net.academiadecodigo.asignatura.rest.facade.MunicipioFacade;

/**
 *
 * @author cash america
 */
@Produces("application/json")
@Consumes("application/json")
@Path("municipios")
public class MunicipioResources {

    @EJB
    MunicipioFacade municipioFacade;

    @GET
    @Path("{departamento}")
    public Response getMunicipiosByDepId(@QueryParam("id") BigDecimal id) {
        List<Municipio> municipios = municipioFacade.municipiosPorIdDep(id);

        if (municipios != null) {
            return Response.ok(municipios).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
