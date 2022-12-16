// Chew Zi Qing 212360
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SoftwareStore {
	final static String FILEPATH = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt";
	final static String FILEPATH_TEMP = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software_tmp.txt";
	
	public static void main(String[] args) throws IOException {
		BinarySearchTree<Software> tree = new BinarySearchTree<Software>();
		BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
		 
		String softwareName, softwareVersion, line;
		int quantity, pos=0;
		double price;
		Software s;
		
		 while((line = reader.readLine()) != null) {
			 String[] splitedInfo = line.split(",");
			 
			 softwareName = splitedInfo[0];
			 quantity = Integer.parseInt(splitedInfo[2]);
			 price = Double.parseDouble(splitedInfo[3]);
			 
			 if (!splitedInfo[1].equals("")) {
				 softwareVersion = splitedInfo[1];
				 s = new Software(softwareName, softwareVersion, quantity, price);
				 tree.insert(s, pos);
			 }else {
				 s = new Software(softwareName, quantity, price);
				 tree.insert(s, pos);
			 }
			 pos += line.length()+1;
		 }
		 reader.close();

		 System.out.println("-------------WELCOME TO SOFTWARE STORE--------------\n");
		 Scanner sc = new Scanner(System.in);
		 boolean isDone = false;
		 while(!isDone) {
			 System.out.println("What would you like to do?");
			 System.out.println("1. Add software");
		      System.out.println("2. Sell software");
		      System.out.println("3. Print inventory");
		      System.out.println("4. Exit");
		      System.out.print("Enter your choice: ");
		      int choice = sc.nextInt();
		      sc.nextLine();
		      
		      switch(choice) {
		      case 1:
		    	  System.out.print("Enter Name: ");
		          softwareName = sc.nextLine();
		          System.out.print("Enter Version: ");
		          softwareVersion = sc.nextLine();
		          System.out.print("Enter Quantity: ");
		          quantity = Integer.parseInt(sc.nextLine());
		          System.out.print("Enter Price: ");
		          price = Double.parseDouble(sc.nextLine());
		          
		          Software software = new Software(softwareName,softwareVersion,quantity, price);
		          BSTNode<Software> node = new BSTNode<>(software, pos);
		          BSTNode<Software> foundNode = tree.search(software);
		          if (foundNode == null) {
		        	  BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH, true));
		        	  writer.write("\n"+softwareName+","+softwareVersion+","+quantity+","+price);
		        	  writer.close();
		        	  tree.insert(software, pos);
		        	  pos += (softwareName.length() + softwareVersion.length() + Integer.toString(quantity).length() + Double.toString(price).length() + 3);
		          }else {
		        	  // software existed
		        	  // update quantity and price
		        	  foundNode.data.quantity += quantity;
		        	  foundNode.data.price = price;
		        	  
		        	  // update file
		        	  BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH, true));
		              reader = new BufferedReader(new FileReader(FILEPATH));
		              int i = 0;
		              while ((line = reader.readLine()) != null) {
		                  if (i == node.position) {
		                    writer.write(softwareName + "," + softwareVersion + "," + node.data.quantity + "," + node.data.price + "\n");
		                  } else {
		                    writer.write(line+"\n");
		                  }
		                  i += line.length() + 1;
		                }
		                reader.close();
		                writer.close();
		          }
		          System.out.println("\nSuccessfully Added!\n");
		          System.out.println("*************************************");
		    	  break;
		      case 2:
		    	  System.out.print("Enter Name: ");
		          softwareName = sc.nextLine();
		          System.out.print("Enter Quantity Sold: ");
		          int copiesSold = Integer.parseInt(sc.nextLine());
		          System.out.println();
		          
		          BSTNode<Software> n = tree.search(softwareName);
		          if (n == null) {
		        	  System.out.println("Software not found");
		          }else if (n.data.quantity < copiesSold) {
		              System.out.println("Software out of stock: Requires "+
		            		  copiesSold+" but only "+n.data.quantity+" available.");
		          }else {
		        	  System.out.println("Sold "+copiesSold+" copies of '"+n.data.name +"' software!");
      	        	  n.data.quantity = n.data.quantity-copiesSold;
		        	  reader = new java.io.BufferedReader(new java.io.FileReader(FILEPATH));
		        	  java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(FILEPATH_TEMP));

		      	    line="";
		      	    int currentPos = 0;
		      	    while ((line = reader.readLine()) != null) {
		      	       if (currentPos == n.position) {
		      	    	 writer.write(softwareName + "," + n.data.version + "," + n.data.quantity + "," + n.data.price + "\n");
		      	       }else {
		      	    	 writer.write(line+"\n"); 
		      	       }
		      	       currentPos += line.length() + 1;
		      	    }
		      	    reader.close();
		      	    writer.close();

		      	    // replace software with cleaned up file
		      	    // we end up with Software.txt only
		      	    java.io.File oldFile = new java.io.File(FILEPATH);
		      	    java.io.File newFile = new java.io.File(FILEPATH_TEMP);
		      	    if (oldFile.delete()) {
		      	      newFile.renameTo(oldFile);
		      	    }
		          }
		          System.out.println("\n*************************************");
		    	  break;
		      case 3:
		    	  System.out.println("\n*************************************");
		    	  System.out.println("\tSoftware Available\n");
		    	  tree.printInventory();
		    	  System.out.println("\n*************************************");
		    	  break;
		      case 4:
		    	  tree.updateFile();
		    	  System.out.println("*************************************\n");
		    	  System.out.println("\tSee You Again!");
		    	  System.out.println("\n*************************************");
		    	  isDone = true;
		    	  break;
		     default:
		    	 tree.inorder();
		    	 System.out.println("Invalid Option");
		    	 System.out.println("*************************************");
		         break;
		      }
		 }
		sc.close();
	  }
}
