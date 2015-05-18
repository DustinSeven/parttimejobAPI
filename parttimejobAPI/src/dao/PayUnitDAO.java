package dao;
// default package

import java.util.List;

import model.PayUnit;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IPayUnitDAO;

/**
 	* A data access object (DAO) providing persistence and search support for PayUnit entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .PayUnit
  * @author MyEclipse Persistence Tools 
 */

public class PayUnitDAO extends HibernateDaoSupport implements IPayUnitDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PayUnitDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IPayUnitDAO#save(model.PayUnit)
	 */
    @Override
	public void save(PayUnit transientInstance) {
        log.debug("saving PayUnit instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IPayUnitDAO#delete(model.PayUnit)
	 */
	@Override
	public void delete(PayUnit persistentInstance) {
        log.debug("deleting PayUnit instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IPayUnitDAO#findById(java.lang.Long)
	 */
    @Override
	public PayUnit findById( java.lang.Long id) {
        log.debug("getting PayUnit instance with id: " + id);
        try {
            PayUnit instance = (PayUnit) getHibernateTemplate()
                    .get("PayUnit", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IPayUnitDAO#findByExample(model.PayUnit)
	 */
    @Override
	public List findByExample(PayUnit instance) {
        log.debug("finding PayUnit instance by example");
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
	 * @see dao.IPayUnitDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding PayUnit instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PayUnit as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IPayUnitDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all PayUnit instances");
		try {
			String queryString = "from PayUnit";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IPayUnitDAO#merge(model.PayUnit)
	 */
    @Override
	public PayUnit merge(PayUnit detachedInstance) {
        log.debug("merging PayUnit instance");
        try {
            PayUnit result = (PayUnit) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IPayUnitDAO#attachDirty(model.PayUnit)
	 */
    @Override
	public void attachDirty(PayUnit instance) {
        log.debug("attaching dirty PayUnit instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IPayUnitDAO#attachClean(model.PayUnit)
	 */
    @Override
	public void attachClean(PayUnit instance) {
        log.debug("attaching clean PayUnit instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IPayUnitDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IPayUnitDAO) ctx.getBean("PayUnitDAO");
	}
}