package utils;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcel {
	public static Map<String, String> getExcelData(String fileName, String sheetName, String rowId){
		Map<String, String> dataMap = new TreeMap<String, String>();
		String query = null;
		query = String.format("SELECT * FROM %s WHERE FlagYN = 'Y' and TCID = '%s'", sheetName, rowId);
		Fillo fillo = new Fillo();
		Connection con = null;
		Recordset recordSet = null;
		try {
			con = fillo.getConnection(fileName);
			recordSet = con.executeQuery(query);
			while(recordSet.next()) {
				for(String colName:recordSet.getFieldNames()) {
					dataMap.put(colName, recordSet.getField(colName));
				}
			}
		} catch (FilloException e) {
			e.printStackTrace();
		}
		con.close();
		return dataMap;
	}

}
