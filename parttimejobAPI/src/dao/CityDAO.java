package dao;
// default package

import java.util.List;

import model.City;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.ICityDAO;

/**
 	* A data access object (DAO) providing persistence and search support for City entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .City
  * @author MyEclipse Persistence Tools 
 */

public class CityDAO extends HibernateDaoSupport implements ICityDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CityDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.ICityDAO#save(model.City)
	 */
    @Override
	public void save(City transientInstance) {
        log.debug("saving City instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.ICityDAO#delete(model.City)
	 */
	@Override
	public void delete(City persistentInstance) {
        log.debug("deleting City instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ICityDAO#findById(java.lang.Long)
	 */
    @Override
	public City findById( java.lang.Long id) {
        log.debug("getting City instance with id: " + id);
        try {
            City instance = (City) getHibernateTemplate()
                    .get("model.City", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.ICityDAO#findByExample(model.City)
	 */
    @Override
	public List findByExample(City instance) {
        log.debug("finding City instance by example");
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
	 * @see dao.ICityDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding City instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from City as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.ICityDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all City instances");
		try {
			String queryString = "from City";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.ICityDAO#merge(model.City)
	 */
    @Override
	public City merge(City detachedInstance) {
        log.debug("merging City instance");
        try {
            City result = (City) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.ICityDAO#attachDirty(model.City)
	 */
    @Override
	public void attachDirty(City instance) {
        log.debug("attaching dirty City instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ICityDAO#attachClean(model.City)
	 */
    @Override
	public void attachClean(City instance) {
        log.debug("attaching clean City instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ICityDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ICityDAO) ctx.getBean("CityDAO");
	}
}