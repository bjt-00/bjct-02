package com.bitguiders.ocejwcd6._10_jdbc_jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCConnectivity {

	  String user    = "db2inst1";
	  String password= "feb24joy";
	  String host="host:post/database";
	//  String msAccessConnectionURL  = "JDBC:ODBC:Driver={MicroSoft Access Driver (*.mdb)};DBQ= resources/academy_db.mdb";
	  String db2ConnectionURL  = "jdbc:db2://blueidt1.boulder.ibm.com:50001/BLUEID:retrieveMessagesFromServerOnGetMessage=true;";
	  int errorCount=0;
	  private Connection connection;
	  private Statement  statement;
	  private ResultSet  resultset;
	  
	  public JDBCConnectivity(String host,String user,String password){
		  this.host =  host;
		  this.user =  user;
		  this.password = password;
	  }
	  public boolean dbConnect()
	  {
	    try 
	    {
	      db2ConnectionURL ="jdbc:db2://"+host+":retrieveMessagesFromServerOnGetMessage=true;";
	      Class.forName("com.ibm.db2.jcc.DB2Driver");//"sun.jdbc.odbc.JdbcOdbcDriver");
	      connection = DriverManager.getConnection(db2ConnectionURL,user,password);
	      statement = connection.createStatement();
	      return true;
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    	e.printStackTrace();
	    	return false;
	        //JOptionPane.showMessageDialog(null,e.getMessage());
	    }
	  }
	  
	  public ResultSet executeQuery(String query)
	  {    
	   try
	   {
//		   System.out.println("Executing SQL: "+query);
	   resultset = statement.executeQuery(query);
	   }
	   catch(SQLException sqlex)
	   {
		   System.out.println(sqlex.getMessage());
	    //JOptionPane.showMessageDialog(null,sqlex.getMessage());
	   }   
	   return resultset;
	  }

	    public void executeUpdate(String query)
	    {    
	     try
	     {
	     statement.executeUpdate(query);
	     }
	     catch(SQLException sqlex)
	     {
	    	 System.out.println(query+" "+sqlex.getMessage());
	    	 errorCount++;
	     }   
	    }

	    public void executeUpdateTransaction(int savePointLoc,String... queries) throws SQLException
	    {    
	    	Savepoint savePoint=null;
	    	int savePointCounter =1;
	     try
	     {
	    	 connection.setAutoCommit(false);
	    	 statement = connection.createStatement();
	    	 
	    	 //execute transaction
		    	for(String query:queries){ 
		    		
		    		statement.executeUpdate(query);
		    			if(savePointLoc>0){
		    				if((savePointCounter)==savePointLoc){
		    					System.out.println("setting save point after "+savePointCounter+" : "+query+"");
		    		    	 savePoint = connection.setSavepoint("SavePoint1");
		    				}
		    				savePointCounter++;
		    			}
		    			
		    	}
	    	connection.commit();
	     }
	     catch(SQLException sqlex)
	     {
	    	 
	    	 errorCount++;
	    	 if(savePointLoc>0){
	    		 System.out.println("Savepoint rollback: "+sqlex.getMessage());
	    	 connection.rollback(savePoint);
	    	 }else{
	    		 connection.rollback();
	    	 }
	     }   
	    }

	    public void executeUpdateBatch(String... queries) throws SQLException
	    {    
	     try
	     {
	    	 connection.setAutoCommit(false);
	    	 
	    	 //execute transaction
		    	for(String query:queries){ 
		    		statement.addBatch(query);
		    	}
		    int updateCount[] = statement.executeBatch();
	    	connection.commit();
	    	for(int count:updateCount){
	    		System.out.println("Updated rows = "+count);
	    	}
	     }
	     catch(SQLException sqlex)
	     {
	    		 connection.rollback();
	     }   
	    }

	public void dbDisConnect()
	{
	  try
	  {
	    connection.close();
	  }
	  catch(SQLException ex)
	  {
	   //JOptionPane.showMessageDialog(null,ex.getMessage());
	  }
	}

	private void viewData(String query){
		
		dbConnect();
		ResultSet rs = executeQuery(query);
		
		try {
			ResultSetMetaData meta = rs.getMetaData();
			
			while(rs.next()){
				for(int i=1;i<=meta.getColumnCount();i++)
				System.out.print(rs.getString(i)+(i!=meta.getColumnCount()?",":"\n"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dbDisConnect();
	}

public static void main(String arg[]){
	
	JDBCConnectivity db = new JDBCConnectivity("blueidt1.boulder.ibm.com:50001/BLUEID", "db2inst1", "feb24joy");
	String query1 ="UPDATE BLUEID.BLUEID_ETL_LOG SET LAST_STATE='REPORTED' WHERE DOMAIN ='BLUEID_DIM_CHIP'";
	String query2 ="UPDATE BLUEID.BLUEID_ETL_LOG SET LAST_STATE='REPORTED' WHERE DOMAIN ='BLUEID_DIM_CHIP'";
	System.out.println("1");
	try {
		System.out.println("2");
		db.dbConnect();
		//db.executeUpdateTransaction(1,query1,query2);
		db.executeUpdateBatch(query1,query2);
		db.dbDisConnect();
		System.out.println("3");
	} catch (SQLException e) {
		System.out.println("4");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	db.viewData("SELECT * FROM BLUEID.BLUEID_ETL_LOG WHERE LAST_STATE = '-'");
}
}
