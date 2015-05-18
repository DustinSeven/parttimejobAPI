package dao;
// default package

import java.util.List;

import model.UserJobLong;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IUserJobLongDAO;

/**
 	* A data access object (DAO) providing persistence and search support for UserJob entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserJob
  * @author MyEclipse Persistence Tools 
 */

public class UserJobLongDAO extends HibernateDaoSupport implements IUserJobLongDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserJobLongDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IUserJobDAO#save(model.UserJob)
	 */
    @Override
	public void save(UserJobLong transientInstance) {
        log.debug("saving UserJob instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IUserJobDAO#delete(model.UserJob)
	 */
	@Override
	public void delete(UserJobLong persistentInstance) {
        log.debug("deleting UserJob instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserJobDAO#findById(java.lang.Long)
	 */
    @Override
	public UserJobLong findById( java.lang.Long id) {
        log.debug("getting UserJob instance with id: " + id);
        try {
            UserJobLong instance = (UserJobLong) getHibernateTemplate()
                    .get("model.UserJobLong", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IUserJobDAO#findByExample(model.UserJob)
	 */
    @Override
	public List findByExample(UserJobLong instance) {
        log.debug("finding UserJob instance by example");
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
	 * @see dao.IUserJobDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserJob instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserJobLong as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IUserJobDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all UserJob instances");
		try {
			String queryString = "from UserJobLong";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IUserJobDAO#merge(model.UserJob)
	 */
    @Override
	public UserJobLong merge(UserJobLong detachedInstance) {
        log.debug("merging UserJob instance");
        try {
            UserJobLong result = (UserJobLong) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IUserJobDAO#attachDirty(model.UserJob)
	 */
    @Override
	public void attachDirty(UserJobLong instance) {
        log.debug("attaching dirty UserJob instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserJobDAO#attachClean(model.UserJob)
	 */
    @Override
	public void attachClean(UserJobLong instance) {
        log.debug("attaching clean UserJob instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IUserJobLongDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IUserJobLongDAO) ctx.getBean("UserJobLongDAO");
	}
}