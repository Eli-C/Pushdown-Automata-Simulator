package application;

public class FileManager {
	
	private String path;
	private String fileName;
	private int operation;
	private boolean current;
	
	
	public FileManager(String path, String fileName, int operation, boolean current)
	{
		this.path = path;
		this.fileName = fileName;
		this.operation = operation;
		this.current = current;
	}
	

	public String getPath() 
	{
		return path;
	}

	public void setPath(String path) 
	{
		this.path = path;
	}

	public String getFileName() 
	{
		return fileName;
	}

	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public int getOperation() 
	{
		return operation;
	}

	public void setOperation(int operation) 
	{
		this.operation = operation;
	}

	public boolean isCurrent() 
	{
		return current;
	}

	public void setCurrent(boolean current) 
	{
		this.current = current;
	}

}
