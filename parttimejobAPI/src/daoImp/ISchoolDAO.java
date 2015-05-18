package daoImp;

import java.util.List;

import model.School;

public interface ISchoolDAO {

	public abstract void save(School transientInstance);

	public abstract void delete(School persistentInstance);

	public abstract School findById(java.lang.Long id);

	public abstract List findByExample(School instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract School merge(School detachedInstance);

	public abstract void attachDirty(School instance);

	public abstract void attachClean(School instance);

}