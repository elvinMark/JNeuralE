package com.eneural;

import com.emath.*;
import java.util.*;

public class eDataset{
    public static ArrayList<eMatrix[]> generateDataset(eMatrix x, eMatrix y,int batch_size){
	ArrayList<eMatrix[]> data = new ArrayList<eMatrix[]>();
	int nums = (int)Math.ceil(1.0*x.rows / batch_size);
	for(int i = 0;i<nums;i++){
	    eMatrix[] elem = new eMatrix[2];
	    elem[0] = x.getSubMatrix(i*batch_size,batch_size);
	    elem[1] = y.getSubMatrix(i*batch_size,batch_size);
	    data.add(elem);
	}
	return data;
    }
}
