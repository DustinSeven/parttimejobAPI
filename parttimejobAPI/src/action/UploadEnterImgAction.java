package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.EnterpriseAccount;
import model.EnterpriseInfo;
import model.UserAccount;
import model.UserInfo;

import org.apache.struts2.ServletActionContext;

import serviceImp.IEnterpriseLoginService;
import serviceImp.ILoginService;
import serviceImp.IUserInfoService;
import tool.ResultUtil;

public class UploadEnterImgAction {

	private File userimage;
	private IEnterpriseLoginService enterpriseLoginService;
	private String mobile;
	private String pwd;
	
	

	public File getUserimage() {
		return userimage;
	}



	public void setUserimage(File userimage) {
		this.userimage = userimage;
	}



	public IEnterpriseLoginService getEnterpriseLoginService() {
		return enterpriseLoginService;
	}



	public void setEnterpriseLoginService(
			IEnterpriseLoginService enterpriseLoginService) {
		this.enterpriseLoginService = enterpriseLoginService;
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



	public String execute() {

		EnterpriseAccount tmpAccount = new EnterpriseAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);

		String result = enterpriseLoginService.checkAccount(tmpAccount);

		if (result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "�������");
		else if (result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "�û��˺Ų����ڣ�");
		else {
			try {
				InputStream is = new FileInputStream(userimage);
				String root = ServletActionContext.getRequest().getRealPath(
						"/enterimage");
				File dir = new File(root);
				if (!dir.exists()) {
					dir.mkdir();
				}
				String fileName = mobile + "&" + System.currentTimeMillis()
						+ ".png";
				File destFile = new File(root, fileName);
				OutputStream os = new FileOutputStream(destFile);
				byte[] buffer = new byte[400];
				int length = 0;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				is.close();
				os.close();

				EnterpriseAccount account = enterpriseLoginService
						.getAccount(tmpAccount);
				EnterpriseInfo userInfo = enterpriseLoginService
						.getEnterpriseInfo(String.valueOf(account.getEnterpriseid()));
				if (userInfo != null) {
					userInfo.setImg("/parttimejobAPI/enterimage/" + fileName);
					enterpriseLoginService.updateUserInfo(userInfo);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userimage", "/parttimejobAPI/enterimage/" + fileName);
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				list.add(map);

				ResultUtil.returnJsonWithCode200(
						ServletActionContext.getResponse(), list, "ͷ���޸ĳɹ���");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				ResultUtil.returnJsonWithCode500(
						ServletActionContext.getResponse(), null, "ͷ���޸�ʧ�ܣ�");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				ResultUtil.returnJsonWithCode500(
						ServletActionContext.getResponse(), null, "ͷ���޸�ʧ�ܣ�");
				e.printStackTrace();
			}
		}

		return null;
	}
}
