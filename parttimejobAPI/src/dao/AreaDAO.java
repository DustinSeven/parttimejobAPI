package dao;
// default package

import java.util.List;

import model.Area;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IAreaDAO;

/**
 	* A data access object (DAO) providing persistence and search support for Area entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Area
  * @author MyEclipse Persistence Tools 
 */

public class AreaDAO extends HibernateDaoSupport implements IAreaDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AreaDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IAreaDAO#save(model.Area)
	 */
    @Override
	public void save(Area transientInstance) {
        log.debug("saving Area instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IAreaDAO#delete(model.Area)
	 */
	@Override
	public void delete(Area persistentInstance) {
        log.debug("deleting Area instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IAreaDAO#findById(java.lang.Long)
	 */
    @Override
	public Area findById( java.lang.Long id) {
        log.debug("getting Area instance with id: " + id);
        try {
            Area instance = (Area) getHibernateTemplate()
                    .get("model.Area", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IAreaDAO#findByExample(model.Area)
	 */
    @Override
	public List findByExample(Area instance) {
        log.debug("finding Area instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see dao.IAreaDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Area instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Area as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IAreaDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Area instances");
		try {
			String queryString = "from Area";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IAreaDAO#merge(model.Area)
	 */
    @Override
	public Area merge(Area detachedInstance) {
        log.debug("merging Area instance");
        try {
            Area result = (Area) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IAreaDAO#attachDirty(model.Area)
	 */
    @Override
	public void attachDirty(Area instance) {
        log.debug("attaching dirty Area instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IAreaDAO#attachClean(model.Area)
	 */
    @Override
	public void attachClean(Area instance) {
        log.debug("attaching clean Area instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IAreaDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IAreaDAO) ctx.getBean("AreaDAO");
	}
}