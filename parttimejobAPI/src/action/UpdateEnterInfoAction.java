package action;

import model.Area;
import model.City;
import model.College;
import model.EnterpriseAccount;
import model.EnterpriseInfo;
import model.Province;
import model.School;
import model.UserAccount;
import model.UserInfo;

import org.apache.struts2.ServletActionContext;

import serviceImp.IEnterpriseLoginService;
import tool.ResultUtil;

public class UpdateEnterInfoAction 
{
	private String id;
	private String name;
	private String company;
	private String mobile;
	private String pwd;
	private String qq;
	private String email;
	private String sex;
	private IEnterpriseLoginService enterpriseLoginService;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public IEnterpriseLoginService getEnterpriseLoginService() {
		return enterpriseLoginService;
	}
	public void setEnterpriseLoginService(
			IEnterpriseLoginService enterpriseLoginService) {
		this.enterpriseLoginService = enterpriseLoginService;
	}
	
	public String execute() {
		EnterpriseAccount tmpAccount = new EnterpriseAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);
		
		String result = enterpriseLoginService.checkAccount(tmpAccount);

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"密码错误！");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"用户账号不存在！");
		else
		{
			EnterpriseInfo info = enterpriseLoginService.getEnterpriseInfo(id);
			if(name != null)
				info.setAccount(name);
			if(company != null)
				info.setCompany(company);
			if(email != null)
				info.setEmail(email);
			if(sex != null)
				info.setSex(Integer.parseInt(sex));
			if(qq != null)
				info.setQq(qq);
			
			enterpriseLoginService.updateUserInfo(info);
			
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), null,"修改成功！");
		}
		
		return null;
	}
}
