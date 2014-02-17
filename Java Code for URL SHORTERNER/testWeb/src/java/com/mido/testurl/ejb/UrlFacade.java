/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mido.testurl.ejb;

import com.mido.testurl.entity.Url;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mido
 */
@Stateless
public class UrlFacade extends AbstractFacade<Url> {
    @PersistenceContext(unitName = "testWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UrlFacade() {
        super(Url.class);
    }
    
}
