/*
 * Implement a menu-driven program for managing a software store. All information about the available software is stored in file software. This information includes the name, version, quantity, and price of each package. When it is invoked, the program automatically creates a binary search tree with one node corresponding to one software package and includes as its key the name of the package and its version. Another field in this node should include the position of the record in the file software. The only access to the information stored in software should be through this tree.

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
public class SoftwareStore {

}
