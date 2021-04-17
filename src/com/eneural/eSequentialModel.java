package com.eneural;

import com.emath.*;
import java.util.*;

public class eSequentialModel{
    ArrayList<eLayer> layers;
    
    public eSequentialModel(){
	this.layers = new ArrayList<eLayer>();
    }

    public void addLayer(eLayer layer){
	this.layers.add(layer);
    }
    
    public eMatrix forward(eMatrix in){
	eMatrix o = in;
	for(eLayer layer : this.layers)
	    o = layer.forward(o);
	return o;
    }
    
    public void backward(eMatrix err){
	eMatrix o = err;
	for(int i = this.layers.size()-1;i>=0;i--)
	    o = this.layers.get(i).backward(o);
    }
    
    public void update(eOptimizer optim){
	for(eLayer layer : this.layers)
	    layer.update(optim);
    }
    
    public ArrayList<Double> train(ArrayList<eMatrix[]> ds,int epochs,eLoss loss,eOptimizer optim){
	ArrayList<Double> loss_log = new ArrayList<Double>();
	double acc;
	eMatrix o;
	eMatrix in;
	eMatrix t;
	for(int epoch = 0; epoch < epochs;epoch++){
	    acc = 0;
	    for(int i = 0;i<ds.size();i++){
		in = ds.get(i)[0];
		t = ds.get(i)[1];
		o = this.forward(in);
		acc += loss.calculateLoss(o,t);
	        this.backward(loss.getGrad());
		this.update(optim);
	    }
	    loss_log.add(acc);
	}
	return loss_log;
    }
}
