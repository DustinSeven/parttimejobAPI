package service;

import java.util.List;

import serviceImp.IGetCollegeService;

import model.College;
import model.Province;
import daoImp.ICollegeDAO;

public class GetCollegeService implements IGetCollegeService {
	
	private ICollegeDAO collegeDAO;

	/* (non-Javadoc)
	 * @see service.IGetCollegeService#getCollegeDAO()
	 */
	@Override
	public ICollegeDAO getCollegeDAO() {
		return collegeDAO;
	}

	/* (non-Javadoc)
	 * @see service.IGetCollegeService#setCollegeDAO(dao.ICollegeDAO)
	 */
	@Override
	public void setCollegeDAO(ICollegeDAO collegeDAO) {
		this.collegeDAO = collegeDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IGetCollegeService#getCollegeById(long)
	 */
	@Override
	public College getCollegeById(long collegeId)
	{
		College college = collegeDAO.findById(collegeId);
		return college;
	}
	
	/* (non-Javadoc)
	 * @see service.IGetCollegeService#getCollege(java.lang.String)
	 */
	@Override
	public List getCollege(long provinceId)
	{
		Province province = new Province();
		province.setCode(provinceId);
		List colleges = collegeDAO.findByProperty("province", province);
		return colleges;
	}

}
