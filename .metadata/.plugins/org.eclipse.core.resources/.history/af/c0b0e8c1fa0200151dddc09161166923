package dao;

// default package

import java.util.List;

import model.EnterpriseAccount;
import model.JobDetail;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import daoImp.IJobDetailDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * JobDetail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .JobDetail
 * @author MyEclipse Persistence Tools
 */

public class JobDetailDAO extends HibernateDaoSupport implements IJobDetailDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JobDetailDAO.class);

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#save(model.JobDetail)
	 */
	@Override
	public void save(JobDetail transientInstance) {
		log.debug("saving JobDetail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			getHibernateTemplate().flush();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#delete(model.JobDetail)
	 */
	@Override
	public void delete(JobDetail persistentInstance) {
		log.debug("deleting JobDetail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#findById(java.lang.Long)
	 */
	@Override
	public JobDetail findById(java.lang.Long id) {
		log.debug("getting JobDetail instance with id: " + id);
		try {
			JobDetail instance = (JobDetail) getHibernateTemplate().get(
					"model.JobDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(int page,int pageSize,int sex,String type,long areaId,String keyword) {

		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session.createQuery("from JobDetail");
		int startRow = (page - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List message = query.list();
		session.close();
		
		for(int i = 0;i<message.size();++i)
		{
			JobDetail jobDetail = (JobDetail)message.get(i);
			if((sex != 0 && jobDetail.getSex() != sex) || (type!=null && !type.equals(String.valueOf(jobDetail.getJobType().getJobtypeid()))) || (areaId > 0 && areaId != jobDetail.getArea().getCode()) || (keyword != null && !jobDetail.getName().contains(keyword)))
			{
				message.remove(i);
				i--;
			}
		}
		return message;
	}
	
	public List findByProperty(int page,int pageSize,long enterId) {

		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		EnterpriseAccount enter = new EnterpriseAccount();
		enter.setEnterpriseid(enterId);
		Query query = session.createQuery("from JobDetail where enterpriseAccount = ?");
		query.setEntity(0, enter);
		int startRow = (page - 1) * pageSize;
		query.setFirstResult(startRow); 
		query.setMaxResults(pageSize);
		List message = query.list();
		session.close();
		
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#findByExample(model.JobDetail)
	 */
	@Override
	public List findByExample(JobDetail instance) {
		log.debug("finding JobDetail instance by example");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding JobDetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from JobDetail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all JobDetail instances");
		try {
			String queryString = "from JobDetail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#merge(model.JobDetail)
	 */
	@Override
	public JobDetail merge(JobDetail detachedInstance) {
		log.debug("merging JobDetail instance");
		try {
			JobDetail result = (JobDetail) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#attachDirty(model.JobDetail)
	 */
	@Override
	public void attachDirty(JobDetail instance) {
		log.debug("attaching dirty JobDetail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
			getHibernateTemplate().flush();
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IJobDetailDAO#attachClean(model.JobDetail)
	 */
	@Override
	public void attachClean(JobDetail instance) {
		log.debug("attaching clean JobDetail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IJobDetailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IJobDetailDAO) ctx.getBean("JobDetailDAO");
	}

	
}