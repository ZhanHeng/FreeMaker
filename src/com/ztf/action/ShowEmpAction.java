package com.ztf.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ztf.bean.EmpBean;
import com.ztf.service.IEmpService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@SuppressWarnings("serial")
public class ShowEmpAction extends ActionSupport implements ServletRequestAware {

	//����Service��ķ���
	private IEmpService empService;
	private HttpServletRequest request;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	@SuppressWarnings("deprecation")
	public String showEmpInfo(){
		List<EmpBean> list = empService.queryEmp();
		List<EmpBean> list1 = new ArrayList<EmpBean>();
		//���õ����� ��ӵ���̬��ҳ����
		Configuration cf = new Configuration();
		cf.setEncoding(Locale.CHINA, "UTF-8");
		cf.setServletContextForTemplateLoading(request.getSession().getServletContext(), "WEB-INF/templates/");
		Map<String,Object> map =new HashMap<String,Object>();
		//��ȡ��ǰӦ�õ�·��
		String path = request.getRealPath("");
		//��ȡ��ǰ����
		String path1 = request.getContextPath();
		FileOutputStream os=null;
		OutputStreamWriter osw=null;
		Writer out=null;
		try {
			//���ɴ�ž�̬����ҳ�ļ���
			File outfile    = new File(path+"/emp");                 
			  //����ļ������ڣ��򴴽�һ�����ļ�
			  if(!outfile.isFile()){
				  outfile.mkdir();
			}
			for (EmpBean empBean : list) {//���ɾ�̬����ҳ
				Map<String,Object> m =new HashMap<String,Object>();
				Template c= cf.getTemplate("showEmp.html","UTF-8");
				m.put("user", empBean);
				String p="/emp/emp"+empBean.getEmpno()+".html";
				File ff=new File(path+p);
				os=new FileOutputStream(ff);
				osw=new OutputStreamWriter(os,"UTF-8");
				out = new BufferedWriter(osw);
				c.process(m, out);
				empBean.setUrl(path1+p);
				list1.add(empBean);
			}
			//���ɾ�̬�б�
			Template t= cf.getTemplate("showEmpList.html","UTF-8");
			map.put("userList", list1);
			File f=new File(path+"/showUser.html");
			os=new FileOutputStream(f);
			osw=new OutputStreamWriter(os,"UTF-8");
			out = new BufferedWriter(osw);	
			this.setUrl("/showUser.html");
			t.process(map, out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
				osw.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
