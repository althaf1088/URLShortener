/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mido.testurl.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ALT
 */
@Embeddable
public class IpUrlPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IPLA")
    private String ipla;

    public IpUrlPK() {
    }

    public IpUrlPK(String url, String ipla) {
        this.url = url;
        this.ipla = ipla;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIpla() {
        return ipla;
    }

    public void setIpla(String ipla) {
        this.ipla = ipla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (url != null ? url.hashCode() : 0);
        hash += (ipla != null ? ipla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpUrlPK)) {
            return false;
        }
        IpUrlPK other = (IpUrlPK) object;
        if ((this.url == null && other.url != null) || (this.url != null && !this.url.equals(other.url))) {
            return false;
        }
        if ((this.ipla == null && other.ipla != null) || (this.ipla != null && !this.ipla.equals(other.ipla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mido.testurl.IpUrlPK[ url=" + url + ", ipla=" + ipla + " ]";
    }
    
}
