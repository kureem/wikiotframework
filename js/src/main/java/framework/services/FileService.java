package framework.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import framework.util.IOUtil;
import jsweet.lang.Array;
import jsweet.lang.JSON;

public class FileService {

	private String registryFileName = "registry.reg";

	private Array<jsweet.lang.Object> registry = null;
	
	private  static FileService instance = null;
	
	public static FileService getInstance()throws Exception{
		if(instance == null){
			instance = new FileService();
			instance.init();
		}
		return instance;
	}
	
	private FileService (){
		
	}

	private void init() throws Exception {
		if (registry == null) {
			registry = new Array<jsweet.lang.Object>();
			File reg = new File(registryFileName);
			if (!reg.exists()) {
				reg.createNewFile();
				FileOutputStream fout = new FileOutputStream(reg);
				fout.write(JSON.stringify(registry).getBytes());
				fout.flush();
				fout.close();
			}
		}
	}

	
	public void addObject(String name, Object o)throws Exception{
		String content = JSON.stringify(o);
		IOUtil.writeToFile(content, new File(name));
	}
	
	public void flush()throws Exception{
		String content = JSON.stringify(registry);
		File f = new File(registryFileName);
		FileOutputStream fout = new FileOutputStream(f,false);
		fout.write(content.getBytes());
		fout.flush();
		fout.close();
	}
	
	public String readFile(String name)throws Exception{
		File f = new File(name);
		if(f.exists()){
			FileInputStream in = new FileInputStream(f);
			byte[] buf = new byte[in.available()];
			in.read(buf);
			return new String(buf);
		}
		return null;
	}
	
	public void addFile(String name, String content) throws Exception {
		init();
		jsweet.lang.Object obj = new jsweet.lang.Object();
		obj.$set("name", name);
		obj.$set("size", content.getBytes().length);
		registry.push(obj);
		createFile(name, content);
		
		flush();
	}
	
	protected void createFile(String name, String content)throws Exception{
		File f = new File(name);
		if(!f.exists()){
			f.createNewFile();
		}
		
		IOUtil.writeToFile(content, f);
	}

	public void deleteFile(String name) throws Exception {
		init();
		Array<jsweet.lang.Object> tmp = new Array<jsweet.lang.Object>();
		for (jsweet.lang.Object s : registry) {
			if (s.$get("name").equals(name)) {

			} else {
				tmp.push(s);
			}
		}

		registry = tmp;
		
		File f = new File(name);
		if(f.exists()){
			f.delete();
		}
		flush();
	}
	
	public List<FileDefinition> getFiles()throws Exception{
		init();
		List<FileDefinition> result = new LinkedList<>();
		List<String> removed = new LinkedList<>();
		for(jsweet.lang.Object obj : registry){
			String name  = obj.$get("name").toString();
			String size = obj.$get("size").toString();
			File f = new File(name);
			if(f.exists()){
				FileDefinition def = new FileDefinition();
				def.setName(name);
				def.setSize(size);
				result.add(def);
			}else{
				removed.add(name);
			}
		}
		
		for(String s : removed){
			deleteFile(s);
		}
		
		return result;
	}
	
	
	public class FileDefinition{
		
		private String name;
		
		private String size;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}
		
		
	}

}
