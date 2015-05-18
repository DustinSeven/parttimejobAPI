package dao;
// default package

import java.util.List;

import model.JobType;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IJobTypeDAO;

/**
 	* A data access object (DAO) providing persistence and search support for JobType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JobType
  * @author MyEclipse Persistence Tools 
 */

public class JobTypeDAO extends HibernateDaoSupport implements IJobTypeDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JobTypeDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IJobTypeDAO#save(model.JobType)
	 */
    @Override
	public void save(JobType transientInstance) {
        log.debug("saving JobType instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IJobTypeDAO#delete(model.JobType)
	 */
	@Override
	public void delete(JobType persistentInstance) {
        log.debug("deleting JobType instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IJobTypeDAO#findById(java.lang.Long)
	 */
    @Override
	public JobType findById( java.lang.Long id) {
        log.debug("getting JobType instance with id: " + id);
        try {
            JobType instance = (JobType) getHibernateTemplate()
                    .get("JobType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IJobTypeDAO#findByExample(model.JobType)
	 */
    @Override
	public List findByExample(JobType instance) {
        log.debug("finding JobType instance by example");
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
	 * @see dao.IJobTypeDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding JobType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JobType as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.IJobTypeDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all JobType instances");
		try {
			String queryString = "from JobType";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IJobTypeDAO#merge(model.JobType)
	 */
    @Override
	public JobType merge(JobType detachedInstance) {
        log.debug("merging JobType instance");
        try {
            JobType result = (JobType) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IJobTypeDAO#attachDirty(model.JobType)
	 */
    @Override
	public void attachDirty(JobType instance) {
        log.debug("attaching dirty JobType instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IJobTypeDAO#attachClean(model.JobType)
	 */
    @Override
	public void attachClean(JobType instance) {
        log.debug("attaching clean JobType instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IJobTypeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IJobTypeDAO) ctx.getBean("JobTypeDAO");
	}
}