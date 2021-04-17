package com.eneural;

import com.emath.*;

public class eMSELoss extends eLoss{
    public eMSELoss(){
	
    }
    public double calculateLoss(eMatrix o, eMatrix t){
	this.grad = o.minus(t);
	return this.grad.applyFunc(x -> 0.5*x*x).sum();
    }
    public eMatrix getGrad(){
	return this.grad;
    }
}
