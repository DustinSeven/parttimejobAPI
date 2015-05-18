package daoImp;

import java.util.List;

import model.UserJobShort;

public interface IUserJobShortDAO {

	public abstract void save(UserJobShort transientInstance);

	public abstract void delete(UserJobShort persistentInstance);

	public abstract UserJobShort findById(java.lang.Long id);

	public abstract List findByExample(UserJobShort instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract UserJobShort merge(UserJobShort detachedInstance);

	public abstract void attachDirty(UserJobShort instance);

	public abstract void attachClean(UserJobShort instance);

}