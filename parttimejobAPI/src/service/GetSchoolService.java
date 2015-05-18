package service;

import java.util.List;

import serviceImp.IGetSchoolService;
import model.College;
import model.School;
import daoImp.ISchoolDAO;

public class GetSchoolService implements IGetSchoolService {
	
	private ISchoolDAO schoolDAO;

	/* (non-Javadoc)
	 * @see service.IGetSchoolService#getSchoolDAO()
	 */
	@Override
	public ISchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	/* (non-Javadoc)
	 * @see service.IGetSchoolService#setSchoolDAO(dao.ISchoolDAO)
	 */
	@Override
	public void setSchoolDAO(ISchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}
	
	
	/* (non-Javadoc)
	 * @see service.IGetSchoolService#getAllSchool(long)
	 */
	@Override
	public List getAllSchool(long collegeId)
	{
		College college = new College();
		college.setId(collegeId);
		List schools = schoolDAO.findByProperty("college", college);
		return schools;
	}
	
	/* (non-Javadoc)
	 * @see service.IGetSchoolService#getSchool(long)
	 */
	@Override
	public School getSchool(long id)
	{
		School school = schoolDAO.findById(id);
		return school;
	}

}
