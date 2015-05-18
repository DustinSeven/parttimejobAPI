package dao;
// default package

import java.util.List;

import model.EnterpriseAccount;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IEnterpriseAccountDAO;

/**
 	* A data access object (DAO) providing persistence and search support for EnterpriseAccount entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .EnterpriseAccount
  * @author MyEclipse Persistence Tools 
 */

public class EnterpriseAccountDAO extends HibernateDaoSupport implements IEnterpriseAccountDAO  {
	     private static final Logger log = LoggerFactory.getLogger(EnterpriseAccountDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#save(model.EnterpriseAccount)
	 */
    @Override
	public void save(EnterpriseAccount transientInstance) {
        log.debug("saving EnterpriseAccount instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#delete(model.EnterpriseAccount)
	 */
	@Override
	public void delete(EnterpriseAccount persistentInstance) {
        log.debug("deleting EnterpriseAccount instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#findById(java.lang.Long)
	 */
    @Override
	public EnterpriseAccount findById( java.lang.Long id) {
        log.debug("getting EnterpriseAccount instance with id: " + id);
        try {
            EnterpriseAccount instance = (EnterpriseAccount) getHibernateTemplate()
                    .get("EnterpriseAccount", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#findByExample(model.EnterpriseAccount)
	 */
    @Override
	public List findByExample(EnterpriseAccount instance) {
        log.debug("finding EnterpriseAccount instance by example");
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
	 * @see dao.IEnterpriseAccountDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding EnterpriseAccount instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EnterpriseAccount as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EnterpriseAccount instances");
		try {
			String queryString = "from EnterpriseAccount";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#merge(model.EnterpriseAccount)
	 */
    @Override
	public EnterpriseAccount merge(EnterpriseAccount detachedInstance) {
        log.debug("merging EnterpriseAccount instance");
        try {
            EnterpriseAccount result = (EnterpriseAccount) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#attachDirty(model.EnterpriseAccount)
	 */
    @Override
	public void attachDirty(EnterpriseAccount instance) {
        log.debug("attaching dirty EnterpriseAccount instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IEnterpriseAccountDAO#attachClean(model.EnterpriseAccount)
	 */
    @Override
	public void attachClean(EnterpriseAccount instance) {
        log.debug("attaching clean EnterpriseAccount instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IEnterpriseAccountDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IEnterpriseAccountDAO) ctx.getBean("EnterpriseAccountDAO");
	}
}