/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lk.gov.health.drugservice.DrugGroup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author user
 */
@Stateless
@Path("lk.gov.health.drugservice.druggroup")
public class DrugGroupFacadeREST extends AbstractFacade<DrugGroup> {

    @PersistenceContext(unitName = "himsDrugPU")
    private EntityManager em;

    public DrugGroupFacadeREST() {
        super(DrugGroup.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DrugGroup entity) {
        entity.setId(null);
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, DrugGroup entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DrugGroup find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getAll() {
        JSONArray array = new JSONArray();
        List<DrugGroup> object = super.findAll();

        for (int i = 0; i < object.size(); i++) {
            JSONObject jo = new JSONObject();
            jo.put("id", object.get(i).getId());
            jo.put("drugGroup", object.get(i).getDrugGroup());
            jo.put("description", object.get(i).getDescription());
            if(object.get(i).getParentGroup() != null)
                jo.put("parentGroup", getRoomTypeObjct(object.get(i).getParentGroup()));
            else
               jo.put("parentGroup", null);  
            array.add(jo);
        }
        return JSONArray.toJSONString(array);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DrugGroup> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JSONObject getRoomTypeObjct(DrugGroup obj) {
        JSONObject tempObj = new JSONObject();
        tempObj.put("id", obj.getId());
        tempObj.put("drugGroup", obj.getDrugGroup());
        tempObj.put("description", obj.getDescription());
        tempObj.put("parentGroup", null);
        return tempObj;
    }

}
