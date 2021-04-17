package com.eneural;

import com.emath.*;

public class eMomentumOptimizer extends eOptimizer{
    public eMomentumOptimizer(double lr, double alpha){
	this.lr = lr;
	this.alpha = alpha;
	this.type = eOptimizer.OPTIM_MOMENTUM;
    }
}
