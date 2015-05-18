package service;

import java.util.List;

import serviceImp.IJobTypeService;

import daoImp.IJobTypeDAO;

public class JobTypeService implements IJobTypeService {
	
	private IJobTypeDAO jobTypeDAO;

	/* (non-Javadoc)
	 * @see service.IJobTypeService#getJobTypeDAO()
	 */
	@Override
	public IJobTypeDAO getJobTypeDAO() {
		return jobTypeDAO;
	}

	/* (non-Javadoc)
	 * @see service.IJobTypeService#setJobTypeDAO(dao.IJobTypeDAO)
	 */
	@Override
	public void setJobTypeDAO(IJobTypeDAO jobTypeDAO) {
		this.jobTypeDAO = jobTypeDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IJobTypeService#getAllJobTyop()
	 */
	@Override
	public List getAllJobTyop()
	{
		List jobTypes = jobTypeDAO.findAll();
		return jobTypes;
	}

}
