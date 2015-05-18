package daoImp;

import java.util.List;

import model.Area;

public interface IAreaDAO {

	public abstract void save(Area transientInstance);

	public abstract void delete(Area persistentInstance);

	public abstract Area findById(java.lang.Long id);

	public abstract List findByExample(Area instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Area merge(Area detachedInstance);

	public abstract void attachDirty(Area instance);

	public abstract void attachClean(Area instance);

}