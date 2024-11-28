/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persistencia;

import Controlador.Persistencia.exceptions.NonexistentEntityException;
import Modelos.Sesion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelos.Sitio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author e_d_d
 */
public class SesionJpaController implements Serializable {

    public SesionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sesion sesion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sitio sitio_id = sesion.getSitio_id();
            if (sitio_id != null) {
                sitio_id = em.getReference(sitio_id.getClass(), sitio_id.getSitio_id());
                sesion.setSitio_id(sitio_id);
            }
            em.persist(sesion);
            if (sitio_id != null) {
                sitio_id.getListaSesiones().add(sesion);
                sitio_id = em.merge(sitio_id);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sesion sesion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sesion persistentSesion = em.find(Sesion.class, sesion.getSes_id());
            Sitio sitio_idOld = persistentSesion.getSitio_id();
            Sitio sitio_idNew = sesion.getSitio_id();
            if (sitio_idNew != null) {
                sitio_idNew = em.getReference(sitio_idNew.getClass(), sitio_idNew.getSitio_id());
                sesion.setSitio_id(sitio_idNew);
            }
            sesion = em.merge(sesion);
            if (sitio_idOld != null && !sitio_idOld.equals(sitio_idNew)) {
                sitio_idOld.getListaSesiones().remove(sesion);
                sitio_idOld = em.merge(sitio_idOld);
            }
            if (sitio_idNew != null && !sitio_idNew.equals(sitio_idOld)) {
                sitio_idNew.getListaSesiones().add(sesion);
                sitio_idNew = em.merge(sitio_idNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sesion.getSes_id();
                if (findSesion(id) == null) {
                    throw new NonexistentEntityException("The sesion with id " + id + " no longer exists.");
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
            Sesion sesion;
            try {
                sesion = em.getReference(Sesion.class, id);
                sesion.getSes_id();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sesion with id " + id + " no longer exists.", enfe);
            }
            Sitio sitio_id = sesion.getSitio_id();
            if (sitio_id != null) {
                sitio_id.getListaSesiones().remove(sesion);
                sitio_id = em.merge(sitio_id);
            }
            em.remove(sesion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sesion> findSesionEntities() {
        return findSesionEntities(true, -1, -1);
    }

    public List<Sesion> findSesionEntities(int maxResults, int firstResult) {
        return findSesionEntities(false, maxResults, firstResult);
    }

    private List<Sesion> findSesionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sesion.class));
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

    public Sesion findSesion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sesion.class, id);
        } finally {
            em.close();
        }
    }

    public int getSesionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sesion> rt = cq.from(Sesion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
