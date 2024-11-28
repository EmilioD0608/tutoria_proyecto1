/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persistencia;

import Controlador.Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelos.Sesion;
import Modelos.Sitio;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author e_d_d
 */
public class SitioJpaController implements Serializable {

    public SitioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sitio sitio) {
        if (sitio.getListaSesiones() == null) {
            sitio.setListaSesiones(new LinkedList<Sesion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Sesion> attachedListaSesiones = new LinkedList<Sesion>();
            for (Sesion listaSesionesSesionToAttach : sitio.getListaSesiones()) {
                listaSesionesSesionToAttach = em.getReference(listaSesionesSesionToAttach.getClass(), listaSesionesSesionToAttach.getSes_id());
                attachedListaSesiones.add(listaSesionesSesionToAttach);
            }
            sitio.setListaSesiones(attachedListaSesiones);
            em.persist(sitio);
            for (Sesion listaSesionesSesion : sitio.getListaSesiones()) {
                Sitio oldSitio_idOfListaSesionesSesion = listaSesionesSesion.getSitio_id();
                listaSesionesSesion.setSitio_id(sitio);
                listaSesionesSesion = em.merge(listaSesionesSesion);
                if (oldSitio_idOfListaSesionesSesion != null) {
                    oldSitio_idOfListaSesionesSesion.getListaSesiones().remove(listaSesionesSesion);
                    oldSitio_idOfListaSesionesSesion = em.merge(oldSitio_idOfListaSesionesSesion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sitio sitio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sitio persistentSitio = em.find(Sitio.class, sitio.getSitio_id());
            LinkedList<Sesion> listaSesionesOld = persistentSitio.getListaSesiones();
            LinkedList<Sesion> listaSesionesNew = sitio.getListaSesiones();
            LinkedList<Sesion> attachedListaSesionesNew = new LinkedList<Sesion>();
            for (Sesion listaSesionesNewSesionToAttach : listaSesionesNew) {
                listaSesionesNewSesionToAttach = em.getReference(listaSesionesNewSesionToAttach.getClass(), listaSesionesNewSesionToAttach.getSes_id());
                attachedListaSesionesNew.add(listaSesionesNewSesionToAttach);
            }
            listaSesionesNew = attachedListaSesionesNew;
            sitio.setListaSesiones(listaSesionesNew);
            sitio = em.merge(sitio);
            for (Sesion listaSesionesOldSesion : listaSesionesOld) {
                if (!listaSesionesNew.contains(listaSesionesOldSesion)) {
                    listaSesionesOldSesion.setSitio_id(null);
                    listaSesionesOldSesion = em.merge(listaSesionesOldSesion);
                }
            }
            for (Sesion listaSesionesNewSesion : listaSesionesNew) {
                if (!listaSesionesOld.contains(listaSesionesNewSesion)) {
                    Sitio oldSitio_idOfListaSesionesNewSesion = listaSesionesNewSesion.getSitio_id();
                    listaSesionesNewSesion.setSitio_id(sitio);
                    listaSesionesNewSesion = em.merge(listaSesionesNewSesion);
                    if (oldSitio_idOfListaSesionesNewSesion != null && !oldSitio_idOfListaSesionesNewSesion.equals(sitio)) {
                        oldSitio_idOfListaSesionesNewSesion.getListaSesiones().remove(listaSesionesNewSesion);
                        oldSitio_idOfListaSesionesNewSesion = em.merge(oldSitio_idOfListaSesionesNewSesion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sitio.getSitio_id();
                if (findSitio(id) == null) {
                    throw new NonexistentEntityException("The sitio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sitio sitio;
            try {
                sitio = em.getReference(Sitio.class, id);
                sitio.getSitio_id();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sitio with id " + id + " no longer exists.", enfe);
            }
            LinkedList<Sesion> listaSesiones = sitio.getListaSesiones();
            for (Sesion listaSesionesSesion : listaSesiones) {
                listaSesionesSesion.setSitio_id(null);
                listaSesionesSesion = em.merge(listaSesionesSesion);
            }
            em.remove(sitio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sitio> findSitioEntities() {
        return findSitioEntities(true, -1, -1);
    }

    public List<Sitio> findSitioEntities(int maxResults, int firstResult) {
        return findSitioEntities(false, maxResults, firstResult);
    }

    private List<Sitio> findSitioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sitio.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sitio findSitio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sitio.class, id);
        } finally {
            em.close();
        }
    }

    public int getSitioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sitio> rt = cq.from(Sitio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
