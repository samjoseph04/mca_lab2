//create table emp(eno integer, ename varchar(30), esal float);
//insert into emp values(&eno, '&ename', &esal);
//create procedure empinsert(no integer, na varchar2, sal float)
//is
//begin
//  insert into emp values(no, na, sal);
//end;
///

//exec empinsert(7, 'tom', 60000);

//select * from emp;

import java.sql.*;
import java.util.*;

public class EmpInsertP {

    public static void main(String[] args) {
        try {
            String no, na, sal;
            Scanner s = new Scanner(System.in);
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mca", "mca");
            System.out.println("connected.." + con);
            Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");
            System.out.println("Enter the no, name and salary");
            no = s.nextLine();
            na = s.nextLine();
            sal = s.nextLine();
            pst.setInt(1, Integer.parseInt(no));
            pst.setString(2, na);
            pst.setFloat(3, Float.parseFloat(sal));
            pst.executeUpdate();
            ResultSet rs = st.executeQuery("select * from emp");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
