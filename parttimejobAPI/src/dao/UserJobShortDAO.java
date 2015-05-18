package dao;
// default package

import java.util.List;

import model.UserJobShort;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IUserJobShortDAO;

/**
 	* A data access object (DAO) providing persistence and search support for UserJobShort entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserJobShort
  * @author MyEclipse Persistence Tools 
 */

public class UserJobShortDAO extends HibernateDaoSupport implements IUserJobShortDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserJobShortDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#save(model.UserJobShort)
	 */
    @Override
	public void save(UserJobShort transientInstance) {
        log.debug("saving UserJobShort instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#delete(model.UserJobShort)
	 */
	@Override
	public void delete(UserJobShort persistentInstance) {
        log.debug("deleting UserJobShort instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#findById(java.lang.Long)
	 */
    @Override
	public UserJobShort findById( java.lang.Long id) {
        log.debug("getting UserJobShort instance with id: " + id);
        try {
            UserJobShort instance = (UserJobShort) getHibernateTemplate()
                    .get("UserJobShort", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#findByExample(model.UserJobShort)
	 */
    @Override
	public List findByExample(UserJobShort instance) {
        log.debug("finding UserJobShort instance by example");
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
	 * @see dao.IUserJobShortDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserJobShort instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserJobShort as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all UserJobShort instances");
		try {
			String queryString = "from UserJobShort";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#merge(model.UserJobShort)
	 */
    @Override
	public UserJobShort merge(UserJobShort detachedInstance) {
        log.debug("merging UserJobShort instance");
        try {
            UserJobShort result = (UserJobShort) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#attachDirty(model.UserJobShort)
	 */
    @Override
	public void attachDirty(UserJobShort instance) {
        log.debug("attaching dirty UserJobShort instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserJobShortDAO#attachClean(model.UserJobShort)
	 */
    @Override
	public void attachClean(UserJobShort instance) {
        log.debug("attaching clean UserJobShort instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IUserJobShortDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IUserJobShortDAO) ctx.getBean("UserJobShortDAO");
	}
}