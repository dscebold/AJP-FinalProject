/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import entities.Users;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.UserTransaction;
import java.util.ResourceBundle;
import jsf.util.JsfUtil;
import session.UsersJpaController;

/**
 *
 * @author Drew
 */
@Named
@RequestScoped
public class Password {
    
    private String newPassword;
    private UsersJpaController jpaController; 
    
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "my_persistence_unit")
    private EntityManagerFactory emf = null;
    
    public Password() {
        
    }
    
    public String getNewPassword() {
        return this.newPassword;
    }
    
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword; 
    }
    
    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        String userName = getCurrentUser();
        externalContext.getFlash().put("loggedOutUserName", userName);
        externalContext.invalidateSession();
        return "logout"; 
    }
    
    public String getCurrentUser() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        return externalContext.getUserPrincipal().getName();
    }
    
    private UsersJpaController getUsersJpaController() {
        if (jpaController == null) {
            jpaController = new UsersJpaController(utx, emf);
        }
        return jpaController;
    }
    
    public String changePassword() {
        Users user = new Users(); 
        user.setUserid(getCurrentUser());
        user.setPassword(this.newPassword);
        try {
            getUsersJpaController().edit(user);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("UsersUpdated"));
            return "index";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
            return "index";
        }
    }
    
    
}
