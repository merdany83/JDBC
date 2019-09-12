import utils.DBType;
import utils.DBUtility;

import java.util.List;
import java.util.Map;

public class util_Main {

    public static void main(String[] args) {

        DBUtility.establishConnection(DBType.ORACLE);
        System.out.println(DBUtility.getRowsCount("select * from employees"));

        List<Map<String,Object>> rsLst = DBUtility.runSQLQuery("select * from regions");

       // DBUtility.closeConnections();

        System.out.println(rsLst.toString());

        List<Map<String,Object>> rs1 = DBUtility.runSQLQuery("select * from employees");

        for (Map<String,Object> rowMap:rs1){
            System.out.println("Name: "+rowMap.get("FIRST_NAME")+" "+
                    "Salary: "+" "+rowMap.get("SALARY"));

        }
        DBUtility.closeConnections();
    }


}