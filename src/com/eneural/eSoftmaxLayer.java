package com.eneural;

import com.emath.*;

public class eSoftmaxLayer extends eLayer{
    public eMatrix cache_in;
    public eMatrix cache_out;
    public eMatrix cache_err;
    
    
    public eMatrix forward(eMatrix in){
	eMatrix tmp;
	this.cache_in = in;
	tmp = in.applyFunc(x -> Math.exp(x));
	this.cache_out = tmp.div(tmp.sum(0));
	return this.cache_out;
    }
    
    public eMatrix backward(eMatrix err){
	eMatrix tmp;
	this.cache_err = err;
	tmp = this.cache_out.times(err);
	return this.cache_out.times(err.minus(tmp.sum(0)));
    }
    
    public void update(eOptimizer optim){

    }
}
