package com.eneural;

import com.emath.*;

public class eTanhLayer extends eLayer{
    public eMatrix cache_in;
    public eMatrix cache_out;
    public eMatrix cache_err;
    
    public eTanhLayer(){
	
    }

    public eMatrix forward(eMatrix in){
	this.cache_in = in;
	this.cache_out = in.applyFunc(x -> (1 - Math.exp(-x))/(1 + Math.exp(-x)));
	return this.cache_out;
    }

    public eMatrix backward(eMatrix err){
	this.cache_err = err;
	return err.times(this.cache_out.applyFunc(x -> (1 - x*x)/2.0));
    }

    public void update(eOptimizer optim){

    }
}
