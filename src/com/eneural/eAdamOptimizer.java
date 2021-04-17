package com.eneural;

import com.emath.*;

public class eAdamOptimizer extends eOptimizer{
    public eAdamOptimizer(double lr, double alpha){
	this.lr = lr;
	this.alpha = alpha;
	this.type = eOptimizer.OPTIM_ADAM;
    }
}
