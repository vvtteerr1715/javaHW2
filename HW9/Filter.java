import java.io.File;

public class Filter implements java.io.FilenameFilter
{
  private String extension = null;
  
  public Filter(String paramString)
  {
    extension = ("." + paramString);
  }
  
  public String getExtension() {
    return extension;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(extension);
  }
}