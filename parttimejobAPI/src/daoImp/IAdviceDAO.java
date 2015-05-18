package daoImp;

import java.util.List;

import model.Advice;

public interface IAdviceDAO {

	public abstract void save(Advice transientInstance);

	public abstract void delete(Advice persistentInstance);

	public abstract Advice findById(java.lang.Long id);

	public abstract List findByExample(Advice instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Advice merge(Advice detachedInstance);

	public abstract void attachDirty(Advice instance);

	public abstract void attachClean(Advice instance);

}