package dao;
// default package

import java.util.List;

import model.JobDate;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IJobDateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for JobDate entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JobDate
  * @author MyEclipse Persistence Tools 
 */

public class JobDateDAO extends HibernateDaoSupport implements IJobDateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JobDateDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IJobDateDAO#save(model.JobDate)
	 */
    @Override
	public void save(JobDate transientInstance) {
        log.debug("saving JobDate instance");
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
	 * @see dao.IJobDateDAO#delete(model.JobDate)
	 */
	@Override
	public void delete(JobDate persistentInstance) {
        log.debug("deleting JobDate instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IJobDateDAO#findById(java.lang.Long)
	 */
    @Override
	public JobDate findById( java.lang.Long id) {
        log.debug("getting JobDate instance with id: " + id);
        try {
            JobDate instance = (JobDate) getHibernateTemplate()
                    .get("model.JobDate", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IJobDateDAO#findByExample(model.JobDate)
	 */
    @Override
	public List findByExample(JobDate instance) {
        log.debug("finding JobDate instance by example");
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
	 * @see dao.IJobDateDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding JobDate instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JobDate as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IJobDateDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all JobDate instances");
		try {
			String queryString = "from JobDate";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IJobDateDAO#merge(model.JobDate)
	 */
    @Override
	public JobDate merge(JobDate detachedInstance) {
        log.debug("merging JobDate instance");
        try {
            JobDate result = (JobDate) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IJobDateDAO#attachDirty(model.JobDate)
	 */
    @Override
	public void attachDirty(JobDate instance) {
        log.debug("attaching dirty JobDate instance");
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
	 * @see dao.IJobDateDAO#attachClean(model.JobDate)
	 */
    @Override
	public void attachClean(JobDate instance) {
        log.debug("attaching clean JobDate instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IJobDateDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IJobDateDAO) ctx.getBean("JobDateDAO");
	}
}