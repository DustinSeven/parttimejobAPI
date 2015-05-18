package service;

import java.util.List;

import serviceImp.IGetAreaService;

import model.Area;
import model.City;

import daoImp.IAreaDAO;

public class GetAreaService implements IGetAreaService {
	
	private IAreaDAO areaDAO;

	/* (non-Javadoc)
	 * @see service.IGetAreaService#getAreaDAO()
	 */
	@Override
	public IAreaDAO getAreaDAO() {
		return areaDAO;
	}

	/* (non-Javadoc)
	 * @see service.IGetAreaService#setAreaDAO(dao.IAreaDAO)
	 */
	@Override
	public void setAreaDAO(IAreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IGetAreaService#getCity(long)
	 */
	@Override
	public List getArea(long ccode)
	{
		City city = new City();
		city.setCode(ccode);
		List areas = areaDAO.findByProperty("city", city);
		return areas;
	}
	
	public Area getAreaById(String code)
	{
		return (Area) areaDAO.findByProperty("code", code).get(0);
	}

}
