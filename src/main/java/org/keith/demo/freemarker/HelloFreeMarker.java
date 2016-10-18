package org.keith.demo.freemarker;

import java.util.*;
import java.io.*;
import freemarker.template.*;

public class HelloFreeMarker {

	private Configuration cfg;

	public void init() throws Exception {
		// 初始化FreeMarker配置
		// 创建一个Configuration实例
		cfg = new Configuration();
		// 设置FreeMarker的模版文件位置
		File file = new File("templates");
		if(!file.exists()) {
			file.mkdirs();
		}
		cfg.setDirectoryForTemplateLoading(file);
	}

	public void process() throws Exception {
		Map root = new HashMap();
		root.put("name", "FreeMarker!");
		root.put("msg", "您已经完成了第一个FreeMarker的示例");
		Template t = cfg.getTemplate("test.html");
		t.process(root, new OutputStreamWriter(System.out));
		
		//HttpCopyWrapper newrequest = new HttpCopyWrapper(request); 
		//String pagename=("/goods-"+goodsid+".html");
		//newrequest.setServletPath(pagename);
		//ThreadContextHolder.setHttpRequest(newrequest);
		
		//t.process(mapData, ThreadContextHolder.getHttpResponse().getWriter());
	}

	public static void main(String[] args) throws Exception {
		HelloFreeMarker hf = new HelloFreeMarker();
		hf.init();
		hf.process();
	}
}
