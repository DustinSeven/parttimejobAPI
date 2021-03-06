package service;

import java.util.List;

import serviceImp.IEnterpriseLoginService;

import model.EnterpriseAccount;
import model.EnterpriseInfo;
import model.UserAccount;
import model.UserInfo;
import model.UserSetting;
import daoImp.IEnterpriseAccountDAO;
import daoImp.IEnterpriseInfoDAO;

public class EnterpriseLoginService implements IEnterpriseLoginService {
	
	private IEnterpriseAccountDAO enterpriseAccountDAO;
	private IEnterpriseInfoDAO enterpriseInfoDAO;
	

	public IEnterpriseInfoDAO getEnterpriseInfoDAO() {
		return enterpriseInfoDAO;
	}

	public void setEnterpriseInfoDAO(IEnterpriseInfoDAO enterpriseInfoDAO) {
		this.enterpriseInfoDAO = enterpriseInfoDAO;
	}

	/* (non-Javadoc)
	 * @see service.IEnterpriseLoginService#getEnterpriseAccountDAO()
	 */
	@Override
	public IEnterpriseAccountDAO getEnterpriseAccountDAO() {
		return enterpriseAccountDAO;
	}

	/* (non-Javadoc)
	 * @see service.IEnterpriseLoginService#setEnterpriseAccountDAO(daoImp.IEnterpriseAccountDAO)
	 */
	@Override
	public void setEnterpriseAccountDAO(IEnterpriseAccountDAO enterpriseAccountDAO) {
		this.enterpriseAccountDAO = enterpriseAccountDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IEnterpriseLoginService#checkAccount(model.UserAccount)
	 */
	@Override
	public String checkAccount (EnterpriseAccount account)
	{
		
		List accountList = enterpriseAccountDAO.findByProperty("mobile", account.getMobile());
		if(accountList.size() == 0)
			return "mobile wrong";
		for(int i = 0;i<accountList.size();++i)
		{
			EnterpriseAccount tmpAccount = (EnterpriseAccount)accountList.get(i);
			if(tmpAccount.getPassword().equals(account.getPassword()))
				return String.valueOf(tmpAccount.getEnterpriseid());
		}
		return "password wrong";
	}
	
	public EnterpriseInfo getEnterpriseInfo(String id)
	{
		return enterpriseInfoDAO.findById(Long.parseLong(id));
	}
	
	public boolean addAccount(EnterpriseAccount account)
	{
		if(enterpriseAccountDAO.findByProperty("mobile", account.getMobile()).size() == 0)
		{
			enterpriseAccountDAO.save(account);
			
			EnterpriseAccount enter = (EnterpriseAccount) enterpriseAccountDAO.findByProperty("mobile",  account.getMobile()).get(0);
			EnterpriseInfo info = new EnterpriseInfo();
			info.setEnterpriseid(enter.getEnterpriseid());
			enterpriseInfoDAO.save(info);
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void changePwd(EnterpriseAccount Account)
	{
		enterpriseAccountDAO.merge(Account);
	}

	public EnterpriseAccount getAccount (EnterpriseAccount account)
	{
		
		List accountList = enterpriseAccountDAO.findByProperty("mobile", account.getMobile());
		if(accountList.size() == 0)
			return null;
		for(int i = 0;i<accountList.size();++i)
		{
			EnterpriseAccount tmpAccount = (EnterpriseAccount)accountList.get(i);
			if(tmpAccount.getPassword().equals(account.getPassword()))
				return (EnterpriseAccount) accountList.get(0);
		}
		return null;
	}
	
	public void updateUserInfo(EnterpriseInfo userInfo)
	{
//		System.out.print(userInfo.getEnterpriseid() + " "+userInfo.getAccount()+" "+userInfo.getImg());
		enterpriseInfoDAO.attachDirty(userInfo);
	}
}
