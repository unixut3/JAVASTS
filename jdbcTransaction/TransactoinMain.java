package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.ConnectionFactory;

/*
<< accountA , accountB >> 
ÀÌ¸§          ³Î        À¯Çü           
----------- -------- ------------ 
ACC_NO      NOT NULL NUMBER(20)   
ACC_NAME             VARCHAR2(20) 
ACC_BALANCE          NUMBER(10)    
 */
public class TransactoinMain {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String updateSqlA="update accountA set acc_balance = acc_balance - ? where acc_no = ?";
		String updateSqlB="update accountB set acc_balance = acc_balance + ? where acc_no = ?";
		String selectSqlA="select acc_balance from accountA where acc_no=?";
		String selectSqlB="select acc_balance from accountB where acc_no=?";
		try{
			
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(updateSqlA);
			int money  = 100000;
			int acc_no = 10000;
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			int rowCount=pstmt.executeUpdate();
			System.out.println("1.accountA "+acc_no+" °èÁÂÀÜ°í "+money+ "¿ø °¨¼Ò:"+rowCount);
			pstmt.close();
			pstmt = con.prepareStatement(updateSqlB);
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			rowCount =pstmt.executeUpdate();
			System.out.println("2.accountB "+acc_no+" °èÁÂÀÜ°í "+money+ "¿ø Áõ°¡:"+rowCount);
			pstmt.close();
			pstmt=con.prepareStatement(selectSqlA);
			pstmt.setInt(1, acc_no);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				int balanceA = rs.getInt(1);
				if(balanceA<0){
					con.rollback();
					System.out.println("3-1.A°èÁÂÀÜ°í "+ balanceA +"À½¼ö--> rollback");
				}else{
					con.commit();
					System.out.println("3-2.A°èÁÂÀÜ°í "+ balanceA +"¾ç¼ö--> commit");
				}
				
			}else{
				throw new Exception("unknown error!!");
			}
		}catch(Exception e){
			
			try {
				con.rollback();
				System.out.println("99.rollback(Exception)");
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		

	}

}











