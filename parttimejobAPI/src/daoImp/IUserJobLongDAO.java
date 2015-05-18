package daoImp;

import java.util.List;

import model.UserJobLong;

public interface IUserJobLongDAO {

	public abstract void save(UserJobLong transientInstance);

	public abstract void delete(UserJobLong persistentInstance);

	public abstract UserJobLong findById(java.lang.Long id);

	public abstract List findByExample(UserJobLong instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract UserJobLong merge(UserJobLong detachedInstance);

	public abstract void attachDirty(UserJobLong instance);

	public abstract void attachClean(UserJobLong instance);

}