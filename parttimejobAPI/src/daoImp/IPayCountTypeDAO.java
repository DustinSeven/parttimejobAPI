package daoImp;

import java.util.List;

import model.PayCountType;

public interface IPayCountTypeDAO {

	public abstract void save(PayCountType transientInstance);

	public abstract void delete(PayCountType persistentInstance);

	public abstract PayCountType findById(java.lang.Long id);

	public abstract List findByExample(PayCountType instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract PayCountType merge(PayCountType detachedInstance);

	public abstract void attachDirty(PayCountType instance);

	public abstract void attachClean(PayCountType instance);

}