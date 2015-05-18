package daoImp;

import java.util.List;

import model.JobDetail;

public interface IJobDetailDAO {

	public abstract void save(JobDetail transientInstance);

	public abstract void delete(JobDetail persistentInstance);

	public abstract JobDetail findById(java.lang.Long id);

	public abstract List findByExample(JobDetail instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract JobDetail merge(JobDetail detachedInstance);

	public abstract void attachDirty(JobDetail instance);

	public abstract void attachClean(JobDetail instance);
	
	public abstract List findByProperty(int page,int pageSize,int sex,String type,long areaId,String keyword);

}