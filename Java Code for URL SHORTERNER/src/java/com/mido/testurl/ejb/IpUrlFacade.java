/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mido.testurl.ejb;

import com.mido.testurl.entity.IpUrl;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mido
 */
@Stateless
public class IpUrlFacade extends AbstractFacade<IpUrl> {
    @PersistenceContext(unitName = "testWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IpUrlFacade() {
        super(IpUrl.class);
    }
    
}
