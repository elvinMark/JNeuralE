package com.etest;

import com.emath.*;
import com.eneural.*;
import com.eutil.*;
import java.util.*;

public class eTest{
    public static void main(String args[]){
        eSequentialModel model = new eSequentialModel();
	model.addLayer(new eLinearLayer(2,3));
	model.addLayer(new eReLULayer());
	model.addLayer(new eLinearLayer(3,2));
	model.addLayer(new eReLULayer());

	model.addLayer(new eSoftmaxLayer());

	double[][][] regions = {{{0,0},{0.5,0.5}}};
	eMatrix[] data = eDataGenerator.generate2DClassifyData(regions,20);

	data[0].print();
	data[1].print();
	
	ArrayList<eMatrix[]> ds = eDataset.generateDataset(data[0],data[1],4);
	
	model.train(ds,1000,new eCrossEntropyLoss(), new eAdamOptimizer(0.1,0.2));
	model.forward(data[0]).print();
    }
}
