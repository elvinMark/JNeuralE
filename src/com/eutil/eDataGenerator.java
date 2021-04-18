package com.eutil;

import com.emath.*;

public class eDataGenerator{
    public static boolean inside2DRegion(double[] p,double[] x0,double[] x1){
	for(int i = 0;i<2;i++){
	    if(p[i] < x0[i] || p[i] > x1[i])
		return false;
	}
	return true;
    }
    
    public static eMatrix[] generate2DClassifyData(double[][][] regions,int N){
	eMatrix[] out = new eMatrix[2];
	int num_classes = regions.length + 1;
	eMatrix x,y;
	int c;
	
	x = new eMatrix(N,2);
	y = new eMatrix(N,num_classes);

	x.random();

	for(int i = 0;i<N;i++){
	    c = num_classes - 1;
	    for(int j = 0;j<num_classes-1;j++){
		if(inside2DRegion(x.data[i],regions[j][0],regions[j][1])){
		    c = j;
		    break;
		}
	    }
	    y.data[i][c] = 1;
	}

	out[0] = x;
	out[1] = y;
	
	return out;
    }
}
