import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.DBType;
import utils.DBUtility;

import java.util.List;
import java.util.Map;

public class DB_Test {

    @BeforeClass
    public static void   setUp(){

        DBUtility.establishConnection(DBType.ORACLE);
    }
    @Test
    public void test1(){

        System.out.println("checking 3rd region is Asia");
        List<Map<String, Object>> lstOfMap = DBUtility.runSQLQuery("SELECT * FROM REGIONS");
        String expected="Asia";
        String actual = (String) lstOfMap.get(2).get("REGION_NAME");
        Assert.assertEquals("Asia", lstOfMap.get(2).get("REGION_NAME"));

   if(expected.equals(actual)){
       System.out.println("passed");
   }  }

    @AfterClass
    public static void tearDown(){
        DBUtility.closeConnections();
    }
}