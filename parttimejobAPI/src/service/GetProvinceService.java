package service;

import java.util.List;

import serviceImp.IGetProvinceService;

import daoImp.IProvinceDAO;
import model.Province;

public class GetProvinceService implements IGetProvinceService {
	
	private IProvinceDAO provinceDAO;

	/* (non-Javadoc)
	 * @see service.IGetProvinceService#getProvinceDAO()
	 */
	@Override
	public IProvinceDAO getProvinceDAO() {
		return provinceDAO;
	}

	/* (non-Javadoc)
	 * @see service.IGetProvinceService#setProvinceDAO(dao.IProvinceDAO)
	 */
	@Override
	public void setProvinceDAO(IProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IGetProvinceService#getAllProvince()
	 */
	@Override
	public List getAllProvince()
	{
		List provinces = provinceDAO.findAll();
		return provinces;
	}
	public Province getProvinceById(String code)
	{
		return (Province) provinceDAO.findByProperty("code", code).get(0);
	}

}
