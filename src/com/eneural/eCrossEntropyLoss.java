package com.eneural;

import com.emath.*;

public class eCrossEntropyLoss extends eLoss{
    public eCrossEntropyLoss(){

    }

    public double calculateLoss(eMatrix o, eMatrix t){
	this.grad = t.div(o).times(-1);
	return t.times(o.applyFunc(x -> Math.log(x))).sum()*-1;
    }
    
    public eMatrix getGrad(){
	return this.grad;
    }
}
