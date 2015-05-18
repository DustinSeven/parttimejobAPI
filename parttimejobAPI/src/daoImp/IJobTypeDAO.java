package daoImp;

import java.util.List;

import model.JobType;

public interface IJobTypeDAO {

	public abstract void save(JobType transientInstance);

	public abstract void delete(JobType persistentInstance);

	public abstract JobType findById(java.lang.Long id);

	public abstract List findByExample(JobType instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract JobType merge(JobType detachedInstance);

	public abstract void attachDirty(JobType instance);

	public abstract void attachClean(JobType instance);

}