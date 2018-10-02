/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud.datasource;


import java.util.*;
import java.sql.*;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
public class EmpDao {
    
    
    
   public static Connection getConnection() {
        Connection con = null;
        
         try {
          //dataSource.getConnection();
        }catch(Exception e){
            System.out.println(e);
        } 
        return con;
    } 
   
    public static int save (Emp e) {
    
            int status= 0;
       try {        
        Connection con = EmpDao.getConnection() ;
        PreparedStatement ps;
                ps = con.prepareStatement
                ("insert into employee(emp_name,email,password,country) values (?,?,?,?)");
        ps.setString(1,e.getName());
        ps.setString(2,e.getEmail());
        ps.setString(3,e.getPassword());
        ps.setString(4,e.getCountry());
        
        status = ps.executeUpdate();
        
        con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
       return status;
    }
   
    public static int update (Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update employee set emp_name=?,email=?,password=?,country=? where id=? ");
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setString(3,e.getPassword());
            ps.setString(4,e.getCountry());
            ps.setInt(5,e.getId());
            
            status = ps.executeUpdate();
            con.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
      }
    
    public static int delete(int id) {
    int status=0;
    try {
        Connection con= EmpDao.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from employee where id=?");
        ps.setInt(1,id);
        
        status = ps.executeUpdate();
        con.close();
    }catch (Exception ex) {
            ex.printStackTrace();
        }
    return status;
    }
    
    public static Emp getEmployeeById(int id) {
    
      Emp e = new Emp();
      
     try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));   
                e.setEmail(rs.getString(3));   
                e.setPassword(rs.getString(4));
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));    
                e.setEmail(rs.getString(4)); 
                e.setPassword(rs.getString(3)); 
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
    
}
