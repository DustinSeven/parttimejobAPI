package dao;
// default package

import java.util.List;

import model.UserSetting;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IUserSettingDAO;

/**
 	* A data access object (DAO) providing persistence and search support for UserSetting entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserSetting
  * @author MyEclipse Persistence Tools 
 */

public class UserSettingDAO extends HibernateDaoSupport implements IUserSettingDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserSettingDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IUserSettingDAO#save(model.UserSetting)
	 */
    @Override
	public void save(UserSetting transientInstance) {
        log.debug("saving UserSetting instance");
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
	 * @see dao.IUserSettingDAO#delete(model.UserSetting)
	 */
	@Override
	public void delete(UserSetting persistentInstance) {
        log.debug("deleting UserSetting instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserSettingDAO#findById(java.lang.Long)
	 */
    @Override
	public UserSetting findById( java.lang.Long id) {
        log.debug("getting UserSetting instance with id: " + id);
        try {
            UserSetting instance = (UserSetting) getHibernateTemplate()
                    .get("model.UserSetting", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IUserSettingDAO#findByExample(model.UserSetting)
	 */
    @Override
	public List findByExample(UserSetting instance) {
        log.debug("finding UserSetting instance by example");
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
	 * @see dao.IUserSettingDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserSetting instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserSetting as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IUserSettingDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all UserSetting instances");
		try {
			String queryString = "from UserSetting";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IUserSettingDAO#merge(model.UserSetting)
	 */
    @Override
	public UserSetting merge(UserSetting detachedInstance) {
        log.debug("merging UserSetting instance");
        try {
            UserSetting result = (UserSetting) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IUserSettingDAO#attachDirty(model.UserSetting)
	 */
    @Override
	public void attachDirty(UserSetting instance) {
        log.debug("attaching dirty UserSetting instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
            getHibernateTemplate().flush();
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IUserSettingDAO#attachClean(model.UserSetting)
	 */
    @Override
	public void attachClean(UserSetting instance) {
        log.debug("attaching clean UserSetting instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IUserSettingDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IUserSettingDAO) ctx.getBean("UserSettingDAO");
	}
}