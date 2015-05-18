package dao;
// default package

import java.util.List;

import model.Advice;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IAdviceDAO;

/**
 	* A data access object (DAO) providing persistence and search support for Advice entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Advice
  * @author MyEclipse Persistence Tools 
 */

public class AdviceDAO extends HibernateDaoSupport implements IAdviceDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AdviceDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IAdviceDAO#save(model.Advice)
	 */
    @Override
	public void save(Advice transientInstance) {
        log.debug("saving Advice instance");
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
	 * @see dao.IAdviceDAO#delete(model.Advice)
	 */
	@Override
	public void delete(Advice persistentInstance) {
        log.debug("deleting Advice instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IAdviceDAO#findById(java.lang.Long)
	 */
    @Override
	public Advice findById( java.lang.Long id) {
        log.debug("getting Advice instance with id: " + id);
        try {
            Advice instance = (Advice) getHibernateTemplate()
                    .get("model.Advice", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IAdviceDAO#findByExample(model.Advice)
	 */
    @Override
	public List findByExample(Advice instance) {
        log.debug("finding Advice instance by example");
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
	 * @see dao.IAdviceDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Advice instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Advice as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IAdviceDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Advice instances");
		try {
			String queryString = "from Advice";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IAdviceDAO#merge(model.Advice)
	 */
    @Override
	public Advice merge(Advice detachedInstance) {
        log.debug("merging Advice instance");
        try {
            Advice result = (Advice) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IAdviceDAO#attachDirty(model.Advice)
	 */
    @Override
	public void attachDirty(Advice instance) {
        log.debug("attaching dirty Advice instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IAdviceDAO#attachClean(model.Advice)
	 */
    @Override
	public void attachClean(Advice instance) {
        log.debug("attaching clean Advice instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IAdviceDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IAdviceDAO) ctx.getBean("AdviceDAO");
	}
}