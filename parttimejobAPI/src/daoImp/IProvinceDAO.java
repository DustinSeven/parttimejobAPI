package daoImp;

import java.util.List;

import model.Province;

public interface IProvinceDAO {

	public abstract void save(Province transientInstance);

	public abstract void delete(Province persistentInstance);

	public abstract Province findById(java.lang.Long id);

	public abstract List findByExample(Province instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Province merge(Province detachedInstance);

	public abstract void attachDirty(Province instance);

	public abstract void attachClean(Province instance);

}