package com.eneural;

import com.emath.*;

public class eLinearLayer extends eLayer{
    public eMatrix W;
    public eMatrix b;
    public eMatrix cache_in;
    public eMatrix cache_out;
    public eMatrix cache_err;
    public eMatrix vW;
    public eMatrix vb;
    public eMatrix hW;
    public eMatrix hb;
    
    public eLinearLayer(int num_in,int num_out){
	this.W = new eMatrix(num_in,num_out);
	this.b = new eMatrix(1,num_out);

	this.vW = new eMatrix(num_in,num_out);
	this.vb = new eMatrix(1,num_out);
	this.hW = new eMatrix(num_in,num_out);
	this.hb = new eMatrix(1,num_out);
	
	this.W.random();
	this.b.random();
    }

    public eMatrix forward(eMatrix in){
	this.cache_in = in;
	this.cache_out = in.dot(this.W).plus(this.b);
	return this.cache_out;
    }

    public eMatrix backward(eMatrix err){
	this.cache_err = err;
	return err.dot(this.W.transpose());
    }

    public void update(eOptimizer optim){
	eMatrix gradW = this.cache_in.transpose().dot(this.cache_err);
	eMatrix gradb = this.cache_err.sum(1);
	
	if(optim.type == eOptimizer.OPTIM_SGD){
	    this.W = this.W.minus(gradW.times(optim.lr));
	    this.b = this.b.minus(gradb.times(optim.lr));
	}
	else if(optim.type == eOptimizer.OPTIM_MOMENTUM){
	    this.vW = this.vW.times(optim.alpha).minus(gradW.times(optim.lr));
	    this.vb = this.vb.times(optim.alpha).minus(gradb.times(optim.lr));
	    this.W = this.W.plus(this.vW);
	    this.b = this.b.plus(this.vb);
	}
	else if(optim.type == eOptimizer.OPTIM_ADAGRAD){
	    this.hW = this.hW.plus(gradW.times(gradW));
	    this.hb = this.hb.plus(gradb.times(gradb));
	    this.W = this.W.minus(gradW.times(optim.lr).times(this.hW.applyFunc(x -> Math.sqrt(x))));
	    this.b = this.b.minus(gradb.times(optim.lr).times(this.hb.applyFunc(x -> Math.sqrt(x))));
	}
	else if(optim.type == eOptimizer.OPTIM_ADAM){
	    this.hW = this.hW.plus(gradW.times(gradW));
	    this.hb = this.hb.plus(gradb.times(gradb));
	    this.vW = this.vW.times(optim.alpha).minus(gradW.times(optim.lr).times(this.hW.applyFunc(x -> Math.sqrt(x))));
	    this.vb = this.vb.times(optim.alpha).minus(gradb.times(optim.lr).times(this.hb.applyFunc(x -> Math.sqrt(x))));
	    this.W = this.W.plus(this.vW);
	    this.b = this.b.plus(this.vb);
	}
    }
}
