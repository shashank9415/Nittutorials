/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Beans.Debug;
import Beans.ErrorCode;
import Beans.Tutorial;
import DatabaseConnection.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shashank
 */
public class ContentHelper extends ConnectionPool {
    private Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private int errorStatus;
    
     public int generateNewTopicId() throws SQLException
    {
         ResultSet result = null;
        int topicId = 0;
        if( ConnectionPool.isClosed(con)) {
            con = ConnectionPool.getConnection();
        } 
        if( !DatabaseConnection.ConnectionPool.isClosed(con) ) {
            try {
                
                String sql = "SELECT MAX(topic_id) FROM topics";
                pstmt = con.prepareStatement(sql);
                result = pstmt.executeQuery();
                if(result.next()) {
                    topicId = result.getInt("MAX(topic_id)");
                } else {
                    topicId = 0;
                }
                
                topicId++;
                
            } catch (SQLException sqle) {
                topicId = -1;
            } finally {
                ConnectionPool.returnConnection(con);
            }
        }
        return topicId;
    }
     public synchronized int insertNewTutorial(Tutorial tutorial,int userId) {
        /* initialise errorStatus */
        errorStatus = ErrorCode.VALID;
        
        /* initialising save point */
        Savepoint spt = null;
        
        /*Checking the validity of the parameter object*/
       // errorStatus=isValid(tutorial);
        
        if(errorStatus == ErrorCode.VALID){
            /*
             * Establishing connection with database
             */
            if (ConnectionPool.isClosed(con)) {
                try {
                    con = ConnectionPool.getConnection();
                } catch (SQLException ex) {
                    if(Debug.on) System.out.println("Connection can not be made");
                }
            }
            if (!ConnectionPool.isClosed(con)) {
                try {

                    /*
                     * Inserting the tutorial into table tutorial and contents
                     */
                    con.setAutoCommit(false);
                    spt = con.setSavepoint();
                    pstmt = con.prepareStatement("INSERT INTO contents VALUES(?,?)");
                    pstmt.setInt(1, tutorial.getTopicId());
                    pstmt.setString(2, tutorial.getContent());
                    pstmt.executeUpdate();
                    java.util.Date date = new java.util.Date();
                    java.sql.Timestamp timeStamp = new java.sql.Timestamp(date.getTime());
                    pstmt.setTimestamp(3, timeStamp);
                    pstmt.executeUpdate();
                    /*
                     * if the operation was success set errorCode to success
                     */

                    con.commit();
                    errorStatus = ErrorCode.SUCCESS;

                } catch (SQLException sqle) {
                    if (Debug.on) {
                        sqle.printStackTrace();
                    }
                    try {
                        con.rollback(spt);
                        errorStatus = ErrorCode.SQL_ERROR;
                    } catch (SQLException sqlex) {
                        if (Debug.on) {
                            System.out.println("sql error 10");
                        }
                        errorStatus = ErrorCode.SQL_ERROR;
                    }

                } finally {
                    try {
                        ConnectionPool.returnConnection(con);
                    } catch (SQLException ex) {
                        if(Debug.on)
                        System.out.println("Connection can not be closed");
                    }
                }
            }
        }
        return errorStatus;
    }
}

