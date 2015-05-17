package com.agarextend.app;

import java.util.*;
import java.io.*;
public class FilePaths 
{  
   private Map<String, File[]> storage = new HashMap<String, File[]>();
   public FilePaths()
   {
      File [] p = new File[15];
      File [] h = new File[15];
      File [] user = new File[15];
      for(int i = 3; i < 12; i++)
      {
         p[i] = new File ("C:/Sites/Awe_Inspiring_maven_hacktj_2015/src/main/java/com/agarextend/app/" + i + "p.png");
         h[i] = new File ("C:/Sites/Awe_Inspiring_maven_hacktj_2015/src/main/java/com/agarextend/app/" + i + "h.png");
         user[i] = new File ("C:/Sites/Awe_Inspiring_maven_hacktj_2015/src/main/java/com/agarextend/app/" + i + ".png");
      }
      storage.put("pred", p);
      storage.put("herb", h);
      storage.put("user", user);
   }
   public Map<String, File[]> getMap()
   {
      return storage;
   }
   public File path(String type, int numsides)
   {
      return getMap().get(type)[numsides];
   }
   public String toString(String type, int numsides)
   {
      return getMap().get(type)[numsides].toString();
   }
}