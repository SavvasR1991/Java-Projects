package com.pack.octadic.tree.function;

public class OctadicTreeNode {
	
		OctadicTreeNode(){
			for(int i=0;i<8;i++) {
				child[i] = null;
			}	
		}
		
		OctadicTreeNode[] child = new OctadicTreeNode[8];
		
		OctadicTreeNode parrent; 
	

}
