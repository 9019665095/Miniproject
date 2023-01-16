package com.bill;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Bill s=new Crud();
		Scanner x=new Scanner(System.in);
		System.out.println("Enter 1 for product table else 2 For productDeatils table 3 For Bill generation ");
		int y=x.nextInt();
		while(y!=4) 
		{
			switch(y) 
			{
			case 1:
			{
				Scanner ip=new Scanner(System.in);
				System.out.println(" 1. For Save deatails\n 2. For delete Product\n 3. For update Product\n 4. For get All Product \n ");
				int n=ip.nextInt();
				while(n!=5)
				{
					switch(n) 
					{
					case 1:s.saveProducts();
					break;
					case 2:s.deleteProduct();
					break;
					case 3:s.updateProduct();
					break;
					case 4:s.getProduct();
					break;
					case 5:break;
					default:System.out.println("Entered wrong input");
					break;
					}
					System.out.println(" 1. For Save deatails\n 2. For delete Product\n 3. For update Product\n 4. For get All Product \n 5. Enter For exit");
					n=ip.nextInt();

				}
			}
			break;
			case 2:
			{
				Scanner ip=new Scanner(System.in);
				System.out.println(" 1. For Save ProductDetails\n 2. For delete ProductDetails\n 3. For updateProductDetails\n 4. For get All ProductDetails\n ");
				int n=ip.nextInt();
				while(n!=5)
				{
					switch(n) 
					{
					case 1:s.saveProductDetails();
					break;
					case 2:s.deleteProductDetail();
					break;
					case 3:s.updateProductDetails();
					break;
					case 4:s.getProductDetails();
					break;
					case 5:break;
					default:System.out.println("Entered wrong input");
					break;
					}
					System.out.println(" 1. For Save ProductDetails\n 2. For delete ProductDetails\n 3. For update ProductDetails\n 4. For get All ProductDetails \n 5. Enter For exit");
					n=ip.nextInt();
				}

			}
			break;
			case 3:
			{
				System.out.println("-----Welcome to Bill Generation--------");
				s.getProductById();
				s.BillGeneartion();
			}
			break;
			case 4:break;
			default:System.out.println("Entered wrong input");
			break;
			}
			System.out.println("Enter 1 for product table else 2 For productDeatils table 3 For Bill generation 4 For exit");
			y=x.nextInt();
		}
		System.out.println("Thank you Visite again");
	}

}
