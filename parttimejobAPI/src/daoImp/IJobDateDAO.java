package daoImp;

import java.util.List;

import model.JobDate;

public interface IJobDateDAO {

	public abstract void save(JobDate transientInstance);

	public abstract void delete(JobDate persistentInstance);

	public abstract JobDate findById(java.lang.Long id);

	public abstract List findByExample(JobDate instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract JobDate merge(JobDate detachedInstance);

	public abstract void attachDirty(JobDate instance);

	public abstract void attachClean(JobDate instance);

}