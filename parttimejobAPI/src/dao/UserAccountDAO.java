package dao;

// default package

import java.util.List;

import model.UserAccount;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IUserAccountDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserAccount entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .UserAccount
 * @author MyEclipse Persistence Tools
 */

public class UserAccountDAO extends HibernateDaoSupport implements IUserAccountDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserAccountDAO.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#save(model.UserAccount)
	 */
	@Override
	public void save(UserAccount transientInstance) {
		log.debug("saving UserAccount instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#delete(model.UserAccount)
	 */
	@Override
	public void delete(UserAccount persistentInstance) {
		log.debug("deleting UserAccount instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#findById(java.lang.Long)
	 */
	@Override
	public UserAccount findById(java.lang.Long id) {
		log.debug("getting UserAccount instance with id: " + id);
		try {
			UserAccount instance = (UserAccount) getHibernateTemplate().get(
					"model.UserAccount", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#findByExample(model.UserAccount)
	 */
	@Override
	public List findByExample(UserAccount instance) {
		log.debug("finding UserAccount instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserAccount instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserAccount as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all UserAccount instances");
		try {
			String queryString = "from UserAccount";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#merge(model.UserAccount)
	 */
	@Override
	public UserAccount merge(UserAccount detachedInstance) {
		log.debug("merging UserAccount instance");
		try {
			UserAccount result = (UserAccount) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			getHibernateTemplate().flush();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.IUserAccountDAO#attachDirty(model.UserAccount)
	 */
	@Override
	public void attachDirty(UserAccount instance) {
		log.debug("attaching dirty UserAccount instance");
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
	 * @see dao.IUserAccountDAO#attachClean(model.UserAccount)
	 */
	@Override
	public void attachClean(UserAccount instance) {
		log.debug("attaching clean UserAccount instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IUserAccountDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IUserAccountDAO) ctx.getBean("UserAccountDAO");
	}
}