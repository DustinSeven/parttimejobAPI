package dao;
// default package

import java.util.List;

import model.School;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.ISchoolDAO;

/**
 	* A data access object (DAO) providing persistence and search support for School entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .School
  * @author MyEclipse Persistence Tools 
 */

public class SchoolDAO extends HibernateDaoSupport implements ISchoolDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SchoolDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.ISchoolDAO#save(model.School)
	 */
    @Override
	public void save(School transientInstance) {
        log.debug("saving School instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.ISchoolDAO#delete(model.School)
	 */
	@Override
	public void delete(School persistentInstance) {
        log.debug("deleting School instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ISchoolDAO#findById(java.lang.Long)
	 */
    @Override
	public School findById( java.lang.Long id) {
        log.debug("getting School instance with id: " + id);
        try {
            School instance = (School) getHibernateTemplate()
                    .get("School", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.ISchoolDAO#findByExample(model.School)
	 */
    @Override
	public List findByExample(School instance) {
        log.debug("finding School instance by example");
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
	 * @see dao.ISchoolDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding School instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from School as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.ISchoolDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all School instances");
		try {
			String queryString = "from School";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.ISchoolDAO#merge(model.School)
	 */
    @Override
	public School merge(School detachedInstance) {
        log.debug("merging School instance");
        try {
            School result = (School) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.ISchoolDAO#attachDirty(model.School)
	 */
    @Override
	public void attachDirty(School instance) {
        log.debug("attaching dirty School instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ISchoolDAO#attachClean(model.School)
	 */
    @Override
	public void attachClean(School instance) {
        log.debug("attaching clean School instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ISchoolDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ISchoolDAO) ctx.getBean("SchoolDAO");
	}
}