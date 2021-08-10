import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Model {
	Connection con;
	PreparedStatement ptst;
	Statement smt;
	ResultSet res;
	String name;
	String email;
	String username;
	String pwd;
	int accno;
	Double balance;
	private String newpwd;
	Double transamount;
	int raccno;
	

//constuctor 

	Model(){
		try {
			Class.forName("com.mysql.jdbc.Driver");// package inside mysql taht we taking info from
			//connect to db
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankProj", "root", "root");

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//getter and setter methods
	
	public String getName() {
		return name;
		
	}
	public String getEmail() {
		return email;
		
	}
	public String getUsername() {
		return username;
		
	}
	public String getPwd() {
		return pwd;
		
	}
	public int getAccno() {
		return accno;
		
	}
	public double getBalance() {
		return balance;
	}
	 public void setName(String name)
	 {
		 this.name=name;
	 }
	 public void setEmail(String email)
	 {
		 this.email=email;
	 }
	 public void setUsername(String username)
	 {
		 this.username=username;
	 }
	 public void setPwd(String pwd)
	 {
		 this.pwd=pwd;
	 }
	 public void setAccno(int accno)
	 {
		 this.accno=accno;
	 }
	 public void setBalance(Double balance)
	 {
		 this.balance=balance;
	 }
	 
	 public String getNewpwd() {
			return newpwd;
		}
		public void setNewpwd(String newpwd) {
			this.newpwd = newpwd;
		}
		
		public void setTransamount(Double transamount) {
			this.transamount = transamount;
		}

		public Double getTransamount() {
			return transamount;
		}
		
		public void setRaccno(int raccno) {
			this.raccno = raccno;
		}

		public int getRaccno() {
			return raccno;
		}
		
	
	public int Register() {
		try {
		String sql="INSERT INTO bank values(?,?,?,?,?,?)";
		ptst=con.prepareStatement(sql);
		ptst.setString(1,name);
		ptst.setString(2, username);
		ptst.setString(3,email);
		ptst.setString(4, pwd);
		ptst.setInt(5, accno);
		ptst.setDouble(6, balance );
		
		int x=ptst.executeUpdate();
		return x;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
		
	
	public int Login() {
		try {
			String sql="SELECT * FROM bank WHERE username=? AND password=? ";
			ptst=con.prepareStatement(sql);
			ptst.setString(1,username);
			ptst.setString(2,pwd);
			
			res=ptst.executeQuery();
			if(res.next()==true) {
				name=res.getString("name");
				username=res.getString("username");
				email=res.getString("email");
				accno=res.getInt("accno");
				balance=res.getDouble("balance");
				name=res.getString("name");
				
				//this is if data has been taken from data to check
				return 1;
			}
			else
			{
				System.out.println("LOGIN ELSE");

				return 0;
			}
			
			
			
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
		}
		return 0;
	}
	
	
	public int UpdateProfile() {
		try {
			String sql="SELECT * FROM bank WHERE name=? AND password=?";
			ptst=con.prepareStatement(sql);
			ptst.setString(1, name);
			ptst.setString(2, pwd);

			
			res=ptst.executeQuery();
			if(res.next()==true) 
			{
				String sql2="UPDATE bank SET password=? WHERE name=? AND password=?";
				ptst=con.prepareStatement(sql2);
				ptst.setString(1, newpwd);
				ptst.setString(2, name);
				ptst.setString(3, pwd);
	
				int x=ptst.executeUpdate();
				return x;	
			}
			else
			{
				return 0;
			}
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		return 0;
		
	}
	
	public int AddMoney()
	{
		try {
			String sql="SELECT * FROM bank WHERE name=? AND password=?";
			ptst=con.prepareStatement(sql);
			ptst.setString(1, name);
			ptst.setString(2, pwd);

			res=ptst.executeQuery();
			if(res.next()==true)
			{
				String sql2="UPDATE bank SET balance=? WHERE accno=? ";
				ptst=con.prepareStatement(sql2);
				ptst.setDouble(1, balance);
				ptst.setInt(2, accno);
				
				int x=ptst.executeUpdate();
				return x;
			}
			else
			{
				return 0;
			}	
	}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return 0;
	

}
	
	
	public int Transfer()
	{
		try {
			String sql="SELECT * FROM bank WHERE name=? AND password=? AND balance > ?";
			ptst=con.prepareStatement(sql);
			ptst.setString(1, name);
			ptst.setString(2, pwd);
			ptst.setDouble(3, transamount);


			res=ptst.executeQuery();
			
			if(res.next()==true)
			{
				String sql2="SELECT * FROM bank WHERE accno=? ";
				ptst=con.prepareStatement(sql2);
				ptst.setDouble(1, raccno);
				
				res=ptst.executeQuery();

				if(res.next()==true)
				{
					String sql3="UPDATE bank SET balance= balance +? WHERE accno=?";
					//LETS ADD TO THE RECIEVING END
					ptst=con.prepareStatement(sql3);
					ptst.setDouble(1, transamount);
					ptst.setInt(2, raccno);
					
					int x=ptst.executeUpdate();
					if(x==1)
					{
						String sql4="UPDATE bank SET balance= balance - ? WHERE accno=?";
						//LETS MINUS FROM NOW ACC
						ptst=con.prepareStatement(sql4);
						ptst.setDouble(1, transamount);
						ptst.setInt(2, accno);
						
						int y=ptst.executeUpdate();
						return y;
					
					}
				
				}
			
			}
			
			else
			{
			return 0;	
			}	
	}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return 0;
	

}
	
	public int resetpwd()
	  {
	    
	    try {
	      String sql = "UPDATE bank SET password=? where email=?";
	      ptst = con.prepareStatement(sql);
	      ptst.setString(1, newpwd);
	      ptst.setString(2, email);
	      

	      
	      int x = ptst.executeUpdate();
	      return x;
	      
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return 0;
	     
	  }
}
