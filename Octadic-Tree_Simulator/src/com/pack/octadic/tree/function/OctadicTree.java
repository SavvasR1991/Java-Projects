package com.pack.octadic.tree.function;

import com.pack.binary.converter.binaryConverter;
import com.pack.colours.ColorInputTable;

public class OctadicTree implements OctadicFunctionality{

	
	private OctadicTreeNode root;
	
	private int OctadicTreeDepth;
	
	private binaryConverter convertColor;
	
	//Constructor
	public int getOctadicTreeDepth() {
		return OctadicTreeDepth;
	}

	public void setOctadicTreeDepth(int octadicTreeDepth) {
		OctadicTreeDepth = octadicTreeDepth;
	}

	public OctadicTree(int depth,ColorInputTable input) {
		this.root = new OctadicTreeNode();
		setOctadicTreeDepth(depth);
		OctadicTreeCreation(input,depth);
		// TODO Auto-generated constructor stub
	}

	//--------------------- Interface -------------//
	@Override
	public void OctadicTreeCreation(ColorInputTable input,int depth) {
		// TODO Auto-generated method stub
		OctadicTreeNode next = this.root;
		for(int i=0;i<input.colourArray.length;i++) {
			for(int j=0;j<depth;i++) {
				if(j == (depth-1)) {
					if(next.bucket==null) {
						next.bucket = new Bucket();
						next.bucket.BucketInsertColor(input.colourArray[i]);
					}
					else {
						next.bucket.BucketInsertColor(input.colourArray[i]);
					}
				}
				else {
					if(next.child[convertColor.colorConvertIndex(input.colourArray[i],j)]==null) {
						next.child[convertColor.colorConvertIndex(input.colourArray[i],j)] = new OctadicTreeNode();
						next = next.child[convertColor.colorConvertIndex(input.colourArray[i],j)];
					}
					else {
						next = next.child[convertColor.colorConvertIndex(input.colourArray[i],j)];
					}
				}
			}
		}
	}

	@Override
	public void OctadicTreeDeletion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OctadicTreeInsertValue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OctadicTreePrint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OctadicTreeSearch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OctadicTreeCompute() {
		// TODO Auto-generated method stub
		
	}
	
	
}
