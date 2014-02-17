/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mido.testurl.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALT
 */
@Entity
@Table(name = "IP_URL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IpUrl.findAll", query = "SELECT i FROM IpUrl i"),
    @NamedQuery(name = "IpUrl.findByUrl", query = "SELECT i FROM IpUrl i WHERE i.ipUrlPK.url = :url"),
    @NamedQuery(name = "IpUrl.findByIpla", query = "SELECT i FROM IpUrl i WHERE i.ipUrlPK.ipla = :ipla"),
    @NamedQuery(name = "IpUrl.findByCount", query = "SELECT i FROM IpUrl i WHERE i.count = :count"),
    @NamedQuery(name = "IpUrl.findAct", query = "SELECT i FROM IpUrl i WHERE i.ipUrlPK.ipla = :ipla and  i.ipUrlPK.url = :url")})
public class IpUrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IpUrlPK ipUrlPK;
    @Column(name = "COUNT")
    private Integer count;

    public IpUrl() {
    }

    public IpUrl(IpUrlPK ipUrlPK) {
        this.ipUrlPK = ipUrlPK;
    }

    public IpUrl(String url, String ipla) {
        this.ipUrlPK = new IpUrlPK(url, ipla);
    }

    public IpUrlPK getIpUrlPK() {
        return ipUrlPK;
    }

    public void setIpUrlPK(IpUrlPK ipUrlPK) {
        this.ipUrlPK = ipUrlPK;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ipUrlPK != null ? ipUrlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpUrl)) {
            return false;
        }
        IpUrl other = (IpUrl) object;
        if ((this.ipUrlPK == null && other.ipUrlPK != null) || (this.ipUrlPK != null && !this.ipUrlPK.equals(other.ipUrlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mido.testurl.IpUrl[ ipUrlPK=" + ipUrlPK + " ]";
    }
    
}
