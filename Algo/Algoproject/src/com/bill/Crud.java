package com.bill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Crud implements Bill{
	
	@Override
	public void saveProducts()
	{
		Scanner ip=new Scanner(System.in);
		System.out.println("Enter product id");
		int id=ip.nextInt();
		System.out.println("Enter product name");
		String name=ip.next();
		System.out.println("Enter product type ");
		String type=ip.next();
		System.out.println("Enter product category");
		String cat=ip.next();
		System.out.println("Enter product price");
		double price=ip.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("insert into product values(?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, type);
			ps.setString(4, cat);
			ps.setDouble(5, price);
			ps.execute();
			c.close();
			System.out.println("Data saved");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		Scanner ip=new Scanner(System.in);
		System.out.println("Enter product id");
		int id=ip.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("delete from product where id=?");
			ps.setInt(1, id);
			ps.execute();
			c.close();
			System.out.println("Data Deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	@Override
	public void updateProduct() {
		Scanner ip=new Scanner(System.in);
	System.out.println("Enter which details to update");
	System.out.println(" 1. For id \n 2. For name \n 3. For type \n 4. For category \n 5. For price");
	int n=ip.nextInt();
	while(n!=6) {
		switch(n) {
		case 1:try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("update product set id=? where name=?");
			System.out.println("Enter the new id");
			ps.setInt(1, ip.nextInt());
			System.out.println("Enter the name");
			ps.setString(2, ip.next());
			ps.execute();
			c.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		break;
		case 2:try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("update product set name=? where id=?");
			System.out.println("Enter the new name");
			ps.setString(1, ip.next());
			System.out.println("Enter the id");
			ps.setInt(2, ip.nextInt());
			ps.execute();
			c.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		break;
		case 3:try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("update product set type=? where id=?");
			System.out.println("Enter the new type");
			ps.setString(1, ip.next());
			System.out.println("Enter the id");
			ps.setInt(2, ip.nextInt());
			ps.execute();
			c.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		break;
		case 4:try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("update product set cat=? where id=?");
			System.out.println("Enter the new category");
			ps.setString(1, ip.next());
			System.out.println("Enter the id");
			ps.setInt(2, ip.nextInt());
			ps.execute();
			c.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		break;
		case 5:try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("update product set price=? where id=?");
			System.out.println("Enter the new price");
			ps.setDouble(1, ip.nextDouble());
			System.out.println("Enter the id");
			ps.setInt(2, ip.nextInt());
			ps.execute();
			c.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		break;
		case 6:break;
		default: System.out.println("Enter correct options");
		break;
		}
		System.out.println("Data updated");
		System.out.println(" 1. For id \n 2. For name \n 3. For type \n 4. For category \n 5. For price\n 6. For exit");
		n=ip.nextInt();
	}

	}



	@Override
	public void getProduct() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("Select * from product");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			System.out.println("Data retrived");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	double rate=0;
	String which="";

	public void getProductById()
	{

		try {
			Scanner ip=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=connection.prepareStatement("select * from product where id=?");
			System.out.println("Enter the product id");
			int o=ip.nextInt();
			ps.setInt(1, o);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(" Product Id: "+rs.getInt(1)+"\n Product Name: "+rs.getString(2)+" \n Product Type:"+rs.getString(3)+"\n Product Category: "+rs.getString(4)+"\n Product Price: "+rs.getDouble(5));
				rate=rs.getDouble(5);
				which=rs.getString(4);
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			System.out.println(rate);
			System.out.println(which);
		}
	}
	@Override
	public void saveProductDetails() {
		// TODO Auto-generated method stub
		Scanner ip=new Scanner(System.in);
		System.out.println("Enter product cat");
		String cat=ip.next();
		System.out.println("Enter product discount");
		double dis=ip.nextDouble();
		System.out.println("Enter product gst");
		double gst=ip.nextDouble();
		System.out.println("Enter product delivery charges");
		double charge=ip.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("insert into productdetails values(?,?,?,?)");
			ps.setString(1,cat);
			ps.setDouble(2,dis);
			ps.setDouble(3,gst);
			ps.setDouble(4, charge);
			ps.execute();
			c.close();
			System.out.println("Data saved");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProductDetail() {
		Scanner ip=new Scanner(System.in);
		System.out.println("Enter product category");
		String cat=ip.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=c.prepareStatement("delete from productdetails where cat=?");
			ps.setString(1,cat);
			ps.execute();
			c.close();
			System.out.println("Data Deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProductDetails() {
		Scanner ip=new Scanner(System.in);
		System.out.println("Enter which product details to update");
		System.out.println(" 1. For category \n 2. For discount \n 3. For gst \n 4. For Delivery Charges");
		int n=ip.nextInt();
		while(n!=5) {
			switch(n) {
			case 1:try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
				PreparedStatement ps=c.prepareStatement("update productdetails set cat=? where discount=?");
				System.out.println("Enter the new category");
				ps.setString(1, ip.next());
				System.out.println("Enter the discount");
				ps.setDouble(2, ip.nextDouble());
				ps.execute();
				c.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
			case 2:try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
				PreparedStatement ps=c.prepareStatement("update productdetails set discount=? where cat=?");
				System.out.println("Enter the new discount");
				ps.setDouble(2, ip.nextDouble());
				System.out.println("Enter the category");
				ps.setString(1, ip.next());
				ps.execute();
				c.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
			case 3:try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
				PreparedStatement ps=c.prepareStatement("update productdetails set gst=? where cat=?");
				System.out.println("Enter the new gst");
				ps.setDouble(1, ip.nextDouble());
				System.out.println("Enter the category");
				ps.setString(2, ip.next());
				ps.execute();
				c.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
			case 4:try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
				PreparedStatement ps=c.prepareStatement("update productdetails set charge=? where cat=?");
				System.out.println("Enter the new Delivery charges");
				ps.setDouble(1, ip.nextDouble());
				System.out.println("Enter the category");
				ps.setString(2, ip.next());
				ps.execute();
				c.close();
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
			case 5:break;
			default: System.out.println("Enter correct options");
			break;
			}
			System.out.println("Data updated");
			System.out.println(" 1. For category \n 2. For discount \n 3. For gst \n 4. For Delivery Charges\n 5. For exit");
			n=ip.nextInt();
		}

		
	}

	@Override
	public void getProductDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("Select * from productdetails");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getDouble(2)+" "+rs.getDouble(3)+" "+rs.getDouble(4));
			}
			System.out.println("Data retrived");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
double discount=0;
double gst=0;
double delivery=0;
	@Override
	public void BillGeneartion()
	{
		try {
			Scanner ip=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/algo", "root", "root");
			PreparedStatement ps=connection.prepareStatement("select * from productdetails where cat=?");
			ps.setString(1, which);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				discount=rs.getDouble(2)/100;
				gst=rs.getDouble(3)/100;
				delivery=rs.getDouble(4);
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			System.out.println(" Discount:"+(rate*discount));
			System.out.println(" Charges\n{");
			System.out.println(" Gst:"+((rate)-(rate*discount))*gst);
			System.out.println(" Delevery:"+delivery+"\n}");
			System.out.println(" Final price:"+((rate)-(rate*discount)+((rate)-(rate*discount))*gst+(delivery))+"\n}");
		}
		
		
	}


}
