/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mido.testurl.service;

import com.mido.testurl.ejb.IpUrlFacade;
import com.mido.testurl.ejb.UrlFacade;
import com.mido.testurl.entity.IpUrl;
import com.mido.testurl.entity.IpUrlPK;
import com.mido.testurl.entity.Url;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALT
 */
public class Forwarder extends HttpServlet {

    @EJB
    UrlFacade uf;
    @EJB
    IpUrlFacade uipf;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("path=" + request.getPathInfo().substring(1));

        Url url = uf.find(UrlFacadeREST.decode(request.getPathInfo().substring(1)));
        System.out.println("request.getPathInfo().substring(1)=" + url);
        response.sendRedirect(url.getLu());

        String ipAddress = request.getRemoteAddr();
        System.out.println("IP Address: " + ipAddress);
        if (!(ipAddress == null)) {
            IpUrl ipu = uipf.find(new IpUrlPK(url.getSu(), ipAddress));
            if (ipu == null) {
                ipu = new IpUrl(new IpUrlPK(url.getSu(), ipAddress));
                ipu.setCount(0);
            }
            ipu.setCount(ipu.getCount() + 1);
            uipf.edit(ipu);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
