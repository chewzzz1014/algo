// Chew Zi Qing 212360
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SoftwareStore {
	public static void main(String[] args) throws IOException {
		BinarySearchTree<Software> tree = new BinarySearchTree<Software>();
		 BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt"));
		// BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt"));
		 
		String softwareName, softwareVersion, line;
		int quantity, price, pos=0;
		Software s;
		 while((line = reader.readLine()) != null) {
			 String[] splitedInfo = line.split(",");
			 
			 softwareName = splitedInfo[0];
			 quantity = Integer.parseInt(splitedInfo[2]);
			 price = Integer.parseInt(splitedInfo[3]);
			 
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

		 Scanner sc = new Scanner(System.in);
		 boolean isDone = false;
		 while(!isDone) {
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
		          price = Integer.parseInt(sc.nextLine());
		          
		          Software software = new Software(softwareName,softwareVersion,quantity, price);
		          BSTNode<Software> node = new BSTNode<>(software, pos);
		          BSTNode<Software> foundNode = tree.search(software);
		          if (foundNode == null) {
		        	  BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt", true));
		        	  writer.write("\n"+softwareName+","+softwareVersion+","+quantity+","+price);
		        	  writer.close();
		        	  tree.insert(software, pos);
		        	  pos += (softwareName.length() + softwareVersion.length() + Integer.toString(quantity).length() + Integer.toString(price).length() + 3);
		          }else {
		        	  // software existed
		        	  // update quantity and price
		        	  foundNode.data.quantity += quantity;
		        	  foundNode.data.price = price;
		        	  
		        	  // update file
		        	  BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt", true));
		              reader = new BufferedReader(new FileReader("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt"));
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
		          
		    	  break;
		      case 2:
		    	  System.out.print("Enter Name: ");
		          softwareName = sc.nextLine();
		          //System.out.print("Enter Quantity Sold: ");
		          //int copiesSold = Integer.parseInt(sc.nextLine());
		          BSTNode<Software> n = tree.search(softwareName);
		          if (n == null) {
		        	  System.out.println("Software not found");
		          }else if (n.data.quantity == 0) {
		              System.out.println("Software out of stock");
		          }else {
		        	  System.out.println("Sold one "+n.data.name +"!");
      	        	  n.data.quantity = n.data.quantity-1;
//		        	  BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt", false));
//		              reader = new BufferedReader(new FileReader("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt"));
//		              int i = 0;
//		              while ((line = reader.readLine()) != null) {
//		                if (i == n.position) {
//		                  writer.write(softwareName + "," + n.data.version + "," + n.data.quantity + "," + n.data.price + "\n");
//		                } else {
//		                  writer.write(line+"\n");
//		                }
//		                i += line.length() + 1;
//		              }
//		              reader.close();
//		              writer.close();
		        	  reader = new java.io.BufferedReader(new java.io.FileReader("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt"));
		        	  java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software_tmp.txt"));

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
		      	    java.io.File oldFile = new java.io.File("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt");
		      	    java.io.File newFile = new java.io.File("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software_tmp.txt");
		      	    if (oldFile.delete()) {
		      	      newFile.renameTo(oldFile);
		      	    }
		          }
		    	  break;
		      case 3:
		    	  tree.printInventory();
		    	  break;
		      case 4:
		    	  tree.updateFile();
		    	  isDone = true;
		    	  break;
		     default:
		    	 System.out.println("Invalid choice");
		         break;
		      }
		 }
		sc.close();
	  }
}
