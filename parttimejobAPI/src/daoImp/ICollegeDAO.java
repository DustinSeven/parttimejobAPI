package daoImp;

import java.util.List;

import model.College;

public interface ICollegeDAO {

	public abstract void save(College transientInstance);

	public abstract void delete(College persistentInstance);

	public abstract College findById(java.lang.Long id);

	public abstract List findByExample(College instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract College merge(College detachedInstance);

	public abstract void attachDirty(College instance);

	public abstract void attachClean(College instance);

}