package service;

import java.util.List;

import serviceImp.IGetCityService;

import model.City;
import model.Province;

import daoImp.ICityDAO;

public class GetCityService implements IGetCityService {
	
	private ICityDAO cityDAO;

	/* (non-Javadoc)
	 * @see service.IGetCityService#getCityDAO()
	 */
	@Override
	public ICityDAO getCityDAO() {
		return cityDAO;
	}

	/* (non-Javadoc)
	 * @see service.IGetCityService#setCityDAO(dao.ICityDAO)
	 */
	@Override
	public void setCityDAO(ICityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IGetCityService#getCity(long)
	 */
	@Override
	public List getCity(long pcode)
	{
		Province province = new Province();
		province.setCode(pcode);
		List citys = cityDAO.findByProperty("province", province);
		return citys;
	}
	public City getCityById(String code)
	{
		return (City) cityDAO.findByProperty("code", code).get(0);
	}

}
