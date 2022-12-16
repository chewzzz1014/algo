/*
 * Implement a menu-driven program for managing a software store. All information about the available software is stored in file software. This information includes the name, version, quantity, and price of each package. When it is invoked, the program automatically creates a binary search tree with one node corresponding to one software package and includes as its key the name of the package and its version. Another field in this node should include the position of the record in the file software. The only access to the information stored in software should be through this tree.

-- Operation: 
----1. Add (put to end of file)
----2. Update quantity (if adding existing software)
----4. Sell (deduct quantity)
----3. Delete (exit and delete those with quantity=0)

The program should allow the file and tree to be updated when new software packages arrive at the store and when some packages are sold. The tree is updated in the usual way. All packages are entry ordered in the file software; if a new package arrives, then it is put at the end of the file. If the package already has an entry in the tree (and the file), then only quantity field is updated. If a package is sold out, the corresponding node is deleted from the tree, and the quantity field in the file is change to 0. For example, if the file has these entries:

Adobe Photoshop	7.0		21		580
Norton Utilities []		10		  30
Norton SystemWorks []	6		  50
Visual J++ Professional	6.0		19		100
Visual J++ Standard	6.0		27		  40

Then after selling all six copies of Norton SystemWorks, the file is

Adobe Photoshop	7.0		21		580
Norton Utilities []		10		  30
Norton SystemWorks []	 0		  50
Visual J++ Professional	6.0		19		100
Visual J++ Standard	6.0		27		  40

If an exit option is chosen from the menu, the program cleans up the file by moving entries from the end of file to the position marked with 0 quantities. For example, the previous file becomes

Adobe Photoshop	7.0		21		580
Norton Utilities []		10		  30
Visual J++ Professional	6.0		19		100
Visual J++ Standard	6.0		27		  40

 */

// Chew Zi Qing 212360
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class SoftwareStore {
	public static void main(String[] args) throws Exception {
		 BinarySearchTree<Software> tree = new BinarySearchTree<>();
		 File file = new File("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt");
		Scanner sc = new Scanner(file);
		 
		String softwareName, softwareVersion;
		int quantity, price;
		Software s;
		 while(sc.hasNext()) {
			 String softwareInfo = sc.nextLine();
			 String[] splitedInfo = softwareInfo.split(",");
			 
			 softwareName = splitedInfo[0];
			 quantity = Integer.parseInt(splitedInfo[2]);
			 price = Integer.parseInt(splitedInfo[3]);
			 if (!splitedInfo[1].equals("")) {
				 softwareVersion = splitedInfo[1];
				 s = new Software(softwareName, softwareVersion, quantity, price);
			 }else {
				 s = new Software(softwareName, quantity, price);
			 }
			 System.out.println(s.toString());
		 }
		 tree.inOrder();
		 // name|version|quantity|price
//	    tree.insert(8);
//	    tree.insert(3);
//	    tree.insert(1);
//	    tree.insert(6);
//	    tree.insert(7);
//	    tree.insert(10);
//	    tree.insert(14);
//	    tree.insert(4);
//	
//	    System.out.print("Inorder traversal: ");
//	    tree.inorder();
//	
//	    System.out.println("\n\nAfter deleting 10");
//	    tree.deleteKey(10);
//	    System.out.print("Inorder traversal: ");
//	    tree.inorder();
		sc.close();
	  }
}
