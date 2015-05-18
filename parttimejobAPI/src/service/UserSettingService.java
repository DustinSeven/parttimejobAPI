package service;

import serviceImp.IUserSettingService;
import model.UserAccount;
import model.UserSetting;
import daoImp.*;

public class UserSettingService implements IUserSettingService {
	
	private IUserSettingDAO userSettingDAO;

	/* (non-Javadoc)
	 * @see service.IUserSettingService#getUserSettingDAO()
	 */
	@Override
	public IUserSettingDAO getUserSettingDAO() {
		return userSettingDAO;
	}

	/* (non-Javadoc)
	 * @see service.IUserSettingService#setUserSettingDAO(daoImp.IUserSettingDAO)
	 */
	@Override
	public void setUserSettingDAO(IUserSettingDAO userSettingDAO) {
		this.userSettingDAO = userSettingDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IUserSettingService#getUserPrivacy(long)
	 */
	@Override
	public int getUserPrivacy(long userId)
	{
		UserSetting userSetting = userSettingDAO.findById(userId);
		return userSetting.getPrivacy();
	}
	
	/* (non-Javadoc)
	 * @see service.IUserSettingService#setUserPrivacy(int, long)
	 */
	@Override
	public void setUserPrivacy(int privacy,long userId)
	{
		UserSetting userSetting = userSettingDAO.findById(userId);
		userSetting.setPrivacy(privacy);
		userSettingDAO.attachDirty(userSetting);
	}

}
