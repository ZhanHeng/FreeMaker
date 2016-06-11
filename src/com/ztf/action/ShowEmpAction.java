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

	//调用Service层的方法
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
		//将得到数据 添加到静态的页面中
		Configuration cf = new Configuration();
		cf.setEncoding(Locale.CHINA, "UTF-8");
		cf.setServletContextForTemplateLoading(request.getSession().getServletContext(), "WEB-INF/templates/");
		Map<String,Object> map =new HashMap<String,Object>();
		//获取当前应用的路径
		String path = request.getRealPath("");
		//获取当前工程
		String path1 = request.getContextPath();
		FileOutputStream os=null;
		OutputStreamWriter osw=null;
		Writer out=null;
		try {
			//生成存放静态内容页文件夹
			File outfile    = new File(path+"/emp");                 
			  //如果文件不存在，则创建一个新文件
			  if(!outfile.isFile()){
				  outfile.mkdir();
			}
			for (EmpBean empBean : list) {//生成静态内容页
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
			//生成静态列表
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
