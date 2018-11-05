package com.pack.octadic.tree.function;

public class OctadicTreeNode {
	
		public OctadicTreeNode[] child = new OctadicTreeNode[8];
		
		public OctadicTreeNode parrent; 
		
		public Bucket bucket;


		OctadicTreeNode(){
			for(int i=0;i<8;i++) {
				this.child[i] = null;
			}	
			this.bucket = null;
		}
		
		
}
