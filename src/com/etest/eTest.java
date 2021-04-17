package com.etest;

import com.emath.*;
import com.eneural.*;
import java.util.*;

public class eTest{
    public static void main(String args[]){
        eSequentialModel model = new eSequentialModel();
	model.addLayer(new eLinearLayer(2,3));
	model.addLayer(new eSigmoidLayer());
	model.addLayer(new eLinearLayer(3,2));
	model.addLayer(new eSigmoidLayer());

	double[][] in_data = {{0,0},{1,0},{0,1},{1,1}};
	double[][] out_data = {{1,0},{0,1},{0,1},{1,0}};
	eMatrix x = new eMatrix(4,2,in_data);
	eMatrix y = new eMatrix(4,2,out_data);

        ArrayList<eMatrix[]> ds = eDataset.generateDataset(x,y,4);

	model.train(ds,1000,new eMSELoss(), new eAdamOptimizer(1,0.5));
	model.forward(x).print();
    }
}
