/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author shashank
 */

public class ErrorCode {
    
    /*Defining constants for error or success codes*/
    public static final int VALID = 1;/*Tutorial object is valid*/
    public static final int INV_COM = 2;/*invalid Tutorial complexity*/
    public static final int INV_STATUS = 3;/*invalid status*/
    public static final int SQL_ERROR = 4;/*database access errors*/
    public static final int SUCCESS = 5;/*function is successful*/
    public static final int NULL_VALUE = 6;/*Non-null attributes assigned null values or a given object is null*/
    public static final int INV_TOPIC = 7;/*Invalid topic id*/
    public static final int INV_CONTENTID = 8;/*to check whether content id is valid or not */ 
    public static final int INV_AUTHOR = 9; /* Invalid author name or id */
    public static final int INV_FUNCTION = 10; /* invalid function was used to insert */
    public static final int EMPTY_STRING = 11; /* if utext of content is empty */ 
    public static final int INV_USERID = 12; /*invalid userid */  
    public static final int INV_PARENTID = 13; /* if the parent id given does not exist for topic */
    public static final int DUP_TOPIC = 14; /* if the topic to be inserted is already present */
    public static final int INV_OBJECT = 15;/* if one of the fields of the object has invalid value*/
    /**
     * This function is used to get the description of the error that occurred 
     * during the operation.
     * 
     * @param errorCode the error code that was generated
     */
    public String getCodeDesc(int errorCode) {
        
        String codeDesc=null;
        
        switch(errorCode) {
            case 1 : codeDesc = "VALID";
                     break;
            case 2 : codeDesc = "INV_TYPE";
                     break;
            case 3 : codeDesc = "INV_STATUS";
                     break;
            case 4 : codeDesc = "SQL_ERROR";
                     break;
            case 5 : codeDesc = "SUCCESS";
                     break;
            case 6 : codeDesc = "NULL_VALUE";
                     break;
           case 7 : codeDesc = "INV_TOPIC";
                      break;
            case 8 : codeDesc = "INV_CONTENTID";
                      break;
            case 9 : codeDesc = "INV_AUTHOR";
                      break;
            case 10 : codeDesc = "INV_FUNCTION";
                      break;
            case 11 : codeDesc = "EMPTY_STRING";
                      break;
            case 12 : codeDesc = "INV_USERID";    
                      break;
            case 13 : codeDesc = "INV_PARENTID";
                      break;
            case 14 : codeDesc = "DUP_TOPIC";
                      break;
            case 15 : codeDesc = "INV_OBJECT";
                      break;
        }
        
        return codeDesc;
    }
     public String getErrorMsg(int errorCode)
    {
         String errorMsg=null;
        
        switch(errorCode) {
            case 1 : errorMsg="invalid_details";
                     break;
            case 4 : errorMsg = "server_problem";
                     break;
            case 8 : errorMsg = "inserted";
                     break;
            case 11 : errorMsg = "empty_string";
                      break;
            case 15 : errorMsg = "invalid_object";
                      break;
        }
        
        return errorMsg;
    }
}


