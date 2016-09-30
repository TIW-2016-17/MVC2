package javaPackage;
/*
 * DataStore.java
 *
 * Created on 13 de diciembre de 2005, 14:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */



import java.util.*;

/**
 *
 * @author telmoz
 */
public class DataStore {
 
  // HashMap of DataModelBean objects keyed by user name
  private static Map dataMap = new HashMap();

  static {
    dataMap.put("rod", new DataModelBean("Rod", "Johnson",
                                         "rod.johnson@interface21.com"));
    dataMap.put("detective", new DataModelBean("Sherlock", "Holmes",
                                               "supersleuth@221b.co.uk"));
    dataMap.put("watson", new DataModelBean("John", "Watson",
                                            "sidekick@221b.co.uk"));
  }

  // Creates new DataStore
  public DataStore() {
  }

  public DataModelBean getInfo(String username) {
    return (DataModelBean) dataMap.get(username);
  }
}