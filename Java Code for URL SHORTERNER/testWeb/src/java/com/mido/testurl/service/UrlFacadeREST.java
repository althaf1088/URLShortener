/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mido.testurl.service;

import com.mido.testurl.entity.IpUrl;
import com.mido.testurl.entity.Url;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author mido
 */
@Stateless
@Path("url")
public class UrlFacadeREST extends AbstractFacade<Url> {
    @PersistenceContext(unitName = "testWebPU")
    private EntityManager em;
    
    private static final char[] chars;
    private static final String s1;
    static {
        s1="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        chars=s1.toCharArray();
    }

    public UrlFacadeREST() {
        super(Url.class);
        
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    @Path("{id}")
    public void create(Url entity) {
        System.out.println("ent="+entity);
        super.create(entity);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Url create2(Url entity) {
        super.create(entity);
        entity.setSu("http://localhost:8080/tw/a/"+encode(entity.getId()));
        super.edit(entity);
        return entity;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Url entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Url find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Url> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Url> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @POST
    @Path("stat")
    public List<IpUrl> stat(Url url){
        List<IpUrl> ips=null;
         try {
            TypedQuery<IpUrl> tq = em.createNamedQuery("IpUrl.findByUrl", IpUrl.class);
            tq.setParameter("url",url.getSu());
             ips= tq.getResultList();
        } catch (NoResultException e) {
            return null;
        }
         System.out.println("urls="+ips);
        return ips;
    }
    
    public static String encode(Long i){
        if(i==0)
            return "a";
        
        StringBuilder sb= new StringBuilder("");
        int tmp;
        while(i>0){
            tmp= (int) (i%chars.length);
            sb.append(chars[tmp]);
            i/=chars.length;
        }            
        return sb.reverse().toString();
    }
    
   public static Long decode(String s){
        Long i=new Long(0);
        int l=chars.length;
        for(char c:s.toCharArray()){
            i=i*l+s1.indexOf(c);
        }
        return i;
    }
    
    
}
