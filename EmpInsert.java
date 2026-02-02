//create table emp(eno integer, ename varchar(30), esal float);
//insert into emp values(&eno, '&ename', &esal);

import java.sql.*;
import java.util.*;
 
public class EmpInsert
{
    public static void main(String[] args) {
        try {
            String no, na, sal, sql;
            Scanner s = new Scanner(System.in);
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
            System.out.println("connected.."+con);
		Statement st = con.createStatement();
        System.out.println("Enter the no, name and salary");
        no = s.nextLine();
        na = s.nextLine();
        sal = s.nextLine();
        sql = "insert into emp values(" + no + ",'"+ na +"',"+ sal +")";
        st.executeUpdate(sql);
		ResultSet rs = st.executeQuery("select * from emp");
		while(rs.next())
		{
			System.out.println(rs.getString(1) + "  " + rs.getString(2)+ "  " + rs.getString(3));
		}
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
 
}