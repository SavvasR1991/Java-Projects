package com.pack.octadic.tree.function;

import com.pack.colours.ColorInputTable;

public class OctadicTree implements OctadicFunctionality{

	
	private OctadicTreeNode root;
	
	private int OctadicTreeDepth;
	
	//Constructor
	public int getOctadicTreeDepth() {
		return OctadicTreeDepth;
	}

	public void setOctadicTreeDepth(int octadicTreeDepth) {
		OctadicTreeDepth = octadicTreeDepth;
	}

	public OctadicTree(int depth,ColorInputTable input) {
		this.root = null;
		// TODO Auto-generated constructor stub
	}

	//--------------------- Interface -------------//
	@Override
	public void OctadicTreeCreation() {
		// TODO Auto-generated method stub
		if(this.root == null) {
			root = new OctadicTreeNode();
			
		}
		else {
			
			
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
