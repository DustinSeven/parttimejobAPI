package daoImp;

import java.util.List;

import model.City;

public interface ICityDAO {

	public abstract void save(City transientInstance);

	public abstract void delete(City persistentInstance);

	public abstract City findById(java.lang.Long id);

	public abstract List findByExample(City instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract City merge(City detachedInstance);

	public abstract void attachDirty(City instance);

	public abstract void attachClean(City instance);

}