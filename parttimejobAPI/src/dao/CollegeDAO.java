package dao;
// default package

import java.util.List;

import model.College;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.ICollegeDAO;

/**
 	* A data access object (DAO) providing persistence and search support for College entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .College
  * @author MyEclipse Persistence Tools 
 */

public class CollegeDAO extends HibernateDaoSupport implements ICollegeDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CollegeDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.ICollegeDAO#save(model.College)
	 */
    @Override
	public void save(College transientInstance) {
        log.debug("saving College instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.ICollegeDAO#delete(model.College)
	 */
	@Override
	public void delete(College persistentInstance) {
        log.debug("deleting College instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ICollegeDAO#findById(java.lang.Long)
	 */
    @Override
	public College findById( java.lang.Long id) {
        log.debug("getting College instance with id: " + id);
        try {
            College instance = (College) getHibernateTemplate()
                    .get("College", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.ICollegeDAO#findByExample(model.College)
	 */
    @Override
	public List findByExample(College instance) {
        log.debug("finding College instance by example");
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
	 * @see dao.ICollegeDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding College instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from College as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.ICollegeDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all College instances");
		try {
			String queryString = "from College";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.ICollegeDAO#merge(model.College)
	 */
    @Override
	public College merge(College detachedInstance) {
        log.debug("merging College instance");
        try {
            College result = (College) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.ICollegeDAO#attachDirty(model.College)
	 */
    @Override
	public void attachDirty(College instance) {
        log.debug("attaching dirty College instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ICollegeDAO#attachClean(model.College)
	 */
    @Override
	public void attachClean(College instance) {
        log.debug("attaching clean College instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ICollegeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ICollegeDAO) ctx.getBean("CollegeDAO");
	}
}