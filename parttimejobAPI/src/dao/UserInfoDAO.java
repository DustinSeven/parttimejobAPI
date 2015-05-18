package dao;
// default package

import java.util.List;

import model.UserInfo;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IUserInfoDAO;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserInfo
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoDAO extends HibernateDaoSupport implements IUserInfoDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserInfoDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IUserInfoDAO#save(model.UserInfo)
	 */
    @Override
	public void save(UserInfo transientInstance) {
        log.debug("saving UserInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
            getHibernateTemplate().flush();
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IUserInfoDAO#delete(model.UserInfo)
	 */
	@Override
	public void delete(UserInfo persistentInstance) {
        log.debug("deleting UserInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserInfoDAO#findById(java.lang.Long)
	 */
    @Override
	public UserInfo findById( java.lang.Long id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
            UserInfo instance = (UserInfo) getHibernateTemplate()
                    .get("model.UserInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IUserInfoDAO#findByExample(model.UserInfo)
	 */
    @Override
	public List findByExample(UserInfo instance) {
        log.debug("finding UserInfo instance by example");
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
	 * @see dao.IUserInfoDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IUserInfoDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IUserInfoDAO#merge(model.UserInfo)
	 */
    @Override
	public UserInfo merge(UserInfo detachedInstance) {
        log.debug("merging UserInfo instance");
        try {
            UserInfo result = (UserInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IUserInfoDAO#attachDirty(model.UserInfo)
	 */
    @Override
	public void attachDirty(UserInfo instance) {
        log.debug("attaching dirty UserInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            getHibernateTemplate().flush();
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserInfoDAO#attachClean(model.UserInfo)
	 */
    @Override
	public void attachClean(UserInfo instance) {
        log.debug("attaching clean UserInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IUserInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IUserInfoDAO) ctx.getBean("UserInfoDAO");
	}
}