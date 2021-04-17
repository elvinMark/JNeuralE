package com.eneural;

import com.emath.*;

public class eReLULayer extends eLayer{
    public eMatrix cache_in;
    public eMatrix cache_out;
    public eMatrix cache_err;
    
    public eReLULayer(){
	
    }

    public eMatrix forward(eMatrix in){
	this.cache_in = in;
	this.cache_out = in.applyFunc(x -> x>0?x:0.01*x);
	return this.cache_out;
    }

    public eMatrix backward(eMatrix err){
	this.cache_err = err;
	return err.times(this.cache_out.applyFunc(x -> x>0?1:0.01));
    }

    public void update(eOptimizer optim){

    }
}
