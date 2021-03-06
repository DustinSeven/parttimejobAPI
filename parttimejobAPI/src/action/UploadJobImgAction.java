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

import model.JobDetail;
import model.UserAccount;
import model.UserInfo;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class UploadJobImgAction {

	private File jobimage;
	private String jobid;
	private IJobDetailService jobDetailService;

	public File getJobimage() {
		return jobimage;
	}

	public void setJobimage(File jobimage) {
		this.jobimage = jobimage;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}

	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}

	public String execute() {

		try {
			InputStream is = new FileInputStream(jobimage);
			String root = ServletActionContext.getRequest().getRealPath(
					"/jobimage");
			File dir = new File(root);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String fileName = jobid + "&" + System.currentTimeMillis() + ".png";
			File destFile = new File(root, fileName);
			OutputStream os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();

			JobDetail jobDetail = jobDetailService.getJobDetailById(Long
					.parseLong(jobid));
			if (jobDetail != null) {
				jobDetail.setImg("/parttimejobAPI/jobimage/" + fileName);
				jobDetailService.updateJob(jobDetail);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("jobimage", "/parttimejobAPI/jobimage/" + fileName);
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list.add(map);

			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "��ְLogo�޸ĳɹ���");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "��ְLogo�޸�ʧ�ܣ�");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "��ְLogo�޸�ʧ�ܣ�");
			e.printStackTrace();
		}

		return null;
	}
}
